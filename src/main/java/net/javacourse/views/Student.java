package net.javacourse.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import net.javacourse.controllers.LoginController;
import net.javacourse.entities.Students;
import net.javacourse.settings.Size;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;


public class Student extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Model */
	private Students _account;

	/* Current selection */
	private JButton _choice;
	
	/* View component */
	private JPanel contentPane;
	private JButton btnDashboard;
	private JButton btnCourse;
	private JButton btnClass;
	private JButton btnLogout;
	private JPanel user;
	private JPanel notification;
	private JPanel task;
	private JPanel workspace;
	private JLabel lblTitle;
	private JTextField search;
	private JLabel avatar;
	private JLabel lblHiAdmin;
	private JPanel panel_1;
	private JLabel lblNotices;

	private JButton btnExit;

	private JButton btnProfileSetting;

	private JButton btnCourses;
	

	/**
	 * Create the frame.
	 */
	public Student(Students account) {
		/* Load setting infor */
		this._choice = btnDashboard;
		this._account = account;
		
		this.initialView();
		this.setDashboard();
		this.setEventButton();
		this.setHoverButton();
		this.setCloseApp();
	}
	
	private void setDashboard() {
		workspace.removeAll();
		workspace.add(new Dashboard());
		workspace.validate();
		workspace.repaint();
	}
	
	/**
	 * 
	 */
	private void initialView() {
		setBounds(250, 100, Size.WIDTH_APP, Size.HEIGHT_APP);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		JPanel nav = new JPanel();
		nav.setPreferredSize(new Dimension(150, 100));
		nav.setBackground(new Color(23, 33,53));
		contentPane.add(nav, BorderLayout.WEST);
		nav.setLayout(null);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(0, 86, 150, 53);
		btnDashboard.setFocusPainted(false);
		btnDashboard.setForeground(Color.WHITE);
		btnDashboard.setBackground(new Color(39, 55, 80));
		btnDashboard.setBorder(new MatteBorder(0, 5, 0, 0, new Color(233, 229, 238)));
		btnDashboard.setFont(new Font("AnjaliOldLipi", Font.BOLD, 16));
		nav.add(btnDashboard);
		
		btnCourse = new JButton("Register");
		btnCourse.setForeground(Color.WHITE);
		btnCourse.setFocusPainted(false);
		btnCourse.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
		btnCourse.setBorder(null);
		btnCourse.setBackground(new Color(23, 33, 53));
		btnCourse.setBounds(0, 151, 150, 53);
		nav.add(btnCourse);
		
		btnClass = new JButton("My Class");
		btnClass.setForeground(Color.WHITE);
		btnClass.setFocusPainted(false);
		btnClass.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
		btnClass.setBorder(null);
		btnClass.setBackground(new Color(23, 33, 53));
		btnClass.setBounds(0, 215, 150, 53);
		nav.add(btnClass);
		
		btnLogout = new JButton("Log out");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
		btnLogout.setFocusPainted(false);
		btnLogout.setBorder(null);
		btnLogout.setBackground(new Color(23, 33, 53));
		btnLogout.setBounds(0, 280, 150, 53);
		nav.add(btnLogout);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(67, 119, 202));
		header.setPreferredSize(new Dimension(70, 70));
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(null);
		
		lblTitle = new JLabel("Course Registration");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 30));
		lblTitle.setBounds(12, 12, 324, 46);
		lblTitle.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblTitle.setFont(new Font("DejaVu Sans Light", Font.BOLD, 30));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblTitle.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 30));
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
		header.add(lblTitle);
		
		search = new JTextField();
		search.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		search.setText("Search ...");
		search.setBounds(730, 24, 202, 25);
		search.setBorder(null);
		header.add(search);
		search.setColumns(10);
		
		JLabel dotquestion = new JLabel("");
		dotquestion.setBackground(Color.WHITE);
		dotquestion.setForeground(Color.WHITE);
		dotquestion.setIcon(new ImageIcon(Student.class.getResource("/images/icons8-search-property-32.png")));
		dotquestion.setBounds(940, 12, 48, 46);
		header.add(dotquestion);
		
		JPanel main = new JPanel();
		contentPane.add(main, BorderLayout.CENTER);
		main.setLayout(new BorderLayout(0, 0));
		
		JPanel status = new JPanel();
		status.setPreferredSize(new Dimension(300, 300));
		main.add(status, BorderLayout.WEST);
		status.setLayout(new BorderLayout(0, 0));
		
		user = new JPanel();
		user.setBackground(new Color(119, 165, 251));
		user.setPreferredSize(new Dimension(120, 120));
		status.add(user, BorderLayout.NORTH);
		user.setLayout(null);
		
		avatar = new JLabel("");
		avatar.setHorizontalAlignment(SwingConstants.CENTER);
		avatar.setBounds(36, 22, 84, 65);
		avatar.setIcon(new ImageIcon(Student.class.getResource("/images/icons8-male-user-64.png")));
		user.add(avatar);
		
		lblHiAdmin = new JLabel("Hi, student <3");
		lblHiAdmin.setForeground(Color.WHITE);
		lblHiAdmin.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblHiAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblHiAdmin.setBounds(0, 86, 167, 22);
		user.add(lblHiAdmin);
		
		btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(Student.class.getResource("/images/icons8-safe-out-32.png")));
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(119, 165, 251));
		btnExit.setBounds(203, 45, 85, 31);
		btnExit.setBorder(null);
		btnExit.setFocusPainted(false);
		user.add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(185, 32, 6, 55);
		user.add(panel);
		
		notification = new JPanel();
		notification.setPreferredSize(new Dimension(200, 340));
		notification.setBackground(new Color(67, 119, 202));
		status.add(notification, BorderLayout.SOUTH);
		notification.setLayout(null);
		
		lblNotices = new JLabel("Notification");
		lblNotices.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNotices.setForeground(Color.GREEN);
		lblNotices.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotices.setBounds(72, 12, 170, 31);
		notification.add(lblNotices);
		
		task = new JPanel();
		task.setBackground(new Color(81,126,211));
		status.add(task, BorderLayout.CENTER);
		task.setLayout(null);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.setHorizontalAlignment(SwingConstants.LEADING);
		btnSchedule.setIcon(new ImageIcon(Student.class.getResource("/images/icons8-calendar-32.png")));
		btnSchedule.setForeground(Color.WHITE);
		btnSchedule.setFocusPainted(false);
		btnSchedule.setBorder(null);
		btnSchedule.setBackground(new Color(81,126,211));
		btnSchedule.setBounds(12, 41, 121, 31);
		task.add(btnSchedule);
		
		JButton btnMark = new JButton("Mark");
		btnMark.setHorizontalAlignment(SwingConstants.LEADING);
		btnMark.setIcon(new ImageIcon(Student.class.getResource("/images/icons8-study-32.png")));
		btnMark.setForeground(Color.WHITE);
		btnMark.setFocusPainted(false);
		btnMark.setBorder(null);
		btnMark.setBackground(new Color(81,126,211));
		btnMark.setBounds(12, 109, 121, 31);
		task.add(btnMark);
		
		btnProfileSetting = new JButton("My Profile");
		btnProfileSetting.setHorizontalAlignment(SwingConstants.LEADING);
		btnProfileSetting.setIcon(new ImageIcon(Student.class.getResource("/images/icons8-admin-settings-male-32.png")));
		btnProfileSetting.setForeground(Color.WHITE);
		btnProfileSetting.setFocusPainted(false);
		btnProfileSetting.setBorder(null);
		btnProfileSetting.setBackground(new Color(81,126,211));
		btnProfileSetting.setBounds(174, 41, 114, 31);
		task.add(btnProfileSetting);
		
		btnCourses = new JButton("Courses");
		btnCourses.setHorizontalAlignment(SwingConstants.LEADING);
		btnCourses.setIcon(new ImageIcon(Student.class.getResource("/images/icons8-course-assign-32.png")));
		btnCourses.setForeground(Color.WHITE);
		btnCourses.setFocusPainted(false);
		btnCourses.setBorder(null);
		btnCourses.setBackground(new Color(81,126,211));
		btnCourses.setBounds(174, 109, 114, 31);
		task.add(btnCourses);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(145, 27, 6, 130);
		task.add(panel_1);
		
		workspace = new JPanel();
		main.add(workspace, BorderLayout.CENTER);
		workspace.setLayout(new BorderLayout(5, 5));
	}
	
	private void setCloseApp() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
	}
	
	private void setEventButton() {
		/* Logout button */
		btnLogout.addActionListener(e -> {
			String[] options = { "Yes", "No" };

			int res = JOptionPane.showOptionDialog(new JPanel(), "Log Out?", "Log Out", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			if (res == 0) {
				dispose();
				/* Login again or not */
				new LoginController().run();
			};
		});
		
		/* Exit */
		btnExit.addActionListener(e -> {
			dispose();
			new LoginController().run();
		});
		
		btnDashboard.addActionListener(e -> {
			workspace.removeAll();
			workspace.add(new Dashboard());
			workspace.validate();
			workspace.repaint();
		});
		
		/**
		 * 
		 */
		btnProfileSetting.addActionListener(e -> {
			workspace.removeAll();
			workspace.add(new ProfileStudent(this._account));
			workspace.validate();
			workspace.repaint();
		});
		
		/* Class information *.
		 *
		 */
		btnClass.addActionListener(e -> {
			workspace.removeAll();
			workspace.add(new ClassStudent(this._account));
			workspace.validate();
			workspace.repaint();
		});
		
		/**
		 * 
		 */
		btnCourse.addActionListener(e -> {
			workspace.removeAll();
			workspace.add(new Portal(this._account));
			workspace.validate();
			workspace.repaint();
		});
		
		/**
		 * 
		 */
		btnCourses.addActionListener(e -> {
			workspace.removeAll();
			workspace.add(new CourseStudent(this._account));
			workspace.validate();
			workspace.repaint();
		});
	}
	
	private void setHoverButton() {
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		buttons.add(btnDashboard);
		buttons.add(btnCourse);
		buttons.add(btnClass);
		buttons.add(btnLogout);
		
		for (JButton btn: buttons) {
			btn.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					_choice = btn;
					setSelection();
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					if (_choice == btn) {
						return;
					};
					
					btn.setBackground(new Color(39, 55, 80));
					btn.setBorder(new MatteBorder(0, 5, 0, 0, new Color(233, 229, 238)));
					btn.setFont(new Font("AnjaliOldLipi", Font.BOLD, 16));
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					if (_choice == btn) {
						return;
					};
					
					btn.setBackground(new Color(23,33,53));
					btn.setBorder(null);
					btn.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
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
	
	/**
	 * 
	 */
	private void setSelection() {
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		buttons.add(btnDashboard);
		buttons.add(btnCourse);
		buttons.add(btnClass);
		buttons.add(btnLogout);
		
		for (JButton btn: buttons) {
			if (_choice == btn) {
				btn.setBackground(new Color(39, 55, 80));
				btn.setBorder(new MatteBorder(0, 5, 0, 0, new Color(233, 229, 238)));
				btn.setFont(new Font("AnjaliOldLipi", Font.BOLD, 16));
			} else {
				btn.setBackground(new Color(23,33,53));
				btn.setBorder(null);
				btn.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
			}
		};
		
		this.validate();
		this.repaint();
	}
}
