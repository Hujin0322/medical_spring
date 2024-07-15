package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;

@Service
@Qualifier(value="ver2")
public class BoardServiceImpl2 implements BoardService {

	@Override
	public ArrayList<BoardDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void selectCount() {
//		System.out.println("BoardServiceImpl 버전2이 실행됩니다.");
//	}

}
