package model;

import java.io.Serializable;

public class Comments implements Serializable {

  private String id;
  private String users_id;
  private String date;
  private String point;
  private String text;

  public Comments (String id, String users_id ,String date ,String point,String text) {
    super();
    this.id = id;
    this.users_id = users_id;
    this.date = date;
    this.point = point;
    this.text = text;

  }

  public String getText() {
	return text;
  }

  public void setText(String text) {
	this.text = text;
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


}
