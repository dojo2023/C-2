package model;

import java.io.Serializable;

public class Restaurants implements Serializable {

	private String posts_restaurant;
	private String walk;
	private String serve;
	private String price;
	private String posts_genre;

	public Restaurants(String posts_restaurant,String walk,String serve,String price,String posts_genre) {
		super();
		this.posts_restaurant = posts_restaurant;
		this.walk = walk;
		this.serve = serve;
		this.price = price;
		this.posts_genre = posts_genre;
	}

	public String getPosts_restaurant() {
		return posts_restaurant;
	}
	public void setPosts_restaurant(String posts_restaurant) {
		this.posts_restaurant = posts_restaurant;
	}
	public String getWalk() {
		return walk;
	}
	public void setWalk(String walk) {
		this.walk = walk;
	}
	public String getServe() {
		return serve;
	}
	public void setServe(String serve) {
		this.serve = serve;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPosts_genre() {
		return posts_genre;
	}
	public void setPosts_genre(String posts_genre) {
		this.posts_genre = posts_genre;
	}
}
