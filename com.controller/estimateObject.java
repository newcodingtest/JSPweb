package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.DTO_case;
import com.model.DTO_cooler;
import com.model.DTO_cpu;
import com.model.DTO_keyboard;
import com.model.DTO_memory;
import com.model.DTO_monitor;
import com.model.DTO_mother;
import com.model.DTO_mouse;
import com.model.DTO_power;
import com.model.DTO_storage;
import com.model.DTO_vga;
import com.model.categoryDAO;


@WebServlet("/estimateObject")
public class estimateObject extends HttpServlet {



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("utf-8"); // 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String page = request.getParameter("page");
		System.out.println("어느 페이지"+page);
		String product = request.getParameter("product"); //여기는  클릭하면 받아지는 곳인데, 처음에 페이지에서 견적버튼 누르면 CPU부터 자동으로 출력
		System.out.println(product);
		ArrayList<String> production_model = new ArrayList<>();
		ArrayList<Integer> production_price = new ArrayList<>();
		ArrayList<String> production_context = new ArrayList<>();
		int count = 0;
		Object first = request.getParameter("first");
		Object second = request.getParameter("second");
		Object third = request.getParameter("third");
		Object fourth = request.getParameter("fourth");
		Object fifth = request.getParameter("fifth");
		Object sixth = request.getParameter("sixth");
		ArrayList<String> search = new ArrayList<>();
		String productObject = request.getParameter("productObject");
		boolean sw = false;
		
		

