package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SpecialEstimate")
public class SpecialEstimate extends HttpServlet {



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] id =  request.getParameterValues("id");
		//int size=id.length;
		HttpSession session = request.getSession(true);

		
		if(id[0].equals("cpu")) {
			System.out.println(id[1]);
			session.setAttribute("pro_cpu", id[1]);
		}
		if(id[0].equals("mother")) {
			System.out.println(id[1]);
			session.setAttribute("pro_mother", id[1]);
		}
		if(id[0].equals("memory")) {
			System.out.println(id[1]);
			session.setAttribute("pro_memory", id[1]);
		}
		if(id[0].equals("gpu")) {
			System.out.println(id[1]);
			session.setAttribute("pro_gpu", id[1]);
		}
		if(id[0].equals("power")) {
			System.out.println(id[1]);
			session.setAttribute("pro_power", id[1]);
		}
		if(id[0].equals("device")) {
			System.out.println(id[1]);
			session.setAttribute("pro_device", id[1]);
		}
		if(id[0].equals("cooler")) {
			System.out.println(id[1]);
			session.setAttribute("pro_cooler", id[1]);
		}
		if(id[0].equals("case")) {
			System.out.println(id[1]);
			session.setAttribute("pro_case", id[1]);
		}
		if(id[0].equals("keyboard")) {
			System.out.println(id[1]);
			session.setAttribute("pro_keyboard", id[1]);
		}
		if(id[0].equals("mouse")) {
			System.out.println(id[1]);
			session.setAttribute("pro_mouse", id[1]);
		}
		if(id[0].equals("monitor")) {
			System.out.println(id[1]);
			session.setAttribute("pro_monitor", id[1]);
		}
		
		
		
		if(id[0].equals("d_cpu")) {
			
			session.removeAttribute("pro_cpu");
		}
		if(id[0].equals("d_mother")) {
			
			session.removeAttribute("pro_mother");
		}
		if(id[0].equals("d_memory")) {
			
			session.removeAttribute("pro_memory");
		}
		if(id[0].equals("d_gpu")) {
			
			session.removeAttribute("pro_gpu");
		}
		if(id[0].equals("d_power")) {
			
			session.removeAttribute("pro_power");
		}
		if(id[0].equals("d_device")) {
			
			session.removeAttribute("pro_device");
		}
		if(id[0].equals("d_cooler")) {
			
			session.removeAttribute("pro_cooler");
		}
		if(id[0].equals("d_case")) {
			
			session.removeAttribute("pro_case");
		}
		if(id[0].equals("d_keyboard")) {
			
			session.removeAttribute("pro_keyboard");
		}
		if(id[0].equals("d_mouse")) {
			
			session.removeAttribute("pro_mouse");
		}
		if(id[0].equals("d_monitor")) {
			
			session.removeAttribute("pro_monitor");
		}

		
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		

		
		
		
	}

}
