package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.model.MemberDAO;
import com.model.MemberDTO;


@WebServlet("/JoinServiceCon")
public class JoinServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("JoinSuccess.jsp");
		
		String email=request.getParameter("email");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String tel=request.getParameter("tel");
		String addr=request.getParameter("addr");
		
		MemberDAO dao=new MemberDAO();
		MemberDTO dto=new MemberDTO(email, pw,name, tel, addr);

		int cnt=dao.join(dto);
		if(cnt>0) {
			System.out.println("회원 등록성공");
			HttpSession session=request.getSession();
			session.setAttribute("email", email);
		}else {
			System.out.println("회원 등록성공");
		}
		dispatcher.forward(request, response);
	}

}
