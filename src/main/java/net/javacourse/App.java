package net.javacourse;

import net.javacourse.entities.Database;
import net.javacourse.entities.Semesters;

import java.util.List;

import org.hibernate.Session;

import net.javacourse.controllers.AdminController;
import net.javacourse.controllers.LoginController;

public class App {
	public static void main(String[] args){
		//new LoginController();
		
		try (Session session = Database.getSessionFactory().openSession();) {
            // Begin a unit of work
            session.beginTransaction();
 
            String query = "FROM Semesters";
            List<Semesters> students = session.createQuery(query, Semesters.class).list();
            
            for (Semesters student: students) {
            	System.out.println(student.getSubName());
            }
             
            // Commit the current resource transaction, writing any unflushed changes to the database.
            session.getTransaction().commit();
        }
	}
}
