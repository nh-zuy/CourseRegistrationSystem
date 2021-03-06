package net.javacourse.entities;
// Generated 12 Jun 2021, 09:55:29 by Hibernate Tools 5.4.30.Final

/**
 * Trainers generated by hbm2java
 */
public class Trainers implements java.io.Serializable {

	private String trainerId;
	private String username;
	private String password;
	private String fullname;
	private byte sex;
	private String telephone;

	public Trainers() {
	}

	public Trainers(String trainerId, String username, String password, String fullname, byte sex) {
		this.trainerId = trainerId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.sex = sex;
	}

	public Trainers(String trainerId, String username, String password, String fullname, byte sex, String telephone) {
		this.trainerId = trainerId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.sex = sex;
		this.telephone = telephone;
	}

	public String getTrainerId() {
		return this.trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public byte getSex() {
		return this.sex;
	}

	public void setSex(byte sex) {
		this.sex = sex;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
