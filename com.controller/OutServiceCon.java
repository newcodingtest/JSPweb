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

/**
 * Servlet implementation class OutServiceCon
 */
@WebServlet("/OutServiceCon")
public class OutServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session =request.getSession();
		RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
	
		MemberDTO info=(MemberDTO)session.getAttribute("info");
		
		MemberDAO dao=new MemberDAO();
		
		int cnt=dao.deleteMember(info);

		session.invalidate();
		
		
		dispatcher.forward(request, response);
		
		
		
	}

}
