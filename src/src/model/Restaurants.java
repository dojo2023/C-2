package model;

import java.io.Serializable;

public class Restaurants implements Serializable {

	private String restaurant;
	private String walk;
	private String serve;
	private String price;
	private String genre;

	public Restaurants(String restaurant,String walk,String serve,String price,String genre) {
		super();
		this.restaurant =restaurant;
		this.walk = walk;
		this.serve = serve;
		this.price = price;
		this.genre = genre;
	}
	public Restaurants() {

	}

	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String Restaurant) {
		this.restaurant = restaurant;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
