package model;

import java.io.Serializable;

public class Profiles implements Serializable {
	private String id;
	private String users_id;
	private String name;
	private String icon;
	private String introduction;

	public Profiles(String id, String users_id, String name, String icon, String introduction) { //コンストラクタ
		super();
		this.id = id;
		this.users_id = users_id;
		this.name = name;
		this.icon = icon;
		this.introduction = introduction;
	}
	public Profiles() { //引数なしのコンストラクタ
		super();
		this.id = "";
		this.users_id = "";
		this.name = "";
		this.icon = "";
		this.introduction = "";
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

}
