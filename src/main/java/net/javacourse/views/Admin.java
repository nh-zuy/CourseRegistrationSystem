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

import net.javacourse.models.AbstractModel;
import net.javacourse.settings.Size;

import javax.swing.JLabel;
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
	private AbstractModel _model;

	/* Current selection */
	private JButton _choice;
	
	/* View component */
	private JPanel contentPane;
	private JButton btnDashboard;
	private JButton btnCourse;
	private JButton btnSemester;
	private JButton btnClass;
	private JButton btnProfile;
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
	

	/**
	 * Create the frame.
	 */
	public Admin(AbstractModel model) {
		/* Load setting infor */
		this._model = model;
		this._choice = btnDashboard;
		this.initialView();
		this.setEventButton();
		this.setHoverButton();
		this.setCloseApp();
	}
	
	private void initialView() {
		/**
		 *  Common view 
		 **/
		setBounds(250, 100, Size.WIDTH_APP, Size.HEIGHT_APP);
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
		
		btnCourse = new JButton("Course");
		btnCourse.setForeground(Color.WHITE);
		btnCourse.setFocusPainted(false);
		btnCourse.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
		btnCourse.setBorder(null);
		btnCourse.setBackground(new Color(23, 33, 53));
		btnCourse.setBounds(0, 151, 150, 53);
		nav.add(btnCourse);
		
		btnSemester = new JButton("Semester");
		btnSemester.setForeground(Color.WHITE);
		btnSemester.setFocusPainted(false);
		btnSemester.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
		btnSemester.setBorder(null);
		btnSemester.setBackground(new Color(23, 33, 53));
		btnSemester.setBounds(0, 226, 150, 53);
		nav.add(btnSemester);
		
		btnProfile = new JButton("Profile");
		btnProfile.setForeground(Color.WHITE);
		btnProfile.setFocusPainted(false);
		btnProfile.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
		btnProfile.setBorder(null);
		btnProfile.setBackground(new Color(23, 33, 53));
		btnProfile.setBounds(0, 356, 150, 54);
		nav.add(btnProfile);
		
		btnLogout = new JButton("Logout");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
		btnLogout.setFocusPainted(false);
		btnLogout.setBorder(null);
		btnLogout.setBackground(new Color(23, 33, 53));
		btnLogout.setBounds(0, 422, 150, 53);
		nav.add(btnLogout);
		
		btnClass = new JButton("Class");
		btnClass.setForeground(Color.WHITE);
		btnClass.setFont(new Font("AnjaliOldLipi", Font.PLAIN, 16));
		btnClass.setFocusPainted(false);
		btnClass.setBorder(null);
		btnClass.setBackground(new Color(23, 33, 53));
		btnClass.setBounds(0, 291, 150, 54);
		nav.add(btnClass);

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
		
		lblHiAdmin = new JLabel("Hi, admin <3");
		lblHiAdmin.setForeground(Color.WHITE);
		lblHiAdmin.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblHiAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblHiAdmin.setBounds(12, 86, 103, 22);
		user.add(lblHiAdmin);
		
		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(Admin.class.getResource("/images/icons8-safe-out-32.png")));
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(119, 165, 251));
		btnExit.setBounds(237, 45, 51, 31);
		btnExit.setBorder(null);
		btnExit.setFocusPainted(false);
		user.add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(230, 32, 6, 55);
		user.add(panel);
		
		notification = new JPanel();
		notification.setPreferredSize(new Dimension(200, 200));
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
		status.add(task, BorderLayout.CENTER);
		task.setLayout(null);
		
		JButton btnSemesters = new JButton("Semesters");
		btnSemesters.setHorizontalAlignment(SwingConstants.LEADING);
		btnSemesters.setIcon(new ImageIcon(Admin.class.getResource("/images/icons8-calendar-32.png")));
		btnSemesters.setForeground(Color.WHITE);
		btnSemesters.setFocusPainted(false);
		btnSemesters.setBorder(null);
		btnSemesters.setBackground(new Color(81,126,211));
		btnSemesters.setBounds(12, 41, 121, 31);
		task.add(btnSemesters);
		
		JButton btnClasses = new JButton("Classes");
		btnClasses.setHorizontalAlignment(SwingConstants.LEADING);
		btnClasses.setIcon(new ImageIcon(Admin.class.getResource("/images/icons8-study-32.png")));
		btnClasses.setForeground(Color.WHITE);
		btnClasses.setFocusPainted(false);
		btnClasses.setBorder(null);
		btnClasses.setBackground(new Color(81,126,211));
		btnClasses.setBounds(12, 109, 121, 31);
		task.add(btnClasses);
		
		JButton btnProfileSetting = new JButton("Profile");
		btnProfileSetting.setHorizontalAlignment(SwingConstants.LEADING);
		btnProfileSetting.setIcon(new ImageIcon(Admin.class.getResource("/images/icons8-admin-settings-male-32.png")));
		btnProfileSetting.setForeground(Color.WHITE);
		btnProfileSetting.setFocusPainted(false);
		btnProfileSetting.setBorder(null);
		btnProfileSetting.setBackground(new Color(81,126,211));
		btnProfileSetting.setBounds(174, 41, 114, 31);
		task.add(btnProfileSetting);
		
		JButton btnCourses = new JButton("Courses");
		btnCourses.setHorizontalAlignment(SwingConstants.LEADING);
		btnCourses.setIcon(new ImageIcon(Admin.class.getResource("/images/icons8-course-assign-32.png")));
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
		
		/**
		 * Main working space
		 */
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
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		buttons.add(btnDashboard);
		buttons.add(btnCourse);
		buttons.add(btnSemester);
		buttons.add(btnClass);
		buttons.add(btnProfile);
		buttons.add(btnLogout);
		
		for (JButton btn: buttons) {
			btn.addActionListener(e -> {
				_choice = btn;
				setSelection();
			});
		};
	}
	
	private void setHoverButton() {
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		buttons.add(btnDashboard);
		buttons.add(btnCourse);
		buttons.add(btnSemester);
		buttons.add(btnClass);
		buttons.add(btnProfile);
		buttons.add(btnLogout);
		
		for (JButton btn: buttons) {
			btn.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
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
		buttons.add(btnClass);
		buttons.add(btnProfile);
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
