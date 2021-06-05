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

import net.javacourse.entities.Courses;
import net.javacourse.entities.Semesters;
import net.javacourse.models.CoursesModel;
import net.javacourse.models.SemestersModel;
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

public class Course extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Data model */
	private CoursesModel _model;
	
	/* View component */
	private JTable table;
	private JPanel header;
	private JTextField textCode;
	private JButton btnAdd, btnUpdate, btnDelete;
	private JLabel message;
	private JTextField textName;
	private JTextField textCredit;
	private JTextField textSlot;

	private JComboBox<String> boxSem;

	
	/**
	 * Create the panel.
	 */
	public Course() {
		setBorder(null);
		this._model = new CoursesModel();
		
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
		title_1.setBackground(new Color(119, 165, 251));
		form.add(title_1);
		
		JLabel lblNewLabel_1 = new JLabel("Manage Course");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(311, 0, 363, 47);
		title_1.add(lblNewLabel_1);
		
		message = new JLabel("* Select row to handle data !");
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setForeground(Color.BLACK);
		message.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		message.setBounds(376, 47, 229, 23);
		title_1.add(message);
		
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
		
		JLabel lblId = new JLabel("Code");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.RED);
		lblId.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblId.setBounds(0, 2, 97, 50);
		forminput_1_2.add(lblId);
		
		textCode = new JTextField();
		textCode.setText("");
		textCode.setHorizontalAlignment(SwingConstants.CENTER);
		textCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		textCode.setColumns(10);
		textCode.setBorder(null);
		textCode.setBounds(98, 2, 160, 50);
		forminput_1_2.add(textCode);
		
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
		
		JPanel forminput_1_3 = new JPanel();
		forminput_1_3.setLayout(null);
		forminput_1_3.setPreferredSize(new Dimension(1000, 50));
		forminput_1_3.setBackground(new Color(119, 165, 251));
		forminput_1_3.setBounds(440, 0, 279, 50);
		input.add(forminput_1_3);
		
		JLabel lblFullname = new JLabel("Semester");
		lblFullname.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullname.setForeground(Color.BLACK);
		lblFullname.setFont(new Font("Chilanka", Font.BOLD, 15));
		lblFullname.setBounds(24, 2, 78, 50);
		forminput_1_3.add(lblFullname);
		
		
		DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<String>();
		boxSem = new JComboBox<String>(boxModel);
		boxSem.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		boxSem.setBounds(109, 13, 158, 24);
		forminput_1_3.add(boxSem);
		
		JPanel forminput_1_4 = new JPanel();
		forminput_1_4.setLayout(null);
		forminput_1_4.setPreferredSize(new Dimension(1000, 50));
		forminput_1_4.setBackground(new Color(119, 165, 251));
		forminput_1_4.setBounds(173, 130, 279, 50);
		input.add(forminput_1_4);
		
		JLabel lblName_1 = new JLabel("Credits");
		lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1.setForeground(Color.BLACK);
		lblName_1.setFont(new Font("Chilanka", Font.BOLD, 15));
		lblName_1.setBounds(0, 3, 88, 50);
		forminput_1_4.add(lblName_1);
		
		textCredit = new JTextField();
		textCredit.setText("");
		textCredit.setHorizontalAlignment(SwingConstants.CENTER);
		textCredit.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textCredit.setColumns(10);
		textCredit.setBorder(null);
		textCredit.setBounds(91, 12, 176, 26);
		forminput_1_4.add(textCredit);
		
		JPanel forminput_1_5 = new JPanel();
		forminput_1_5.setLayout(null);
		forminput_1_5.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5.setBackground(new Color(119, 165, 251));
		forminput_1_5.setBounds(449, 130, 270, 50);
		input.add(forminput_1_5);
		
		JLabel lblName_2 = new JLabel("Slots");
		lblName_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_2.setForeground(Color.BLACK);
		lblName_2.setFont(new Font("Chilanka", Font.BOLD, 15));
		lblName_2.setBounds(0, 3, 88, 50);
		forminput_1_5.add(lblName_2);
		
		textSlot = new JTextField();
		textSlot.setText("");
		textSlot.setHorizontalAlignment(SwingConstants.CENTER);
		textSlot.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textSlot.setColumns(10);
		textSlot.setBorder(null);
		textSlot.setBounds(82, 12, 176, 26);
		forminput_1_5.add(textSlot);
		
		JPanel forminput_1_2_1 = new JPanel();
		forminput_1_2_1.setLayout(null);
		forminput_1_2_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_2_1.setBackground(new Color(119, 165, 251));
		forminput_1_2_1.setBounds(173, 62, 546, 50);
		input.add(forminput_1_2_1);
		
		JLabel Name = new JLabel("Course Name");
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setForeground(Color.RED);
		Name.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		Name.setBounds(0, 2, 149, 50);
		forminput_1_2_1.add(Name);
		
		textName = new JTextField();
		textName.setText("");
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setFont(new Font("Arial", Font.BOLD, 20));
		textName.setColumns(10);
		textName.setBorder(null);
		textName.setBounds(167, 2, 367, 50);
		forminput_1_2_1.add(textName);
		
		/* Manipulating data */
		this.resetTextField();
		this.setData();
		this.setEventButton();
	}
	
	/**
	 * Reset data in textfield
	 */
	private void resetTextField() {
		message.setForeground(Color.BLACK);
		message.setText("* Select row to handle data!");
		textCode.setText("");
		textName.setText("");
		textCredit.setText("0");
		textSlot.setText("0");
		
		this.validate();
		this.repaint();
	}

	/**
	 * Show information account
	 */
	private void setData() {
		/* Set data for JTable */
		List<Courses> courses = this._model.getAll();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = new Vector<String>();
		Vector<String> headers = new Vector<String>();
		headers.add("Code");
		headers.add("Course Name");
		headers.add("Semester");
		headers.add("Credit");
		headers.add("Slot");

		for (Courses course: courses) {
			row.add(course.getCode());
			row.add(course.getName());
			Semesters sem = course.getSemesters();
			if (sem != null) {
				row.add(sem.getYear() + " - " + sem.getSubName() + " " + "(" + sem.getSemId() + ")");
			} else {
				row.add("NULL");
			};
			
			row.add(String.valueOf(course.getCredits()));
			row.add(String.valueOf(course.getSlots()));

			data.add(new Vector<String>(row));
			row.clear();
		};

		table = new JTable(data, headers);
		table.setRowHeight(28);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getTableHeader().setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		JScrollPane sp = new JScrollPane(table);
		header.add(sp);
		
		/* Set data for JComboBox Semester */
		SemestersModel semModel = new SemestersModel();
		List<Semesters> semesters = semModel.getAll();
		DefaultComboBoxModel<String> boxModel = (DefaultComboBoxModel<String>) boxSem.getModel();
		for (Semesters sem: semesters) {
			boxModel.addElement(sem.getYear() + " - " + sem.getSubName() + " " + "(" + sem.getSemId() + ")");
		};
	}
	
	/**
	 * 
	 */
	private void setEventButton() {
		/* Only one checkbox is selected on time */

		
		/* Click button */
		btnAdd.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String code = textCode.getText().trim();
				String name = textName.getText().trim();
				String sem = (String)boxSem.getSelectedItem();
				Integer semId = Helper.parseSemesterId(sem);
				String credit = textCredit.getText().trim();
				int credits = Integer.parseInt(credit);
				String slot = textSlot.getText().trim();
				int slots = Integer.parseInt(slot);
				
				if (code.isBlank() || name.isBlank() || credit.isBlank() || slot.isBlank() || semId == -1 || credits == 0 || slots == 0) {
					message.setText("Fill all blank !");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please fill all blank!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure adding new course?", "New Course",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					
					if (res == 0) {
						SemestersModel semModel = new SemestersModel();
						Semesters semester = semModel.find(semId);
						Courses data = new Courses(code, name, credits, slots, semester.getYear());
						data.setSemesters(semester);
						
						if (_model.add(data)) {
							DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
							String row[] = {code, name, sem, credit, slot};
							tableModel.addRow(row);
							
							table.validate();
							table.repaint();
							resetTextField();
						} else {
							JOptionPane.showMessageDialog(new JPanel(), "ERROR save!", "Error", JOptionPane.ERROR_MESSAGE);
						}
					};
				}
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
				
				String code = textCode.getText().trim();
				String name = textName.getText().trim();
				String sem = (String)boxSem.getSelectedItem();
				Integer semId = Helper.parseSemesterId(sem);
				String credit = textCredit.getText().trim();
				int credits = Integer.parseInt(credit);
				String slot = textSlot.getText().trim();
				int slots = Integer.parseInt(slot);
				
				if (code.isBlank() || name.isBlank() || credit.isBlank() || slot.isBlank() || semId == -1 || credits == 0 || slots == 0) {
					message.setText("Fill all blank !");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please fill all blank!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
					
					Courses data = _model.get(code);
					data.setName(name);
					data.setCredits(credits);
					data.setSlots(slots);
					SemestersModel model = new SemestersModel();
					Semesters semester = model.find(semId);
					data.setSemesters(semester);
					
					if (_model.updateById(code, data)) {
						tableModel.setValueAt(code, table.getSelectedRow(), 0);
						tableModel.setValueAt(name, table.getSelectedRow(), 1);
						tableModel.setValueAt(semester.getYear() + " - " + semester.getSubName() + " " + "(" + semester.getSemId() + ")", table.getSelectedRow(), 2);
						tableModel.setValueAt(credit, table.getSelectedRow(), 3);
						tableModel.setValueAt(slot, table.getSelectedRow(), 4);
						
						JOptionPane.showMessageDialog(new JPanel(), "Update Successfully !", "Update", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(new JPanel(), "ERROR update !", "Error", JOptionPane.ERROR_MESSAGE);
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
		
		/* Click button Delete */
		btnDelete.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if (table.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(new JPanel(), "Please select one row !", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				};
				if (table.getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(new JPanel(), "Only one row can be deleted on time!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				};
				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(new JPanel(), "Blank table !", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				};
				
				String code = textCode.getText().trim();
				
				if (code.isBlank()) {
					message.setText("Select a specific account!");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please select an ID!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure delete this course?",
							"Delete Semester", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
							options[0]);
					
					/* If click YES */
					if (res == 0) {
						DefaultTableModel tableMode = (DefaultTableModel)table.getModel();
						
						if (_model.deleteById(code)) {
							tableMode.removeRow(table.getSelectedRow());

							JOptionPane.showMessageDialog(new JPanel(), "Delete Successfully!", "Delete",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(new JPanel(), "ERROR Delete !", "Error",
									JOptionPane.ERROR_MESSAGE);
						};
					};
				}
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
				
				String codeField = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
				String nameField = tableModel.getValueAt(table.getSelectedRow(), 1).toString();
				Object semField = tableModel.getValueAt(table.getSelectedRow(), 2);
				String creditField = tableModel.getValueAt(table.getSelectedRow(), 3).toString();
				String slotField = tableModel.getValueAt(table.getSelectedRow(), 4).toString();
				
				textCode.setText(codeField);
				textName.setText(nameField);
				boxSem.setSelectedItem(semField);
				textCredit.setText(creditField);
				textSlot.setText(slotField);
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
