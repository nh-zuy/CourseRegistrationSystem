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
import net.javacourse.entities.Semesters;
import net.javacourse.entities.Students;
import net.javacourse.models.ClassesModel;
import net.javacourse.models.CoursesModel;
import net.javacourse.models.CurrentSemModel;
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

public class StudentList extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Data model */
	private StudentsModel _model;
	
	/* View component */
	private JTable table;
	private JPanel header;
	private JTextField textID;
	private JButton btnAdd, btnUpdate, btnDelete;
	private JTextField textName;
	private JTextField textEmail;
	private JLabel message;
	private JTextField textTelephone;

	private JRadioButton chMale;

	private JRadioButton chFemale;
	private JTextField textCitizen;
	private JTextField textAddress;
	private JTextField textSID;

	private JComboBox<String> boxClasses;

	private JComboBox<String> boxClass;

	private JButton btnFilter;

	
	/**
	 * Create the panel.
	 */
	public StudentList() {
		setBorder(null);
		this._model = new StudentsModel();
		
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
		forminput_1_3.setBounds(173, 12, 268, 50);
		title_1.add(forminput_1_3);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblClass.setForeground(Color.BLACK);
		lblClass.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblClass.setBounds(0, 2, 112, 50);
		forminput_1_3.add(lblClass);
		
		boxClasses = new JComboBox<String>(new DefaultComboBoxModel<String>());
		boxClasses.setBounds(110, 16, 149, 24);
		forminput_1_3.add(boxClasses);
		
		JPanel forminput_1_2_1_1 = new JPanel();
		forminput_1_2_1_1.setLayout(null);
		forminput_1_2_1_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_2_1_1.setBackground(new Color(119, 165, 251));
		forminput_1_2_1_1.setBounds(465, 12, 255, 50);
		title_1.add(forminput_1_2_1_1);
		
		JLabel Name_1 = new JLabel("ID");
		Name_1.setHorizontalAlignment(SwingConstants.CENTER);
		Name_1.setForeground(Color.BLACK);
		Name_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		Name_1.setBounds(0, 2, 71, 50);
		forminput_1_2_1_1.add(Name_1);
		
		textSID = new JTextField();
		textSID.setText("");
		textSID.setHorizontalAlignment(SwingConstants.CENTER);
		textSID.setFont(new Font("Arial", Font.BOLD, 20));
		textSID.setColumns(10);
		textSID.setBorder(null);
		textSID.setBounds(71, 15, 170, 26);
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
		
		JPanel forminput_1_2 = new JPanel();
		forminput_1_2.setLayout(null);
		forminput_1_2.setPreferredSize(new Dimension(1000, 50));
		forminput_1_2.setBackground(new Color(119, 165, 251));
		forminput_1_2.setBounds(173, 0, 270, 50);
		input.add(forminput_1_2);
		
		JLabel lblId = new JLabel("Profile ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.RED);
		lblId.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblId.setBounds(0, 2, 109, 50);
		forminput_1_2.add(lblId);
		
		textID = new JTextField();
		textID.setText("");
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		textID.setColumns(10);
		textID.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textID.setBounds(110, 2, 150, 50);
		forminput_1_2.add(textID);
		
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
		
		JPanel forminput_1_2_1 = new JPanel();
		forminput_1_2_1.setLayout(null);
		forminput_1_2_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_2_1.setBackground(new Color(119, 165, 251));
		forminput_1_2_1.setBounds(173, 69, 331, 50);
		input.add(forminput_1_2_1);
		
		JLabel Name = new JLabel("Fulllname");
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setForeground(Color.RED);
		Name.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		Name.setBounds(0, 2, 99, 50);
		forminput_1_2_1.add(Name);
		
		textName = new JTextField();
		textName.setText("");
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setFont(new Font("Arial", Font.BOLD, 20));
		textName.setColumns(10);
		textName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textName.setBounds(110, 2, 221, 50);
		forminput_1_2_1.add(textName);
		
		JPanel forminput_1_5_1 = new JPanel();
		forminput_1_5_1.setLayout(null);
		forminput_1_5_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5_1.setBackground(new Color(119, 165, 251));
		forminput_1_5_1.setBounds(173, 131, 270, 50);
		input.add(forminput_1_5_1);
		
		JLabel Email = new JLabel("Email");
		Email.setHorizontalAlignment(SwingConstants.CENTER);
		Email.setForeground(Color.BLACK);
		Email.setFont(new Font("Chilanka", Font.BOLD, 17));
		Email.setBounds(0, 3, 75, 50);
		forminput_1_5_1.add(Email);
		
		textEmail = new JTextField();
		textEmail.setText("0");
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textEmail.setColumns(10);
		textEmail.setBorder(null);
		textEmail.setBounds(92, 12, 168, 26);
		forminput_1_5_1.add(textEmail);
		
		JPanel forminput_1_3_1 = new JPanel();
		forminput_1_3_1.setLayout(null);
		forminput_1_3_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_3_1.setBackground(new Color(119, 165, 251));
		forminput_1_3_1.setBounds(440, 0, 279, 50);
		input.add(forminput_1_3_1);
		
		JLabel lblClass_1 = new JLabel("Class");
		lblClass_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblClass_1.setForeground(Color.BLACK);
		lblClass_1.setFont(new Font("Chilanka", Font.BOLD, 17));
		lblClass_1.setBounds(0, 2, 96, 50);
		forminput_1_3_1.add(lblClass_1);
		
		boxClass = new JComboBox<String>(new DefaultComboBoxModel<String>());
		boxClass.setBounds(96, 13, 171, 24);
		forminput_1_3_1.add(boxClass);
		
		JPanel forminput_1_5_1_1 = new JPanel();
		forminput_1_5_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		forminput_1_5_1_1.setLayout(null);
		forminput_1_5_1_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5_1_1.setBackground(new Color(119, 165, 251));
		forminput_1_5_1_1.setBounds(536, 62, 171, 69);
		input.add(forminput_1_5_1_1);
		
		JLabel lblNewLabel = new JLabel("Sex");
		lblNewLabel.setBounds(12, 0, 59, 69);
		forminput_1_5_1_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		chMale = new JRadioButton("Male");
		chMale.setBounds(75, 8, 76, 27);
		forminput_1_5_1_1.add(chMale);
		chMale.addActionListener(e -> {
			if (chFemale.isSelected()) {
				chFemale.setSelected(false);
			};
			chMale.setSelected(true);
		});
		chMale.setBackground(new Color(119, 165, 251));
		chMale.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chFemale = new JRadioButton("Female");
		chFemale.addActionListener(e -> {
			if (chMale.isSelected()) {
				chMale.setSelected(false);
			};
			chFemale.setSelected(true);
		});
		chFemale.setBounds(75, 31, 88, 30);
		forminput_1_5_1_1.add(chFemale);
		chFemale.setFont(new Font("Dialog", Font.BOLD, 16));
		chFemale.setBackground(new Color(119, 165, 251));
		
		JPanel forminput_1_5_1_2 = new JPanel();
		forminput_1_5_1_2.setLayout(null);
		forminput_1_5_1_2.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5_1_2.setBackground(new Color(119, 165, 251));
		forminput_1_5_1_2.setBounds(440, 131, 279, 50);
		input.add(forminput_1_5_1_2);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelephone.setForeground(Color.BLACK);
		lblTelephone.setFont(new Font("Chilanka", Font.BOLD, 17));
		lblTelephone.setBounds(0, 3, 99, 50);
		forminput_1_5_1_2.add(lblTelephone);
		
		textTelephone = new JTextField();
		textTelephone.setText("0");
		textTelephone.setHorizontalAlignment(SwingConstants.CENTER);
		textTelephone.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textTelephone.setColumns(10);
		textTelephone.setBorder(null);
		textTelephone.setBounds(96, 12, 171, 26);
		forminput_1_5_1_2.add(textTelephone);
		
		JPanel forminput_1_5_1_3 = new JPanel();
		forminput_1_5_1_3.setLayout(null);
		forminput_1_5_1_3.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5_1_3.setBackground(new Color(119, 165, 251));
		forminput_1_5_1_3.setBounds(173, 192, 270, 50);
		input.add(forminput_1_5_1_3);
		
		JLabel lblCitizenId = new JLabel("Citizen ID");
		lblCitizenId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCitizenId.setForeground(Color.BLACK);
		lblCitizenId.setFont(new Font("Chilanka", Font.BOLD, 17));
		lblCitizenId.setBounds(0, 3, 92, 50);
		forminput_1_5_1_3.add(lblCitizenId);
		
		textCitizen = new JTextField();
		textCitizen.setText("0");
		textCitizen.setHorizontalAlignment(SwingConstants.CENTER);
		textCitizen.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textCitizen.setColumns(10);
		textCitizen.setBorder(null);
		textCitizen.setBounds(92, 12, 168, 26);
		forminput_1_5_1_3.add(textCitizen);
		
		JPanel forminput_1_5_1_3_1 = new JPanel();
		forminput_1_5_1_3_1.setLayout(null);
		forminput_1_5_1_3_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5_1_3_1.setBackground(new Color(119, 165, 251));
		forminput_1_5_1_3_1.setBounds(440, 193, 279, 50);
		input.add(forminput_1_5_1_3_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Chilanka", Font.BOLD, 17));
		lblAddress.setBounds(0, 3, 98, 50);
		forminput_1_5_1_3_1.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setText("0");
		textAddress.setHorizontalAlignment(SwingConstants.CENTER);
		textAddress.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textAddress.setColumns(10);
		textAddress.setBorder(null);
		textAddress.setBounds(96, 12, 170, 26);
		forminput_1_5_1_3_1.add(textAddress);
		
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
		textEmail.setText("");
		textAddress.setText("");
		textTelephone.setText("");
		textCitizen.setText("");
		chMale.setSelected(false);
		chFemale.setSelected(false);
		
		this.validate();
		this.repaint();
	}

	/**
	 * Show information account
	 */
	private void setData() {
		/* Set data for JTable */
		List<Students> students = this._model.getAll();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = new Vector<String>();
		Vector<String> headers = new Vector<String>();
		headers.add("Profile ID");
		headers.add("Fullame");
		headers.add("Class");
		headers.add("Sex");
		headers.add("Email");
		headers.add("Telephone");

		for (Students student: students) {
			row.add(student.getStudentId());
			row.add(student.getFullname());
			if (student.getClasses() != null) {
				row.add(student.getClasses().getName() + " (" + student.getClasses().getClassId() + ")");
			} else {
				row.add("null");
			};
			
			byte sex = student.getSex();
			if (sex == 0) {
				row.add("Male");
				
			} else {
				row.add("Female");
			};
			row.add(student.getEmail());
			row.add(student.getTelephone());
			
			data.add(new Vector<String>(row));
			row.clear();
		};

		table = new JTable(data, headers);
		table.setRowHeight(28);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(17);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		
		table.getTableHeader().setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		
		JScrollPane sp = new JScrollPane(table);
		header.add(sp, BorderLayout.CENTER);
		
		/* Data table */
		ClassesModel classModel = new ClassesModel();
		List<Classes> classes = classModel.getAll();
		DefaultComboBoxModel<String> box1 = (DefaultComboBoxModel<String>) boxClasses.getModel();
		DefaultComboBoxModel<String> box2 = (DefaultComboBoxModel<String>) boxClass.getModel();
		for (Classes c: classes) {
			box2.addElement(c.getName() + " (" + c.getClassId() + ")");
			box1.addElement(c.getName() + " (" + c.getClassId() + ")");
		};
		box1.addElement("All");
	}
	
	/**
	 * 
	 */
	private void setEventButton() {
		/* Only one checkbox is selected on time */
		btnFilter.addActionListener(e -> {
			String tClass = (String)boxClasses.getSelectedItem();
			int classId;
			String profileId = textSID.getText().trim();
			
			List<Students> students = _model.getAll();
			Vector<String> row = new Vector<String>();
			
			DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
			tableModel.setRowCount(0);
			
			if (tClass.equals("All")) {
				for (Students student: students) {
					row.add(student.getStudentId());
					row.add(student.getFullname());
					row.add(student.getClasses().getName() + " (" + student.getClasses().getClassId() + ")");
					byte sex = student.getSex();
					if (sex == 0) {
						row.add("Male");
					} else {
						row.add("Female");
					};
					row.add(student.getEmail());
					row.add(student.getTelephone());

					tableModel.addRow(new Vector<String>(row));
					row.clear();
				};
				return;
			};
			
			classId = Helper.parseClassId(tClass);
			
			for (Students student: students) {
				if (student.getClasses().getClassId() == classId) {
					row.add(student.getStudentId());
					row.add(student.getFullname());
					row.add(student.getClasses().getName() + " (" + student.getClasses().getClassId() + ")");
					byte sex = student.getSex();
					if (sex == 0) {
						row.add("Male");
					} else {
						row.add("Female");
					};
					row.add(student.getEmail());
					row.add(student.getTelephone());
					
					tableModel.addRow(new Vector<String>(row));
					row.clear();
				} else if (student.getStudentId().equals(profileId)){
					row.add(student.getStudentId());
					row.add(student.getFullname());
					row.add(student.getClasses().toString());
					byte sex = student.getSex();
					if (sex == 0) {
						row.add("Male");
					} else {
						row.add("Female");
					};
					row.add(student.getEmail());
					row.add(student.getTelephone());
					
					tableModel.addRow(new Vector<String>(row));
					row.clear();
				}
			};
		});
		
		/* Click button */
		btnAdd.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String id = textID.getText().trim();
				String fullname = textName.getText().trim();
				Object tClass = boxClass.getSelectedItem();
				int classId;
				if (tClass == null) {
					classId = -1;
				} else {
					classId = Helper.parseClassId((String)tClass);
				};
				
				byte sex = 0;
				if (chFemale.isSelected()) {
					sex = 1;
				};
				String citizenId = textCitizen.getText().trim();
				String telephone = textTelephone.getText().trim();
				String email = textEmail.getText().trim();
				String address = textAddress.getText().trim();
				
				if (id.isBlank() || fullname.isBlank()) {
					message.setText("Fill all require!");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please fill profile ID and fullname!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure adding new student?", "New student",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					
					if (res == 0) {
						ClassesModel model = new ClassesModel();
						CurrentSem current = new CurrentSemModel().getCurrentSemester();
						Semesters s = current.getSemesters();
						Students data = new Students();
						data.setStudentId(id);
						data.setEmail(email);
						data.setAddress(address);
						data.setCitizenId(citizenId);
						data.setTelephone(telephone);
						if (classId != -1) {
							Classes c = model.find(classId);
							data.setClasses(c);
						};
						data.setSemesters(s);
						data.setSex(sex);
						data.setFullname(fullname);
						
						
						if (_model.add(data)) {
							DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
							String row[] = {id, fullname, (String)tClass, (sex == 0) ? "Male" : "Female", email, telephone};
							tableModel.addRow(row);
							
							table.validate();
							table.repaint();
							resetTextField();
						} else {
							JOptionPane.showMessageDialog(new JPanel(), "ERROR insert!", "Error", JOptionPane.ERROR_MESSAGE);
						};
					};
				};
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		/* Click button update */
		btnUpdate.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
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
				String fullname = textName.getText().trim();
				String tClass = (String)boxClass.getSelectedItem();
				int classId = Helper.parseClassId(tClass);
				byte sex = 0;
				if (chFemale.isSelected()) {
					sex = 1;
				};
				String citizenId = textCitizen.getText().trim();
				String telephone = textTelephone.getText().trim();
				String email = textEmail.getText().trim();
				String address = textAddress.getText().trim();
				
				if (id.isBlank() || fullname.isBlank()) {
					message.setText("Fill all require!");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please fill profile ID and fullname!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
					
					Students data = _model.get(id);
					data.setFullname(fullname);
					data.setAddress(address);
					data.setTelephone(telephone);
					data.setEmail(email);
					data.setCitizenId(citizenId);
					data.setClasses(new ClassesModel().find(classId));
					data.setSex(sex);
					
					if (_model.updateById(id, data)) {
						tableModel.setValueAt(id, table.getSelectedRow(), 0);
						tableModel.setValueAt(fullname, table.getSelectedRow(), 1);
						tableModel.setValueAt(tClass, table.getSelectedRow(), 2);
						if (sex== 0) {
							chMale.setSelected(true);
							chFemale.setSelected(false);
						} else {
							chMale.setSelected(false);
							chFemale.setSelected(true);
						};
						tableModel.setValueAt((sex == 0) ? "Male" : "Female", table.getSelectedRow(), 3);
						tableModel.setValueAt(email, table.getSelectedRow(), 4);
						tableModel.setValueAt(telephone, table.getSelectedRow(), 5);
						
						JOptionPane.showMessageDialog(new JPanel(), "Update Successfully!", "Update", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(new JPanel(), "ERROR update!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				resetTextField();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		/* Click button Delete */
		btnDelete.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
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
				
				String id = textID.getText().trim();
				
				if (id.isBlank()) {
					message.setText("Select a specific account!");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please select an ID!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure delete student?",
							"Delete Semester", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
							options[0]);
					
					/* If click YES */
					if (res == 0) {
						DefaultTableModel tableMode = (DefaultTableModel)table.getModel();
						
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
				
				resetTextField();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		/* Event for data table */
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				
				String idField = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
				String nameField = tableModel.getValueAt(table.getSelectedRow(), 1).toString();
				String classField = tableModel.getValueAt(table.getSelectedRow(), 2).toString();
				String sexField = tableModel.getValueAt(table.getSelectedRow(), 3).toString();
				Object emailField = tableModel.getValueAt(table.getSelectedRow(), 4);
				String email = "";
				if (emailField != null) {
					email = emailField.toString();
				};
				Object telephoneField = tableModel.getValueAt(table.getSelectedRow(), 5);
				String telephone = "";
				if (telephoneField != null) {
					telephone = telephoneField.toString();
				};
				
				textID.setText(idField);
				textName.setText(nameField);
				textEmail.setText(email);
				boxClass.setSelectedItem(classField);
				if (sexField.equals("Male")) {
					chMale.setSelected(true);
					chFemale.setSelected(false);
				} else {
					chMale.setSelected(false);
					chFemale.setSelected(true);
				};
				textTelephone.setText(telephone);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
}
