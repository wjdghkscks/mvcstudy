package com.ict.model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateOkCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		VO vo = new VO();
		
		try {
			// 파일 처리
			String path = request.getServletContext().getRealPath("/upload");
			
			MultipartRequest mr = new MultipartRequest(
						request,
						path,
						100 * 1024 * 1024,
						"UTF-8",
						new DefaultFileRenamePolicy()
					);
			
			// session에서 파라미터 값 받기
			vo.setIdx(mr.getParameter("idx"));
			vo.setName(mr.getParameter("name"));
			vo.setSubject(mr.getParameter("subject"));
			vo.setContent(mr.getParameter("content"));
			vo.setFile_name(mr.getParameter("file_name"));
			vo.setEmail(mr.getParameter("email"));
			vo.setPwd(mr.getParameter("pwd"));
			
			// 파일을 업로드 하는 경우와 하지 않는 경우 구별
			if (mr.getFile("file_name") != null) {
				vo.setFile_name(mr.getFilesystemName("file_name"));
			} else {
				vo.setFile_name(mr.getParameter("f_name"));
			}
			
			int result = DAO.getUpdate(vo);
			if (result >= 1) {
				// update 성공 시 기존 세션에 변경된 vo 를 덮어쓰기
				request.getSession().setAttribute("vo", vo);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/MyController?cmd=onelist&idx=" + vo.getIdx(); 
	}
}
