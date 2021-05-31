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

import net.javacourse.entities.Semesters;
import net.javacourse.models.SemestersModel;
import javax.swing.JCheckBox;

import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import net.javacourse.helpers.Helper;

public class Semester extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Data model */
	private SemestersModel _model;
	
	/* View component */
	private JTable table;
	private JPanel header;
	private JTextField textSubname, textID, textYear;
	private JButton btnAdd, btnUpdate, btnDelete;
	private JLabel message;

	private JDateChooser startDay;

	private JDateChooser endDay;

	
	/**
	 * Create the panel.
	 */
	public Semester() {
		setBorder(null);
		this._model = new SemestersModel();
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Manage Semester");
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
		forminput_1_2.setBounds(317, 0, 279, 50);
		input.add(forminput_1_2);
		
		JLabel lblId = new JLabel("Semester ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Chilanka", Font.BOLD, 15));
		lblId.setBounds(0, 2, 97, 50);
		forminput_1_2.add(lblId);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setText("");
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textID.setColumns(10);
		textID.setBorder(null);
		textID.setBounds(98, 11, 169, 26);
		forminput_1_2.add(textID);
		
		JPanel forminput_1 = new JPanel();
		forminput_1.setLayout(null);
		forminput_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1.setBackground(new Color(119, 165, 251));
		forminput_1.setBounds(449, 62, 270, 50);
		input.add(forminput_1);
		
		JLabel lblName = new JLabel("Subname");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Chilanka", Font.BOLD, 15));
		lblName.setBounds(0, 3, 88, 50);
		forminput_1.add(lblName);
		
		textSubname = new JTextField();
		textSubname.setText("");
		textSubname.setHorizontalAlignment(SwingConstants.CENTER);
		textSubname.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textSubname.setColumns(10);
		textSubname.setBorder(null);
		textSubname.setBounds(82, 12, 176, 26);
		forminput_1.add(textSubname);
		
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
		forminput_1_3.setBounds(173, 62, 279, 50);
		input.add(forminput_1_3);
		
		JLabel lblFullname = new JLabel("Year");
		lblFullname.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullname.setForeground(Color.BLACK);
		lblFullname.setFont(new Font("Chilanka", Font.BOLD, 15));
		lblFullname.setBounds(0, 2, 78, 50);
		forminput_1_3.add(lblFullname);
		
		textYear = new JTextField();
		textYear.setText("");
		textYear.setHorizontalAlignment(SwingConstants.CENTER);
		textYear.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textYear.setColumns(10);
		textYear.setBorder(null);
		textYear.setBounds(81, 11, 186, 26);
		forminput_1_3.add(textYear);
		
		JPanel forminput_1_4 = new JPanel();
		forminput_1_4.setLayout(null);
		forminput_1_4.setPreferredSize(new Dimension(1000, 50));
		forminput_1_4.setBackground(new Color(119, 165, 251));
		forminput_1_4.setBounds(173, 130, 279, 50);
		input.add(forminput_1_4);
		
		JLabel lblName_1 = new JLabel("Start Day");
		lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1.setForeground(new Color(0, 128, 0));
		lblName_1.setFont(new Font("Chilanka", Font.BOLD, 15));
		lblName_1.setBounds(0, 3, 88, 50);
		forminput_1_4.add(lblName_1);
		
		startDay = new JDateChooser();
		startDay.setBorder(null);
		startDay.setBounds(82, 12, 185, 26);
		startDay.setDateFormatString("dd-MM-yyyy");
		forminput_1_4.add(startDay);
		
		JPanel forminput_1_5 = new JPanel();
		forminput_1_5.setLayout(null);
		forminput_1_5.setPreferredSize(new Dimension(1000, 50));
		forminput_1_5.setBackground(new Color(119, 165, 251));
		forminput_1_5.setBounds(449, 130, 270, 50);
		input.add(forminput_1_5);
		
		JLabel lblName_2 = new JLabel("End Day");
		lblName_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_2.setForeground(new Color(255, 0, 0));
		lblName_2.setFont(new Font("Chilanka", Font.BOLD, 15));
		lblName_2.setBounds(0, 3, 88, 50);
		forminput_1_5.add(lblName_2);
		
		endDay = new JDateChooser();
		endDay.setBounds(81, 12, 177, 26);
		endDay.setDateFormatString("dd-MM-yyyy");
		forminput_1_5.add(endDay);
		
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
		textSubname.setText("");
		textYear.setText("0");
		textID.setText("");
		startDay.setDate(null);
		endDay.setDate(null);
		
		this.validate();
		this.repaint();
	}

	/**
	 * Show information account
	 */
	private void setData() {
		List<Semesters> semesters = this._model.getAll();

		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = new Vector<String>();
		Vector<String> headers = new Vector<String>();
		headers.add("Semester ID");
		headers.add("Year");
		headers.add("Subname");
		headers.add("Start Date");
		headers.add("End Date");

		for (Semesters sem : semesters) {
			row.add(String.valueOf(sem.getSemId()));
			row.add(String.valueOf(sem.getYear()));
			row.add(sem.getSubName());
			
			LocalDateTime start = Helper.toLocalDateTime(sem.getStartDay());
			LocalDateTime end = Helper.toLocalDateTime(sem.getEndDay());
			
			row.add(start.toString());
			row.add(end.toString());

			data.add(new Vector<String>(row));
			row.clear();
		};

		table = new JTable(data, headers);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(21);
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setPreferredWidth(16);
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
				String tYear = textYear.getText().trim();
				int year = Integer.parseInt(tYear);
				String subname = textSubname.getText().trim();
				Date start = startDay.getDate();
				Date end = endDay.getDate();
				
				if (tYear.isBlank() || subname.isBlank() || start == null || end == null) {
					message.setText("Fill all blank !");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please fill all blank !", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure adding new Semester ?", "New Semester",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					
					if (res == 0) {
						Semesters newSem = new Semesters(year, subname, start, end);
						int insertedID = _model.add(newSem);
						
						/* Add into db */
						if (insertedID != -1) {
							DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
							String data[] = {String.valueOf(insertedID), tYear, subname, Helper.toLocalDateTime(start).toString(), Helper.toLocalDateTime(end).toString()};
							tableModel.addRow(data);
							
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
				Integer id = Integer.parseInt(tID);
				String tYear = textYear.getText().trim();
				int year = Integer.parseInt(tYear);
				String subname = textSubname.getText().trim();
				Date start = startDay.getDate();
				Date end = endDay.getDate();
				
				if (tYear.isBlank() || subname.isBlank() || start == null || end == null) {
					message.setText("Fill all blank!");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please fill all blank!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure update it ?", "Update Semester",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					
					if (res == 0) {
						DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
						
						Semesters sem = _model.find(id);
						sem.setSubName(subname);
						sem.setYear(year);
						sem.setStartDay(start);
						sem.setEndDay(end);
						
						if (_model.updateById(id, sem)) {
							tableModel.setValueAt(tID, table.getSelectedRow(), 0);
							tableModel.setValueAt(tYear, table.getSelectedRow(), 1);
							tableModel.setValueAt(subname, table.getSelectedRow(), 2);
							tableModel.setValueAt(Helper.toLocalDateTime(start).toString(), table.getSelectedRow(), 3);
							tableModel.setValueAt(Helper.toLocalDateTime(end).toString(), table.getSelectedRow(), 4);
							
							JOptionPane.showMessageDialog(new JPanel(), "Update Successfully !", "Update", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(new JPanel(), "ERROR update !", "Error", JOptionPane.ERROR_MESSAGE);
						}
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
				
				String tID = textID.getText().trim();
				Integer id = Integer.parseInt(tID);
				
				if (tID.isBlank()) {
					message.setText("Select a specific account!");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please select an ID!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure delete this semester?",
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
				
				/* Get data from 1 row in table */
				String idField = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
				String yearField = tableModel.getValueAt(table.getSelectedRow(), 1).toString();
				String subnameField = tableModel.getValueAt(table.getSelectedRow(), 2).toString();
				String startField = tableModel.getValueAt(table.getSelectedRow(), 3).toString();
				String endField = tableModel.getValueAt(table.getSelectedRow(), 4).toString();
				
				/* Display data below */
				textID.setText(idField);
				textYear.setText(yearField);
				textSubname.setText(subnameField);
				LocalDateTime start = LocalDateTime.parse(startField);
				LocalDateTime end = LocalDateTime.parse(endField);
				startDay.setDate(Helper.toDate(start));
				endDay.setDate(Helper.toDate(end));
				table.validate();
				table.repaint();
				
				
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
