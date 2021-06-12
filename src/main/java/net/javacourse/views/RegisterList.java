package net.javacourse.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.javacourse.entities.Classes;
import net.javacourse.entities.Courses;
import net.javacourse.entities.CurrentSem;
import net.javacourse.entities.Schedules;
import net.javacourse.entities.Semesters;
import net.javacourse.entities.Students;
import net.javacourse.entities.Studies;
import net.javacourse.models.ClassesModel;
import net.javacourse.models.CoursesModel;
import net.javacourse.models.CurrentSemModel;
import net.javacourse.models.SchedulesModel;
import net.javacourse.models.SemestersModel;
import net.javacourse.models.StudentsModel;
import net.javacourse.models.StudiesModel;

import javax.swing.JCheckBox;

import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.toedter.calendar.JDateChooser;
import net.javacourse.helpers.Helper;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class RegisterList extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Data model */
	private StudiesModel _model;
	
	/* View component */
	private JTable table;
	private JPanel header;
	private JLabel message;
	private JTextField textRoom;
	private JTextField textSID;

	private JButton btnFilter;
	private JTextField textSName;
	private JTextField textCourse;
	private JTextField textID;
	private JTextField textName;
	private JTextField textShift;
	private JTextField textDay;
	private JTextField textTeacher;

	
	/**
	 * Create the panel.
	 */
	public RegisterList() {
		setBorder(null);
		this._model = new StudiesModel();
		
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		header = new JPanel();
		header.setBorder(new LineBorder(Color.WHITE, 5));
		header.setBackground(Color.WHITE);
		header.setPreferredSize(new Dimension(100, 300));
		add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));

		
		JPanel form = new JPanel();
		form.setBackground(new Color(119, 165, 251));
		add(form, BorderLayout.CENTER);
		form.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel title_1 = new JPanel();
		title_1.setLayout(null);
		title_1.setPreferredSize(new Dimension(1000, 70));
		title_1.setBackground(Color.WHITE);
		form.add(title_1);
		
		JPanel forminput_1_2_1_1 = new JPanel();
		forminput_1_2_1_1.setLayout(null);
		forminput_1_2_1_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_2_1_1.setBackground(new Color(119, 165, 251));
		forminput_1_2_1_1.setBounds(173, 12, 222, 50);
		title_1.add(forminput_1_2_1_1);
		
		JLabel Name_1 = new JLabel("ID");
		Name_1.setHorizontalAlignment(SwingConstants.CENTER);
		Name_1.setForeground(Color.BLACK);
		Name_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		Name_1.setBounds(0, 2, 65, 50);
		forminput_1_2_1_1.add(Name_1);
		
		textSID = new JTextField();
		textSID.setText("");
		textSID.setHorizontalAlignment(SwingConstants.CENTER);
		textSID.setFont(new Font("Arial", Font.BOLD, 20));
		textSID.setColumns(10);
		textSID.setBorder(null);
		textSID.setBounds(62, 15, 148, 26);
		forminput_1_2_1_1.add(textSID);
		
		btnFilter = new JButton("Filter");
		btnFilter.setFont(new Font("Dialog", Font.BOLD, 16));
		btnFilter.setFocusPainted(false);
		btnFilter.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		btnFilter.setBackground(Color.ORANGE);
		btnFilter.setBounds(732, 12, 86, 50);
		title_1.add(btnFilter);
		
		JPanel forminput_1_2_1_1_1 = new JPanel();
		forminput_1_2_1_1_1.setLayout(null);
		forminput_1_2_1_1_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_2_1_1_1.setBackground(new Color(119, 165, 251));
		forminput_1_2_1_1_1.setBounds(407, 12, 294, 50);
		title_1.add(forminput_1_2_1_1_1);
		
		JLabel Name_1_1 = new JLabel("Fullname");
		Name_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		Name_1_1.setForeground(Color.BLACK);
		Name_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		Name_1_1.setBounds(0, 2, 86, 50);
		forminput_1_2_1_1_1.add(Name_1_1);
		
		textSName = new JTextField();
		textSName.setText("");
		textSName.setHorizontalAlignment(SwingConstants.CENTER);
		textSName.setFont(new Font("Arial", Font.BOLD, 20));
		textSName.setColumns(10);
		textSName.setBorder(null);
		textSName.setBounds(88, 15, 194, 26);
		forminput_1_2_1_1_1.add(textSName);
		
		JPanel input = new JPanel();
		input.setPreferredSize(new Dimension(1000, 400));
		input.setBackground(new Color(119, 165, 251));
		form.add(input);
		input.setLayout(null);
		
		JPanel forminput_1_5_1 = new JPanel();
		forminput_1_5_1.setLayout(null);
		forminput_1_5_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5_1.setBackground(new Color(119, 165, 251));
		forminput_1_5_1.setBounds(172, 136, 165, 50);
		input.add(forminput_1_5_1);
		
		JLabel Email = new JLabel("Day");
		Email.setHorizontalAlignment(SwingConstants.CENTER);
		Email.setForeground(Color.BLACK);
		Email.setFont(new Font("Chilanka", Font.BOLD, 17));
		Email.setBounds(0, 3, 51, 50);
		forminput_1_5_1.add(Email);
		
		textDay = new JTextField();
		textDay.setText("0");
		textDay.setHorizontalAlignment(SwingConstants.CENTER);
		textDay.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textDay.setColumns(10);
		textDay.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textDay.setBounds(64, 12, 89, 26);
		forminput_1_5_1.add(textDay);
		
		JPanel forminput_1_5_1_2 = new JPanel();
		forminput_1_5_1_2.setLayout(null);
		forminput_1_5_1_2.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5_1_2.setBackground(new Color(119, 165, 251));
		forminput_1_5_1_2.setBounds(349, 136, 156, 50);
		input.add(forminput_1_5_1_2);
		
		JLabel lblTelephone = new JLabel("Shift");
		lblTelephone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelephone.setForeground(Color.BLACK);
		lblTelephone.setFont(new Font("Chilanka", Font.BOLD, 17));
		lblTelephone.setBounds(0, 3, 59, 50);
		forminput_1_5_1_2.add(lblTelephone);
		
		textShift = new JTextField();
		textShift.setText("0");
		textShift.setHorizontalAlignment(SwingConstants.CENTER);
		textShift.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textShift.setColumns(10);
		textShift.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textShift.setBounds(55, 12, 89, 26);
		forminput_1_5_1_2.add(textShift);
		
		JPanel forminput_1_5_1_3 = new JPanel();
		forminput_1_5_1_3.setLayout(null);
		forminput_1_5_1_3.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5_1_3.setBackground(new Color(119, 165, 251));
		forminput_1_5_1_3.setBounds(522, 136, 168, 50);
		input.add(forminput_1_5_1_3);
		
		JLabel lblCitizenId = new JLabel("Room");
		lblCitizenId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCitizenId.setForeground(Color.BLACK);
		lblCitizenId.setFont(new Font("Chilanka", Font.BOLD, 17));
		lblCitizenId.setBounds(0, 3, 73, 50);
		forminput_1_5_1_3.add(lblCitizenId);
		
		textRoom = new JTextField();
		textRoom.setText("0");
		textRoom.setHorizontalAlignment(SwingConstants.CENTER);
		textRoom.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textRoom.setColumns(10);
		textRoom.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textRoom.setBounds(66, 12, 89, 26);
		forminput_1_5_1_3.add(textRoom);
		
		JPanel forminput_1_2_1_1_1_1 = new JPanel();
		forminput_1_2_1_1_1_1.setLayout(null);
		forminput_1_2_1_1_1_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_2_1_1_1_1.setBackground(new Color(119, 165, 251));
		forminput_1_2_1_1_1_1.setBounds(172, 74, 259, 50);
		input.add(forminput_1_2_1_1_1_1);
		
		JLabel Name_1_1_1 = new JLabel("Course");
		Name_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		Name_1_1_1.setForeground(Color.BLACK);
		Name_1_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		Name_1_1_1.setBounds(0, 2, 86, 50);
		forminput_1_2_1_1_1_1.add(Name_1_1_1);
		
		textCourse = new JTextField();
		textCourse.setText("");
		textCourse.setHorizontalAlignment(SwingConstants.CENTER);
		textCourse.setFont(new Font("Arial", Font.BOLD, 20));
		textCourse.setColumns(10);
		textCourse.setBorder(null);
		textCourse.setBounds(88, 15, 164, 26);
		forminput_1_2_1_1_1_1.add(textCourse);
		
		JPanel forminput_1_2_1_1_2 = new JPanel();
		forminput_1_2_1_1_2.setLayout(null);
		forminput_1_2_1_1_2.setPreferredSize(new Dimension(1000, 50));
		forminput_1_2_1_1_2.setBackground(new Color(119, 165, 251));
		forminput_1_2_1_1_2.setBounds(172, 12, 222, 50);
		input.add(forminput_1_2_1_1_2);
		
		JLabel Name_1_2 = new JLabel("ID");
		Name_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		Name_1_2.setForeground(Color.BLACK);
		Name_1_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		Name_1_2.setBounds(0, 2, 65, 50);
		forminput_1_2_1_1_2.add(Name_1_2);
		
		textID = new JTextField();
		textID.setText("");
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setFont(new Font("Arial", Font.BOLD, 20));
		textID.setColumns(10);
		textID.setBorder(null);
		textID.setBounds(62, 15, 148, 26);
		forminput_1_2_1_1_2.add(textID);
		
		JPanel forminput_1_2_1_1_1_2 = new JPanel();
		forminput_1_2_1_1_1_2.setLayout(null);
		forminput_1_2_1_1_1_2.setPreferredSize(new Dimension(1000, 50));
		forminput_1_2_1_1_1_2.setBackground(new Color(119, 165, 251));
		forminput_1_2_1_1_1_2.setBounds(406, 12, 294, 50);
		input.add(forminput_1_2_1_1_1_2);
		
		JLabel Name_1_1_2 = new JLabel("Fullname");
		Name_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		Name_1_1_2.setForeground(Color.BLACK);
		Name_1_1_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		Name_1_1_2.setBounds(0, 2, 86, 50);
		forminput_1_2_1_1_1_2.add(Name_1_1_2);
		
		textName = new JTextField();
		textName.setText("");
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setFont(new Font("Arial", Font.BOLD, 20));
		textName.setColumns(10);
		textName.setBorder(null);
		textName.setBounds(88, 15, 194, 26);
		forminput_1_2_1_1_1_2.add(textName);
		
		JPanel forminput_1_2_1_1_1_1_1 = new JPanel();
		forminput_1_2_1_1_1_1_1.setLayout(null);
		forminput_1_2_1_1_1_1_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_2_1_1_1_1_1.setBackground(new Color(119, 165, 251));
		forminput_1_2_1_1_1_1_1.setBounds(441, 74, 259, 50);
		input.add(forminput_1_2_1_1_1_1_1);
		
		JLabel Name_1_1_1_1 = new JLabel("Teacher");
		Name_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		Name_1_1_1_1.setForeground(Color.BLACK);
		Name_1_1_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		Name_1_1_1_1.setBounds(0, 2, 86, 50);
		forminput_1_2_1_1_1_1_1.add(Name_1_1_1_1);
		
		textTeacher = new JTextField();
		textTeacher.setText("");
		textTeacher.setHorizontalAlignment(SwingConstants.CENTER);
		textTeacher.setFont(new Font("Arial", Font.BOLD, 20));
		textTeacher.setColumns(10);
		textTeacher.setBorder(null);
		textTeacher.setBounds(88, 15, 164, 26);
		forminput_1_2_1_1_1_1_1.add(textTeacher);
		
		/* Manipulating data */
		this.resetTextField();
		this.setData();
		this.setEventButton();
	}
	
	/**
	 * Reset data in textfield
	 */
	private void resetTextField() {
		textID.setText("");
		textName.setText("");
		textCourse.setText("");
		textDay.setText("");
		textShift.setText("");
		textRoom.setText("");
		
		this.validate();
		this.repaint();
	}

	/**
	 * Show information account
	 */
	private void setData() {
		/* Set data for JTable */
		List<Studies> registerList = this._model.getAll();
		
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = new Vector<String>();
		Vector<String> headers = new Vector<String>();
		headers.add("MSSV");
		headers.add("Fullname");
		headers.add("Course");
		headers.add("Day");
		headers.add("Shift");
		headers.add("Room");
		headers.add("Teacher");

		for (Studies register: registerList) {
			Students student = register.getStudents();
			Schedules schedule = register.getSchedules();
			
			row.add(student.getStudentId());
			row.add(student.getFullname());
			row.add(schedule.getCourses().getName());
			row.add(schedule.getDay());
			row.add(String.valueOf(schedule.getShift()));
			row.add(schedule.getRoom());
			row.add(schedule.getTeacher());
			
			data.add(new Vector<String>(row));
			row.clear();
		};

		table = new JTable(data, headers);
		table.setRowHeight(28);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getTableHeader().setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		JScrollPane sp = new JScrollPane(table);
		header.add(sp, BorderLayout.CENTER);
	}
	
	/**
	 * 
	 */
	private void setEventButton() {
		/* Only one checkbox is selected on time */
		btnFilter.addActionListener(e -> {
			String id = textID.getText().trim();
			String name = textName.getText().trim();
			
			List<Studies> registerList = _model.getAll();
			
			DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
			tableModel.setRowCount(0);
			Vector<String> row = new Vector<String>();
			
			if (id.isBlank() && name.isBlank()) {
				for (Studies register: registerList) {
					Students student = register.getStudents();
					Schedules schedule = register.getSchedules();
					
					row.add(student.getStudentId());
					row.add(student.getFullname());
					row.add(schedule.getCourses().getName());
					row.add(schedule.getDay());
					row.add(String.valueOf(schedule.getShift()));
					row.add(schedule.getRoom());
					row.add(schedule.getTeacher());
					
					tableModel.addRow(new Vector<String>(row));
					row.clear();
				};
				
				return;
			};
			
			for (Studies register: registerList) {
				Students student = register.getStudents();
				Schedules schedule = register.getSchedules();
				
				if (student.getFullname().equals(name) || student.getStudentId().equals(id)) {
					row.add(student.getStudentId());
					row.add(student.getFullname());
					row.add(schedule.getCourses().getName());
					row.add(schedule.getDay());
					row.add(String.valueOf(schedule.getShift()));
					row.add(schedule.getRoom());
					row.add(schedule.getTeacher());
					
					tableModel.addRow(new Vector<String>(row));
					row.clear();
				};
			};
		});

		
		/* Event for data table */
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String id = table.getValueAt(table.getSelectedRow(), 0).toString();
				String fullname = table.getValueAt(table.getSelectedRow(), 1).toString();
				String course = table.getValueAt(table.getSelectedRow(), 2).toString();
				String day = table.getValueAt(table.getSelectedRow(), 3).toString();
				String shift = table.getValueAt(table.getSelectedRow(), 4).toString();
				String room = table.getValueAt(table.getSelectedRow(), 5).toString();
				String teacher = table.getValueAt(table.getSelectedRow(), 6).toString();
				
				textID.setText(id);
				textName.setText(fullname);
				textCourse.setText(course);
				textDay.setText(day);
				textShift.setText(shift);
				textRoom.setText(room);
				textTeacher.setText(teacher);
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
