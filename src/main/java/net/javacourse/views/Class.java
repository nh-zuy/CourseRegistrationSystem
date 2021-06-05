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
import net.javacourse.entities.Semesters;
import net.javacourse.models.ClassesModel;
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

public class Class extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Data model */
	private ClassesModel _model;
	
	/* View component */
	private JTable table;
	private JPanel header;
	private JTextField textID;
	private JButton btnAdd, btnUpdate, btnDelete;
	private JLabel message;
	private JTextField textName;
	private JTextField textMale;
	private JTextField textFemale;
	private JTextField textTotal;

	
	/**
	 * Create the panel.
	 */
	public Class() {
		setBorder(null);
		this._model = new ClassesModel();
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Manage Class");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(311, 0, 363, 43);
		title_1.add(lblNewLabel_1);
		
		message = new JLabel("* Select row to handle data !");
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setForeground(Color.BLACK);
		message.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		message.setBounds(376, 38, 229, 32);
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
		
		JLabel lblId = new JLabel("Class ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.RED);
		lblId.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblId.setBounds(0, 2, 97, 50);
		forminput_1_2.add(lblId);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setText("");
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		textID.setColumns(10);
		textID.setBorder(null);
		textID.setBounds(98, 2, 160, 50);
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
		
		JPanel forminput_1_4 = new JPanel();
		forminput_1_4.setLayout(null);
		forminput_1_4.setPreferredSize(new Dimension(1000, 50));
		forminput_1_4.setBackground(new Color(119, 165, 251));
		forminput_1_4.setBounds(366, 131, 176, 50);
		input.add(forminput_1_4);
		
		JLabel lblName_1 = new JLabel("Males");
		lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1.setForeground(Color.BLACK);
		lblName_1.setFont(new Font("Chilanka", Font.BOLD, 15));
		lblName_1.setBounds(0, 3, 74, 50);
		forminput_1_4.add(lblName_1);
		
		textMale = new JTextField();
		textMale.setText("");
		textMale.setHorizontalAlignment(SwingConstants.CENTER);
		textMale.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textMale.setColumns(10);
		textMale.setBorder(null);
		textMale.setBounds(70, 12, 94, 26);
		forminput_1_4.add(textMale);
		
		JPanel forminput_1_5 = new JPanel();
		forminput_1_5.setLayout(null);
		forminput_1_5.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5.setBackground(new Color(119, 165, 251));
		forminput_1_5.setBounds(553, 130, 165, 50);
		input.add(forminput_1_5);
		
		JLabel lblName_2 = new JLabel("Females");
		lblName_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_2.setForeground(Color.BLACK);
		lblName_2.setFont(new Font("Chilanka", Font.BOLD, 15));
		lblName_2.setBounds(0, 3, 70, 50);
		forminput_1_5.add(lblName_2);
		
		textFemale = new JTextField();
		textFemale.setText("");
		textFemale.setHorizontalAlignment(SwingConstants.CENTER);
		textFemale.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textFemale.setColumns(10);
		textFemale.setBorder(null);
		textFemale.setBounds(70, 12, 83, 26);
		forminput_1_5.add(textFemale);
		
		JPanel forminput_1_2_1 = new JPanel();
		forminput_1_2_1.setLayout(null);
		forminput_1_2_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_2_1.setBackground(new Color(119, 165, 251));
		forminput_1_2_1.setBounds(173, 69, 352, 50);
		input.add(forminput_1_2_1);
		
		JLabel Name = new JLabel("Class Name");
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setForeground(Color.RED);
		Name.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		Name.setBounds(0, 2, 121, 50);
		forminput_1_2_1.add(Name);
		
		textName = new JTextField();
		textName.setText("");
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setFont(new Font("Arial", Font.BOLD, 20));
		textName.setColumns(10);
		textName.setBorder(null);
		textName.setBounds(120, 2, 220, 50);
		forminput_1_2_1.add(textName);
		
		JPanel forminput_1_5_1 = new JPanel();
		forminput_1_5_1.setLayout(null);
		forminput_1_5_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5_1.setBackground(new Color(119, 165, 251));
		forminput_1_5_1.setBounds(173, 131, 182, 50);
		input.add(forminput_1_5_1);
		
		JLabel lblName_2_1 = new JLabel("Total");
		lblName_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_2_1.setForeground(Color.BLACK);
		lblName_2_1.setFont(new Font("Chilanka", Font.BOLD, 20));
		lblName_2_1.setBounds(0, 3, 75, 50);
		forminput_1_5_1.add(lblName_2_1);
		
		textTotal = new JTextField();
		textTotal.setText("0");
		textTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textTotal.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textTotal.setColumns(10);
		textTotal.setBorder(null);
		textTotal.setBounds(82, 12, 88, 26);
		forminput_1_5_1.add(textTotal);
		
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
		textID.setText("");
		textName.setText("");
		textTotal.setText("0");
		textMale.setText("0");
		textFemale.setText("0");
		
		this.validate();
		this.repaint();
	}

	/**
	 * Show information account
	 */
	private void setData() {
		/* Set data for JTable */
		List<Classes> classes = this._model.getAll();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = new Vector<String>();
		Vector<String> headers = new Vector<String>();
		headers.add("Class ID");
		headers.add("Class Name");
		headers.add("Total");
		headers.add("Males");
		headers.add("Females");

		for (Classes c: classes) {
			row.add(String.valueOf(c.getClassId()));
			row.add(c.getName());
			row.add(String.valueOf(c.getTotal()));
			row.add(String.valueOf(c.getTotalMales()));
			row.add(String.valueOf(c.getTotalFemales()));
			
			data.add(new Vector<String>(row));
			row.clear();
		};

		table = new JTable(data, headers);
		table.setRowHeight(28);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(21);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getTableHeader().setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
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
		/* Only one checkbox is selected on time */

		
		/* Click button */
		btnAdd.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String name = textName.getText().trim();
				String tTotal = textTotal.getText().trim();
				int total = Integer.parseInt(tTotal);
				String tMale = textMale.getText().trim();
				int male = Integer.parseInt(tMale);
				String tFemale = textFemale.getText().trim();
				int female = Integer.parseInt(tFemale);
				
				if (name.isBlank() || tMale.isBlank() || tFemale.isBlank() || male == 0 || female == 0) {
					message.setText("Fill all blank !");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please fill all blank!", "Error", JOptionPane.ERROR_MESSAGE);
				}  else if (total != (male + female)) {
					message.setText("Invalid value!");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Sum of males and females must to be the same Total!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure add new class?", "New Class",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					
					if (res == 0) {
						Classes newClass = new Classes(name, total, male, female);
						int gid = _model.add(newClass);
						
						if (gid != -1) {
							DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
							String row[] = {String.valueOf(gid), name, String.valueOf(total), String.valueOf(male), String.valueOf(female)};
							tableModel.addRow(row);
							
							table.validate();
							table.repaint();
							resetTextField();
						} else {
							JOptionPane.showMessageDialog(new JPanel(), "ERROR save!", "Error", JOptionPane.ERROR_MESSAGE);
						};
					}
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
				
				String tID = textID.getText().trim();
				int id = Integer.parseInt(tID);
				String name = textName.getText().trim();
				String tTotal = textTotal.getText().trim();
				int total = Integer.parseInt(tTotal);
				String tMale = textMale.getText().trim();
				int male = Integer.parseInt(tMale);
				String tFemale = textFemale.getText().trim();
				int female = Integer.parseInt(tFemale);
				
				if (tID.isBlank() || name.isBlank() || tTotal.isBlank() || tMale.isBlank() || tFemale.isBlank()) {
					message.setText("Fill all blank !");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please fill all blank!", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (total != (male + female)) {
					message.setText("Invalid value!");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Sum of males and females must to be the same Total!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure update class?", "Update Class",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					
					if (res == 0) {
						Classes data = _model.find(id);
						data.setName(name);
						data.setTotal(total);
						data.setTotalMales(male);
						data.setTotalFemales(female);
						
						if (_model.updateById(id, data)) {
							DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
							tableModel.setValueAt(tID, table.getSelectedRow(), 0);
							tableModel.setValueAt(name, table.getSelectedRow(), 1);
							tableModel.setValueAt(tTotal, table.getSelectedRow(), 2);
							tableModel.setValueAt(tMale, table.getSelectedRow(), 3);
							tableModel.setValueAt(tFemale, table.getSelectedRow(), 4);
							
							JOptionPane.showMessageDialog(new JPanel(), "Update Successfully !", "Update", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(new JPanel(), "ERROR update !", "Error", JOptionPane.ERROR_MESSAGE);
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
				
				String tID = textID.getText().trim();
				int id = Integer.parseInt(tID);
				
				if (tID.isBlank()) {
					message.setText("Select a specific class!");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please select an ID!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure delete class?",
							"Delete Class", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
							options[0]);
					
					if (res == 0) {
						if (_model.deleteById(id)) {
							DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
							
							tableModel.removeRow(table.getSelectedRow());
							JOptionPane.showMessageDialog(new JPanel(), "Delete Successfully!", "Delete",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(new JPanel(), "ERROR Delete!", "Error",
									JOptionPane.ERROR_MESSAGE);
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
		
		/* Event for data table */
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				
				String idField = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
				String nameField = tableModel.getValueAt(table.getSelectedRow(), 1).toString();
				String totalField = tableModel.getValueAt(table.getSelectedRow(), 2).toString();
				String maleField = tableModel.getValueAt(table.getSelectedRow(), 3).toString();
				String femaleField = tableModel.getValueAt(table.getSelectedRow(), 4).toString();
				
				textID.setText(idField);
				textName.setText(nameField);
				textTotal.setText(totalField);
				textMale.setText(maleField);
				textFemale.setText(femaleField);
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
