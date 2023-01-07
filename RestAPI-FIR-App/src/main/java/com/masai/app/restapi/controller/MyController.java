package com.masai.app.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.restapi.entity.FIR;
import com.masai.app.restapi.entity.LoginReq;
import com.masai.app.restapi.entity.User;
import com.masai.app.restapi.service.FirService;
import com.masai.app.restapi.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/masaifir/user/")
public class MyController {

	@Autowired
	UserService userservice;
	@Autowired
	FirService firservice;
	
	// for registering a new user
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user){
		User regUser = userservice.createUser(user);
		return new ResponseEntity<User>(regUser,HttpStatus.CREATED);
	}
	
	// for login
	@PostMapping("/login")
	public ResponseEntity<User> login(@Valid @RequestBody LoginReq login){
		User user = userservice.login(login.getMobileNumber(), login.getPassword());
		if(user==null) {
			return new ResponseEntity<User>(user,HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.ok(user);
	}
	
	// getting list of fir's for a particular user
	@GetMapping("/{id}/fir")
	public ResponseEntity<List<FIR>> getFirByUser(@PathVariable int id){
		List<FIR> usersFir = userservice.getUserFirs(id);
		return ResponseEntity.ok(usersFir);
	}
	
	// creating a new fir
	@PostMapping("/fir")
	public ResponseEntity<FIR> createFir(@Valid @RequestBody FIR fir){
		FIR createFir = firservice.createFir(fir);
		return new ResponseEntity<FIR>(createFir,HttpStatus.CREATED);
	}
	
	
}
