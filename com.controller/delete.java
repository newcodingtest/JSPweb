package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BoardDAO;
import com.model.BoardDTO;


@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int comid=Integer.parseInt(request.getParameter("comid"));
		
		BoardDAO dao=new BoardDAO();

		int cnt=dao.delete(comid);
		
		if(cnt>0) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
		response.sendRedirect("List.jsp");
	}

}
