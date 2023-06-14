package model;

import java.io.Serializable;

public class Profiles implements Serializable {
	private String id;
	private String users_id;
	private String name;
	private String icon;
	private String introduction;
	private String t_point;
	private String g_point;
	private String c_point;

	public Profiles(String id, String users_id, String name, String icon, String introduction,String t_point,String g_point,String c_point) { //コンストラクタ
		super();
		this.id = id;
		this.users_id = users_id;
		this.name = name;
		this.icon = icon;
		this.introduction = introduction;
		this.t_point=t_point;
		this.t_point=g_point;
		this.t_point=c_point;
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
	public String getT_point() {
		return t_point;
	}
	public void setT_point(String t_point) {
		this.t_point = t_point;
	}
	public String getG_point() {
		return g_point;
	}
	public void setG_point(String g_point) {
		this.g_point = g_point;
	}
	public String getC_point() {
		return c_point;
	}
	public void setC_point(String c_point) {
		this.c_point = c_point;
	}

}
