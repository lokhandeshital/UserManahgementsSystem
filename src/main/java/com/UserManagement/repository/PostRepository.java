package com.UserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserManagement.beans.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
