package hs.com.in.tcb.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hs.com.in.tcb.assessment.entities.AddressEntity;
import hs.com.in.tcb.assessment.entities.UserEntity;
import hs.com.in.tcb.assessment.repository.UserRepository;
import hs.com.in.tcb.assessment.request.Address;
import hs.com.in.tcb.assessment.request.UserDetailsRequest;
import hs.com.in.tcb.assessment.response.UserResponse;

@Service
public class TcbServiceImpl {
	
	@Autowired
	UserRepository userRepository;
	
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
		UserEntity userEntity= new UserEntity();
		//userEntity.setUserId(user.getFirstName()+user.getLastName());
		userEntity.setDateOfBirth(user.getFirstName());
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setDateOfBirth(user.getDateOfBirth());
		userEntity.setGender(user.getGender());
		
		for(Address address: user.getAddress()) {
			
			AddressEntity addressEntity=new AddressEntity();
			addressEntity.setAddressType(address.getAddressType());
			addressEntity.setLine1(address.getLine1());
			addressEntity.setLine2(address.getLine2());
			addressEntity.setCity(address.getCity());
			addressEntity.setPostcode(address.getPostcode());
			addressEntity.setCity(address.getCity());
			addressEntity.setState(address.getState());
			
			userEntity.getAddress().add(addressEntity);
		}
		
		UserEntity savedUser=userRepository.save(userEntity);
		return savedUser.getUserId()+" : created Successfully";
	}

}
