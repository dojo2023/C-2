package model;

import java.io.Serializable;

public class Gathers implements Serializable {

//	private String id;
//	private String users_id;
//	private String date;
//	private String point;
	private String restaurant_name;
	private int time;
	private int place;

    public Gathers(//String id, String users_id, String date,String point,
    		String restaurant_name,int time,int place) {
      super();
//      this.id = id;
//      this.users_id= users_id;
//      this.date = date;
 //     this.point= point;
      this.restaurant_name= restaurant_name;
      this.time= time;
      this.place= place;
    }


/*	public String getId() {
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


	public String getPoint() {
		return point;
	}


	public void setPoint(String point) {
		this.point = point;
	}
*/
	public String getRestaurant_name() {
		return restaurant_name;
	}


	public void setText(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	
	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}
	
	public int getPlace() {
		return place;
	}


	public void setPlace(int place) {
		this.place = place;
	}
	
}
