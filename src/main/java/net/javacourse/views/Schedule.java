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
import net.javacourse.models.ClassesModel;
import net.javacourse.models.CoursesModel;
import net.javacourse.models.CurrentSemModel;
import net.javacourse.models.SchedulesModel;
import net.javacourse.models.SemestersModel;
import net.javacourse.models.StudentsModel;

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

public class Schedule extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Data model */
	private SchedulesModel _model;
	
	/* View component */
	private JTable table;
	private JPanel header;
	private JButton btnAdd, btnUpdate, btnDelete;
	private JLabel message;
	private JTextField textRoom;
	private JTextField textSID;

	private JComboBox<String> boxCourses;

	private JButton btnFilter;
	private JTextField textID;

	private JComboBox<String> boxCourse;

	private JComboBox<String> boxDay;

	private JComboBox<String> boxShift;

	
	/**
	 * Create the panel.
	 */
	public Schedule() {
		setBorder(null);
		this._model = new SchedulesModel();
		
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
		
		JPanel forminput_1_3 = new JPanel();
		forminput_1_3.setLayout(null);
		forminput_1_3.setPreferredSize(new Dimension(1000, 50));
		forminput_1_3.setBackground(new Color(119, 165, 251));
		forminput_1_3.setBounds(189, 12, 297, 50);
		title_1.add(forminput_1_3);
		
		JLabel lblClass = new JLabel("Courses");
		lblClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblClass.setForeground(Color.BLACK);
		lblClass.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblClass.setBounds(0, 2, 89, 50);
		forminput_1_3.add(lblClass);
		
		boxCourses = new JComboBox<String>(new DefaultComboBoxModel<String>());
		boxCourses.setBounds(87, 16, 198, 24);
		forminput_1_3.add(boxCourses);
		
		JPanel forminput_1_2_1_1 = new JPanel();
		forminput_1_2_1_1.setLayout(null);
		forminput_1_2_1_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_2_1_1.setBackground(new Color(119, 165, 251));
		forminput_1_2_1_1.setBounds(498, 12, 222, 50);
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
		
		JPanel input = new JPanel();
		input.setPreferredSize(new Dimension(1000, 400));
		input.setBackground(new Color(119, 165, 251));
		form.add(input);
		input.setLayout(null);
		
		/* Three of button */
		btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.GREEN);
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAdd.setBounds(731, 131, 86, 50);
		btnAdd.setFocusPainted(false);
		btnAdd.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		input.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 16));
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		btnUpdate.setBackground(Color.YELLOW);
		btnUpdate.setBounds(731, 69, 86, 50);
		input.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDelete.setFocusPainted(false);
		btnDelete.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(731, 0, 86, 50);
		input.add(btnDelete);
		
		JPanel forminput_1_5_1 = new JPanel();
		forminput_1_5_1.setLayout(null);
		forminput_1_5_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5_1.setBackground(new Color(119, 165, 251));
		forminput_1_5_1.setBounds(173, 131, 165, 50);
		input.add(forminput_1_5_1);
		
		JLabel Email = new JLabel("Day");
		Email.setHorizontalAlignment(SwingConstants.CENTER);
		Email.setForeground(Color.BLACK);
		Email.setFont(new Font("Chilanka", Font.BOLD, 17));
		Email.setBounds(0, 3, 51, 50);
		forminput_1_5_1.add(Email);
		
		boxDay = new JComboBox<String>(new DefaultComboBoxModel<String>());
		boxDay.setBounds(45, 13, 108, 24);
		forminput_1_5_1.add(boxDay);
		
		JPanel forminput_1_5_1_2 = new JPanel();
		forminput_1_5_1_2.setLayout(null);
		forminput_1_5_1_2.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5_1_2.setBackground(new Color(119, 165, 251));
		forminput_1_5_1_2.setBounds(350, 131, 156, 50);
		input.add(forminput_1_5_1_2);
		
		JLabel lblTelephone = new JLabel("Shift");
		lblTelephone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelephone.setForeground(Color.BLACK);
		lblTelephone.setFont(new Font("Chilanka", Font.BOLD, 17));
		lblTelephone.setBounds(0, 3, 59, 50);
		forminput_1_5_1_2.add(lblTelephone);
		
		boxShift = new JComboBox<String>(new DefaultComboBoxModel<String>());
		boxShift.setBounds(61, 13, 83, 24);
		forminput_1_5_1_2.add(boxShift);
		
		JPanel forminput_1_5_1_3 = new JPanel();
		forminput_1_5_1_3.setLayout(null);
		forminput_1_5_1_3.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5_1_3.setBackground(new Color(119, 165, 251));
		forminput_1_5_1_3.setBounds(523, 131, 168, 50);
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
		textRoom.setBorder(null);
		textRoom.setBounds(66, 12, 89, 26);
		forminput_1_5_1_3.add(textRoom);
		
		JPanel forminput_1_2_1_1_1 = new JPanel();
		forminput_1_2_1_1_1.setLayout(null);
		forminput_1_2_1_1_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_2_1_1_1.setBackground(new Color(119, 165, 251));
		forminput_1_2_1_1_1.setBounds(173, 69, 151, 50);
		input.add(forminput_1_2_1_1_1);
		
		JLabel Name_1_1 = new JLabel("ID");
		Name_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		Name_1_1.setForeground(Color.BLACK);
		Name_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		Name_1_1.setBounds(0, 2, 65, 50);
		forminput_1_2_1_1_1.add(Name_1_1);
		
		textID = new JTextField();
		textID.setText("");
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setFont(new Font("Arial", Font.BOLD, 20));
		textID.setColumns(10);
		textID.setBorder(null);
		textID.setBounds(62, 15, 77, 26);
		forminput_1_2_1_1_1.add(textID);
		
		JPanel forminput_1_3_1 = new JPanel();
		forminput_1_3_1.setLayout(null);
		forminput_1_3_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_3_1.setBackground(new Color(119, 165, 251));
		forminput_1_3_1.setBounds(350, 69, 340, 50);
		input.add(forminput_1_3_1);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourse.setForeground(Color.BLACK);
		lblCourse.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblCourse.setBounds(0, 2, 89, 50);
		forminput_1_3_1.add(lblCourse);
		
		boxCourse = new JComboBox<String>(new DefaultComboBoxModel<String>());
		boxCourse.setBounds(87, 16, 241, 24);
		forminput_1_3_1.add(boxCourse);
		
		JLabel lblNewLabel_1 = new JLabel("Manage Course");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(225, 0, 437, 57);
		input.add(lblNewLabel_1);
		
		/* Manipulating data */
		this.resetTextField();
		this.setData();
		this.setEventButton();
	}
	
	/**
	 * Reset data in textfield
	 */
	private void resetTextField() {
		textID.setEditable(false);
		textID.setText("");
		textRoom.setText("");
		
		this.validate();
		this.repaint();
	}

	/**
	 * Show information account
	 */
	private void setData() {
		/* Set data for JTable */
		List<Schedules> schedules = this._model.getAll();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = new Vector<String>();
		Vector<String> headers = new Vector<String>();
		headers.add("ID");
		headers.add("Course");
		headers.add("Day");
		headers.add("Shift");
		headers.add("Room");

		for (Schedules schedule: schedules) {
			row.add(schedule.getId().toString());
			row.add(schedule.getCourses().getName() + " (" + schedule.getCourses().getCode() + ")");
			row.add(schedule.getDay());
			row.add(String.valueOf(schedule.getShift()));
			row.add(schedule.getRoom());
			
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
		
		/* Courses combobox */
		CoursesModel courseModel = new CoursesModel();
		List<Courses> courses = courseModel.getAll();
		DefaultComboBoxModel<String> box1 = (DefaultComboBoxModel<String>) boxCourses.getModel();
		DefaultComboBoxModel<String> box2 = (DefaultComboBoxModel<String>) boxCourse.getModel();
		box1.addElement("All");
		for (Courses course: courses) {
			box1.addElement(course.getName() + " (" + course.getCode() + ")");
			box2.addElement(course.getName() + " (" + course.getCode() + ")");
		};
		
		DefaultComboBoxModel<String> box3 = (DefaultComboBoxModel<String>) boxDay.getModel();
		box3.addElement("Monday");
		box3.addElement("Tuesday");
		box3.addElement("Wednesday");
		box3.addElement("Thursday");
		box3.addElement("Friday");
		box3.addElement("Saturday");
		box3.addElement("Sunday");
		
		/* Shift combobox */
		DefaultComboBoxModel<String> box4 = (DefaultComboBoxModel<String>) boxShift.getModel();
		box4.addElement("1");
		box4.addElement("2");
		box4.addElement("3");
		box4.addElement("4");
	}
	
	/**
	 * 
	 */
	private void setEventButton() {
		/* Only one checkbox is selected on time */
		btnFilter.addActionListener(e -> {
			String tCourse = (String)boxCourses.getSelectedItem();
			String code;
			String sid = textSID.getText().trim();
			
			List<Schedules> schedules = _model.getAll();
			Vector<String> row = new Vector<String>();
		
			DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
			tableModel.setRowCount(0);
			
			if (tCourse.equals("All")) {
				for (Schedules schedule: schedules) {
					row.add(schedule.getId().toString());
					row.add(schedule.getCourses().getName() + " (" + schedule.getCourses().getCode() + ")");
					row.add(schedule.getDay());
					row.add(String.valueOf(schedule.getShift()));
					row.add(schedule.getRoom());

					tableModel.addRow(new Vector<String>(row));
					row.clear();
				};
				return;
			};
			
			code = Helper.parseCode(tCourse);
			
			for (Schedules schedule: schedules) {
				if (schedule.getCourses().getCode().equals(code)) {
					System.out.println("2");
					row.add(schedule.getId().toString());
					row.add(schedule.getCourses().getName() + " (" + schedule.getCourses().getCode() + ")");
					row.add(schedule.getDay());
					row.add(String.valueOf(schedule.getShift()));
					row.add(schedule.getRoom());

					tableModel.addRow(new Vector<String>(row));
					row.clear();
				};
			};
		});
		
		/* Click button */
		btnAdd.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String day = (String)boxDay.getSelectedItem().toString();
				String tShift = boxShift.getSelectedItem().toString().trim();
				String room = textRoom.getText().trim();
				String tCourse = (String)boxCourse.getSelectedItem();
				
				if (day.isBlank() || tShift.isBlank() || room.isBlank() || tCourse.isBlank()) {
					JOptionPane.showMessageDialog(new JPanel(), "Please fill blank!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure add schedule?", "New Schedule",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					
					if (res == 0) {
						Schedules data = new Schedules();
						String code = Helper.parseCode(tCourse);
						data.setCourses(new CoursesModel().find(code));
						data.setShift(Integer.parseInt(tShift));
						data.setDay(day);
						data.setRoom(room);
						
						int insertedId = _model.add(data);
						
						if (insertedId != -1) {
							DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
							String row[] = {String.valueOf(insertedId), tCourse, day, tShift, room};
							tableModel.addRow(row);
							
							table.validate();
							table.repaint();
							resetTextField();
						} else {
							JOptionPane.showMessageDialog(new JPanel(), "ERROR insert!", "Error", JOptionPane.ERROR_MESSAGE);
						}
					};
				};
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
		
		/* Click button update */
		btnUpdate.addActionListener(e -> {
			if (table.getSelectedRowCount() == 0) {
				JOptionPane.showMessageDialog(new JPanel(), "Please select one row !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			};
			if (table.getSelectedRowCount() > 1) {
				JOptionPane.showMessageDialog(new JPanel(), "Only one row can be updated on time!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			};
			if (table.getRowCount() == 0) {
				JOptionPane.showMessageDialog(new JPanel(), "Blank table !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			};
			
			String id = textID.getText().trim();
			String day = (String)boxDay.getSelectedItem().toString();
			String tShift = boxShift.getSelectedItem().toString().trim();
			String room = textRoom.getText().trim();
			String tCourse = (String)boxCourse.getSelectedItem();
			String code = Helper.parseCode(tCourse);
			
			if (day.isBlank() || tShift.isBlank() || room.isBlank()) {
				message.setText("Fill all require!");
				message.setForeground(Color.RED);
				JOptionPane.showMessageDialog(new JPanel(), "Please fill blank!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				String[] options = { "Yes", "No" };

				int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure add schedule?", "New Schedule",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				
				if (res == 0) {
					Integer tid = Integer.parseInt(id);
					Schedules data = _model.find(tid);
					data.setCourses(new CoursesModel().find(code));
					data.setShift(Integer.parseInt(tShift));
					data.setDay(day);
					data.setRoom(room);
					
					if (_model.updateById(tid, data)) {
						DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
						
						tableModel.setValueAt(id, table.getSelectedRow(), 0);
						tableModel.setValueAt(tCourse, table.getSelectedRow(), 1);
						tableModel.setValueAt(day, table.getSelectedRow(), 2);
						tableModel.setValueAt(tShift, table.getSelectedRow(), 3);
						tableModel.setValueAt(room, table.getSelectedRow(), 4);
						
						JOptionPane.showMessageDialog(new JPanel(), "Update Successfully!", "Update", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(new JPanel(), "ERROR update!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			};
		});
		
		/* Click button Delete */
		btnDelete.addActionListener(e -> {
			if (table.getSelectedRowCount() == 0) {
				JOptionPane.showMessageDialog(new JPanel(), "Please don't select multiple row!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			};
			if (table.getSelectedRowCount() > 1) {
				JOptionPane.showMessageDialog(new JPanel(), "Only one row can be deleted on time!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			};
			if (table.getRowCount() == 0) {
				JOptionPane.showMessageDialog(new JPanel(), "Blank table!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			};
			
			String tid = textID.getText().trim();
			
			if (tid.isBlank()) {
				message.setText("Select a specific account!");
				message.setForeground(Color.RED);
				JOptionPane.showMessageDialog(new JPanel(), "Please select an ID!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				String[] options = { "Yes", "No" };

				int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure delete schedule?",
						"Delete Semester", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
						options[0]);
				
				/* If click YES */
				if (res == 0) {
					DefaultTableModel tableMode = (DefaultTableModel)table.getModel();
					int id = Integer.parseInt(tid);
					
					if (_model.deleteById(id)) {
						tableMode.removeRow(table.getSelectedRow());

						JOptionPane.showMessageDialog(new JPanel(), "Delete Successfully!", "Delete",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(new JPanel(), "ERROR Delete !", "Error",
								JOptionPane.ERROR_MESSAGE);
					};
				};
			};
		});

		
		/* Event for data table */
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String id = table.getValueAt(table.getSelectedRow(), 0).toString();
				String course = table.getValueAt(table.getSelectedRow(), 1).toString();
				String day = table.getValueAt(table.getSelectedRow(), 2).toString();
				String shift = table.getValueAt(table.getSelectedRow(), 3).toString();
				String room = table.getValueAt(table.getSelectedRow(), 4).toString();
				
				textID.setText(id);
				boxCourse.setSelectedItem(course);
				boxDay.setSelectedItem(day);
				boxShift.setSelectedItem(shift);
				textRoom.setText(room);
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
