package hs.com.in.tcb.assessment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import hs.com.in.tcb.assessment.entities.AddressEntity;
import hs.com.in.tcb.assessment.entities.UserEntity;
import hs.com.in.tcb.assessment.repository.UserRepository;
import hs.com.in.tcb.assessment.request.Address;
import hs.com.in.tcb.assessment.request.UpdateUserDetailsRequest;
import hs.com.in.tcb.assessment.request.UserDetailsRequest;
import hs.com.in.tcb.assessment.response.UserResponse;
import hs.com.in.tcb.assessment.service.TcbServiceImpl;

@SpringBootTest
class TcbServiceImplTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private TcbServiceImpl tcbService;
	
	@Test
	public void testGetUser() {
		UserEntity userEntity = new UserEntity();
		populateUserEntity(userEntity);
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(userEntity));
		UserResponse response=tcbService.getUser("1");
		assertEquals(response.getUserId(), 1);
	}
	
	@Test
	public void testUpdateUser() {
		UserEntity userEntity = new UserEntity();
		populateUserEntity(userEntity);
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(userEntity));
		UpdateUserDetailsRequest user = new UpdateUserDetailsRequest();
		populateUpdateUserDetailsRequest(user);
		UserResponse response=tcbService.updateUser(user);
		assertEquals(response.getErrorMessage(), "DateOfBirth cannot be Updated.");
	}
	
	

	@Test
	public void testCreateUser() {
		
		UserEntity userEntity = new UserEntity();
		populateUserEntity(userEntity);
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(userEntity);
		UserDetailsRequest user = new UserDetailsRequest();
		populateUserDetailsRequest(user);
		String response=tcbService.createUser(user);
		assertEquals("1 : created Successfully",response);
		
	}
	
	

	private void populateUserEntity(UserEntity userEntity) {
		userEntity.setFirstName("John");
		userEntity.setLastName("Carter");
		userEntity.setDateOfBirth("25-01-1990");
		userEntity.setGender("M");
		userEntity.setUserId(1);
		
		AddressEntity address= new AddressEntity();
		address.setAddressType("WORK");
		address.setCity("Hyderabad");
		address.setLine1("Line1");
		address.setLine1("Line2");
		address.setPostcode("500008");
		
		userEntity.getAddress().add(address);
		
	}
	
	private void populateUpdateUserDetailsRequest(UpdateUserDetailsRequest user) {
		user.setFirstName("John");
		user.setLastName("Carter");
		user.setDateOfBirth("25-01-1990");
		user.setGender("M");
		user.setUserId(1);
	}
	
	private void populateUserDetailsRequest(UserDetailsRequest user) {
		user.setFirstName("John");
		user.setLastName("Carter");
		user.setDateOfBirth("25-01-1990");
		user.setGender("M");
		user.setUserId(1);	
		
		Address address= new Address();
		address.setAddressType("WORK");
		address.setCity("Hyderabad");
		address.setLine1("Line1");
		address.setLine1("Line2");
		address.setPostcode("500008");
		
		user.getAddress().add(address);
		
		
	}

}
