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
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

public class Portal extends JPanel {
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
	private JPanel title;
	private JButton btnRegister;
	private JLabel time;

	/**
	 * Create the panel.
	 */
	public Portal(Students account) {
		setBorder(null);
		this._account = account;
		this._model = new StudiesModel();

		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		JPanel form = new JPanel();
		form.setBackground(new Color(119, 165, 251));
		add(form, BorderLayout.CENTER);
		form.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel title_1 = new JPanel();
		title_1.setLayout(null);
		title_1.setPreferredSize(new Dimension(1000, 100));
		title_1.setBackground(new Color(119, 165, 251));
		form.add(title_1);
		
		JLabel portalTitle = new JLabel("Course Registration Time");
		portalTitle.setHorizontalAlignment(SwingConstants.CENTER);
		portalTitle.setForeground(Color.WHITE);
		portalTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		portalTitle.setBackground(Color.WHITE);
		portalTitle.setBounds(273, 12, 437, 47);
		title_1.add(portalTitle);
		
		time = new JLabel("Time register: ");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setForeground(Color.RED);
		time.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		time.setBounds(278, 61, 427, 33);
		title_1.add(time);
		
		title = new JPanel();
		title.setLayout(null);
		title.setPreferredSize(new Dimension(1000, 70));
		title.setBackground(new Color(119, 165, 251));
		form.add(title);
		
		btnRegister = new JButton("Register");
		btnRegister.setFocusPainted(false);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnRegister.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRegister.setBackground(Color.ORANGE);
		btnRegister.setBounds(422, 0, 138, 46);
		title.add(btnRegister);

		header = new JPanel();
		header.setBorder(new LineBorder(Color.WHITE, 5));
		header.setBackground(Color.WHITE);
		header.setPreferredSize(new Dimension(100, 450));
		add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));

		/* Role: Admin/Student */
		Date now = new Date();
		
		SessionsModel sessionModel = new SessionsModel();
		List<Sessions> sessions = sessionModel.getAll();
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		for (Sessions session: sessions) {
			Date start = null;
			Date end = null;
			try {
				start = fm.parse(session.getStartDay().toString());
				end = fm.parse(session.getEndDay().toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
			if (start.compareTo(now) > 0 || end.compareTo(now) < 0) {
				time.setText("");
				portalTitle.setText("Not in register time");
				portalTitle.setForeground(Color.RED);
				btnRegister.setVisible(false);
				JOptionPane.showMessageDialog(new JPanel(), "Not in course registration time!", "Error", JOptionPane.ERROR_MESSAGE);	
			} else {
				/* Time remaining */
				SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
				String quote = time.getText().trim();
				quote = quote + " " + dfm.format(start) + " - " + dfm.format(end);
				time.setText(quote);
						
				/* Manipulating data */
				this.resetTextField();
				this.setData();
				this.setEventButton();
				break;
			}
		};
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
		
		/* Data in table */
		SchedulesModel scheduleModel = new SchedulesModel();
		List<Schedules> schedules = scheduleModel.getAll();
		this._studies = _model.getAll();
		
		List<Integer> schedule = new ArrayList<Integer>();
		for (Studies study: _studies) {
			schedule.add(study.getSchedules().getId());
		}

		table = new JTable();
		// Model for Table
		DefaultTableModel model = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column) {
				switch (column) {

				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				case 5:
					return Boolean.class;
				default:
					return String.class;

				}
			}
		};
		table.setModel(model);
		
		model.addColumn("ID");
		model.addColumn("Course");
		model.addColumn("Day");
		model.addColumn("Shift");
		model.addColumn("Room");
		model.addColumn("Register");
		
		for (int i = 0; i < schedules.size(); ++i) {
			model.addRow(new Object[0]);
			 model.setValueAt(schedules.get(i).getId().toString(), i, 0);
			 model.setValueAt(schedules.get(i).getCourses().getName() + " (" + schedules.get(i).getCourses().getCode() + ")", i, 1);
			 model.setValueAt(schedules.get(i).getDay(), i, 2);
			 model.setValueAt(String.valueOf(schedules.get(i).getShift()), i, 3);
			 model.setValueAt(schedules.get(i).getRoom(), i, 4);
			 
			 if (schedule.contains(schedules.get(i).getId())) {
				 model.setValueAt(true, i, 5);
			 } else {
				 model.setValueAt(false, i, 5);
			 };
		};
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getTableHeader().setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(table);
		header.add(sp);
	}

	/**
	 * 
	 */
	private void setEventButton() {
		btnRegister.addActionListener(e -> {
			String[] options = { "Yes", "No" };

			int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure register courses?", "Register",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (res != 0) {
				return;
			};
			
			List<String> courses = new ArrayList<String>();
			
			for (int i = 0; i < table.getRowCount(); ++i) {
				Boolean checked = Boolean.valueOf(table.getValueAt(i, 5).toString());
		        
		        if (checked) {
		        	String id = table.getValueAt(i, 0).toString();
			        courses.add(id);
		        };
			};
			
			for (Studies study: this._studies) {
				if (!courses.contains(study.getSchedules().getId().toString())) {
					this._model.deleteById(study.getId());
				};
			};
			
			List<Integer> c = new ArrayList<Integer>();
			for (Studies study: this._studies) {
				if (study.getStudents().getStudentId().equals(this._account.getStudentId())) {
					c.add(study.getSchedules().getId());
				};
			};
			
			for (String id: courses) {
				Integer ID = Integer.parseInt(id);
				Schedules s = new SchedulesModel().find(ID);
				
				if (!c.contains(ID)) {
					Studies data = new Studies();
					data.setStudents(_account);
					data.setSchedules(s);
					
					boolean isConcur = false;
					
					for (Studies study: this._studies) {
						if (study.getSchedules().getDay().equals(s.getDay()) && study.getSchedules().getShift() == s.getShift()) {
							isConcur = true;
							break;
						};
					};
					
					if (isConcur) {
						JOptionPane.showMessageDialog(new JPanel(), "Courses're overlapped*\n Try another course!", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						_model.add(data);
						this._studies.clear();
						this._studies = _model.getAll();
						c.clear();
						for (Studies study: this._studies) {
							if (study.getStudents().getStudentId().equals(this._account.getStudentId())) {
								c.add(study.getSchedules().getId());
							};
						};
					}
				};
			};
			
			resetTextField();
		});
		
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
