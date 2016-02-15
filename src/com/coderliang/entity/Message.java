package com.coderliang.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private int id;
	private String msg;
	private String photo;
	private String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getTime() {
		return time;
	}
	public void setTime(Date time) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		this.time = sdf.format(time);
	}
	
}
