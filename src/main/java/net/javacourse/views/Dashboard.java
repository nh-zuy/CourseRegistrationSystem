package net.javacourse.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.javacourse.entities.Students;
import net.javacourse.entities.Trainers;
import net.javacourse.models.StudentsModel;
import net.javacourse.models.TrainersModel;

import javax.swing.JCheckBox;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.BevelBorder;
import com.toedter.calendar.JCalendar;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class Dashboard extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public Dashboard() {
		this.initialView();
		
		/* Manipulating data */
		this.resetTextField();
		this.setData();
		this.setEventButton();
	}
	
	private void initialView() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		header.setBackground(Color.WHITE);
		header.setPreferredSize(new Dimension(100, 100));
		add(header, BorderLayout.NORTH);
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewStudent = new JLabel("Course Registration System");
		lblNewStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewStudent.setPreferredSize(new Dimension(500, 50));
		lblNewStudent.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		header.add(lblNewStudent);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000, 40));
		header.add(panel);
		
		JPanel form = new JPanel();
		form.setBackground(new Color(119, 165, 251));
		add(form, BorderLayout.CENTER);
		form.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel forminput = new JPanel();
		forminput.setBackground(new Color(119, 165, 251));
		forminput.setPreferredSize(new Dimension(1000, 400));
		form.add(forminput);
		forminput.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Calendar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 92, 92)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(176, 12, 646, 376);
		forminput.add(panel_1);
		panel_1.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		calendar.setBounds(24, 25, 599, 339);
		panel_1.add(calendar);
		
		JPanel forminput_1 = new JPanel();
		forminput_1.setLayout(null);
		forminput_1.setPreferredSize(new Dimension(1000, 150));
		forminput_1.setBackground(new Color(119, 165, 251));
		form.add(forminput_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "News", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 92, 92)));
		panel_2.setBounds(176, 12, 646, 94);
		forminput_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("** New semester 2020 - 2021 (04 - 04 - 2020)");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblNewLabel.setBounds(48, 26, 573, 29);
		panel_2.add(lblNewLabel);
		
		JLabel lblWelcomeNew = new JLabel("** Welcome new student to my school (09 - 09 - 2020)");
		lblWelcomeNew.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblWelcomeNew.setBounds(48, 53, 573, 29);
		panel_2.add(lblWelcomeNew);
	}
	
	/**
	 * Reset data in textfield
	 */
	private void resetTextField() {
	}

	/**
	 * Show information account
	 */
	private void setData() {
	}
	
	/**
	 * 
	 */
	private void setEventButton() {
	}
}