		if(first != null || second != null || third != null || fourth != null || fifth != null || sixth != null) {
			sw = true;
			if( !first.equals("null") && product != null) { // 상단의 null 은 처음 first에 들어가는 null이고, 하단은 콤보박스 null상태
			search.add(request.getParameter("detail_1")); // "cpu" 받은것 올림[컬럼명]
			search.add((String)first); //String 형의  데이터값 받음 [행]
			count++;
			
		}
	
			if( !second.equals("null") && product != null) {
			search.add(request.getParameter("detail_2"));	
			search.add((String)second);
			count++;
				
			}
		
		
			if( !third.equals("null") && product != null) {
			search.add(request.getParameter("detail_3"));	
			search.add((String)third);
			count++;
				
			}
		
		
			if( !fourth.equals("null") && product != null) {
			search.add(request.getParameter("detail_4"));
			search.add((String)fourth);
			count++;
				
			}
			
			if( !fifth.equals("null") && product != null) {
			search.add(request.getParameter("detail_5"));
			search.add((String)fifth);
			count++;
				
			}
			
			
			
			categoryDAO dao = new categoryDAO();
			
			if (product.equals("cpu")) {
			ArrayList<DTO_cpu> list= new ArrayList<DTO_cpu>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("칩셋 제조사: "+list.get(i).getCompany()+"/ "+
						"아키텍처: "+list.get(i).getAc()+"/ "+
						"코어 수: "+list.get(i).getCore()+"/ "+
						"쓰레드 수: "+list.get(i).getThread()+"/ "+
						"모델 명: "+list.get(i).getModel()+"/ "+
						"클럭: "+list.get(i).getClock()+"/ "+
						"부스트 클럭: "+list.get(i).getClock_b()+"/ "+
						"공정: "+list.get(i).getMp());
			}

			
		}
			if (product.equals("mother")) {
			ArrayList<DTO_mother> list= new ArrayList<DTO_mother>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("칩셋 제조사: "+list.get(i).getCompany()+"/ "+
						"폼팩터: "+list.get(i).getForm()+"/ "+
						"칩셋 제조사: "+list.get(i).getC_company()+"/ "+
						"칩셋 명: "+list.get(i).getChipset()+"/ "+
						"모델 명: "+list.get(i).getModel()+"/ "+
						"소켓: "+list.get(i).getSocket());
			}

			
		}	
			if (product.equals("memory")) {
			ArrayList<DTO_memory> list= new ArrayList<DTO_memory>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("칩셋 제조사: "+list.get(i).getCompany()+"/ "+
						"메모리 타입: "+list.get(i).getType()+"/ "+
						"메모리 용량: "+list.get(i).getMem()+"/ "+
						"메모리 클럭: "+list.get(i).getClock()+"/ "+
						"모델 명: "+list.get(i).getModel());
			}

			
		}
			
			if (product.equals("gpu")) {
			ArrayList<DTO_vga> list= new ArrayList<DTO_vga>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("칩셋 제조사: "+list.get(i).getChip_com()+"/ "+
						"칩셋명: "+list.get(i).getChipname()+"/ "+			
						"제조사: "+list.get(i).getCompany()+"/ "+
						"메모리용량: "+list.get(i).getMem()+"/ "+
						"부스트 클럭: "+list.get(i).getClock_b()+"/ "+
						"길이: "+list.get(i).getLength());
			}

			
		}
			if (product.equals("power")) {
			ArrayList<DTO_power> list= new ArrayList<DTO_power>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("제조사: "+list.get(i).getCompany()+"/ "+
						"폼펙터: "+list.get(i).getForm()+"/ "+			
						"정격출력: "+list.get(i).getOutput()+"/ "+
						"인증: "+list.get(i).getAuthen()+"/ "+
						"보증기간: "+list.get(i).getGurantee());
			}

			
		}
			if (product.equals("device")) {
			ArrayList<DTO_storage> list= new ArrayList<DTO_storage>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("제조사: "+list.get(i).getCompany()+"/ "+
						"폼펙터: "+list.get(i).getForm()+"/ "+			
						"인터페이스: "+list.get(i).getInterfaced()+"/ "+
						"용량: "+list.get(i).getMem()+"/ "+
						"분류: "+list.get(i).getKind()+"/ "+
						"메모리 타입: "+list.get(i).getType());
			}

			
		}
			if (product.equals("cooler")) {
			ArrayList<DTO_cooler> list= new ArrayList<DTO_cooler>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("제조사: "+list.get(i).getCompany()+"/ "+
						"냉각 방식: "+list.get(i).getForm()+"/ "+			
						"팬 크기: "+list.get(i).getFan_size()+"/ "+
						"히트 파이프: "+list.get(i).getHitcnt()+"/ "+
						"TDP: "+list.get(i).getTdp()+"/ "+
						"라디에이터 길이: "+list.get(i).getRadi_length()+"/ "+
						"쿨러 형태: "+list.get(i).getForm()+"/ "+
						"소켓: "+list.get(i).getSocket()+"/ "+
						"소음: "+list.get(i).getNoise());
			}

			
		}
			if (product.equals("case")) {
			ArrayList<DTO_case> list= new ArrayList<DTO_case>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("제조사: "+list.get(i).getCompany()+"/ "+
						"케이스 크기: "+list.get(i).getSized()+"/ "+			
						"폼팩터: "+list.get(i).getMax()+"/ "+
						"쿨링팬 제공: "+list.get(i).getPane_cnt());
			}

			
		}
			if (product.equals("keyboard")) {
			ArrayList<DTO_keyboard> list= new ArrayList<DTO_keyboard>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("제조사: "+list.get(i).getCompany()+"/ "+
						"연결 방식: "+list.get(i).getConn()+"/ "+			
						"접점 방식: "+list.get(i).getSelect_s()+"/ "+
						"스위치 회사: "+list.get(i).getS_company()+"/ "+
						"스위치: "+list.get(i).getK_switch()+"/ "+
						"키 배열: "+list.get(i).getArray()+"/ "+
						"색깔: "+list.get(i).getColor());
			}

			
		}
			if (product.equals("mouse")) {
			ArrayList<DTO_mouse> list= new ArrayList<DTO_mouse>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("제조사: "+list.get(i).getCompany()+"/ "+
						"연결 방식: "+list.get(i).getConn()+"/ "+			
						"감도: "+list.get(i).getFeel()+"/ "+
						"센서: "+list.get(i).getSensor()+"/ "+
						"컬러: "+list.get(i).getColor());
			}

			
		}
			if (product.equals("monitor")) {
			ArrayList<DTO_monitor> list= new ArrayList<DTO_monitor>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("제조사: "+list.get(i).getCompany()+"/ "+
						"화면 크기: "+list.get(i).getInchi()+"/ "+			
						"해상도: "+list.get(i).getHae()+"/ "+
						"화면 비율: "+list.get(i).getRate()+"/ "+
						"주사율: "+list.get(i).getHz()+"/ "+
						"패널 형태: "+list.get(i).getForm()+"/"+
						"무게: "+list.get(i).getWeight()+"/ "+
						"블루라이트: "+list.get(i).isBlue()+"/ "+
						"패널: "+list.get(i).getPanel()+"/ "+
						"색 재현율: "+list.get(i).getColor());
			}

			
		}
		}
		/////////////////////////아래로 노말 영역 ////////////////////////////
		
		if(product.equals("cpu") & sw == false) {
			
			ArrayList<DTO_cpu> list= new ArrayList<DTO_cpu>(); // 이거랑 맨 아래 set Attribute만 작동
			categoryDAO dao = new categoryDAO(); // 이것도 작동 X
			list = dao.SelectCategory(product); // 이전의 필터 받으면 이거 작동 안시켜야함 
			request.setAttribute("product_list", list);
			
			//페이지에 표시할 요소를 미리 로딩

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("칩셋 제조사: "+list.get(i).getCompany()+"/ "+
					"아키텍처: "+list.get(i).getAc()+"/ "+
					"코어 수: "+list.get(i).getCore()+"/ "+
					"쓰레드 수: "+list.get(i).getThread()+"/ "+
					"모델 명: "+list.get(i).getModel()+"/ "+
					"클럭: "+list.get(i).getClock()+"/ "+
					"부스트 클럭: "+list.get(i).getClock_b()+"/ "+
					"공정: "+list.get(i).getMp());
			

			
			}
	
		}
		if(product.equals("mother") & sw == false) {
			
			ArrayList<DTO_mother> list= new ArrayList<DTO_mother>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//페이지에 표시할 요소를 미리 로딩

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("칩셋 제조사: "+list.get(i).getCompany()+"/ "+
					"폼팩터: "+list.get(i).getForm()+"/ "+
					"칩셋 제조사: "+list.get(i).getC_company()+"/ "+
					"칩셋 명: "+list.get(i).getChipset()+"/ "+
					"모델 명: "+list.get(i).getModel()+"/ "+
					"소켓: "+list.get(i).getSocket());

			
			}
			
			
		}
		if(product.equals("memory") & sw == false) {
			
			ArrayList<DTO_memory> list= new ArrayList<DTO_memory>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//페이지에 표시할 요소를 미리 로딩

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("칩셋 제조사: "+list.get(i).getCompany()+"/ "+
					"메모리 타입: "+list.get(i).getType()+"/ "+
					"메모리 용량: "+list.get(i).getMem()+"/ "+
					"메모리 클럭: "+list.get(i).getClock()+"/ "+
					"모델 명: "+list.get(i).getModel());

			
			}
			
			
		}
		if(product.equals("gpu") & sw == false) {
			
			ArrayList<DTO_vga> list= new ArrayList<DTO_vga>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//페이지에 표시할 요소를 미리 로딩

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("칩셋 제조사: "+list.get(i).getChip_com()+"/ "+
					"칩셋명: "+list.get(i).getChipname()+"/ "+			
					"제조사: "+list.get(i).getCompany()+"/ "+
					"메모리용량: "+list.get(i).getMem()+"/ "+
					"부스트 클럭: "+list.get(i).getClock_b()+"/ "+
					"길이: "+list.get(i).getLength());

			
			}
			
			
		}
		if(product.equals("power") & sw == false) {
			
			ArrayList<DTO_power> list= new ArrayList<DTO_power>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//페이지에 표시할 요소를 미리 로딩

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("제조사: "+list.get(i).getCompany()+"/ "+
					"폼펙터: "+list.get(i).getForm()+"/ "+			
					"정격출력: "+list.get(i).getOutput()+"/ "+
					"인증: "+list.get(i).getAuthen()+"/ "+
					"보증기간: "+list.get(i).getGurantee());

			
			}
			
			
		}
		if(product.equals("device") & sw == false) {
			
			ArrayList<DTO_storage> list= new ArrayList<DTO_storage>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//페이지에 표시할 요소를 미리 로딩

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("제조사: "+list.get(i).getCompany()+"/ "+
					"폼펙터: "+list.get(i).getForm()+"/ "+			
					"인터페이스: "+list.get(i).getInterfaced()+"/ "+
					"용량: "+list.get(i).getMem()+"/ "+
					"분류: "+list.get(i).getKind()+"/ "+
					"메모리 타입: "+list.get(i).getType());

			
			}
			
			
		}
		if(product.equals("cooler") & sw == false) {
			
			ArrayList<DTO_cooler> list= new ArrayList<DTO_cooler>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//페이지에 표시할 요소를 미리 로딩

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("제조사: "+list.get(i).getCompany()+"/ "+
					"냉각 방식: "+list.get(i).getForm()+"/ "+			
					"팬 크기: "+list.get(i).getFan_size()+"/ "+
					"히트 파이프: "+list.get(i).getHitcnt()+"/ "+
					"TDP: "+list.get(i).getTdp()+"/ "+
					"라디에이터 길이: "+list.get(i).getRadi_length()+"/ "+
					"쿨러 형태: "+list.get(i).getForm()+"/ "+
					"소켓: "+list.get(i).getSocket()+"/ "+
					"소음: "+list.get(i).getNoise());

			
			}
			
			
		}
		if(product.equals("case") & sw == false) {
			
			ArrayList<DTO_case> list= new ArrayList<DTO_case>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//페이지에 표시할 요소를 미리 로딩

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("제조사: "+list.get(i).getCompany()+"/ "+
					"케이스 크기: "+list.get(i).getSized()+"/ "+			
					"폼팩터: "+list.get(i).getMax()+"/ "+
					"쿨링팬 제공: "+list.get(i).getPane_cnt());

			
			}
			
			
		}
		if(product.equals("keyboard") & sw == false) {
			
			ArrayList<DTO_keyboard> list= new ArrayList<DTO_keyboard>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//페이지에 표시할 요소를 미리 로딩

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("제조사: "+list.get(i).getCompany()+"/ "+
					"연결 방식: "+list.get(i).getConn()+"/ "+			
					"접점 방식: "+list.get(i).getSelect_s()+"/ "+
					"스위치 회사: "+list.get(i).getS_company()+"/ "+
					"스위치: "+list.get(i).getK_switch()+"/ "+
					"키 배열: "+list.get(i).getArray()+"/ "+
					"색깔: "+list.get(i).getColor());

			
			}
			
			
		}
		if(product.equals("mouse") & sw == false) {
			
			ArrayList<DTO_mouse> list= new ArrayList<DTO_mouse>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//페이지에 표시할 요소를 미리 로딩

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("제조사: "+list.get(i).getCompany()+"/ "+
					"연결 방식: "+list.get(i).getConn()+"/ "+			
					"감도: "+list.get(i).getFeel()+"/ "+
					"센서: "+list.get(i).getSensor()+"/ "+
					"컬러: "+list.get(i).getColor());

			
			}
			
			
		}
		if(product.equals("monitor") & sw == false) {
			
			ArrayList<DTO_monitor> list= new ArrayList<DTO_monitor>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//페이지에 표시할 요소를 미리 로딩

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("제조사: "+list.get(i).getCompany()+"/ "+
					"화면 크기: "+list.get(i).getInchi()+"/ "+			
					"해상도: "+list.get(i).getHae()+"/ "+
					"화면 비율: "+list.get(i).getRate()+"/ "+
					"주사율: "+list.get(i).getHz()+"/ "+
					"패널 형태: "+list.get(i).getForm()+"/ "+
					"무게: "+list.get(i).getWeight()+"/ "+
					"블루라이트: "+list.get(i).isBlue()+"/ "+
					"패널: "+list.get(i).getPanel()+"/ "+
					"색 재현율: "+list.get(i).getColor());

			
			}
			
			
		}
		
		
		request.setAttribute("model", production_model);
		request.setAttribute("price", production_price);
		request.setAttribute("context", production_context);
		request.setAttribute("product", product);
		// 유지한 채로 페이지로 넘겨줌
		ServletContext context = getServletContext();
		if(page.equals("estimate")) {
		RequestDispatcher dispatcher = context.getRequestDispatcher("/estimate.jsp");
		dispatcher.forward(request, response);}
		if(page.equals("category")) {
		RequestDispatcher dispatcher = context.getRequestDispatcher("/category.jsp");
		dispatcher.forward(request, response);;	
		}
		
		
	

}
}
