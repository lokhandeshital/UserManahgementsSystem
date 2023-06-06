package com.UserManagement.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto {

	@NotEmpty
	@Size(min = 4, max = 10, message = "User Name Must Be min 4 character and max 10 character")
	private String name;

	@Email
	private String email;

	@NotEmpty
	@Size(min = 4, max = 10, message = "User password Must Be min 4 character and max 10 character")
	private String password;

	@NotEmpty
	@Size(min = 4, max = 10, message = "User address Must Be min 4 character and max 10 character")
	private String address;

	@NotEmpty
	@Size(min = 4, max = 10, message = "Phone Number Must Be min 4 character and max 10 character")
	private String phoneno;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public UserDto(String name, String email, String password, String address, String phoneno) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneno = phoneno;
	}  

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
