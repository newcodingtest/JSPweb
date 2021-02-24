package com.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
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
	
		
		//===================파일 업로드 시작===========================//
	      
//	      String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
//
//	      System.out.println("파일 저장 경로: "+uploadPath);
//	      
//	       int size = 1024 * 1024 * 10; // 저장가능한 파일 크기
//	       String file = ""; // 업로드 한 파일의 이름(이름이 변경될수 있다)
//	       String originalFile = ""; // 이름이 변경되기 전 실제 파일 이름
//
//	       // 실제로 파일 업로드하는 과정
//	   
//	           MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
//
//	           Enumeration files = multi.getFileNames();
//	           String str = (String)files.nextElement(); // 파일 이름을 받아와 string으로 저장
//
//	           file = multi.getFilesystemName(str); // 업로드 된 파일 7이름 가져옴
//	           originalFile = multi.getOriginalFileName(str); // 원래의 파일이름 가져옴
//
//	           System.out.println(originalFile);
	   
	           
	      //===================파일 업로드 끝===========================//

		
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		BoardDTO dto=new BoardDTO(title,content,id,pw);
		
		BoardDAO dao=new BoardDAO();
		int cnt=dao.write(dto);
		
		if(cnt>0) {
		System.out.println("글쓰기 성공");
	
		}else {
			System.out.println("글쓰기 실패");
		}
		
		request.getRequestDispatcher("ListServiceCon").forward(request, response);
	}


}
