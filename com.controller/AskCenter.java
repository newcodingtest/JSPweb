package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;
import com.model.MessageDAO;
import com.model.MessageDTO;


@WebServlet("/AskCenter")
public class AskCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		String kind=request.getParameter("kind");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String email=request.getParameter("email");
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
		
		System.out.println("kind: "+kind+"title: "+title+"content: "+content+"email: "+email);
		MessageDTO dto=new MessageDTO();
		dto.setKind(kind);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setE_mail(email);
		
		MessageDAO dao=new MessageDAO();
		dao.AddAsk(dto);
		
		dispatcher.forward(request, response);
	}

}
