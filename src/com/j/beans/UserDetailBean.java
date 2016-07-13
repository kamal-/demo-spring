package com.j.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDetailBean {

	private String imgUrl;
	private String name;
	private String surName;
	private String duration;
	private String rating;
	private String profileID;
	private String address;
	private int age;
	private int currentregisteredID;
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getProfileID() {
		return profileID;
	}
	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCurrentregisteredID() {
		return currentregisteredID;
	}
	public void setCurrentregisteredID(int currentregisteredID) {
		this.currentregisteredID = currentregisteredID;
	}
	public String getFuture1() {
		return future1;
	}
	public void setFuture1(String future1) {
		this.future1 = future1;
	}
	public Date getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}
	public List<ArrayList<VisitRecords>> getVisitRecords() {
		return visitRecords;
	}
	public void setVisitRecords(List<ArrayList<VisitRecords>> visitRecords) {
		this.visitRecords = visitRecords;
	}
	private String future1;
	private Date lastVisit;
	private List<ArrayList<VisitRecords>> visitRecords;
}
