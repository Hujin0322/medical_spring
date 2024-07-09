package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor		//기본생성자
@AllArgsConstructor		//생성자
@Data 					//Getter+Setter
public class Member {
	
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String hobby;
	private String[] hobbys;
}
