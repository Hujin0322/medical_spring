package com.java.www;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex0708_02 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new
				ClassPathXmlApplicationContext("com/java/www/beans.xml");
		
		//beans파일에서 pencil소스 가져오기
		Pencil pencil = ctx.getBean("pencil",Pencil.class);
		pencil.use();
		
		ctx.close(); //필수
		
	}

}
