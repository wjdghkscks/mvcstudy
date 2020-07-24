package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class OnelistCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터 값 받기
		String idx = request.getParameter("idx");
		
		VO vo = DAO.getOnelist(idx);
		
		// session에 저장
		request.getSession().setAttribute("vo", vo);
		
		return "view/onelist.jsp";
	}
}
