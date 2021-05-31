package net.javacourse.controllers;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import net.javacourse.entities.Students;
import net.javacourse.entities.Trainers;
import net.javacourse.models.LoginModel;
import net.javacourse.models.Model;
import net.javacourse.models.StudentsModel;
import net.javacourse.models.TrainersModel;
import net.javacourse.views.LoginForm;

public class LoginController {
	private LoginForm _view;
	
	/**
	 * Constructor
	 */
	public LoginController() {
		_view = new LoginForm();
	}
	
	/**
	 * Running application
	 */
	public void run() {
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
				LoginModel model = new LoginModel();
				String id = model.validate(username, password);
				
				if (id == null) {
					_view.getErrorUn().setText("Incorrect !");
				} else {
					StudentsModel studentModel = new StudentsModel();
					Students student = studentModel.get(id);
					
					if (student != null) {
						new StudentController(student);
					} else {
						TrainersModel trainerModel = new TrainersModel();
						Trainers admin = trainerModel.get(id);
						
						new AdminController(admin);
					};
					
					_view.dispose();
					_view = null;
					
					
				}
			};
		});
	}
}
