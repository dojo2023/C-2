package model;

import java.io.Serializable;

public class Posts implements Serializable {//JavaBeans Posts=クラス名
	private String id;
	private String users_id;
	private String date;
	private String photo;
	private String restaurant;
	private String walk;
	private String sereve;
	private String price;
	private String genre;
	private String text;
	private String point;


	public Posts(String id, String users_id, String date, String photo, String restaurant, String walk, String sereve, String price, String genre,
			String text, String point ) { //コンストラクタ
		super();
		this.id = id;
		this.users_id = users_id;
		this.date = date;
		this.photo = photo;
		this.restaurant = restaurant;
		this.walk = walk;
		this.sereve = sereve;
		this.price = price;
		this.genre = genre;
		this.text = text;
		this.point = point;
	}
	public Posts(String restaurant, String text, String point ) { //コンストラクタ
		super();
		this.restaurant = restaurant;
		this.text = text;
		this.point = point;
	}

	public Posts() { //引数なしのコンストラクタ
		super();
		this.id = "";
		this.users_id = "";
		this.date = "";
		this.photo = "";
		this.restaurant = "";
		this.walk = "";
		this.sereve = "";
		this.price = "";
		this.genre = "";
		this.text = "";
		this.point = "";
	}
	public String getId() {//privateをgetter/setterで取り出す
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public String getWalk() {
		return walk;
	}
	public void setWalk(String walk) {
		this.walk = walk;
	}
	public String getSereve() {
		return sereve;
	}
	public void setSereve(String serve) {
		this.sereve = serve;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}

}