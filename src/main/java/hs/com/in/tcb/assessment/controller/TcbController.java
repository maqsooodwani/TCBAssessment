package hs.com.in.tcb.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hs.com.in.tcb.assessment.request.UpdateUserDetailsRequest;
import hs.com.in.tcb.assessment.request.UserDetailsRequest;
import hs.com.in.tcb.assessment.response.UserResponse;
import hs.com.in.tcb.assessment.service.TcbServiceImpl;

@RestController
public class TcbController {
	
	@Autowired
	private TcbServiceImpl tcbService;
	
	@PostMapping("api/v1/createUser")
	public ResponseEntity<String> createUser(@RequestBody UserDetailsRequest user) {
		String response=tcbService.createUser(user);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@PutMapping("api/v1/updateUser")
	public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserDetailsRequest user) {
		UserResponse userResponse=tcbService.updateUser(user);
		ResponseEntity<UserResponse> response;
		if(userResponse.getErrorMessage()!=null) {
			if(userResponse.getErrorMessage().contentEquals("User Not Found.")) {
				response=new ResponseEntity<UserResponse>(userResponse,HttpStatus.NOT_FOUND);
			}else {
				response=new ResponseEntity<UserResponse>(userResponse,HttpStatus.NOT_ACCEPTABLE);
			}
		}else {
			response=new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("api/v1/user/{userId}")
	public ResponseEntity<UserResponse> getUser(@PathVariable("userId") String userId) {
		UserResponse response=tcbService.getUser(userId);
		ResponseEntity<UserResponse> userResponse;
		if(response.getErrorMessage()==null) {
			userResponse= new ResponseEntity(response,HttpStatus.OK);
		}else {
			userResponse= new ResponseEntity(response,HttpStatus.NOT_FOUND);
		}
		return userResponse;
	}

}
