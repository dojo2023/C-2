package model;

import java.io.Serializable;

public class Restaurants implements Serializable {

	private String restaurant;
	private int genre;
	private int price;
	private int walk;
	private int serve;

	public Restaurants(String restaurant,int genre,int price,int walk,int serve) {
		super();
		this.restaurant =restaurant;
		this.genre = genre;
		this.price = price;
		this.walk = walk;
		this.serve = serve;
	}
	public Restaurants() {
	}

	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public int getGenre() {
		return genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getWalk() {
		return walk;
	}
	public void setWalk(int walk) {
		this.walk = walk;
	}
	public int getServe() {
		return serve;
	}
	public void setServe(int serve) {
		this.serve = serve;
	}
}
