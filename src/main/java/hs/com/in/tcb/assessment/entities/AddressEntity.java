package hs.com.in.tcb.assessment.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Address")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int addressId;
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserEntity user;
	private String addressType;
	private String line1;
	private String line2;
	private String postcode;
	private String city;
	private String state;

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
}
