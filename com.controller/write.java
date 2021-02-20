package com.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.model.BoardDAO;
import com.model.BoardDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		
		//===================파일 업로드 시작===========================//
//		String realFolder="";
//		String filename1="";
//		int maxSize=1024*1024*5;
//		String encType="euc-kr";
//		String savefile="img";
//		ServletContext scontext=getServletContext();
//		realFolder=scontext.getRealPath(savefile);
//		
//		try{
//			  MultipartRequest multi=new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
//
//			  Enumeration<?> files = multi.getFileNames();
//			     String file1 = (String)files.nextElement();
//			     filename1 = multi.getFilesystemName(file1);
//			 } catch(Exception e) {
//			  e.printStackTrace();
//			 }
//			 
//			 String fullpath = realFolder + "\\" + filename1;
		
			//===================파일 업로드 끝===========================//

	
		
		
		BoardDTO dto=new BoardDTO();
		
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		
		BoardDAO dao=new BoardDAO();
		int cnt=dao.write(dto);
		
		if(cnt>0) {
		System.out.println("글쓰기 성공");
	
		}else {
			System.out.println("글쓰기 실패");
		}
		
		
		response.sendRedirect("List.jsp");
	}


}
