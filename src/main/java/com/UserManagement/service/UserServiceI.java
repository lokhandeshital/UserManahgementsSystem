package com.UserManagement.service;

import java.util.List;

import com.UserManagement.beans.User;
import com.UserManagement.dto.UserDto;


public interface UserServiceI {

	public UserDto saveUser(UserDto userdto);
	
	public List<UserDto> getAllUser(Integer pageNumber,Integer pageSize);
	
	public UserDto getUserById(Integer id);
	
	public UserDto updateUser(UserDto userdto,Integer id);
	
	public void deleteUser(Integer id);
	
}
