package com.masai.app.restapi.service;

import org.springframework.stereotype.Service;

import com.masai.app.restapi.entity.FIR;

@Service
public interface FirService {
	
	FIR createFir(FIR fir);
}
