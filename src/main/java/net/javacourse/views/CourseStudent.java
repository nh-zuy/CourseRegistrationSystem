package net.javacourse.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.javacourse.entities.Courses;
import net.javacourse.entities.Schedules;
import net.javacourse.entities.Semesters;
import net.javacourse.entities.Sessions;
import net.javacourse.entities.Students;
import net.javacourse.entities.Studies;
import net.javacourse.entities.Trainers;
import net.javacourse.helpers.Helper;
import net.javacourse.models.ClassesModel;
import net.javacourse.models.CoursesModel;
import net.javacourse.models.SchedulesModel;
import net.javacourse.models.SessionsModel;
import net.javacourse.models.StudentsModel;
import net.javacourse.models.StudiesModel;
import net.javacourse.models.TrainersModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.lang.Class;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;

public class CourseStudent extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Data model */
	private StudiesModel _model;
	private Students _account;
	private List<Studies> _studies; 

	/* View component */
	private JTable table;
	private JPanel header;

	/**
	 * Create the panel.
	 */
	public CourseStudent(Students account) {
		setBorder(null);
		this._account = account;
		this._model = new StudiesModel();
		this._studies = new ArrayList<Studies>();

		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		JPanel form = new JPanel();
		form.setBackground(new Color(119, 165, 251));
		add(form, BorderLayout.CENTER);
		form.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		header = new JPanel();
		header.setBorder(new LineBorder(Color.WHITE, 5));
		header.setBackground(Color.WHITE);
		header.setPreferredSize(new Dimension(100, 450));
		add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));

		/* Role: Admin/Student */
		this.resetTextField();
		this.setData();
		this.setEventButton();
	}

	/**
	 * Reset data in textfield
	 */
	private void resetTextField() {
		this.validate();
		this.repaint();
	}

	/**
	 * Show information account
	 */
	private void setData() {
		List<Studies> studies = this._model.getAll();
		for (Studies study: studies) {
			String id = study.getStudents().getStudentId();
			
			if (this._account.getStudentId().equals(id)) {
				this._studies.add(study);
			};
		};
		
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = new Vector<String>();
		Vector<String> headers = new Vector<String>();
		headers.add("ID");
		headers.add("Course");
		headers.add("Day");
		headers.add("Shift");
		headers.add("Room");
		headers.add("Teacher");

		for (Studies study: this._studies) {
			/* ID */
			row.add(study.getId().toString());
			
			Schedules schedule = study.getSchedules();
			
			/* Course */
			row.add(schedule.getCourses().getName());
			
			row.add(schedule.getDay());
			row.add(String.valueOf(schedule.getShift()));
			row.add(schedule.getRoom());
			row.add(schedule.getTeacher());

			data.add(new Vector<String>(row));
			row.clear();
		};

		table = new JTable(data, headers);
		table.setRowHeight(30);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(21);
		table.getColumnModel().getColumn(1).setWidth(80);
		table.getTableHeader().setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		JScrollPane sp = new JScrollPane(table);
		header.add(sp);
	}

	/**
	 * 
	 */
	private void setEventButton() {
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		});
	}
}
