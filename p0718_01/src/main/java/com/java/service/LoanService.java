package com.java.service;

import java.util.ArrayList;

import com.java.dto.LoanDto;

public interface LoanService {

	//loan 리스트 - region
	ArrayList<LoanDto> selectLoan();
	
	//loan 리스트 - period
	ArrayList<LoanDto> selectLoan2();

	

}
