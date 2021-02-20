package com.controller;

import java.io.IOException; 


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.AdminDTO;
import com.model.MemberDAO;
import com.model.MemberDTO;


@WebServlet("/LoginServiceCon")
public class LoginServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int abc = Integer.parseInt(request.getParameter("abc"));
		//System.out.println(abc);
		check chk = new check();
		RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
		HttpSession session=request.getSession();
		
	
		String email=request.getParameter("email");
		String pw=request.getParameter("pw");
	
		//1.����� �Է� ���� �������� test
//		System.out.println(email);
//		System.out.println(pw);
		
		
		MemberDAO dao=new MemberDAO();
		
		//������ ������ db�� �ִ���? Ȯ��
		int admin=dao.AdminCheck(email, pw);
		//�Ϲ�ȸ�� ������ db�� �ִ���? Ȯ��
		int guest =dao.LoginCheck(email, pw);
		
		//DB�� ���� ���� �����Դ���? �ܼ� �׽�Ʈ
		System.out.println("LoginServiceCon admin: "+admin);
		System.out.println("LoginServiceCon guest: "+guest);
		
		//���ΰ����� �����ϸ� ȸ���� ���̵� ���°�� 1:�α��� ���� 2:���Ʋ�� 3:���̵� ����
		if(admin>0 && guest==3) {
		if(admin==1) {
			AdminDTO adinfo=dao.AdminLogin(email); 
			session.setAttribute("adinfo",adinfo);
			
			request.setAttribute("admin", 1);
			System.out.println("������ �α��� ����");
			System.out.println("������ ���� �ѱ�� ��: "+adinfo);
			chk.setCheck(1);
		}else if(admin==2) {
			System.out.println("��й�ȣ �� ��ġ");
			request.setAttribute("admin", 2);
		}else if(admin==3) {
			System.out.println("���̵� �����");
			request.setAttribute("admin", 3);
			
		}else { //����Ʈ�� �ƹ��͵� ��� ����
			request.setAttribute("admin", 0);
		}
		
		}
		
		//ȸ�������� �����ϸ� ���� ���̵� ���°�� 1:�α��� ���� 2:���Ʋ�� 3:���̵� ����
		if(guest>0 && admin==3) {
		if(guest==1) {
			MemberDTO info=dao.Login(email); 
			System.out.println("�α��� ����");
			System.out.println("����� �����ѱ�� ��"+info);
			session.setAttribute("info",info);
			
			request.setAttribute("guest", 1);
			request.setAttribute("open", 2);
			chk.setCheck(1);
		}else if(guest==2) {
			System.out.println("��й�ȣ �� ��ġ");
			request.setAttribute("guest", 2);
		}else if(guest==3) {
			System.out.println("���̵� �����");
			request.setAttribute("guest", 3);
			
		}else { //����Ʈ�� �ƹ��͵� ��� ����
			request.setAttribute("guest", 0);
		}
		
		}
	
		dispatcher.forward(request, response);

		
	}
	

}
