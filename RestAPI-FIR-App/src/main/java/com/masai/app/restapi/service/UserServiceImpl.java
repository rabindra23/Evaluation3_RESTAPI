package com.masai.app.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.restapi.entity.FIR;
import com.masai.app.restapi.entity.User;
import com.masai.app.restapi.repository.FIRRepository;
import com.masai.app.restapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	FIRRepository firRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User login(String mobileNumber, String password) {
		if(userRepository.findByMobileNumberAndPassword(mobileNumber, password)==null) {
			return null;
		}
		return userRepository.findByMobileNumberAndPassword(mobileNumber, password);
	}

	@Override
	public List<FIR> getUserFirs(int id) {
		return userRepository.findById(id).get().getFirs();
	}

}
