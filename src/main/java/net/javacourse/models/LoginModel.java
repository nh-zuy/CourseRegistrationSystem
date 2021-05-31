package net.javacourse.models;

import java.util.List;

import net.javacourse.entities.Students;
import net.javacourse.entities.Trainers;

public class LoginModel {
	private List<Trainers> _admins;
	private List<Students> _students;
	
	/**
	 * 
	 */
	public LoginModel() {
		TrainersModel adminModel = new TrainersModel();
		StudentsModel studentModel = new StudentsModel();
		
		this._admins = adminModel.getAll();
		this._students = studentModel.getAll();
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public String validate(String username, String password) {
		username = username.trim();
		password = password.trim();
		
		for (Students student: this._students) {
			if (username.equals(student.getUsername())) {
				if (password.equals(student.getPassword())) {
					return student.getStudentId();
				};
			};
		};
		
		for (Trainers admin: this._admins) {
			if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
				return admin.getTrainerId();
			};
		};
		
		return null;
	}
}
