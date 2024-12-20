package com.jbedu.mysql.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.jbedu.mysql.dao.BoardDao;

public class BDeleterCommand implements BCommand {

	@Override
	public int execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");		
		
		BoardDao boardDao = new BoardDao();
		int deleteFlag = boardDao.boardDelete(request.getParameter("bnum"));
		
		return deleteFlag;
	}

}