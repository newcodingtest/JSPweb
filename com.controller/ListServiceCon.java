package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BoardDAO;
import com.model.BoardDTO;


@WebServlet("/ListServiceCon")
public class ListServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//f:검색조건(작성자 or 제목) q:검색입력란
		String field_=request.getParameter("f");
		String query_=request.getParameter("q");
		String page_=request.getParameter("p");
		
		
		String field="title";
		if(field_!=null && !field_.equals(""))
			field=field_;
		
		String query="";
		if(query_!=null && !query_.equals(""))
			query=query_;
		
		int page=1;
		if(page_!=null && !page_.equals(""))
			page=Integer.parseInt(page_);
		
	  BoardDAO dao=new BoardDAO();
       List<BoardDTO> list=dao.getlist(field,query,page);
       int count =dao.getListCount(field, query);
       
       request.setAttribute("list", list);
       request.setAttribute("count", count);
       
       request.getRequestDispatcher("Board_View/List.jsp").forward(request, response);
	}

}
