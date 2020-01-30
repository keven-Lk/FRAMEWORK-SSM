package com.blog.pojo;

import java.io.Serializable;

public class Author implements Serializable{
	private static final long serialVersionUID = -8895407544545997334L;
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String bio;
	/**¸öÈË¼ò½é*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", bio="
				+ bio + "]";
	}
}
