package com.jbedu.mysql.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbedu.mysql.dao.BoardDao;
import com.jbedu.mysql.dto.BoardDto;

@Controller
public class BoardController {
	
	@RequestMapping(value = "/write_form")
	public String write_form() {
		return "write_form";
	}
	
	@RequestMapping(value = "/writeOk")
	public String writeOk(HttpServletRequest request, Model model) {
		
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao boardDao = new BoardDao();
		boardDao.boardWrite(bname, btitle, bcontent);
		
		return "redirect:boardList";
	}
	
	@RequestMapping(value = "/boardList")
	public String boardList(HttpServletRequest request, Model model) {
		
		BoardDao boardDao = new BoardDao();
		ArrayList<BoardDto> bDtos = boardDao.boardList();//모든 글 목록
		
		model.addAttribute("bDtos", bDtos);
		
		return "boardList";
	}
	
	
	
	
	
	
}