package com.UserManagement.serviceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserManagement.beans.Post;
import com.UserManagement.beans.User;
import com.UserManagement.dto.PostDto;
import com.UserManagement.exception.UserNotFoundException;
import com.UserManagement.repository.PostRepository;
import com.UserManagement.repository.UserRepository;
import com.UserManagement.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postrepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepository userrepo;

	/**
	 * @author Shital
	 * @apiNote This Api is to save Post Data
	 * 
	 * 
	 */

	@Override
	public PostDto createPost(PostDto postDto, Integer userid) {

		// Step 1 :Finding User
		User user = this.userrepo.findById(userid)
				.orElseThrow(() -> new UserNotFoundException("User", "userid", userid));

		// Step 2 :Converting Dto to Entity
		Post post = this.mapper.map(postDto, Post.class);

		// Step 3 :Setting Hardcoded value
		post.setImagename("shital.jpg");
		post.setAddeddate(new Date());
		post.setUser(user);

		// Step 4 :We are saving post to DataBase
		Post newpost = postrepo.save(post);

		// Step 5 :Converting Entity To Dto
		PostDto updatedpost = this.mapper.map(newpost, PostDto.class);

		return updatedpost;
	}

}
