package com.UserManagement.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.UserManagement.beans.User;
import com.UserManagement.dto.UserDto;
import com.UserManagement.exception.UserNotFoundException;
import com.UserManagement.repository.UserRepository;
import com.UserManagement.service.UserServiceI;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepository repository;

	@Override
	public UserDto saveUser(UserDto userdto) {

		// Step 1 : Dto to Entity Convert
		User newusers = this.mapper.map(userdto, User.class);

		// Step 2 : Database save this User
		User newUser = this.repository.save(newusers);

		// Step 3 :Entity to Dto
		UserDto updateduser = this.mapper.map(newUser, UserDto.class);

		return updateduser;
	}

	@Override
	public List<UserDto> getAllUser(Integer pageNumber, Integer pageSize) {

		Pageable page = PageRequest.of(pageNumber, pageSize);

		Page<User> findAll = this.repository.findAll(page);

		List<User> content = findAll.getContent();

		List<UserDto> collect = findAll.stream().map((list) -> this.mapper.map(list, UserDto.class))
				.collect(Collectors.toList());

		return collect;
	}

	@Override
	public UserDto getUserById(Integer id) {

		User newuser = this.repository.findById(id).orElseThrow(() -> new UserNotFoundException("User", "id", id));

		UserDto updated = this.mapper.map(newuser, UserDto.class);

		return updated;
	}

	@Override
	public UserDto updateUser(UserDto user, Integer id) {

		User newuser = this.repository.findById(id).orElseThrow(() -> new UserNotFoundException("User", "id", id));

		newuser.setName(user.getName());
		newuser.setEmail(user.getEmail());
		newuser.setAddress(user.getAddress());
		newuser.setPhoneno(user.getPhoneno());
		newuser.setPassword(user.getPassword());

		this.repository.save(newuser);

		UserDto updatedUser = this.mapper.map(newuser, UserDto.class);

		return updatedUser;
	}

	@Override
	public void deleteUser(Integer id) {

		User newuser = this.repository.findById(id).orElseThrow(() -> new UserNotFoundException("User", "id", id));

		this.repository.delete(newuser);

	}

}
