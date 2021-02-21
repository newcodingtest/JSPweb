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
import com.model.productDAO;


@WebServlet("/productSearchCon")
public class productSearchCon extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8"); // 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String productname = request.getParameter("productname");
		String productid = request.getParameter("productid");
		String productids = request.getParameter("productid");
		System.out.println("고른상품: "+productname);
		System.out.println("고른종류: "+productid);
		productDAO dao = new productDAO();
		
		if (productid.equals("cpu")) {
		
		String producttable = "cpu_t";
		productid = "c_model";
		int join = dao.selectItemSeq(productname, productid);
		System.out.println(join);
		ArrayList<DTO_cpu> list = new ArrayList<DTO_cpu>();
		list = dao.selectItem(join, producttable, productid);
		
		String name = list.get(0).getModel();
		int price = list.get(0).getPrice();
		String company = list.get(0).getCompany();
		int cnt = list.get(0).getCnt();
		
		String object = "아키텍처: "+ list.get(0).getAc()+
				", 클럭: "+list.get(0).getClock()+
				", 부스트클럭:"+list.get(0).getClock_b()+
				", 코어 수: "+list.get(0).getCore()+
				", 쓰레드 수: "+list.get(0).getThread()+
				", 소켓: "+list.get(0).getSocket()+
				", TDP: "+list.get(0).getTdp()+"";
		
		System.out.println(list.get(0).getModel());
		request.setAttribute("product_item_val", productids);
		request.setAttribute("product_item_name", name);	
		request.setAttribute("product_item_price", price);
		request.setAttribute("product_item_company", company);
		request.setAttribute("product_item_cnt", cnt);
		request.setAttribute("product_item_object", object);
		}
		

		if (productid.equals("mother")) {
			
		String producttable = "mainboard_t";
		productid = "m_model";
		int join = dao.selectItemSeq(productname, productid);
		System.out.println(join);
		ArrayList<DTO_mother> list = new ArrayList<DTO_mother>();
		list = dao.selectItem(join, producttable, productid);
		
		String name = list.get(0).getModel();
		int price = list.get(0).getPrice();
		String company = list.get(0).getCompany();
		int cnt = list.get(0).getCnt();
		
		String object = "칩셋 제조사: "+list.get(0).getCompany()+"/ "+
				"폼팩터: "+list.get(0).getForm()+"/ "+
				"칩셋 제조사: "+list.get(0).getC_company()+"/ "+
				"칩셋 명: "+list.get(0).getChipset()+"/ "+
				"모델 명: "+list.get(0).getModel()+"/ "+
				"소켓: "+list.get(0).getSocket()+"";
		
		System.out.println(list.get(0).getModel());
		request.setAttribute("product_item_val", productids);
		request.setAttribute("product_item_name", name);	
		request.setAttribute("product_item_price", price);
		request.setAttribute("product_item_company", company);
		request.setAttribute("product_item_cnt", cnt);
		request.setAttribute("product_item_object", object);
		}
		
		
		
		if (productid.equals("gpu")) {
			
		String producttable = "gpu_t";
		productid = "g_model";
		int join = dao.selectItemSeq(productname, productid);
		System.out.println(join);
		ArrayList<DTO_vga> list = new ArrayList<DTO_vga>();
		list = dao.selectItem(join, producttable, productid);
		
		String name = list.get(0).getModel();
		int price = list.get(0).getPrice();
		String company = list.get(0).getCompany();
		int cnt = list.get(0).getCnt();
		
		String object = "칩셋 제조사: "+list.get(0).getChip_com()+"/ "+
				"칩셋명: "+list.get(0).getChipname()+"/ "+			
				"제조사: "+list.get(0).getCompany()+"/ "+
				"메모리용량: "+list.get(0).getMem()+"/ "+
				"부스트 클럭: "+list.get(0).getClock_b()+"/ "+
				"길이: "+list.get(0).getLength()+"";
		
		System.out.println(list.get(0).getModel());
		request.setAttribute("product_item_val", productids);
		request.setAttribute("product_item_name", name);	
		request.setAttribute("product_item_price", price);
		request.setAttribute("product_item_company", company);
		request.setAttribute("product_item_cnt", cnt);
		request.setAttribute("product_item_object", object);
		}
		
		
		
		if (productid.equals("memory")) {
			
		String producttable = "memory_t";
		productid = "me_model";
		int join = dao.selectItemSeq(productname, productid);
		System.out.println(join);
		ArrayList<DTO_memory> list = new ArrayList<DTO_memory>();
		list = dao.selectItem(join, producttable, productid);
		
		String name = list.get(0).getModel();
		int price = list.get(0).getPrice();
		String company = list.get(0).getCompany();
		int cnt = list.get(0).getCnt();
		
		String object = "칩셋 제조사: "+list.get(0).getCompany()+"/ "+
				"메모리 타입: "+list.get(0).getType()+"/ "+
				"메모리 용량: "+list.get(0).getMem()+"/ "+
				"메모리 클럭: "+list.get(0).getClock()+"/ "+
				"모델 명: "+list.get(0).getModel()+"";
		
		
		request.setAttribute("product_item_val", productids);
		request.setAttribute("product_item_name", name);	
		request.setAttribute("product_item_price", price);
		request.setAttribute("product_item_company", company);
		request.setAttribute("product_item_cnt", cnt);
		request.setAttribute("product_item_object", object);
		}
		
		
		
		if (productid.equals("device")) {
			
		String producttable = "device_t";
		productid = "d_model";
		int join = dao.selectItemSeq(productname, productid);
		System.out.println(join);
		ArrayList<DTO_storage> list = new ArrayList<DTO_storage>();
		list = dao.selectItem(join, producttable, productid);
		
		String name = list.get(0).getModel();
		int price = list.get(0).getPrice();
		String company = list.get(0).getCompany();
		int cnt = list.get(0).getCnt();
		
		String object = "제조사: "+list.get(0).getCompany()+"/ "+
				"폼펙터: "+list.get(0).getForm()+"/ "+			
				"인터페이스: "+list.get(0).getInterfaced()+"/ "+
				"용량: "+list.get(0).getMem()+"/ "+
				"분류: "+list.get(0).getKind()+"/ "+
				"메모리 타입: "+list.get(0).getType()+"";
		
		
		request.setAttribute("product_item_val", productids);
		request.setAttribute("product_item_name", name);	
		request.setAttribute("product_item_price", price);
		request.setAttribute("product_item_company", company);
		request.setAttribute("product_item_cnt", cnt);
		request.setAttribute("product_item_object", object);
		}
		
		
		
		if (productid.equals("power")) {
			
		String producttable = "power_t";
		productid = "p_model";
		int join = dao.selectItemSeq(productname, productid);
		System.out.println(join);
		ArrayList<DTO_power> list = new ArrayList<DTO_power>();
		list = dao.selectItem(join, producttable, productid);
		
		String name = list.get(0).getModel();
		int price = list.get(0).getPrice();
		String company = list.get(0).getCompany();
		int cnt = list.get(0).getCnt();
		
		String object = "제조사: "+list.get(0).getCompany()+"/ "+
				"폼펙터: "+list.get(0).getForm()+"/ "+			
				"정격출력: "+list.get(0).getOutput()+"/ "+
				"인증: "+list.get(0).getAuthen()+"/ "+
				"보증기간: "+list.get(0).getGurantee()+"";
		
	
		request.setAttribute("product_item_val", productids);
		request.setAttribute("product_item_name", name);	
		request.setAttribute("product_item_price", price);
		request.setAttribute("product_item_company", company);
		request.setAttribute("product_item_cnt", cnt);
		request.setAttribute("product_item_object", object);
		}
		
		
		
		if (productid.equals("case")) {
			
		String producttable = "case_t";
		productid = "ca_model";
		int join = dao.selectItemSeq(productname, productid);
		System.out.println(join);
		ArrayList<DTO_case> list = new ArrayList<DTO_case>();
		list = dao.selectItem(join, producttable, productid);
		
		String name = list.get(0).getModel();
		int price = list.get(0).getPrice();
		String company = list.get(0).getCompany();
		int cnt = list.get(0).getCnt();
		
		String object = "제조사: "+list.get(0).getCompany()+"/ "+
				"케이스 크기: "+list.get(0).getSized()+"/ "+			
				"폼팩터: "+list.get(0).getMax()+"/ "+
				"쿨링팬 제공: "+list.get(0).getPane_cnt()+"";
		
		request.setAttribute("product_item_val", productids);
		request.setAttribute("product_item_name", name);	
		request.setAttribute("product_item_price", price);
		request.setAttribute("product_item_company", company);
		request.setAttribute("product_item_cnt", cnt);
		request.setAttribute("product_item_object", object);
		}
		
		
		
		if (productid.equals("mouse")) {
			
		String producttable = "mouse_t";
		productid = "ms_model";
		int join = dao.selectItemSeq(productname, productid);
		System.out.println(join);
		ArrayList<DTO_mouse> list = new ArrayList<DTO_mouse>();
		list = dao.selectItem(join, producttable, productid);
		
		String name = list.get(0).getModel();
		int price = list.get(0).getPrice();
		String company = list.get(0).getCompany();
		int cnt = list.get(0).getCnt();
		
		String object = "제조사: "+list.get(0).getCompany()+"/ "+
				"연결 방식: "+list.get(0).getConn()+"/ "+			
				"감도: "+list.get(0).getFeel()+"/ "+
				"센서: "+list.get(0).getSensor()+"/ "+
				"컬러: "+list.get(0).getColor()+"";
		
		request.setAttribute("product_item_val", productids);
		request.setAttribute("product_item_name", name);	
		request.setAttribute("product_item_price", price);
		request.setAttribute("product_item_company", company);
		request.setAttribute("product_item_cnt", cnt);
		request.setAttribute("product_item_object", object);
		}
		
		
		
		if (productid.equals("keyboard")) {
			
		String producttable = "keyboard_t";
		productid = "k_model";
		int join = dao.selectItemSeq(productname, productid);
		System.out.println(join);
		ArrayList<DTO_keyboard> list = new ArrayList<DTO_keyboard>();
		list = dao.selectItem(join, producttable, productid);
		
		String name = list.get(0).getModel();
		int price = list.get(0).getPrice();
		String company = list.get(0).getCompany();
		int cnt = list.get(0).getCnt();
		
		String object = "제조사: "+list.get(0).getCompany()+"/ "+
				"연결 방식: "+list.get(0).getConn()+"/ "+			
				"접점 방식: "+list.get(0).getSelect_s()+"/ "+
				"스위치 회사: "+list.get(0).getS_company()+"/ "+
				"스위치: "+list.get(0).getK_switch()+"/ "+
				"키 배열: "+list.get(0).getArray()+"/ "+
				"색깔: "+list.get(0).getColor()+"";

		request.setAttribute("product_item_val", productids);
		request.setAttribute("product_item_name", name);	
		request.setAttribute("product_item_price", price);
		request.setAttribute("product_item_company", company);
		request.setAttribute("product_item_cnt", cnt);
		request.setAttribute("product_item_object", object);
		}
		
		
		
		if (productid.equals("cooler")) {
			
		String producttable = "cooler_t";
		productid = "cl_model";
		int join = dao.selectItemSeq(productname, productid);
		System.out.println(join);
		ArrayList<DTO_cooler> list = new ArrayList<DTO_cooler>();
		list = dao.selectItem(join, producttable, productid);
		
		String name = list.get(0).getModel();
		int price = list.get(0).getPrice();
		String company = list.get(0).getCompany();
		int cnt = list.get(0).getCnt();
		
		String object = "제조사: "+list.get(0).getCompany()+"/ "+
				"냉각 방식: "+list.get(0).getForm()+"/ "+			
				"팬 크기: "+list.get(0).getFan_size()+"/ "+
				"히트 파이프: "+list.get(0).getHitcnt()+"/ "+
				"TDP: "+list.get(0).getTdp()+"/ "+
				"라디에이터 길이: "+list.get(0).getRadi_length()+"/ "+
				"쿨러 형태: "+list.get(0).getForm()+"/ "+
				"소켓: "+list.get(0).getSocket()+"/ "+
				"소음: "+list.get(0).getNoise()+"";
		

		request.setAttribute("product_item_val", productids);
		request.setAttribute("product_item_name", name);	
		request.setAttribute("product_item_price", price);
		request.setAttribute("product_item_company", company);
		request.setAttribute("product_item_cnt", cnt);
		request.setAttribute("product_item_object", object);
		}
		
		
		
		if (productid.equals("monitor")) {
			
		String producttable = "monitor_t";
		productid = "mon_model";
		int join = dao.selectItemSeq(productname, productid);
		System.out.println(join);
		ArrayList<DTO_monitor> list = new ArrayList<DTO_monitor>();
		list = dao.selectItem(join, producttable, productid);
		
		String name = list.get(0).getModel();
		int price = list.get(0).getPrice();
		String company = list.get(0).getCompany();
		int cnt = list.get(0).getCnt();
		
		String object ="제조사: "+list.get(0).getCompany()+"/ "+
				"화면 크기: "+list.get(0).getInchi()+"/ "+			
				"해상도: "+list.get(0).getHae()+"/ "+
				"화면 비율: "+list.get(0).getRate()+"/ "+
				"주사율: "+list.get(0).getHz()+"/ "+
				"패널 형태: "+list.get(0).getForm()+"/"+
				"무게: "+list.get(0).getWeight()+"/ "+
				"블루라이트: "+list.get(0).isBlue()+"/ "+
				"패널: "+list.get(0).getPanel()+"/ "+
				"색 재현율: "+list.get(0).getColor()+"";
		
		System.out.println(list.get(0).getModel());
		request.setAttribute("product_item_val", productids);
		request.setAttribute("product_item_name", name);	
		request.setAttribute("product_item_price", price);
		request.setAttribute("product_item_company", company);
		request.setAttribute("product_item_cnt", cnt);
		request.setAttribute("product_item_object", object);
		}
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/ProductPage.jsp");
		dispatcher.forward(request, response);
		
	}

}
