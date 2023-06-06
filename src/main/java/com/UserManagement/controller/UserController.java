package com.UserManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UserManagement.beans.User;
import com.UserManagement.dto.UserDto;
import com.UserManagement.service.UserServiceI;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServiceI serviceI;

	@PostMapping("/saveUser")
	public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userdto) {

		UserDto saveUser = this.serviceI.saveUser(userdto);

		return new ResponseEntity<UserDto>(saveUser, HttpStatus.CREATED);

	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer id) {

		UserDto userById = this.serviceI.getUserById(id);

		return new ResponseEntity<UserDto>(userById, HttpStatus.FOUND);

	}

	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserDto>> getAllUser(
			@RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize) {

		List<UserDto> allUser = this.serviceI.getAllUser(pageNumber,pageSize);

		return new ResponseEntity<List<UserDto>>(allUser, HttpStatus.FOUND);

	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {

		this.serviceI.deleteUser(id);

		return new ResponseEntity<String>("User Deleted Successfully :" + id, HttpStatus.OK);

	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto user, @PathVariable("id") Integer id) {

		UserDto newuser = this.serviceI.updateUser(user, id);

		return new ResponseEntity<UserDto>(newuser, HttpStatus.OK);

	}

}
