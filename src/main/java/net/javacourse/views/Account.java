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
import javax.swing.border.BevelBorder;

public class Account extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Data model */
	private TrainersModel _model;
	private Trainers _account;
	
	/* View component */
	private JTable table;
	private JPanel header;
	private JTextField textUsername, textPassword, textID, textFullname;
	private JButton btnAdd, btnUpdate, btnDelete;
	private JCheckBox chAdmin, chStudent;
	private JLabel message;
	
	/**
	 * Create the panel.
	 */
	public Account(Trainers account) {
		setBorder(null);
		this._account = account;
		this._model = new TrainersModel();
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Manage Account");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(311, 0, 363, 50);
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
		forminput_1_2.setBounds(204, 0, 238, 50);
		input.add(forminput_1_2);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Chilanka", Font.BOLD, 20));
		lblId.setBounds(0, 2, 34, 50);
		forminput_1_2.add(lblId);
		
		textID = new JTextField();
		textID.setText("");
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textID.setColumns(10);
		textID.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textID.setBounds(35, 12, 191, 26);
		forminput_1_2.add(textID);
		
		JPanel forminput_1 = new JPanel();
		forminput_1.setLayout(null);
		forminput_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1.setBackground(new Color(119, 165, 251));
		forminput_1.setBounds(318, 124, 289, 50);
		input.add(forminput_1);
		
		JLabel lblName = new JLabel("Username");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.YELLOW);
		lblName.setFont(new Font("Chilanka", Font.BOLD, 18));
		lblName.setBounds(0, 3, 88, 50);
		forminput_1.add(lblName);
		
		textUsername = new JTextField();
		textUsername.setText("");
		textUsername.setHorizontalAlignment(SwingConstants.CENTER);
		textUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textUsername.setColumns(10);
		textUsername.setBorder(null);
		textUsername.setBounds(98, 13, 177, 26);
		forminput_1.add(textUsername);
		
		JPanel forminput_1_1 = new JPanel();
		forminput_1_1.setLayout(null);
		forminput_1_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_1.setBackground(new Color(119, 165, 251));
		forminput_1_1.setBounds(318, 186, 289, 50);
		input.add(forminput_1_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.YELLOW);
		lblPassword.setFont(new Font("Chilanka", Font.BOLD, 17));
		lblPassword.setBounds(0, 2, 81, 50);
		forminput_1_1.add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setText("");
		textPassword.setHorizontalAlignment(SwingConstants.CENTER);
		textPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textPassword.setColumns(10);
		textPassword.setBorder(null);
		textPassword.setBounds(98, 11, 177, 26);
		forminput_1_1.add(textPassword);
		
		JPanel forminput_1_1_1 = new JPanel();
		forminput_1_1_1.setLayout(null);
		forminput_1_1_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_1_1.setBackground(new Color(119, 165, 251));
		forminput_1_1_1.setBounds(315, 62, 294, 50);
		input.add(forminput_1_1_1);
		
		/* Role: Admin/Student */
		JLabel lblRole = new JLabel("Role");
		lblRole.setHorizontalAlignment(SwingConstants.CENTER);
		lblRole.setForeground(Color.BLACK);
		lblRole.setFont(new Font("Chilanka", Font.BOLD, 20));
		lblRole.setBounds(0, 0, 49, 50);
		forminput_1_1_1.add(lblRole);
		
		chAdmin = new JCheckBox("Admin");
		chAdmin.setForeground(Color.YELLOW);
		chAdmin.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		chAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		chAdmin.setBounds(63, 0, 101, 50);
		chAdmin.setFocusPainted(false);
		chAdmin.setBackground(new Color(119, 165, 251));
		chAdmin.addActionListener(e -> {
			if (chStudent.isSelected()) {
				chStudent.setSelected(false);
			};
			chAdmin.setSelected(true);
		});
		forminput_1_1_1.add(chAdmin);
		
		chStudent = new JCheckBox("Student");
		chStudent.setHorizontalAlignment(SwingConstants.CENTER);
		chStudent.setForeground(Color.YELLOW);
		chStudent.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		chStudent.setFocusPainted(false);
		chStudent.setBackground(new Color(119, 165, 251));
		chStudent.setBounds(168, 0, 126, 50);
		chStudent.addActionListener(e -> {
			if (chAdmin.isSelected()) {
				chAdmin.setSelected(false);
			};
			chStudent.setSelected(true);
		});
		forminput_1_1_1.add(chStudent);
		
		/* Three of button */
		btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.GREEN);
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAdd.setBounds(731, 131, 86, 50);
		btnAdd.setFocusPainted(false);
		btnAdd.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		input.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 16));
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(0, 0, 0)));
		btnUpdate.setBackground(Color.YELLOW);
		btnUpdate.setBounds(731, 69, 86, 50);
		input.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
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
		forminput_1_3.setBounds(442, 0, 269, 50);
		input.add(forminput_1_3);
		
		JLabel lblFullname = new JLabel("Fullname");
		lblFullname.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullname.setForeground(Color.BLACK);
		lblFullname.setFont(new Font("Chilanka", Font.BOLD, 17));
		lblFullname.setBounds(0, 2, 78, 50);
		forminput_1_3.add(lblFullname);
		
		textFullname = new JTextField();
		textFullname.setText("");
		textFullname.setHorizontalAlignment(SwingConstants.CENTER);
		textFullname.setFont(new Font("Arial", Font.BOLD, 16));
		textFullname.setColumns(10);
		textFullname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFullname.setBounds(81, 11, 176, 26);
		forminput_1_3.add(textFullname);
		
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
		message.setText("* Select row to handle data !");
		textUsername.setText("");
		textFullname.setText("");
		textPassword.setText("");
		textID.setText("");
		chAdmin.setSelected(false);
		chStudent.setSelected(false);
		
		this.validate();
		this.repaint();
	}

	/**
	 * Show information account
	 */
	private void setData() {
		List<Trainers> admins = this._model.getAll();
		StudentsModel model = new StudentsModel();
		List<Students> students = model.getAll();
		
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = new Vector<String>();
		Vector<String> headers = new Vector<String>();
		headers.add("Profile ID");
		headers.add("Fullname");
		headers.add("Username");
		headers.add("Password");
		headers.add("Type");

		for (Trainers acc : admins) {
			row.add(acc.getTrainerId());
			row.add(acc.getFullname());
			row.add(acc.getUsername());
			row.add(acc.getPassword());
			row.add("Admin");

			data.add(new Vector<String>(row));
			row.clear();
		};
		for (Students acc : students) {
			row.add(acc.getStudentId());
			row.add(acc.getFullname());
			row.add(acc.getUsername());
			row.add(acc.getPassword());
			row.add("Student");

			data.add(new Vector<String>(row));
			row.clear();
		};
		
		table = new JTable(data, headers);
		table.setRowHeight(28);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getTableHeader().setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		JScrollPane sp = new JScrollPane(table);
		header.add(sp);
	}
	
	/**
	 * 
	 */
	private void setEventButton() {
		/* Click button */
		btnAdd.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String id = textID.getText().trim();
				String fullname = textFullname.getText().trim();
				String username = textUsername.getText().trim();
				String password = textPassword.getText().trim();
				String role = null;
				
				if (chAdmin.isSelected()) {
					role = "Admin";
				} else if (chStudent.isSelected()){
					role = "Student";
				};
				
				if (id.isBlank() || fullname.isBlank() || username.isBlank() || password.isBlank() || role == null) {
					message.setText("Fill all blank !");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please fill all blank !", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure add account?", "New Account",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					
					if (res == 0) {
						if (role.equals("Admin")) {
							Trainers newAdmin = new Trainers(id, username, password, fullname, (byte)0);
							
							/* Add into db */
							if (_model.add(newAdmin)) {
								DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
								String data[] = {id, fullname, username, password, role};
								tableModel.addRow(data);
								
								table.validate();
								table.repaint();
								resetTextField();
							} else {
								JOptionPane.showMessageDialog(new JPanel(), "ERROR insert!", "Error", JOptionPane.ERROR_MESSAGE);
							};
						} else {
							StudentsModel model = new StudentsModel();
							Students data = new Students(id, username, password, fullname, (byte)0);
							
							if (model.add(data)) {
								DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
								String row[] = {id, fullname, username, password, role};
								tableModel.addRow(row);
								
								table.validate();
								table.repaint();
								resetTextField();
							} else {
								JOptionPane.showMessageDialog(new JPanel(), "ERROR insert!", "Error", JOptionPane.ERROR_MESSAGE);
							};
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
				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(new JPanel(), "Blank table!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				};
				if (table.getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(new JPanel(), "Only one row can be deleted on time!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				};
				if (table.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(new JPanel(), "Please select one row!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				};
				
				String id = textID.getText().trim();
				String fullname = textFullname.getText().trim();
				String username = textUsername.getText().trim();
				String password = textPassword.getText().trim();
				String role = null;
				
				if (chAdmin.isSelected()) {
					role = "Admin";
				} else if (chStudent.isSelected()){
					role = "Student";
				};
				
				if (id.isBlank() || fullname.isBlank() || username.isBlank() || password.isBlank() || role == null) {
					message.setText("Fill all blank !");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please fill all blank!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure update account?", "Update Account",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					
					/* If click YES */
					if (res == 0) {
						DefaultTableModel tableMode = (DefaultTableModel)table.getModel();
						
						if (role.equals("Admin")) {
							/**
							 * Handle admin account 
							 */
							if (table.getSelectedRowCount() == 1) {
								Trainers admin = _model.get(id);
								admin.setFullname(fullname);
								admin.setUsername(username);
								admin.setPassword(password);
								
								if (_model.updateById(id, admin)) {
									tableMode.setValueAt(id, table.getSelectedRow(), 0);
									tableMode.setValueAt(fullname, table.getSelectedRow(), 1);
									tableMode.setValueAt(password, table.getSelectedRow(), 2);
									tableMode.setValueAt(username, table.getSelectedRow(), 3);
									tableMode.setValueAt(role, table.getSelectedRow(), 4);
									
									JOptionPane.showMessageDialog(new JPanel(), "Update Successfully !", "Update", JOptionPane.INFORMATION_MESSAGE);
								} else {
									JOptionPane.showMessageDialog(new JPanel(), "ERROR update !", "Error", JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(new JPanel(), "Only one row can be updated on time !", "Error", JOptionPane.ERROR_MESSAGE);
							};
						} else {
							/**
							 * Handle student account
							 */
							if (table.getSelectedRowCount() == 1) {
								StudentsModel model = new StudentsModel();
								Students data = model.get(id);
								data.setFullname(fullname);
								data.setUsername(username);
								data.setPassword(password);
								
								if (model.updateById(id, data)) {
									tableMode.setValueAt(id, table.getSelectedRow(), 0);
									tableMode.setValueAt(fullname, table.getSelectedRow(), 1);
									tableMode.setValueAt(password, table.getSelectedRow(), 2);
									tableMode.setValueAt(username, table.getSelectedRow(), 3);
									tableMode.setValueAt(role, table.getSelectedRow(), 4);
									
									JOptionPane.showMessageDialog(new JPanel(), "Update Successfully !", "Update", JOptionPane.INFORMATION_MESSAGE);
								} else {
									JOptionPane.showMessageDialog(new JPanel(), "ERROR update !", "Error", JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(new JPanel(), "Only one row can be updated on time!", "Error", JOptionPane.ERROR_MESSAGE);
							};
						};
						resetTextField();
					}
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
					JOptionPane.showMessageDialog(new JPanel(), "Please select one row!", "Error", JOptionPane.ERROR_MESSAGE);
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
				String role = null;
				if (chAdmin.isSelected()) {
					role = "Admin";
				} else if (chStudent.isSelected()){
					role = "Student";
				};
				
				if (id.isBlank()) {
					message.setText("Select a specific account!");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please select an ID!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure delete account ?",
							"Delete Account", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
							options[0]);
					
					/* If click YES */
					if (res == 0) {
						DefaultTableModel tableMode = (DefaultTableModel)table.getModel();
						
						if (role.equals("Admin")) {
							/**
							 * Handle admin account 
							 */
							if (id.equals(_account.getTrainerId())) {
								JOptionPane.showMessageDialog(new JPanel(), "Can't delete your current account!", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							};
							
							if (_model.deleteById(id)) {
								tableMode.removeRow(table.getSelectedRow());

								JOptionPane.showMessageDialog(new JPanel(), "Delete Successfully!", "Delete",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(new JPanel(), "ERROR Delete !", "Error",
										JOptionPane.ERROR_MESSAGE);
							};
						} else {
							/**
							 * Handle student account
							 */
							StudentsModel model = new StudentsModel();
							
							if (model.deleteById(id)) {
								tableMode.removeRow(table.getSelectedRow());

								JOptionPane.showMessageDialog(new JPanel(), "Delete Successfully!", "Delete",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(new JPanel(), "ERROR Delete!", "Error",
										JOptionPane.ERROR_MESSAGE);
							};
						};
						resetTextField();
					}
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
		
		/* Event for data table */
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

				/* Get the selected row data */
				String idField = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
				String fullnameField = tableModel.getValueAt(table.getSelectedRow(), 1).toString();
				String usernameField = tableModel.getValueAt(table.getSelectedRow(), 2).toString();
				String passwordField = tableModel.getValueAt(table.getSelectedRow(), 3).toString();
				String roleField = tableModel.getValueAt(table.getSelectedRow(), 4).toString();

				textID.setText(idField);
				textFullname.setText(fullnameField);
				textUsername.setText(usernameField);
				textPassword.setText(passwordField);
				if (roleField.equals("Admin")) {
					chAdmin.setSelected(true);
					chStudent.setSelected(false);
				} else {
					chAdmin.setSelected(false);
					chStudent.setSelected(true);
				}
				;
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
