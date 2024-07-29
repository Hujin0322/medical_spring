package com.java.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberDao;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired MemberDao memberDao;
	
	@Override //로그인확인
	public MemberDto selectLogin(MemberDto memberDto) {

		MemberDto mDto = memberDao.selectLogin(memberDto);
		
		return mDto;
	}

	@Override //아이디 찾기
	public MemberDto findId(String name_v, String fullEmail) {
		
		MemberDto mDto = memberDao.findId(name_v,fullEmail);
		
		return mDto;
	}

	@Override  //중복아이디 찾기
	public MemberDto compareId(String id) {
		
		MemberDto mDto = memberDao.compareId(id);
		
		return mDto;
	}

	@Override  //회원가입
	public void joinMem(String name, String id, String pw2, String fullEmail, String fullTell, Date birth,
			String genderC) {
		memberDao.joinMem(name,id,pw2,fullEmail,fullTell,birth,genderC);
	}

	
	@Override  //마이페이지 회원정보 가져오기
	public MemberDto InfoMem(String sessionId) {
		MemberDto mdto = memberDao.InfoMem(sessionId);
		return mdto;
	}

	@Override //회원정보 수정
	public void doUpdateMem(MemberDto mDto) {
		System.out.println("serviceImpl doUpdateMem");
		memberDao.doUpdateMem(mDto);
		System.out.println("serviceImpl doUpdateMem2");
		
	}
	
	
	@Override  //관리자페이지 - 멤버리스트
	public ArrayList<MemberDto> memList() {
		
		ArrayList<MemberDto> list = memberDao.memList();
		
		return list;
	}

	@Override  //회원정보삭제
	public void deleteMem(String id, String name) {

		memberDao.deleteMem(id,name);
	}


}
