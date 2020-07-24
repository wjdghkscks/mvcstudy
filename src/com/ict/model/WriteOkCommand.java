package com.ict.model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteOkCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
			// 파일을 저장할 위치
			String path = request.getServletContext().getRealPath("/upload");
			
			MultipartRequest mr = new MultipartRequest (
							request,
							path,
							100 * 1024 * 1024,
							"UTF-8",
							new DefaultFileRenamePolicy()
						);
							
			// 파라미터 값 받기
			VO vo = new VO();
			vo.setName(mr.getParameter("name"));
			vo.setSubject(mr.getParameter("subject"));
			vo.setContent(mr.getParameter("content"));
			vo.setFile_name(mr.getParameter("file_name"));
			vo.setEmail(mr.getParameter("email"));
			vo.setPwd(mr.getParameter("pwd"));
			
			// 파일을 첨부하는 경우와 첨부하지 않는 경우를 구분
			if(mr.getFile("file_name") != null) {
				vo.setFile_name(mr.getFilesystemName("file_name"));
			} else {
				vo.setFile_name("");
			}
			
			int result = DAO.getWrite(vo);
			
			request.setAttribute("result", result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "view/write_ok.jsp";
	}
}
