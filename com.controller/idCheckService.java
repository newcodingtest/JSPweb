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
		

	//login.jsp ���� ȸ�������Ҷ� email ���� ajax�� �ҷ����� ��	
	String email=request.getParameter("id");
	
	MemberDAO dao=new MemberDAO(); 
	boolean check=dao.idCheck(email);
	
	//true ������ ���̵� ���� false ������ 
	System.out.println("���̵� �ߺ�Ȯ��: "+check);
	

	
	response.setContentType("text/html; charset=euc-kr"); // �̰Ŵ� ��û�ÿ� ���� response.setCharacterEncoding(id); �� �������� ȭ�鿡 ��û�Ҷ� out.print �� ���  request.setCharacterEncoding("EUC-KR");  html >>jsp �� �� �����ö� jsp ���� ���ڵ��������
	
	PrintWriter out=response.getWriter();
	
	out.print(check);
	}
}
