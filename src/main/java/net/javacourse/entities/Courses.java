package net.javacourse.entities;
// Generated 24 May 2021, 17:03:10 by Hibernate Tools 5.4.30.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Courses generated by hbm2java
 */
public class Courses implements java.io.Serializable {

	private String code;
	private Semesters semesters;
	private String name;
	private int credits;
	private int slots;
	private int year;
	private Set studieses = new HashSet(0);
	private Set scheduleses = new HashSet(0);
	private Set timetables = new HashSet(0);

	public Courses() {
	}

	public Courses(String code, Semesters semesters, String name, int credits, int slots, int year) {
		this.code = code;
		this.semesters = semesters;
		this.name = name;
		this.credits = credits;
		this.slots = slots;
		this.year = year;
	}

	public Courses(String code, Semesters semesters, String name, int credits, int slots, int year, Set studieses,
			Set scheduleses, Set timetables) {
		this.code = code;
		this.semesters = semesters;
		this.name = name;
		this.credits = credits;
		this.slots = slots;
		this.year = year;
		this.studieses = studieses;
		this.scheduleses = scheduleses;
		this.timetables = timetables;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Semesters getSemesters() {
		return this.semesters;
	}

	public void setSemesters(Semesters semesters) {
		this.semesters = semesters;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return this.credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getSlots() {
		return this.slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Set getStudieses() {
		return this.studieses;
	}

	public void setStudieses(Set studieses) {
		this.studieses = studieses;
	}

	public Set getScheduleses() {
		return this.scheduleses;
	}

	public void setScheduleses(Set scheduleses) {
		this.scheduleses = scheduleses;
	}

	public Set getTimetables() {
		return this.timetables;
	}

	public void setTimetables(Set timetables) {
		this.timetables = timetables;
	}

}
