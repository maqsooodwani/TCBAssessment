package hs.com.in.tcb.assessment.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hs.com.in.tcb.assessment.entities.AddressEntity;
import hs.com.in.tcb.assessment.entities.UserEntity;
import hs.com.in.tcb.assessment.repository.UserRepository;
import hs.com.in.tcb.assessment.request.Address;
import hs.com.in.tcb.assessment.request.UpdateUserDetailsRequest;
import hs.com.in.tcb.assessment.request.UserDetailsRequest;
import hs.com.in.tcb.assessment.response.UserResponse;

@Service
public class TcbServiceImpl {

	@Autowired
	UserRepository userRepository;

	public UserResponse getUser(String userId) {
		UserResponse userResponse=new UserResponse();
		Optional<UserEntity> userEntity=userRepository.findById(Integer.parseInt(userId));
		if(userEntity.isPresent()) {
			UserEntity user=userEntity.get();
			userResponse.setUserId(user.getUserId());
			userResponse.setFirstName(user.getFirstName());
			userResponse.setGender(user.getGender());
			userResponse.setDateOfBirth(user.getDateOfBirth());
			userResponse.setLastName(user.getLastName());
		}else {
			userResponse.setErrorMessage("User Not Found.");
		}
		return userResponse;
	}

	public UserResponse updateUser(UpdateUserDetailsRequest user) {
		UserResponse response = new UserResponse();
		if(user.getDateOfBirth()!=null) {
			response.setErrorMessage("DateOfBirth cannot be Updated.");
			response.setUserId(user.getUserId());
			return response;
		}else {
			Optional<UserEntity> userEntity=userRepository.findById(user.getUserId());
			if(userEntity.isPresent()) {
				UserEntity savedUserEntity=userEntity.get();
				myCopyProperties(user,savedUserEntity);
				userRepository.save(savedUserEntity);
			}else {
				response.setErrorMessage("User Not Found.");
				response.setUserId(user.getUserId());
				return response;
			}
		}
		response.setMessage("user Updated Successfully");
		return response;
	}

	public String createUser(UserDetailsRequest user) {
		UserEntity userEntity= new UserEntity();
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
	
	public String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }

	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}

	public void myCopyProperties(Object src, Object target) {
	    BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}

}
