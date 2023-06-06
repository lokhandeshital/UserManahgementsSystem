package com.UserManagement.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse> usernotfoundexception(UserNotFoundException ex) {

		String message = ex.getMessage();

		ApiResponse apiResponse = new ApiResponse(message, ErrorCode.USERN);

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgument(MethodArgumentNotValidException ex){
		
		Map<String, String> data = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> { 
			
		String field=((FieldError)error).getField();
		
		String defaultMessage = error.getDefaultMessage();
		
		data.put(field, defaultMessage);
		});
		return new ResponseEntity<Map<String,String>>(data,HttpStatus.BAD_REQUEST);
		
	}

}
