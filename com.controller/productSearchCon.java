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
		
		response.setCharacterEncoding("utf-8"); // �ѱ� ó��
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String productname = request.getParameter("productname");
		String productid = request.getParameter("productid");
		String productids = request.getParameter("productid");
		System.out.println("����ǰ: "+productname);
		System.out.println("������: "+productid);
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
		
		String object = "��Ű��ó: "+ list.get(0).getAc()+
				", Ŭ��: "+list.get(0).getClock()+
				", �ν�ƮŬ��:"+list.get(0).getClock_b()+
				", �ھ� ��: "+list.get(0).getCore()+
				", ������ ��: "+list.get(0).getThread()+
				", ����: "+list.get(0).getSocket()+
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
		
		String object = "Ĩ�� ������: "+list.get(0).getCompany()+"/ "+
				"������: "+list.get(0).getForm()+"/ "+
				"Ĩ�� ������: "+list.get(0).getC_company()+"/ "+
				"Ĩ�� ��: "+list.get(0).getChipset()+"/ "+
				"�� ��: "+list.get(0).getModel()+"/ "+
				"����: "+list.get(0).getSocket()+"";
		
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
		
		String object = "Ĩ�� ������: "+list.get(0).getChip_com()+"/ "+
				"Ĩ�¸�: "+list.get(0).getChipname()+"/ "+			
				"������: "+list.get(0).getCompany()+"/ "+
				"�޸𸮿뷮: "+list.get(0).getMem()+"/ "+
				"�ν�Ʈ Ŭ��: "+list.get(0).getClock_b()+"/ "+
				"����: "+list.get(0).getLength()+"";
		
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
		
		String object = "Ĩ�� ������: "+list.get(0).getCompany()+"/ "+
				"�޸� Ÿ��: "+list.get(0).getType()+"/ "+
				"�޸� �뷮: "+list.get(0).getMem()+"/ "+
				"�޸� Ŭ��: "+list.get(0).getClock()+"/ "+
				"�� ��: "+list.get(0).getModel()+"";
		
		
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
		
		String object = "������: "+list.get(0).getCompany()+"/ "+
				"������: "+list.get(0).getForm()+"/ "+			
				"�������̽�: "+list.get(0).getInterfaced()+"/ "+
				"�뷮: "+list.get(0).getMem()+"/ "+
				"�з�: "+list.get(0).getKind()+"/ "+
				"�޸� Ÿ��: "+list.get(0).getType()+"";
		
		
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
		
		String object = "������: "+list.get(0).getCompany()+"/ "+
				"������: "+list.get(0).getForm()+"/ "+			
				"�������: "+list.get(0).getOutput()+"/ "+
				"����: "+list.get(0).getAuthen()+"/ "+
				"�����Ⱓ: "+list.get(0).getGurantee()+"";
		
	
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
		
		String object = "������: "+list.get(0).getCompany()+"/ "+
				"���̽� ũ��: "+list.get(0).getSized()+"/ "+			
				"������: "+list.get(0).getMax()+"/ "+
				"���� ����: "+list.get(0).getPane_cnt()+"";
		
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
		
		String object = "������: "+list.get(0).getCompany()+"/ "+
				"���� ���: "+list.get(0).getConn()+"/ "+			
				"����: "+list.get(0).getFeel()+"/ "+
				"����: "+list.get(0).getSensor()+"/ "+
				"�÷�: "+list.get(0).getColor()+"";
		
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
		
		String object = "������: "+list.get(0).getCompany()+"/ "+
				"���� ���: "+list.get(0).getConn()+"/ "+			
				"���� ���: "+list.get(0).getSelect_s()+"/ "+
				"����ġ ȸ��: "+list.get(0).getS_company()+"/ "+
				"����ġ: "+list.get(0).getK_switch()+"/ "+
				"Ű �迭: "+list.get(0).getArray()+"/ "+
				"����: "+list.get(0).getColor()+"";

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
		
		String object = "������: "+list.get(0).getCompany()+"/ "+
				"�ð� ���: "+list.get(0).getForm()+"/ "+			
				"�� ũ��: "+list.get(0).getFan_size()+"/ "+
				"��Ʈ ������: "+list.get(0).getHitcnt()+"/ "+
				"TDP: "+list.get(0).getTdp()+"/ "+
				"������� ����: "+list.get(0).getRadi_length()+"/ "+
				"�� ����: "+list.get(0).getForm()+"/ "+
				"����: "+list.get(0).getSocket()+"/ "+
				"����: "+list.get(0).getNoise()+"";
		

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
		
		String object ="������: "+list.get(0).getCompany()+"/ "+
				"ȭ�� ũ��: "+list.get(0).getInchi()+"/ "+			
				"�ػ�: "+list.get(0).getHae()+"/ "+
				"ȭ�� ����: "+list.get(0).getRate()+"/ "+
				"�ֻ���: "+list.get(0).getHz()+"/ "+
				"�г� ����: "+list.get(0).getForm()+"/"+
				"����: "+list.get(0).getWeight()+"/ "+
				"������Ʈ: "+list.get(0).isBlue()+"/ "+
				"�г�: "+list.get(0).getPanel()+"/ "+
				"�� ������: "+list.get(0).getColor()+"";
		
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
