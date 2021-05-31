package net.javacourse.controllers;

import java.awt.EventQueue;

import net.javacourse.entities.Trainers;
import net.javacourse.models.Model;
import net.javacourse.views.Admin;

public class AdminController {
	private Admin _view;
	private Model _model;
	
	public AdminController(Trainers account) {
		_model = new Model();
		_view = new Admin(account);
		
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
