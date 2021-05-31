package net.javacourse.controllers;

import java.awt.EventQueue;

import net.javacourse.entities.Students;
import net.javacourse.models.Model;
import net.javacourse.views.Student;

public class StudentController {
	private Student _view;
	private Model _model;
	
	public StudentController(Students account) {
		_model = new Model();
		_view = new Student(account);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_view.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
