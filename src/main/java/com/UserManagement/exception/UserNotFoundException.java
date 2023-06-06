package com.UserManagement.exception;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String resourcename;
	
	String filedname;
	
	Integer filedvalue;

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getFiledname() {
		return filedname;
	}

	public void setFiledname(String filedname) {
		this.filedname = filedname;
	}

	public Integer getFiledvalue() {
		return filedvalue;
	}

	public void setFiledvalue(Integer filedvalue) {
		this.filedvalue = filedvalue;
	}

	public UserNotFoundException(String resourcename, String filedname, Integer filedvalue) {
		super(String.format("%s not found %s : %s", resourcename,filedname,filedvalue));
		this.resourcename = resourcename;
		this.filedname = filedname;
		this.filedvalue = filedvalue;
	}

     

	
	
	
}
