package net.javacourse.controllers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.Timer;

import net.javacourse.models.AbstractModel;
import net.javacourse.models.AccountModel;
import net.javacourse.models.StudentModel;
import net.javacourse.views.LoginForm;

public class LoginController {
	private LoginForm _view;
	private AbstractModel _model;
	private boolean _status;
	
	/**
	 * Constructor
	 */
	public LoginController() {
		_view = new LoginForm();
		_model = new AccountModel();
		_status = false;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_view.setVisible(true);
					login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Login
	 */
	public void login() {
		JButton click = _view.getBtnLogin();
		
		click.addActionListener(e -> {
			String username = _view.getUsername().trim();
			String password = _view.getPassword().trim();
			
			_view.getErrorUn().setText("");
			_view.getErrorPw().setText("");
			
			if (username.isEmpty()) {
				_view.getErrorUn().setText("Please fill all the blank !");
			} else if (password.isEmpty()) {
				_view.getErrorPw().setText("Please fill all the blank !");
			} else {
				String dbUn = "1";
				String dbPw = "1";
				
				if (!username.equals(dbUn)) {
					_view.getErrorUn().setText("Incorrect!");
				} else if (!password.equals(dbPw)) {
					_view.getErrorPw().setText("Incorrect");
				} else {	
//					try {
//						TimeUnit.SECONDS.sleep(2);
//					} catch (InterruptedException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					};
					
					_view.dispose();
					_view = null;
					new AdminController();
				};
				
				if (username.equals("2") && password.equals("2")) {	
//					try {
//						TimeUnit.SECONDS.sleep(2);
//					} catch (InterruptedException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					};
					
					_view.dispose();
					_view = null;
					new StudentController();
				};
			};
		});
	}
}
