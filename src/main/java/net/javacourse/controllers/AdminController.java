package net.javacourse.controllers;

import java.awt.EventQueue;

import net.javacourse.models.AbstractModel;
import net.javacourse.models.StudentModel;
import net.javacourse.views.Admin;

public class AdminController {
	private Admin _view;
	private AbstractModel _model;
	
	public AdminController() {
		_model = new StudentModel();
		_view = new Admin(_model);
		
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
