package model;

import java.io.Serializable;

public class Users implements Serializable {
	private String id;
	private String mail_address;
	private String password;

	public Users(String id, String mail_address,String password) {
		super();
		this.mail_address = mail_address;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMail_address() {
		return mail_address;
	}
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
