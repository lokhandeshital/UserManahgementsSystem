package com.UserManagement.service;

import com.UserManagement.dto.PostDto;

public interface PostService {

	public PostDto createPost(PostDto postDto, Integer userid);
}
