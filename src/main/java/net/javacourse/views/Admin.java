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
import net.javacourse.entities.Trainers;
import net.javacourse.settings.Size;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;


public class Admin extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Model */
	private Trainers _account;

	/* Current selection */
	private JButton _choice;
	
	/* View component */
	private JPanel contentPane;
	private JButton btnDashboard;
	private JButton btnCourse;
	private JButton btnSemester;
	private JButton btnStudent;
	private JButton btnAccount;
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
	
	/* Task */
	private JButton btnProfileSetting;

	private JButton btnExit;

	private JButton btnClasses;

	private JButton btnSchedule;

	private JButton btnSession;
	

	/**
	 * Create the frame.
	 */
	public Admin(Trainers account) {
		/* Load setting information */
		this._choice = btnDashboard;
		this._account = account;
		
		/* Initial view and event */
		this.initialView();
		this.setEventButton();
		this.setHoverButton();
		this.setCloseApp();
	}
	
	private void initialView() {
		/**
		 *  Common view 
		 **/
		setBounds(250, 20, Size.WIDTH_APP, Size.HEIGHT_APP);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		/**
		 *  Navigation left bar 
		 **/
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
		
		btnCourse = new JButton("Courses");
		btnCourse.setForeground(Color.WHITE);
		btnCourse.setFocusPainted(false);
		btnCourse.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
		btnCourse.setBorder(null);
		btnCourse.setBackground(new Color(23, 33, 53));
		btnCourse.setBounds(0, 218, 150, 53);
		nav.add(btnCourse);
		
		btnSemester = new JButton("Semesters");
		btnSemester.setForeground(Color.WHITE);
		btnSemester.setFocusPainted(false);
		btnSemester.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
		btnSemester.setBorder(null);
		btnSemester.setBackground(new Color(23, 33, 53));
		btnSemester.setBounds(0, 152, 150, 53);
		nav.add(btnSemester);
		
		btnAccount = new JButton("Accounts");
		btnAccount.setForeground(Color.WHITE);
		btnAccount.setFocusPainted(false);
		btnAccount.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
		btnAccount.setBorder(null);
		btnAccount.setBackground(new Color(23, 33, 53));
		btnAccount.setBounds(0, 351, 150, 53);
		nav.add(btnAccount);
		
		btnLogout = new JButton("Log out");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
		btnLogout.setFocusPainted(false);
		btnLogout.setBorder(null);
		btnLogout.setBackground(new Color(23, 33, 53));
		btnLogout.setBounds(0, 418, 150, 53);
		nav.add(btnLogout);
		
		btnStudent = new JButton("Students");
		btnStudent.setForeground(Color.WHITE);
		btnStudent.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
		btnStudent.setFocusPainted(false);
		btnStudent.setBorder(null);
		btnStudent.setBackground(new Color(23, 33, 53));
		btnStudent.setBounds(0, 284, 150, 53);
		nav.add(btnStudent);

		/**
		 * The top of the frame: Header
		 */
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
		dotquestion.setIcon(new ImageIcon(Admin.class.getResource("/images/icons8-search-property-32.png")));
		dotquestion.setBounds(940, 12, 48, 46);
		header.add(dotquestion);
		
		/**
		 * Main content
		 */
		JPanel main = new JPanel();
		contentPane.add(main, BorderLayout.CENTER);
		main.setLayout(new BorderLayout(0, 0));
		
		/* Status zone */
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
		avatar.setBounds(12, 22, 103, 65);
		avatar.setIcon(new ImageIcon(Admin.class.getResource("/images/icons8-male-user-64.png")));
		user.add(avatar);
		
		lblHiAdmin = new JLabel("Hello, admin @");
		lblHiAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblHiAdmin.setForeground(Color.WHITE);
		lblHiAdmin.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblHiAdmin.setBounds(0, 86, 142, 22);
		user.add(lblHiAdmin);
		
		btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(Admin.class.getResource("/images/icons8-safe-out-32.png")));
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(119, 165, 251));
		btnExit.setBounds(210, 45, 78, 31);
		btnExit.setBorder(null);
		btnExit.setFocusPainted(false);
		user.add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(192, 32, 6, 55);
		user.add(panel);
		
		notification = new JPanel();
		notification.setPreferredSize(new Dimension(200, 340));
		notification.setBackground(new Color(67, 119, 202));
		status.add(notification, BorderLayout.SOUTH);
		notification.setLayout(null);
		
		lblNotices = new JLabel("Notifications");
		lblNotices.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNotices.setForeground(Color.GREEN);
		lblNotices.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotices.setBounds(0, 0, 300, 38);
		notification.add(lblNotices);
		
		/* Task zone */
		task = new JPanel();
		task.setBackground(new Color(81,126,211));
		task.setPreferredSize(new Dimension(50, 50));
		status.add(task, BorderLayout.CENTER);
		task.setLayout(null);
		
		btnSchedule = new JButton("Schedules");
		btnSchedule.setHorizontalAlignment(SwingConstants.LEADING);
		btnSchedule.setIcon(new ImageIcon(Admin.class.getResource("/images/icons8-calendar-32.png")));
		btnSchedule.setForeground(Color.WHITE);
		btnSchedule.setFocusPainted(false);
		btnSchedule.setBorder(null);
		btnSchedule.setBackground(new Color(81,126,211));
		btnSchedule.setBounds(12, 41, 121, 31);
		task.add(btnSchedule);
		
		btnClasses = new JButton("Classes");
		btnClasses.setHorizontalAlignment(SwingConstants.LEADING);
		btnClasses.setIcon(new ImageIcon(Admin.class.getResource("/images/icons8-study-32.png")));
		btnClasses.setForeground(Color.WHITE);
		btnClasses.setFocusPainted(false);
		btnClasses.setBorder(null);
		btnClasses.setBackground(new Color(81,126,211));
		btnClasses.setBounds(12, 109, 121, 31);
		task.add(btnClasses);
		
		btnProfileSetting = new JButton("My Profile");
		btnProfileSetting.setHorizontalAlignment(SwingConstants.LEADING);
		btnProfileSetting.setIcon(new ImageIcon(Admin.class.getResource("/images/icons8-admin-settings-male-32.png")));
		btnProfileSetting.setForeground(Color.WHITE);
		btnProfileSetting.setFocusPainted(false);
		btnProfileSetting.setBorder(null);
		btnProfileSetting.setBackground(new Color(81,126,211));
		btnProfileSetting.setBounds(174, 41, 126, 31);
		task.add(btnProfileSetting);
		
		btnSession = new JButton("Sessions");
		btnSession.setHorizontalAlignment(SwingConstants.LEADING);
		btnSession.setIcon(new ImageIcon(Admin.class.getResource("/images/icons8-course-assign-32.png")));
		btnSession.setForeground(Color.WHITE);
		btnSession.setFocusPainted(false);
		btnSession.setBorder(null);
		btnSession.setBackground(new Color(81,126,211));
		btnSession.setBounds(174, 109, 114, 31);
		task.add(btnSession);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(145, 27, 6, 130);
		task.add(panel_1);
		
		/**
		 * Main working space
		 */
		workspace = new JPanel();
		main.add(workspace, BorderLayout.CENTER);
		workspace.setLayout(new BorderLayout(5, 5));
	}
	
	/**
	 * 
	 */
	private void setCloseApp() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
	}
	
	/**
	 * Set event for button
	 * 1. Menu button
	 * 2. Task button
	 */
	private void setEventButton() {
		/* Menu button */
		btnAccount.addActionListener(e -> {
			workspace.removeAll();
			workspace.add(new Account(this._account));
			workspace.validate();
			workspace.repaint();
		});
		
		/* Task button */
		btnProfileSetting.addActionListener(e -> {
			workspace.removeAll();
			workspace.add(new Profile(this._account));
			workspace.validate();
			workspace.repaint();
		});
		
		/* Semester button */
		btnSemester.addActionListener(e -> {
			workspace.removeAll();
			workspace.add(new Semester());
			workspace.validate();
			workspace.repaint();
		});
		
		/* Course button */
		btnCourse.addActionListener(e -> {
			workspace.removeAll();
			workspace.add(new Course());
			workspace.validate();
			workspace.repaint();
		});
		
		/* Class button */
		btnStudent.addActionListener(e -> {
			workspace.removeAll();
			workspace.add(new StudentList());
			workspace.validate();
			workspace.repaint();
		});
		
		/* Classes button */
		btnClasses.addActionListener(e -> {
			workspace.removeAll();
			workspace.add(new Class());
			workspace.validate();
			workspace.repaint();
		});
		
		/* Schedule button */
		btnSchedule.addActionListener(e -> {
			workspace.removeAll();
			workspace.add(new Schedule());
			workspace.validate();
			workspace.repaint();
		});
		
		/* Session button */
		btnSession.addActionListener(e -> {
			workspace.removeAll();
			workspace.add(new Session());
			workspace.validate();
			workspace.repaint();
		});
		
		/* Logout button */
		btnLogout.addActionListener(e -> {
			String[] options = { "Yes", "No" };

			int res = JOptionPane.showOptionDialog(new JPanel(), "Sure Logout?", "Logout",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			
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
	}
	
	private void setHoverButton() {
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		buttons.add(btnDashboard);
		buttons.add(btnCourse);
		buttons.add(btnSemester);
		buttons.add(btnStudent);
		buttons.add(btnAccount);
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
	
	private void setSelection() {
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		buttons.add(btnDashboard);
		buttons.add(btnCourse);
		buttons.add(btnSemester);
		buttons.add(btnStudent);
		buttons.add(btnAccount);
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
