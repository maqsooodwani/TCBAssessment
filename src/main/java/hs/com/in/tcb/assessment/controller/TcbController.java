package hs.com.in.tcb.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<String> updateUser(@RequestBody UserDetailsRequest user) {
		String response=tcbService.updateUser(user);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@GetMapping("api/v1/user/{userId}")
	public ResponseEntity<UserResponse> getUser(@PathVariable("userId") String userId) {
		UserResponse response=tcbService.getUser(userId);
		ResponseEntity<UserResponse> userResponse= new ResponseEntity(response,HttpStatus.OK);
		return userResponse;
	}

}
