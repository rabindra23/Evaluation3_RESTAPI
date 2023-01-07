package com.masai.app.restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class FIR {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fId;
	@Pattern(regexp="^[A-Z][a-z]*",message ="Name not valid")
	private String firstName;
	@Pattern(regexp="^[A-Z][a-z]*",message ="Name not valid")
	private String lastName;
	@Size(min=10,max=10,message="please enter valid mobile number")
	private String mobileNumber;
	@Size(max=100)
	private String address;
	@Size(min=8,message="minimum age should be 8 years")
	private int age;
	private String gender;
	@Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){6,12}$", message ="try new password" )
	private String password;
	@ManyToOne
	private User user;
	
	
	public FIR() {}


	public FIR(int fId, String firstName, String lastName, String mobileNumber, String address, int age, String gender,
			String password, User user) {
		super();
		this.fId = fId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.password = password;
		this.user = user;
	}


	public int getfId() {
		return fId;
	}


	public void setfId(int fId) {
		this.fId = fId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	

	
	
	
	
}
