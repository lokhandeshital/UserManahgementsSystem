package com.UserManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.UserManagement.dto.PostDto;
import com.UserManagement.service.PostService;

@RestController
public class PostController {

	@Autowired
	private PostService service;
	
	@PostMapping("/user/{userid}/post")
	public ResponseEntity<PostDto> createpost(@RequestBody PostDto postDto,@PathVariable("userid") Integer userid){
		
		PostDto createPost = this.service.createPost(postDto, userid);
		
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
		
	}
}
