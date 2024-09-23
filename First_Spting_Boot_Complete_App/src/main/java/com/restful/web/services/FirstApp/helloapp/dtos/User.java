package com.restful.web.services.FirstApp.helloapp.dtos;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.restful.web.services.FirstApp.helloapp.repoordao.entities.Post;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="user_detail")
public class User {
	@Id
	@GeneratedValue
	private int userId;
	//validation Annotation
	@Size(min = 2, max = 10, message = "Name lenght should be min 2 and max 10")
	private String name;
	@Past
	private LocalDate dob;
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public User() {
		System.out.println("<<<No args constructor>>>");
	}
	public User(int userId, String name, LocalDate dob) {
		this.userId = userId;
		this.name = name;
		this.dob = dob;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
}
