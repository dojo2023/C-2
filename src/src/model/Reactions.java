package model;

import java.io.Serializable;

public class Reactions implements Serializable {

	private String id;
	private String users_id;
	private String gathers_id;

	public Reactions(String id, String users_id, String gathers_id) {
		super();
		this.id = id;
		this.users_id = users_id;
		this.gathers_id = gathers_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsers_id() {
		return users_id;
	}

	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}

	public String getGathers_id() {
		return gathers_id;
	}

	public void setGathers_id(String gathers_id) {
		this.gathers_id = gathers_id;
	}
}
