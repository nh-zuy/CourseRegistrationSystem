package net.javacourse.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import net.javacourse.entities.Students;
import net.javacourse.models.StudentsModel;
import javax.swing.JCheckBox;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;


public class ProfileStudent extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Data model */
	private StudentsModel _model;
	private Students _account;
	
	/* View component */
	private JLabel message;
	private JTextField textID;
	private JTextField textUsername;
	private JTextField textPasswd;
	private JTextField textFullname;
	private JTextField textAddress;
	private JButton btnUpdate, btnReset;
	private JCheckBox boxMale;
	private JTextField textTelephone;
	private JTextField textEmail;
	private JCheckBox boxFemale;
	private JTextField textCitizen;
	
	/**
	 * Create the panel.
	 */
	public ProfileStudent(Students account) {
		this._account = account;
		this._model = new StudentsModel();
		
		this.initialView();
		
		/* Manipulating data */
		this.setData();
		this.setEventButton();
	}
	
	private void initialView() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		header.setBackground(Color.WHITE);
		header.setPreferredSize(new Dimension(100, 100));
		add(header, BorderLayout.NORTH);
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewStudent = new JLabel("Profile information");
		lblNewStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewStudent.setPreferredSize(new Dimension(500, 50));
		lblNewStudent.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		header.add(lblNewStudent);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000, 40));
		header.add(panel);
		
		message = new JLabel("* Update account information !");
		message.setForeground(Color.GREEN);
		message.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setPreferredSize(new Dimension(1000, 30));
		panel.add(message);
		
		JPanel form = new JPanel();
		form.setBackground(new Color(119, 165, 251));
		add(form, BorderLayout.CENTER);
		form.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel forminput = new JPanel();
		forminput.setBackground(new Color(119, 165, 251));
		forminput.setPreferredSize(new Dimension(1000, 50));
		form.add(forminput);
		forminput.setLayout(null);
		
		JLabel lblId = new JLabel("Profile ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Chilanka", Font.BOLD, 20));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(254, 0, 121, 50);
		forminput.add(lblId);
		
		textID = new JTextField();
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textID.setEditable(false);
		textID.setBounds(376, 0, 323, 50);
		textID.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		forminput.add(textID);
		textID.setColumns(10);
		
		JPanel forminput_1 = new JPanel();
		forminput_1.setLayout(null);
		forminput_1.setPreferredSize(new Dimension(1000, 50));
		forminput_1.setBackground(new Color(119, 165, 251));
		form.add(forminput_1);
		
		JLabel lblName = new JLabel("Username");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.ORANGE);
		lblName.setFont(new Font("Chilanka", Font.BOLD, 20));
		lblName.setBounds(210, 2, 109, 50);
		forminput_1.add(lblName);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textUsername.setHorizontalAlignment(SwingConstants.CENTER);
		textUsername.setColumns(10);
		textUsername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textUsername.setBounds(321, 14, 184, 26);
		forminput_1.add(textUsername);
		
		JLabel lblMark = new JLabel("Password");
		lblMark.setBounds(510, 2, 98, 50);
		forminput_1.add(lblMark);
		lblMark.setHorizontalAlignment(SwingConstants.CENTER);
		lblMark.setForeground(Color.ORANGE);
		lblMark.setFont(new Font("Chilanka", Font.BOLD, 20));
		
		textPasswd = new JTextField();
		textPasswd.setBounds(615, 14, 184, 26);
		forminput_1.add(textPasswd);
		textPasswd.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textPasswd.setHorizontalAlignment(SwingConstants.CENTER);
		textPasswd.setColumns(10);
		textPasswd.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		
		JPanel forminput_3 = new JPanel();
		forminput_3.setLayout(null);
		forminput_3.setPreferredSize(new Dimension(1000, 50));
		forminput_3.setBackground(new Color(119, 165, 251));
		form.add(forminput_3);
		
		JLabel lblFullname = new JLabel("Fullname");
		lblFullname.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullname.setForeground(Color.WHITE);
		lblFullname.setFont(new Font("Chilanka", Font.BOLD, 20));
		lblFullname.setBounds(273, 0, 104, 50);
		forminput_3.add(lblFullname);
		
		textFullname = new JTextField();
		textFullname.setFont(new Font("Arial", Font.BOLD, 16));
		textFullname.setHorizontalAlignment(SwingConstants.CENTER);
		textFullname.setColumns(10);
		textFullname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFullname.setBounds(376, 12, 323, 26);
		forminput_3.add(textFullname);
		
		JPanel forminput_4 = new JPanel();
		forminput_4.setLayout(null);
		forminput_4.setPreferredSize(new Dimension(1000, 50));
		forminput_4.setBackground(new Color(119, 165, 251));
		form.add(forminput_4);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		lblSex.setForeground(Color.WHITE);
		lblSex.setFont(new Font("Chilanka", Font.BOLD, 20));
		lblSex.setBounds(274, 0, 100, 50);
		forminput_4.add(lblSex);
		
		boxMale = new JCheckBox(" Male");
		boxMale.setFocusPainted(false);
		boxMale.setBorder(null);
		boxMale.setForeground(Color.PINK);
		boxMale.setHorizontalAlignment(SwingConstants.CENTER);
		boxMale.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		boxMale.setBounds(388, 0, 100, 50);
		boxMale.setBackground(new Color(119, 165, 251));
		forminput_4.add(boxMale);
		boxMale.addActionListener(e -> {
			if (boxFemale.isSelected()) {
				boxFemale.setSelected(false);
			};
			boxMale.setSelected(true);
		});
		
		boxFemale = new JCheckBox(" Female");
		boxFemale.setFocusPainted(false);
		boxFemale.setHorizontalAlignment(SwingConstants.CENTER);
		boxFemale.setForeground(Color.PINK);
		boxFemale.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		boxFemale.setBackground(new Color(119, 165, 251));
		boxFemale.setBounds(492, 0, 100, 50);
		forminput_4.add(boxFemale);
		boxFemale.addActionListener(e -> {
			if (boxMale.isSelected()) {
				boxMale.setSelected(false);
			};
			
			boxFemale.setSelected(true);
		});
		
		JPanel forminput_5_2 = new JPanel();
		forminput_5_2.setLayout(null);
		forminput_5_2.setPreferredSize(new Dimension(1000, 50));
		forminput_5_2.setBackground(new Color(119, 165, 251));
		form.add(forminput_5_2);
		
		JLabel lblCitizenId = new JLabel("Citizen ID");
		lblCitizenId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCitizenId.setForeground(Color.WHITE);
		lblCitizenId.setFont(new Font("Chilanka", Font.BOLD, 20));
		lblCitizenId.setBounds(274, 0, 104, 50);
		forminput_5_2.add(lblCitizenId);
		
		textCitizen = new JTextField();
		textCitizen.setText((String) null);
		textCitizen.setHorizontalAlignment(SwingConstants.CENTER);
		textCitizen.setFont(new Font("Arial", Font.BOLD, 16));
		textCitizen.setColumns(10);
		textCitizen.setBorder(null);
		textCitizen.setBounds(376, 12, 323, 26);
		forminput_5_2.add(textCitizen);
		
		JPanel forminput_5 = new JPanel();
		forminput_5.setLayout(null);
		forminput_5.setPreferredSize(new Dimension(1000, 50));
		forminput_5.setBackground(new Color(119, 165, 251));
		form.add(forminput_5);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Chilanka", Font.BOLD, 20));
		lblAddress.setBounds(274, 0, 104, 50);
		forminput_5.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Arial", Font.BOLD, 16));
		textAddress.setHorizontalAlignment(SwingConstants.CENTER);
		textAddress.setColumns(10);
		textAddress.setBorder(null);
		textAddress.setBounds(376, 12, 323, 26);
		forminput_5.add(textAddress);
		
		JPanel forminput_5_1 = new JPanel();
		forminput_5_1.setLayout(null);
		forminput_5_1.setPreferredSize(new Dimension(1000, 50));
		forminput_5_1.setBackground(new Color(119, 165, 251));
		form.add(forminput_5_1);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelephone.setForeground(Color.WHITE);
		lblTelephone.setFont(new Font("Chilanka", Font.BOLD, 20));
		lblTelephone.setBounds(250, 0, 128, 50);
		forminput_5_1.add(lblTelephone);
		
		textTelephone = new JTextField();
		textTelephone.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textTelephone.setHorizontalAlignment(SwingConstants.CENTER);
		textTelephone.setColumns(10);
		textTelephone.setBorder(null);
		textTelephone.setBounds(376, 12, 323, 26);
		forminput_5_1.add(textTelephone);
		
		JPanel forminput_5_1_1 = new JPanel();
		forminput_5_1_1.setLayout(null);
		forminput_5_1_1.setPreferredSize(new Dimension(1000, 50));
		forminput_5_1_1.setBackground(new Color(119, 165, 251));
		form.add(forminput_5_1_1);
		
		JLabel lblNote_1_1 = new JLabel("Email");
		lblNote_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote_1_1.setForeground(Color.WHITE);
		lblNote_1_1.setFont(new Font("Chilanka", Font.BOLD, 20));
		lblNote_1_1.setBounds(274, 0, 104, 50);
		forminput_5_1_1.add(lblNote_1_1);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setColumns(10);
		textEmail.setBorder(null);
		textEmail.setBounds(376, 12, 323, 26);
		forminput_5_1_1.add(textEmail);
		
		JPanel forminput_6 = new JPanel();
		forminput_6.setLayout(null);
		forminput_6.setPreferredSize(new Dimension(1000, 70));
		forminput_6.setBackground(new Color(119, 165, 251));
		form.add(forminput_6);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Chilanka", Font.BOLD, 20));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBounds(268, 12, 197, 50);
		btnUpdate.setBackground(new Color(0, 113, 224));
		btnUpdate.setFocusable(false);
		btnUpdate.setBorder(null);
		forminput_6.add(btnUpdate);
		
		btnReset = new JButton("Reset");
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Chilanka", Font.BOLD, 20));
		btnReset.setFocusable(false);
		btnReset.setBorder(null);
		btnReset.setBackground(Color.RED);
		btnReset.setBounds(546, 12, 197, 50);
		forminput_6.add(btnReset);
	}
	
	/**
	 * Reset data in textfield
	 */
	private void resetTextField() {
		textID.setText(_account.getStudentId());
		textUsername.setText(_account.getUsername());
		textPasswd.setText(_account.getPassword());
		textFullname.setText(_account.getFullname());
		textAddress.setText(_account.getAddress());
		textTelephone.setText(_account.getTelephone());
		textEmail.setText(_account.getEmail());
		textCitizen.setText(_account.getCitizenId());
	}

	/**
	 * Show information account
	 */
	private void setData() {
		textID.setText(String.valueOf(this._account.getStudentId()));
		textUsername.setText(this._account.getUsername());
		textPasswd.setText(this._account.getPassword());
		textFullname.setText(this._account.getFullname());
		textTelephone.setText(this._account.getTelephone());
		textAddress.setText(this._account.getAddress());
		textEmail.setText(this._account.getEmail());
		textCitizen.setText(this._account.getCitizenId());
		
		int sex = this._account.getSex();
		if (sex == 0) {
			boxMale.setSelected(true);
			boxFemale.setSelected(false);
		} else {
			boxMale.setSelected(false);
			boxFemale.setSelected(true);
		};
	}
	
	/**
	 * 
	 */
	private void setEventButton() {
		btnUpdate.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String username = textUsername.getText().trim();
				String password = textPasswd.getText().trim();
				String fullname = textFullname.getText().trim();
				String telephone = textTelephone.getText().trim();
				String address = textAddress.getText().trim();
				String email = textEmail.getText().trim();
				byte sex = 0;
				if (boxMale.isSelected()) {
					sex = 0;
				} else {
					sex = 1;
				};
				
				if (username.isBlank() || password.isBlank() || fullname.isBlank() || telephone.isBlank() || address.isBlank() || email.isBlank()) {
					message.setText("Fill all blank!");
					message.setForeground(Color.RED);
					JOptionPane.showMessageDialog(new JPanel(), "Please fill all blank!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String[] options = { "Yes", "No" };

					int res = JOptionPane.showOptionDialog(new JPanel(), "Are you sure update profile?", "Update Profile",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					
					if (res == 0) {
						if (_account != null) {
							_account.setUsername(username);
							_account.setPassword(password);
							_account.setFullname(fullname);
							_account.setTelephone(telephone);
							_account.setEmail(email);
							_account.setAddress(address);
							_account.setSex(sex);
							
							if (_model.updateById(_account.getStudentId(), _account)) {
								JOptionPane.showMessageDialog(new JPanel(), "Update Successfully!", "Update", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(new JPanel(), "ERROR update!", "Error", JOptionPane.ERROR_MESSAGE);
							};
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
		
		/* Handle mouse on button Reset */
		btnReset.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				/* Just can reset before update data */
				resetTextField();
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
