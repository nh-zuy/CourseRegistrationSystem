package net.javacourse.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.javacourse.entities.Students;
import net.javacourse.entities.Trainers;
import net.javacourse.models.StudentsModel;
import net.javacourse.models.TrainersModel;

import javax.swing.JCheckBox;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class Profile extends JPanel {
	/* Data model */
	private TrainersModel _adminModel;
	private StudentsModel _studentModel;
	private Trainers _account;
	
	/* View component */
	private JLabel message;
	private JTextField textID;
	private JTextField textUsername;
	private JTextField textPasswd;
	private JTextField textFullname;
	private JTextField textAddress;
	private JButton btnUpdate, btnReset;
	private JCheckBox chboxMale;
	private JTextField textTelephone;
	private JTextField textEmail;
	private JCheckBox chckbxFemale;
	
	/**
	 * Create the panel.
	 */
	public Profile(Trainers account) {
		this._account = account;
		this._adminModel = new TrainersModel();
		this._studentModel = new StudentsModel();
		
		this.initialView();
		
		/* Manipulating data */
		this.resetTextField();
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
		textID.setBounds(376, 12, 323, 26);
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
		
		chboxMale = new JCheckBox(" Male");
		chboxMale.setFocusPainted(false);
		chboxMale.setBorder(null);
		chboxMale.setForeground(Color.PINK);
		chboxMale.setHorizontalAlignment(SwingConstants.CENTER);
		chboxMale.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		chboxMale.setBounds(388, 0, 100, 50);
		chboxMale.setBackground(new Color(119, 165, 251));
		forminput_4.add(chboxMale);
		chboxMale.addActionListener(e -> {
			if (chckbxFemale.isSelected()) {
				chckbxFemale.setSelected(false);
			};
			chboxMale.setSelected(true);
		});
		
		chckbxFemale = new JCheckBox(" Female");
		chckbxFemale.setFocusPainted(false);
		chckbxFemale.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxFemale.setForeground(Color.PINK);
		chckbxFemale.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		chckbxFemale.setBackground(new Color(119, 165, 251));
		chckbxFemale.setBounds(492, 0, 100, 50);
		forminput_4.add(chckbxFemale);
		chckbxFemale.addActionListener(e -> {
			if (chboxMale.isSelected()) {
				chboxMale.setSelected(false);
			};
			
			chckbxFemale.setSelected(true);
		});
		
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
		textID.setText(this._account.getTrainerId());
		textUsername.setText(this._account.getUsername());
		textPasswd.setText(this._account.getPassword());
		textFullname.setText(this._account.getFullname());
		textAddress.setText("");
		textTelephone.setText(this._account.getTelephone());
		textEmail.setText("");
	}

	/**
	 * Show information account
	 */
	private void setData() {
		textID.setText(String.valueOf(this._account.getTrainerId()));
		textUsername.setText(this._account.getUsername());
		textPasswd.setText(this._account.getPassword());
		textFullname.setText(this._account.getFullname());
		int sex = this._account.getSex();
		if (sex == 0) {
			chboxMale.setSelected(true);
			chckbxFemale.setSelected(false);
		} else {
			chboxMale.setSelected(false);
			chckbxFemale.setSelected(true);
		};
		textTelephone.setText(this._account.getTelephone());
	}
	
	/**
	 * 
	 */
	private void setEventButton() {
		btnUpdate.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String username = textUsername.getText();
				String password = textPasswd.getText();
				
				if (_account != null) {
					_account.setUsername(username);
					_account.setPassword(password);
					_adminModel.updateById(_account.getTrainerId(), _account);
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
