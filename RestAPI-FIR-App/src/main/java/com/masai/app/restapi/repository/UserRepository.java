package com.masai.app.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.app.restapi.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	User findByMobileNumberAndPassword(String mobileNumber, String password);

}
