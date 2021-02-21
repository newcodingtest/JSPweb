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
	
		response.setCharacterEncoding("utf-8"); // �ѱ� ó��
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String page = request.getParameter("page");
		System.out.println("��� ������"+page);
		String product = request.getParameter("product"); //�����  Ŭ���ϸ� �޾����� ���ε�, ó���� ���������� ������ư ������ CPU���� �ڵ����� ���
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
			if( !first.equals("null") && product != null) { // ����� null �� ó�� first�� ���� null�̰�, �ϴ��� �޺��ڽ� null����
			search.add(request.getParameter("detail_1")); // "cpu" ������ �ø�[�÷���]
			search.add((String)first); //String ����  �����Ͱ� ���� [��]
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
				production_context.add("Ĩ�� ������: "+list.get(i).getCompany()+"/ "+
						"��Ű��ó: "+list.get(i).getAc()+"/ "+
						"�ھ� ��: "+list.get(i).getCore()+"/ "+
						"������ ��: "+list.get(i).getThread()+"/ "+
						"�� ��: "+list.get(i).getModel()+"/ "+
						"Ŭ��: "+list.get(i).getClock()+"/ "+
						"�ν�Ʈ Ŭ��: "+list.get(i).getClock_b()+"/ "+
						"����: "+list.get(i).getMp());
			}

			
		}
			if (product.equals("mother")) {
			ArrayList<DTO_mother> list= new ArrayList<DTO_mother>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("Ĩ�� ������: "+list.get(i).getCompany()+"/ "+
						"������: "+list.get(i).getForm()+"/ "+
						"Ĩ�� ������: "+list.get(i).getC_company()+"/ "+
						"Ĩ�� ��: "+list.get(i).getChipset()+"/ "+
						"�� ��: "+list.get(i).getModel()+"/ "+
						"����: "+list.get(i).getSocket());
			}

			
		}	
			if (product.equals("memory")) {
			ArrayList<DTO_memory> list= new ArrayList<DTO_memory>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("Ĩ�� ������: "+list.get(i).getCompany()+"/ "+
						"�޸� Ÿ��: "+list.get(i).getType()+"/ "+
						"�޸� �뷮: "+list.get(i).getMem()+"/ "+
						"�޸� Ŭ��: "+list.get(i).getClock()+"/ "+
						"�� ��: "+list.get(i).getModel());
			}

			
		}
			
			if (product.equals("gpu")) {
			ArrayList<DTO_vga> list= new ArrayList<DTO_vga>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("Ĩ�� ������: "+list.get(i).getChip_com()+"/ "+
						"Ĩ�¸�: "+list.get(i).getChipname()+"/ "+			
						"������: "+list.get(i).getCompany()+"/ "+
						"�޸𸮿뷮: "+list.get(i).getMem()+"/ "+
						"�ν�Ʈ Ŭ��: "+list.get(i).getClock_b()+"/ "+
						"����: "+list.get(i).getLength());
			}

			
		}
			if (product.equals("power")) {
			ArrayList<DTO_power> list= new ArrayList<DTO_power>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("������: "+list.get(i).getCompany()+"/ "+
						"������: "+list.get(i).getForm()+"/ "+			
						"�������: "+list.get(i).getOutput()+"/ "+
						"����: "+list.get(i).getAuthen()+"/ "+
						"�����Ⱓ: "+list.get(i).getGurantee());
			}

			
		}
			if (product.equals("device")) {
			ArrayList<DTO_storage> list= new ArrayList<DTO_storage>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("������: "+list.get(i).getCompany()+"/ "+
						"������: "+list.get(i).getForm()+"/ "+			
						"�������̽�: "+list.get(i).getInterfaced()+"/ "+
						"�뷮: "+list.get(i).getMem()+"/ "+
						"�з�: "+list.get(i).getKind()+"/ "+
						"�޸� Ÿ��: "+list.get(i).getType());
			}

			
		}
			if (product.equals("cooler")) {
			ArrayList<DTO_cooler> list= new ArrayList<DTO_cooler>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("������: "+list.get(i).getCompany()+"/ "+
						"�ð� ���: "+list.get(i).getForm()+"/ "+			
						"�� ũ��: "+list.get(i).getFan_size()+"/ "+
						"��Ʈ ������: "+list.get(i).getHitcnt()+"/ "+
						"TDP: "+list.get(i).getTdp()+"/ "+
						"������� ����: "+list.get(i).getRadi_length()+"/ "+
						"�� ����: "+list.get(i).getForm()+"/ "+
						"����: "+list.get(i).getSocket()+"/ "+
						"����: "+list.get(i).getNoise());
			}

			
		}
			if (product.equals("case")) {
			ArrayList<DTO_case> list= new ArrayList<DTO_case>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("������: "+list.get(i).getCompany()+"/ "+
						"���̽� ũ��: "+list.get(i).getSized()+"/ "+			
						"������: "+list.get(i).getMax()+"/ "+
						"���� ����: "+list.get(i).getPane_cnt());
			}

			
		}
			if (product.equals("keyboard")) {
			ArrayList<DTO_keyboard> list= new ArrayList<DTO_keyboard>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("������: "+list.get(i).getCompany()+"/ "+
						"���� ���: "+list.get(i).getConn()+"/ "+			
						"���� ���: "+list.get(i).getSelect_s()+"/ "+
						"����ġ ȸ��: "+list.get(i).getS_company()+"/ "+
						"����ġ: "+list.get(i).getK_switch()+"/ "+
						"Ű �迭: "+list.get(i).getArray()+"/ "+
						"����: "+list.get(i).getColor());
			}

			
		}
			if (product.equals("mouse")) {
			ArrayList<DTO_mouse> list= new ArrayList<DTO_mouse>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("������: "+list.get(i).getCompany()+"/ "+
						"���� ���: "+list.get(i).getConn()+"/ "+			
						"����: "+list.get(i).getFeel()+"/ "+
						"����: "+list.get(i).getSensor()+"/ "+
						"�÷�: "+list.get(i).getColor());
			}

			
		}
			if (product.equals("monitor")) {
			ArrayList<DTO_monitor> list= new ArrayList<DTO_monitor>();
			list = dao.SelectCategoryQuery(search, product, productObject, count);
			
			for(int i =0; i<list.size(); i++) {
				production_model.add(list.get(i).getModel());
				production_price.add(list.get(i).getPrice());
				production_context.add("������: "+list.get(i).getCompany()+"/ "+
						"ȭ�� ũ��: "+list.get(i).getInchi()+"/ "+			
						"�ػ�: "+list.get(i).getHae()+"/ "+
						"ȭ�� ����: "+list.get(i).getRate()+"/ "+
						"�ֻ���: "+list.get(i).getHz()+"/ "+
						"�г� ����: "+list.get(i).getForm()+"/"+
						"����: "+list.get(i).getWeight()+"/ "+
						"������Ʈ: "+list.get(i).isBlue()+"/ "+
						"�г�: "+list.get(i).getPanel()+"/ "+
						"�� ������: "+list.get(i).getColor());
			}

			
		}
		}
		/////////////////////////�Ʒ��� �븻 ���� ////////////////////////////
		
		if(product.equals("cpu") & sw == false) {
			
			ArrayList<DTO_cpu> list= new ArrayList<DTO_cpu>(); // �̰Ŷ� �� �Ʒ� set Attribute�� �۵�
			categoryDAO dao = new categoryDAO(); // �̰͵� �۵� X
			list = dao.SelectCategory(product); // ������ ���� ������ �̰� �۵� �Ƚ��Ѿ��� 
			request.setAttribute("product_list", list);
			
			//�������� ǥ���� ��Ҹ� �̸� �ε�

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("Ĩ�� ������: "+list.get(i).getCompany()+"/ "+
					"��Ű��ó: "+list.get(i).getAc()+"/ "+
					"�ھ� ��: "+list.get(i).getCore()+"/ "+
					"������ ��: "+list.get(i).getThread()+"/ "+
					"�� ��: "+list.get(i).getModel()+"/ "+
					"Ŭ��: "+list.get(i).getClock()+"/ "+
					"�ν�Ʈ Ŭ��: "+list.get(i).getClock_b()+"/ "+
					"����: "+list.get(i).getMp());
			

			
			}
	
		}
		if(product.equals("mother") & sw == false) {
			
			ArrayList<DTO_mother> list= new ArrayList<DTO_mother>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//�������� ǥ���� ��Ҹ� �̸� �ε�

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("Ĩ�� ������: "+list.get(i).getCompany()+"/ "+
					"������: "+list.get(i).getForm()+"/ "+
					"Ĩ�� ������: "+list.get(i).getC_company()+"/ "+
					"Ĩ�� ��: "+list.get(i).getChipset()+"/ "+
					"�� ��: "+list.get(i).getModel()+"/ "+
					"����: "+list.get(i).getSocket());

			
			}
			
			
		}
		if(product.equals("memory") & sw == false) {
			
			ArrayList<DTO_memory> list= new ArrayList<DTO_memory>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//�������� ǥ���� ��Ҹ� �̸� �ε�

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("Ĩ�� ������: "+list.get(i).getCompany()+"/ "+
					"�޸� Ÿ��: "+list.get(i).getType()+"/ "+
					"�޸� �뷮: "+list.get(i).getMem()+"/ "+
					"�޸� Ŭ��: "+list.get(i).getClock()+"/ "+
					"�� ��: "+list.get(i).getModel());

			
			}
			
			
		}
		if(product.equals("gpu") & sw == false) {
			
			ArrayList<DTO_vga> list= new ArrayList<DTO_vga>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//�������� ǥ���� ��Ҹ� �̸� �ε�

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("Ĩ�� ������: "+list.get(i).getChip_com()+"/ "+
					"Ĩ�¸�: "+list.get(i).getChipname()+"/ "+			
					"������: "+list.get(i).getCompany()+"/ "+
					"�޸𸮿뷮: "+list.get(i).getMem()+"/ "+
					"�ν�Ʈ Ŭ��: "+list.get(i).getClock_b()+"/ "+
					"����: "+list.get(i).getLength());

			
			}
			
			
		}
		if(product.equals("power") & sw == false) {
			
			ArrayList<DTO_power> list= new ArrayList<DTO_power>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//�������� ǥ���� ��Ҹ� �̸� �ε�

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("������: "+list.get(i).getCompany()+"/ "+
					"������: "+list.get(i).getForm()+"/ "+			
					"�������: "+list.get(i).getOutput()+"/ "+
					"����: "+list.get(i).getAuthen()+"/ "+
					"�����Ⱓ: "+list.get(i).getGurantee());

			
			}
			
			
		}
		if(product.equals("device") & sw == false) {
			
			ArrayList<DTO_storage> list= new ArrayList<DTO_storage>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//�������� ǥ���� ��Ҹ� �̸� �ε�

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("������: "+list.get(i).getCompany()+"/ "+
					"������: "+list.get(i).getForm()+"/ "+			
					"�������̽�: "+list.get(i).getInterfaced()+"/ "+
					"�뷮: "+list.get(i).getMem()+"/ "+
					"�з�: "+list.get(i).getKind()+"/ "+
					"�޸� Ÿ��: "+list.get(i).getType());

			
			}
			
			
		}
		if(product.equals("cooler") & sw == false) {
			
			ArrayList<DTO_cooler> list= new ArrayList<DTO_cooler>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//�������� ǥ���� ��Ҹ� �̸� �ε�

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("������: "+list.get(i).getCompany()+"/ "+
					"�ð� ���: "+list.get(i).getForm()+"/ "+			
					"�� ũ��: "+list.get(i).getFan_size()+"/ "+
					"��Ʈ ������: "+list.get(i).getHitcnt()+"/ "+
					"TDP: "+list.get(i).getTdp()+"/ "+
					"������� ����: "+list.get(i).getRadi_length()+"/ "+
					"�� ����: "+list.get(i).getForm()+"/ "+
					"����: "+list.get(i).getSocket()+"/ "+
					"����: "+list.get(i).getNoise());

			
			}
			
			
		}
		if(product.equals("case") & sw == false) {
			
			ArrayList<DTO_case> list= new ArrayList<DTO_case>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//�������� ǥ���� ��Ҹ� �̸� �ε�

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("������: "+list.get(i).getCompany()+"/ "+
					"���̽� ũ��: "+list.get(i).getSized()+"/ "+			
					"������: "+list.get(i).getMax()+"/ "+
					"���� ����: "+list.get(i).getPane_cnt());

			
			}
			
			
		}
		if(product.equals("keyboard") & sw == false) {
			
			ArrayList<DTO_keyboard> list= new ArrayList<DTO_keyboard>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//�������� ǥ���� ��Ҹ� �̸� �ε�

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("������: "+list.get(i).getCompany()+"/ "+
					"���� ���: "+list.get(i).getConn()+"/ "+			
					"���� ���: "+list.get(i).getSelect_s()+"/ "+
					"����ġ ȸ��: "+list.get(i).getS_company()+"/ "+
					"����ġ: "+list.get(i).getK_switch()+"/ "+
					"Ű �迭: "+list.get(i).getArray()+"/ "+
					"����: "+list.get(i).getColor());

			
			}
			
			
		}
		if(product.equals("mouse") & sw == false) {
			
			ArrayList<DTO_mouse> list= new ArrayList<DTO_mouse>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//�������� ǥ���� ��Ҹ� �̸� �ε�

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("������: "+list.get(i).getCompany()+"/ "+
					"���� ���: "+list.get(i).getConn()+"/ "+			
					"����: "+list.get(i).getFeel()+"/ "+
					"����: "+list.get(i).getSensor()+"/ "+
					"�÷�: "+list.get(i).getColor());

			
			}
			
			
		}
		if(product.equals("monitor") & sw == false) {
			
			ArrayList<DTO_monitor> list= new ArrayList<DTO_monitor>();
			categoryDAO dao = new categoryDAO();
			list = dao.SelectCategory(product);
			request.setAttribute("product_list", list);
			
			//�������� ǥ���� ��Ҹ� �̸� �ε�

			for(int i =0; i<list.size(); i++) {
			production_model.add(list.get(i).getModel());
			production_price.add(list.get(i).getPrice());
			production_context.add("������: "+list.get(i).getCompany()+"/ "+
					"ȭ�� ũ��: "+list.get(i).getInchi()+"/ "+			
					"�ػ�: "+list.get(i).getHae()+"/ "+
					"ȭ�� ����: "+list.get(i).getRate()+"/ "+
					"�ֻ���: "+list.get(i).getHz()+"/ "+
					"�г� ����: "+list.get(i).getForm()+"/ "+
					"����: "+list.get(i).getWeight()+"/ "+
					"������Ʈ: "+list.get(i).isBlue()+"/ "+
					"�г�: "+list.get(i).getPanel()+"/ "+
					"�� ������: "+list.get(i).getColor());

			
			}
			
			
		}
		
		
		request.setAttribute("model", production_model);
		request.setAttribute("price", production_price);
		request.setAttribute("context", production_context);
		request.setAttribute("product", product);
		// ������ ä�� �������� �Ѱ���
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
