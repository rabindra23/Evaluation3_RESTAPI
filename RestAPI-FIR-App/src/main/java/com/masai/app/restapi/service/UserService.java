package com.masai.app.restapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.app.restapi.entity.FIR;
import com.masai.app.restapi.entity.User;

@Service
public interface UserService {

	User createUser(User user);
	User login(String mobileNumber, String password);
	List<FIR> getUserFirs(int id);
}
