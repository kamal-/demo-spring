package com.j.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDetailBean {

	private String imgUrl;
	private String name;
	private String surName;
	private String profileID;
	private String state;
	private String city;
	private String country;
	private Date attendeddate;
	private int postalcode;
	private int countrycode;
	private int statecode;
	private int monumber;
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getAttendeddate() {
		return attendeddate;
	}
	public void setAttendeddate(Date attendeddate) {
		this.attendeddate = attendeddate;
	}
	public int getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}
	public int getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}
	public int getStatecode() {
		return statecode;
	}
	public void setStatecode(int statecode) {
		this.statecode = statecode;
	}
	public int getMonumber() {
		return monumber;
	}
	public void setMonumber(int monumber) {
		this.monumber = monumber;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	private int age;
	public String getImgUrl(String string) {
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
	
	public String getProfileID() {
		return profileID;
	}
	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
