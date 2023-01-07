package com.masai.app.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.restapi.entity.FIR;
import com.masai.app.restapi.repository.FIRRepository;

@Service
public class FirServiceImpl implements FirService {
	
	@Autowired
	FIRRepository firRepository;

	@Override
	public FIR createFir(FIR fir) {
		return firRepository.save(fir);
	}

}
