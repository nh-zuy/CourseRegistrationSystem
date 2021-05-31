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

public class Course extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Data model */
	private SemestersModel _model;
	
	/* View component */
	private JTable table;
	private JPanel header;
	private JTextField textYear, textCode, textSem;
	private JButton btnAdd, btnUpdate, btnDelete;
	private JLabel message;
	private JTextField textName;
	private JTextField textCredit;
	private JTextField textSlot;

	
	/**
	 * Create the panel.
	 */
	public Course() {
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
		forminput_1_2.setBounds(173, 0, 243, 50);
		input.add(forminput_1_2);
		
		JLabel lblId = new JLabel("Code");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Chilanka", Font.BOLD, 15));
		lblId.setBounds(0, 2, 97, 50);
		forminput_1_2.add(lblId);
		
		textCode = new JTextField();
		textCode.setText("");
		textCode.setHorizontalAlignment(SwingConstants.CENTER);
		textCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textCode.setColumns(10);
		textCode.setBorder(null);
		textCode.setBounds(98, 11, 137, 26);
		forminput_1_2.add(textCode);
		
		JPanel forminput_1 = new JPanel();
		forminput_1.setLayout(null);
		forminput_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1.setBackground(new Color(119, 165, 251));
		forminput_1.setBounds(449, 62, 270, 50);
		input.add(forminput_1);
		
		JLabel lblName = new JLabel("Year");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Chilanka", Font.BOLD, 15));
		lblName.setBounds(0, 3, 88, 50);
		forminput_1.add(lblName);
		
		textYear = new JTextField();
		textYear.setText("");
		textYear.setHorizontalAlignment(SwingConstants.CENTER);
		textYear.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textYear.setColumns(10);
		textYear.setBorder(null);
		textYear.setBounds(82, 12, 176, 26);
		forminput_1.add(textYear);
		
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
		
		JLabel lblFullname = new JLabel("Semester");
		lblFullname.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullname.setForeground(Color.BLACK);
		lblFullname.setFont(new Font("Chilanka", Font.BOLD, 15));
		lblFullname.setBounds(0, 2, 78, 50);
		forminput_1_3.add(lblFullname);
		
		textSem = new JTextField();
		textSem.setText("");
		textSem.setHorizontalAlignment(SwingConstants.CENTER);
		textSem.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textSem.setColumns(10);
		textSem.setBorder(null);
		textSem.setBounds(81, 11, 186, 26);
		forminput_1_3.add(textSem);
		
		JPanel forminput_1_4 = new JPanel();
		forminput_1_4.setLayout(null);
		forminput_1_4.setPreferredSize(new Dimension(1000, 50));
		forminput_1_4.setBackground(new Color(119, 165, 251));
		forminput_1_4.setBounds(173, 130, 279, 50);
		input.add(forminput_1_4);
		
		JLabel lblName_1 = new JLabel("Credits");
		lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1.setForeground(new Color(0, 128, 0));
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
		lblName_2.setForeground(new Color(255, 0, 0));
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
		forminput_1_2_1.setBounds(417, 0, 302, 50);
		input.add(forminput_1_2_1);
		
		JLabel Name = new JLabel("Name");
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setForeground(Color.BLACK);
		Name.setFont(new Font("Chilanka", Font.BOLD, 15));
		Name.setBounds(0, 2, 79, 50);
		forminput_1_2_1.add(Name);
		
		textName = new JTextField();
		textName.setText("");
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textName.setColumns(10);
		textName.setBorder(null);
		textName.setBounds(82, 11, 208, 26);
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
		message.setText("* Select row to handle data !");
		textYear.setText("");
		textSem.setText("0");
		textCode.setText("");
		
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
				
				String tID = textCode.getText().trim();
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
