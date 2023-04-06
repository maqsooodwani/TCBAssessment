package hs.com.in.tcb.assessment.service;

import org.springframework.stereotype.Service;

import hs.com.in.tcb.assessment.request.UserDetailsRequest;
import hs.com.in.tcb.assessment.response.UserResponse;



@Service
public class TcbServiceImpl {
	
	public UserResponse getUser(String userId) {
		UserResponse userResponse=new UserResponse();
		userResponse.setFirstName("Tabida");
		userResponse.setGender("F");
		userResponse.setDateOfBirth("27-06-2022");
		return userResponse;
	}

	public String updateUser(UserDetailsRequest user) {
		System.out.println(user.getDateOfBirth());
		return "user Updated Successfully";
		// TODO Auto-generated method stub
		
	}

	public String createUser(UserDetailsRequest user) {
		System.out.println(user.getFirstName());
		return "user created Successfully";
	}

}
