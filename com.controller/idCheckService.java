package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;

@WebServlet("/idCheckService")
public class idCheckService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	//login.jsp 에서 회원가입할때 email 값을 ajax로 불러오는 값	
	String email=request.getParameter("id");
	
	MemberDAO dao=new MemberDAO(); 
	boolean check=dao.idCheck(email);
	
	//true 나오면 아이디 존재 false 나오면 
	System.out.println("아이디 중복확인: "+check);
	

	
	response.setContentType("text/html; charset=euc-kr"); // 이거는 요청시에 쓴다 response.setCharacterEncoding(id); 는 서블릿에서 화면에 요청할때 out.print 시 사용  request.setCharacterEncoding("EUC-KR");  html >>jsp 로 갑 가져올때 jsp 에서 인코딩해줘야함
	
	PrintWriter out=response.getWriter();
	
	out.print(check);
	}
}
