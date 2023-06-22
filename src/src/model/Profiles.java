package model;

import java.io.Serializable;

public class Profiles implements Serializable {
	private String id;
	private String users_id;
	private String name;
	private String icon;
	private String introduction;
	private int t_point;
	private int g_point;
	private int c_point;

	public Profiles(String id, String users_id, String name, String icon, String introduction, int t_point, int g_point, int c_point) { //コンストラクタ
		super();
		this.id = id;
		this.users_id = users_id;
		this.name = name;
		this.icon = icon;
		this.introduction = introduction;
		this.t_point = t_point;
		this.g_point = g_point;
		this.c_point = c_point;
	}

	//ランキング用のBeans
	public Profiles(String users_id, String name, String icon , int t_point, int g_point, int c_point) { //コンストラクタ
		super();
		this.users_id = users_id;
		this.name = name;
		this.icon = icon;
		this.t_point=t_point;
		this.g_point=g_point;
		this.c_point=c_point;
	}

	// プロフィール編集用のBeans
	public Profiles(String users_id, String name, String icon , String introduction) { //コンストラクタ
		super();
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
		this.t_point = 0;
		this.g_point = 0;
		this.c_point = 0;
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
	public int getT_point() {
		return t_point;
	}
	public void setT_point(int t_point) {
		this.t_point = t_point;
	}
	public int getG_point() {
		return g_point;
	}
	public void setG_point(int g_point) {
		this.g_point = g_point;
	}
	public int getC_point() {
		return c_point;
	}
	public void setC_point(int c_point) {
		this.c_point = c_point;
	}

}
