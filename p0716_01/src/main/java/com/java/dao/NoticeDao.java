package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.CommentBDto;
import com.java.dto.NoticeDto;

@Mapper
public interface NoticeDao {

	ArrayList<NoticeDto> selectAll();

	//notice 1개 가져오기
	NoticeDto selectOne(NoticeDto noticeDto);

	//댓글 list 가져오기
	ArrayList<CommentBDto> selectAllCommentB(NoticeDto noticeDto);

	//하단댓글 저장
	void insertCommentB(CommentBDto commentBDto);

	//하단댓글 1개 가져오기
	CommentBDto selectOneCommentB(CommentBDto commentBDto);

	//하단댓글 삭제
	void deleteCommentB(CommentBDto commentBDto);

	//하단댓글 수정
	void updateCommentB(CommentBDto commentBDto);

}
