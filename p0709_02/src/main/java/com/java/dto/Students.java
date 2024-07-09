package com.java.dto;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students {

	private int stuNo;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	private int rank;
	private String gender;
	private String hobby;
	private String[] hobbys;
	static int count = 1;
	
	public Students(int stuNo, String name, int kor, int eng, int math) {
		this.stuNo = stuNo; //번호 추가 --> DB에서 
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor+eng+math;
		this.avg = total/3.;
	}
	
}
