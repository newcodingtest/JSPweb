package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.DTO_cpu;
import com.model.categoryDAO;



@WebServlet("/categoryServiceCon")
public class categoryServiceCon extends HttpServlet {



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int count = 0;
		String product = request.getParameter("product");
		System.out.println(product);
		
		if(product.equals("cpu")) {
			String productObject = "cpu_t";
			String company = request.getParameter("company");
			String core = request.getParameter("core");
			String socket_i = request.getParameter("socket_i");
			String socket_a = request.getParameter("socket_a");
			ArrayList<String> production = new ArrayList<>();
			
			
			if(!company.equals("null")) {
				production.add("company");
				production.add(company);
				count++;
			}
			if(!core.equals("null")) {
				production.add("core");
				production.add(core);
				count++;
			}
			if(!socket_i.equals("null")) {
				production.add("socket");
				production.add(socket_i);
				count++;
			}
			if(!socket_a.equals("null")) {
				production.add("socket");
				production.add(socket_a);
				count++;
			}
		
			 ArrayList<DTO_cpu> list = new ArrayList<DTO_cpu>();
			 categoryDAO dao = new categoryDAO();
			 list = dao.SelectCategoryQuery(production, product,productObject, count);
			 System.out.println("리스트 사이즈= "+list.size());
			 /*for(int i=1; i<=list.size(); i++) {
				 
				 System.out.println(list.get(i).getModel());
				 
			 }*/
			
		}
		
		
		
		
	}

}
