package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.java.dao.BoardDao;
import com.java.dto.BoardDto;
import com.java.service.BoardService;

import ch.qos.logback.core.model.Model;

@RequestMapping("/board")
@Controller
public class BoardController {
	
	//방법1. BoardServiceImpl boardServiceImpl = new BoardServiceImpl(); //객체선언
	//방법2. BoardService boardService = new BoardServiceImpl(); //다형성
	@Autowired //방법3
	BoardService boardService; 
	
	@RequestMapping("/list") //게시판리스트
	public ModelAndView list() {
		ArrayList<BoardDto> list = boardService.selectList();
		
		//mv
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("board/list");
		mv.addObject("list", list);
		return mv;
	}//list
	
	@RequestMapping("/view") //뷰페이지
//	@RequestParam(defaultValue = "1") int bno: bno=null일 경우 1로 고정.
	//(= BoardDto bdto)
	public ModelAndView view(BoardDto bdto) {
		
		//1개 참조변수명.메소드명()
		BoardDto boardDto = boardService.selectOne(bdto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardDto",boardDto);
		mv.setViewName("board/view");
		return mv;
	}//view
	
	@GetMapping("/write") //글쓰기 화면
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/write") //글쓰기 저장
	public String write(BoardDto bdto, @RequestPart MultipartFile files) {
		//id,btitle,bcontent,files
		System.out.println("controller files: "+files.getOriginalFilename());
		String uFile = "";
		
		//파일이 존재할 경우 
		if(!files.isEmpty()) {
			//jsp
			long time = System.currentTimeMillis();
			System.out.println("time: "+time);
			
		//uuid 방식
//		UUID uuid = UUID.randomUUID();
//		System.out.println("uuid: "+uuid);
		
		uFile = String.format("%d_%s", time,files.getOriginalFilename());
		String saveUrl = "c:/upload/";
		File f = new File(saveUrl+uFile);
		try {
			files.transferTo(f);
		} catch (Exception e) {e.printStackTrace();} //파일 업로드
	}//if
	
		//변경된 파일이름 저장
		bdto.setBfile(uFile);	
		boardService.insertBoard(bdto);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/delete") //게시글 삭제
	public String delete(BoardDto bdto) {
		System.out.println("controller delete bno: "+bdto.getBno());
		boardService.deleteBoard(bdto);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/update") //수정페이지
	public ModelAndView update(BoardDto bdto) { 
		BoardDto boardDto = boardService.updateBoard(bdto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardDto",boardDto);
		mv.setViewName("board/modify");
		return mv;
	}
	
	@RequestMapping("/doUpdate") //게시글 수정 저장
	public String doUpdate(BoardDto bdto, @RequestPart MultipartFile files) {
		//수정 페이지 저장 - bno,id,btitle,bcontent,files
		
		String uFile = "";

		if(!files.isEmpty()) {
			long time = System.currentTimeMillis();
			System.out.println("time: "+time);

		uFile = String.format("%d_%s", time,files.getOriginalFilename());
		String saveUrl = "c:/upload/";
		File f = new File(saveUrl+uFile);
		try {
			files.transferTo(f);
		} catch (Exception e) {e.printStackTrace();} //파일 업로드
		bdto.setBfile(uFile);	
	}//if
		boardService.doUpdateBoard(bdto);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/reply") //답글페이지
	public ModelAndView reply(BoardDto bdto) {
		BoardDto boardDto = boardService.selectOne(bdto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardDto",boardDto);
		mv.setViewName("board/reply");
		return mv;
	}
	
	@RequestMapping("/doReply") //답글 페이지 저장 
	public String toReply(BoardDto bdto, @RequestPart MultipartFile files) {
		String uFile = "";
	
		//파일이 존재할 경우 
		if(!files.isEmpty()) {
			long time = System.currentTimeMillis();
			System.out.println("time: "+time);

		uFile = String.format("%d_%s", time,files.getOriginalFilename());
		String saveUrl = "c:/upload/";
		File f = new File(saveUrl+uFile);
		try {
			files.transferTo(f);
		} catch (Exception e) {e.printStackTrace();} //파일 업로드
	}//if
		bdto.setBfile(uFile);
		
		boardService.insertReply(bdto);
		return "redirect:/board/list";
	}
	
	
	
}
