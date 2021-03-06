package net.javacourse.controllers;

import java.awt.EventQueue;
import javax.swing.JButton;

import org.hibernate.cfg.Configuration;

import net.javacourse.entities.Students;
import net.javacourse.entities.Trainers;
import net.javacourse.models.LoginModel;
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
			String Dusername = _view.getDUn().trim();
			String Dpassword = _view.getDPw().trim();
			
			if (Dusername.isEmpty()) {
				_view.getErrorUn().setText("Please enter the Database username!");
			} else if (Dpassword.isEmpty()) {
				_view.getErrorPw().setText("Please enter the Database password!");
			} else {
				try {
					Configuration cfg = new Configuration();
					cfg.configure();
					cfg.setProperty("hibernate.connection.password", Dpassword);
					cfg.setProperty("hibernate.connection.username", Dusername);

				} catch (Throwable ex) {
					_view.getErrorUn().setText("Unable to conect database! Try again!");
					System.err.println("Initial SessionFactory creation failed." + ex);
					throw new ExceptionInInitializerError(ex);
				};
			};
			
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
