package net.javacourse;

import net.javacourse.controllers.LoginController;
import net.javacourse.models.Model;

public class App {
	public static void main(String[] args){
		Model model = new Model();
		LoginController controller = new LoginController();
		
		controller.run();
	}
}
