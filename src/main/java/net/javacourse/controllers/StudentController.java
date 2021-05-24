package net.javacourse.controllers;

import java.awt.EventQueue;

import net.javacourse.models.AbstractModel;
import net.javacourse.models.StudentModel;
import net.javacourse.views.Student;

public class StudentController {
	private Student _view;
	private AbstractModel _model;
	
	public StudentController() {
		_model = new StudentModel();
		_view = new Student(_model);
		
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
