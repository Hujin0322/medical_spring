package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper //=@Repository
public interface BoardDao {

	ArrayList<BoardDto> selectList();
	
}