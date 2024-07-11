package com.java.service;

import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;

@Service
public interface MemberService {

	MemberDto selectLogin(MemberDto mdto);
	
}
