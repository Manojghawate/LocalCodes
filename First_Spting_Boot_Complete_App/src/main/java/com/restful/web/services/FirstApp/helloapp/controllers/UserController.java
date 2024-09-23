package com.restful.web.services.FirstApp.helloapp.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.web.services.FirstApp.helloapp.Exceptions.UserNotFoundException;
import com.restful.web.services.FirstApp.helloapp.dtos.User;
import com.restful.web.services.FirstApp.helloapp.repoordao.entities.Post;
import com.restful.web.services.FirstApp.helloapp.services.UserService;

import jakarta.validation.Valid;
/**
 * @author manoj.ghawate
 * 
 * This controller elaborates the API naming standards and conventions
 * Ideal way to get request parameters and ideal way to sending API response.
 */
@RestController
@RequestMapping("api/users")
public class UserController {
	private UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(this.userService.getAllUsers(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public  EntityModel<User> getUserByid(@PathVariable("id") int id){
		User user = this.userService.getUserByid(id);
		if(user==null) {
			throw new UserNotFoundException("id "+id);
		}
		EntityModel<User>entityModel = EntityModel.of(user);
		WebMvcLinkBuilder builder = linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(builder.withRel("all-users"));
		return entityModel;
	}
	@PostMapping
	public ResponseEntity<String> addUser(@RequestBody @Valid User user) {
		this.userService.addUser(user);
		return new ResponseEntity<String>(String.format("User with id %s added succesfully !!", user.getUserId()),HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
		this.userService.deleteUserByid(id);
		return new ResponseEntity<String>(String.format("User with id %s deleted succesfully !!", id),HttpStatus.OK);
	}
	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Post>> getAllPosts(@PathVariable("id") int id){
		User user = this.userService.getUserByid(id);
		if(user == null)
			throw new UserNotFoundException(String.format("user with %s not found",id));
		
		return new ResponseEntity<List<Post>>(user.getPosts(),HttpStatus.OK);
	}
	@PostMapping("/{id}/posts")
	public ResponseEntity<String> addPostForUser(@PathVariable("id") int id, @Valid @RequestBody Post post){
		User user = this.userService.getUserByid(id);
		if(user == null)
			throw new UserNotFoundException(String.format("user with %s not found",id));
		post.setUser(user);
		this.userService.addPostForUser(post);
		return new ResponseEntity<String>(String.format("User with id %s created succesfully !!", post.getId()),HttpStatus.OK);
	}
	@GetMapping("/{id}/posts/{postId}")
	public ResponseEntity<Post> getPost(@PathVariable("id") int id,@PathVariable("postId") int postId){
		User user = this.userService.getUserByid(id);
		if(user == null)
			throw new UserNotFoundException(String.format("user with %s not found",id));
		Post post =this.userService.getPostById(postId);
		if(post==null) {
			throw new RuntimeException("post not found");
		}
		return new ResponseEntity<Post>(this.userService.getPostById(postId),HttpStatus.OK);
	}
}
