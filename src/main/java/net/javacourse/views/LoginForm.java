package net.javacourse.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.javacourse.objects.RadiusBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	
	private JTextField username;
	private JPasswordField password;
	
	private JLabel errorUn;
	private JLabel errorPw;
	
	private JButton btnLogin;
	private JButton btnCancel;

	private JProgressBar bar;
	private JTextField textDUn;
	private JTextField textDPw;

	/**
	 * Constructor
	 */
	public LoginForm() {
		this.initialView();
		this.setBanner();
		this.setSignin();
		this.setEventButton();
	}
	
	/**
	 * Inititalize view
	 */
	private void initialView() {
		this.setCloseApp();
		
		setBounds(250, 100, 800, 525);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
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
	 * Generating left panel
	 * Greeting, infor, ...
	 */
	private void setBanner() {
		JPanel banner = new JPanel();
		banner.setBackground(new Color(119, 165, 251));
		contentPane.add(banner, BorderLayout.WEST);
		banner.setPreferredSize(new Dimension(350, 100));
		banner.setLayout(null);
		
		JLabel title = new JLabel("Course Registration System");
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
		title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(12, 12, 326, 61);
		banner.add(title);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setIcon(new ImageIcon(LoginForm.class.getResource("/images/webp-net-resizeimage.jpg")));
		background.setBounds(0, 64, 350, 239);
		banner.add(background);
		
		JLabel license = new JLabel("*Available on Github nh-zuy");
		license.setHorizontalAlignment(SwingConstants.CENTER);
		license.setForeground(Color.BLACK);
		license.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		license.setBounds(125, 328, 225, 34);
		banner.add(license);
		
		JLabel quote = new JLabel("Education is power !");
		quote.setHorizontalAlignment(SwingConstants.CENTER);
		quote.setForeground(Color.BLACK);
		quote.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		quote.setBounds(125, 299, 225, 34);
		banner.add(quote);
	}
	
	/**
	 * Inititalize right Sign in view
	 * 
	 * Sign in
	 */
	private void setSignin() {
		JPanel signin = new JPanel();
		signin.setBackground(new Color(119, 165, 251));
		contentPane.add(signin, BorderLayout.CENTER);
		signin.setLayout(null);
		
		JPanel popup = new JPanel();
		popup.setBorder(new RadiusBorder(Color.white, 2, 16, 16));
		popup.setBackground(Color.WHITE);
		popup.setBounds(25, 22, 401, 465);
		signin.add(popup);
		popup.setLayout(null);
		
		username = new JTextField();
		username.setFont(new Font("Chandas", Font.PLAIN, 16));
		username.setColumns(10);
		username.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(192, 192, 192)));
		username.setBackground(Color.WHITE);
		username.setBounds(33, 106, 336, 32);
		popup.add(username);
		
		JLabel signinTitle = new JLabel("Sign In");
		signinTitle.setHorizontalAlignment(SwingConstants.CENTER);
		signinTitle.setForeground(new Color(30, 144, 255));
		signinTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		signinTitle.setBackground(new Color(23, 119, 242));
		signinTitle.setBounds(3, 0, 401, 63);
		signinTitle.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				signinTitle.setForeground(new Color(30, 144, 254));
				signinTitle.setFont(new Font("Comic Sans MS", Font.ITALIC, 40));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				signinTitle.setForeground(new Color(30, 144, 255));
				signinTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
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
		popup.add(signinTitle);
		
		JLabel lblUn = new JLabel("Username");
		lblUn.setLabelFor(lblUn);
		lblUn.setForeground(Color.BLACK);
		lblUn.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblUn.setBounds(33, 62, 105, 32);
		popup.add(lblUn);
		
		JLabel lblPw = new JLabel("Password");
		lblPw.setForeground(Color.BLACK);
		lblPw.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblPw.setBounds(33, 163, 98, 24);
		popup.add(lblPw);
		
		password = new JPasswordField();
		lblPw.setLabelFor(password);
		password.setBounds(33, 199, 336, 37);
		password.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		password.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		popup.add(password);
		
		btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		btnLogin.setFocusPainted(false);
		btnLogin.setBackground(new Color(23, 119, 242));
		btnLogin.setBounds(29, 261, 149, 40);
		btnLogin.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(192, 192, 192), new Color(192, 192, 192)));
		popup.add(btnLogin);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(192, 192, 192), new Color(192, 192, 192)));
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(219, 261, 149, 40);
		popup.add(btnCancel);
		
		errorUn = new JLabel("");
		errorUn.setForeground(Color.RED);
		errorUn.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		errorUn.setBounds(150, 62, 219, 32);
		popup.add(errorUn);
		
		errorPw = new JLabel("");
		errorPw.setForeground(Color.RED);
		errorPw.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		errorPw.setBounds(150, 161, 219, 32);
		popup.add(errorPw);
		
		JLabel lblDbUsername = new JLabel("Username");
		lblDbUsername.setForeground(Color.BLACK);
		lblDbUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblDbUsername.setBounds(33, 362, 98, 32);
		popup.add(lblDbUsername);
		
		textDUn = new JTextField();
		textDUn.setFont(new Font("Chandas", Font.PLAIN, 16));
		textDUn.setColumns(10);
		textDUn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textDUn.setBackground(Color.WHITE);
		textDUn.setBounds(139, 360, 230, 32);
		popup.add(textDUn);
		
		JLabel lblDbPassword = new JLabel("Password");
		lblDbPassword.setForeground(Color.BLACK);
		lblDbPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblDbPassword.setBounds(33, 408, 98, 32);
		popup.add(lblDbPassword);
		
		textDPw = new JTextField();
		textDPw.setFont(new Font("Chandas", Font.PLAIN, 16));
		textDPw.setColumns(10);
		textDPw.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textDPw.setBackground(Color.WHITE);
		textDPw.setBounds(139, 406, 230, 32);
		popup.add(textDPw);
		
		JLabel lblConnectDatabase = new JLabel("Connect database");
		lblConnectDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnectDatabase.setForeground(Color.BLACK);
		lblConnectDatabase.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblConnectDatabase.setBackground(Color.BLACK);
		lblConnectDatabase.setBounds(28, 313, 350, 37);
		popup.add(lblConnectDatabase);
	}
	
	/**
	 * 
	 */
	private void setEventButton() {
		btnLogin.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				btnLogin.setForeground(Color.WHITE);
				btnLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
				btnLogin.setBounds(29, 261, 149, 52);
				btnLogin.setBorder(new RadiusBorder(Color.white, 2, 16, 16, true));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				btnLogin.setForeground(Color.WHITE);
				btnLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
				btnLogin.setBounds(29, 261, 149, 40);
				btnLogin.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, new Color(192, 192, 192), new Color(192, 192, 192)));
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
		
		btnCancel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				btnCancel.setForeground(Color.RED);
				btnCancel.setBackground(Color.WHITE);
				btnCancel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				btnCancel.setForeground(Color.WHITE);
				btnCancel.setBackground(Color.RED);
				btnCancel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(192, 192, 192), new Color(192, 192, 192)));
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

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username.getText();
	}

	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return String.copyValueOf(password.getPassword());
	}
	
	
	/**
	 * 
	 * @return
	 */
	public JButton getBtnLogin() {
		return btnLogin;
	}

	/**
	 * 
	 * @return
	 */
	public JButton getBtnCancel() {
		return btnCancel;
	}

	
	/**
	 * 
	 * @return
	 */
	public JLabel getErrorUn() {
		return errorUn;
	}
	public void setErrorUn(JLabel errorUn) {
		this.errorUn = errorUn;
	}

	/**
	 * 
	 * @return
	 */
	public JLabel getErrorPw() {
		return errorPw;
	}
	public void setErrorPw(JLabel errorPw) {
		this.errorPw = errorPw;
	}

	/**
	 * 
	 */
	public JPanel getContentPane() {
		return contentPane;
	}
	
	public String getDUn() {
		return textDUn.getText();
	}

	public void setTextDUn(JTextField textDUn) {
		this.textDUn = textDUn;
	}

	public String getDPw() {
		return textDPw.getText();
	}

	public void setTextDPw(JTextField textDPw) {
		this.textDPw = textDPw;
	}
}
