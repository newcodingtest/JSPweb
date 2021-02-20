package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberDTO;


@WebServlet("/MypageUpdate")
public class MypageUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
		HttpSession session=request.getSession();
		
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String tel=request.getParameter("tel");
		String address=request.getParameter("address");
		
		MemberDAO dao=new MemberDAO();
		MemberDTO Updateinfo=new MemberDTO(pw,name,tel,address);
		
		int cnt=dao.Update(Updateinfo);
		
		if(cnt>0) {
			System.out.println("수정성공");
			session.setAttribute("info", Updateinfo);
		}else {
			System.out.println("실패");
		}
		dispatcher.forward(request, response);
		
	}

}
