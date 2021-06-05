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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.javacourse.entities.Students;
import net.javacourse.entities.Trainers;
import net.javacourse.models.ClassesModel;
import net.javacourse.models.StudentsModel;
import net.javacourse.models.TrainersModel;
import javax.swing.JCheckBox;
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

public class ClassStudent extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Data model */
	private StudentsModel _model;
	private Students _account;

	/* View component */
	private JTable table;
	private JPanel header;

	/**
	 * Create the panel.
	 */
	public ClassStudent(Students account) {
		setBorder(null);
		this._account = account;
		this._model = new StudentsModel();

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

		/* Three of button */

		/* Manipulating data */
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
		List<Students> students = _model.getAll();

		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = new Vector<String>();
		Vector<String> headers = new Vector<String>();
		headers.add("Profile ID");
		headers.add("Fullname");
		headers.add("Email");
		headers.add("Telephone");

		for (Students student : students) {
			if (student.getClasses() != null) {
				if (student.getClasses().getClassId() == this._account.getClasses().getClassId()) {
					row.add(student.getStudentId());
					row.add(student.getFullname());
					row.add(student.getEmail());
					row.add(student.getTelephone());

					data.add(new Vector<String>(row));
					row.clear();
				};
			};
		}

		table = new JTable(data, headers);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getTableHeader().setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

		JScrollPane sp = new JScrollPane(table);
		header.add(sp);
	}

	/**
	 * 
	 */
	private void setEventButton() {
	}
}
