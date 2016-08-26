package com.j.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
public class AdminRegisterBean {
	@Pattern(regexp="")
	@Size(min=7,max=100)
	@NotNull
	private String email;
	@Size(min=5,max=100)
	@NotNull
	private String username;
	@Pattern(regexp="")
	@Size(min=7,max=100)
	@NotNull
	private char[] password;
	@Pattern(regexp="")
	@Size(min=7,max=100)
	@NotNull
	private String imgUrl;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
