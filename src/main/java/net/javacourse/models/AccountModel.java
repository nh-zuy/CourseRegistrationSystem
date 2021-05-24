package net.javacourse.models;

import net.javacourse.entities.Database;

public class AccountModel extends AbstractModel {
	private Database db;
	private String tabel = "Accounts";
	private int acc_id;
	private int level;
	
	public AccountModel() {}
}
