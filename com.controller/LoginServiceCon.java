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
	
		//1.사용자 입력 정보 가져오기 test
//		System.out.println(email);
//		System.out.println(pw);
		
		
		MemberDAO dao=new MemberDAO();
		
		//관리자 정보가 db에 있는지? 확인
		int admin=dao.AdminCheck(email, pw);
		//일반회원 정보가 db에 있는지? 확인
		int guest =dao.LoginCheck(email, pw);
		
		//DB로 부터 값을 가져왔는지? 콘솔 테스트
		System.out.println("LoginServiceCon admin: "+admin);
		System.out.println("LoginServiceCon guest: "+guest);
		
		//어드민계정이 존재하며 회원의 아이디가 없는경우 1:로그인 성공 2:비번틀림 3:아이디 없음
		if(admin>0 && guest==3) {
		if(admin==1) {
			AdminDTO adinfo=dao.AdminLogin(email); 
			session.setAttribute("adinfo",adinfo);
			
			request.setAttribute("admin", 1);
			System.out.println("관리자 로그인 성공");
			System.out.println("관리자 정보 넘기는 값: "+adinfo);
			chk.setCheck(1);
		}else if(admin==2) {
			System.out.println("비밀번호 불 일치");
			request.setAttribute("admin", 2);
		}else if(admin==3) {
			System.out.println("아이디가 없어요");
			request.setAttribute("admin", 3);
			
		}else { //디폴트값 아무것도 출력 안함
			request.setAttribute("admin", 0);
		}
		
		}
		
		//회원계정이 존재하며 어드민 아이디가 없는경우 1:로그인 성공 2:비번틀림 3:아이디 없음
		if(guest>0 && admin==3) {
		if(guest==1) {
			MemberDTO info=dao.Login(email); 
			System.out.println("로그인 성공");
			System.out.println("사용자 정보넘기는 값"+info);
			session.setAttribute("info",info);
			
			request.setAttribute("guest", 1);
			request.setAttribute("open", 2);
			chk.setCheck(1);
		}else if(guest==2) {
			System.out.println("비밀번호 불 일치");
			request.setAttribute("guest", 2);
		}else if(guest==3) {
			System.out.println("아이디가 없어요");
			request.setAttribute("guest", 3);
			
		}else { //디폴트값 아무것도 출력 안함
			request.setAttribute("guest", 0);
		}
		
		}
	
		dispatcher.forward(request, response);

		
	}
	

}
