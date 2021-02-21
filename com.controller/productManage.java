package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.categoryDTO;
import com.model.productDAO;
import com.model.productManageDAO;


@WebServlet("/productManage")
public class productManage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int count;
		
		
		productManageDAO dao = new productManageDAO();
		ArrayList<categoryDTO> list = new ArrayList<categoryDTO>();
		ArrayList ProductList = new ArrayList<>();
		ArrayList cntList = new ArrayList<>();
		ArrayList ProductList_Back = new ArrayList<>();
		list = dao.SelectProductList();
		
		for (int i =0; i<list.size(); i++ ) {
			
			if(list.get(i).getC_model() != null) {
				ProductList.add("1");
				ProductList.add(list.get(i).getC_model());  // (1, 
				ProductList_Back.add(list.get(i).getC_model());
			}
			if(list.get(i).getM_model() != null) {
				ProductList.add("2");
				ProductList.add(list.get(i).getM_model());
				ProductList_Back.add(list.get(i).getM_model());
			}
			if(list.get(i).getG_model() != null) {
				ProductList.add("3");
				ProductList.add(list.get(i).getG_model());
				ProductList_Back.add(list.get(i).getG_model());
			}
			if(list.get(i).getMe_model() != null) {
				ProductList.add("4");
				ProductList.add(list.get(i).getMe_model());
				ProductList_Back.add(list.get(i).getMe_model());
			}
			if(list.get(i).getD_model() != null) {
				ProductList.add("5");
				ProductList.add(list.get(i).getD_model());
				ProductList_Back.add(list.get(i).getD_model());
			}
			if(list.get(i).getP_model() != null) {
				ProductList.add("6");
				ProductList.add(list.get(i).getP_model());
				ProductList_Back.add(list.get(i).getP_model());
			}
			if(list.get(i).getCa_model() != null) {
				ProductList.add("7");
				ProductList.add(list.get(i).getCa_model());
				ProductList_Back.add(list.get(i).getCa_model());
			}
			if(list.get(i).getMs_model() != null) {
				ProductList.add("8");
				ProductList.add(list.get(i).getMs_model());
				ProductList_Back.add(list.get(i).getMs_model());
			}
			if(list.get(i).getK_model() != null) {
				ProductList.add("9");
				ProductList.add(list.get(i).getK_model());
				ProductList_Back.add(list.get(i).getK_model());
			}
			if(list.get(i).getCl_model() != null) {
				ProductList.add("10");
				ProductList.add(list.get(i).getCl_model());
				ProductList_Back.add(list.get(i).getCl_model());
			}
			if(list.get(i).getMon_model() != null) {
				ProductList.add("11");
				ProductList.add(list.get(i).getMon_model());
				ProductList_Back.add(list.get(i).getMon_model());
			}
					
			}
		System.out.println(ProductList.size());
		cntList = dao.getCnt(ProductList);
		int getNum = ProductList.size();
		for(int i =0; i<ProductList.size(); i++) {
			
			System.out.println(ProductList_Back.get(i)+" "+" "+cntList.get(i)+"개");
		}
		
		/*for(int i=0; i<ProductList.size(); i++) {
			
			if(ProductList.get(i).equals("1")) {
			ProductList.remove(0);
			cntList.add(dao.getCnt("cpu_t", (String)ProductList.get(i)));
			//System.out.println(i+""+ ProductList.get(i));
			}
			if(ProductList.get(i).equals("2")) {
			ProductList.remove(0);
			cntList.add(dao.getCnt("mainboard_t", (String)ProductList.get(i)));
			//System.out.println(i+""+ ProductList.get(i));
			}
			if(ProductList.get(i).equals("3")) {
			ProductList.remove(0);
			cntList.add(dao.getCnt("gpu_t", (String)ProductList.get(i)));
			//System.out.println(i+""+ ProductList.get(i));
			}
			if(ProductList.get(i).equals("4")) {
			ProductList.remove(0);
			cntList.add(dao.getCnt("memory_t", (String)ProductList.get(i)));
			//System.out.println(i+""+ ProductList.get(i));
			}
			if(ProductList.get(i).equals("5")) {
			ProductList.remove(0);
			cntList.add(dao.getCnt("device_t", (String)ProductList.get(i)));
			//System.out.println(i+""+ ProductList.get(i));
			}
			if(ProductList.get(i).equals("6")) {
			ProductList.remove(0);
			cntList.add(dao.getCnt("power_t", (String)ProductList.get(i)));
			//System.out.println(i+""+ ProductList.get(i));
			}
			if(ProductList.get(i).equals("7")) {
			ProductList.remove(0);
			cntList.add(dao.getCnt("case_t", (String)ProductList.get(i)));
			//System.out.println(i+""+ ProductList.get(i));
			}
			if(ProductList.get(i).equals("8")) {
			ProductList.remove(0);
			cntList.add(dao.getCnt("mouse_t", (String)ProductList.get(i)));
			//System.out.println(i+""+ ProductList.get(i));
			}
			if(ProductList.get(i).equals("9")) {
			ProductList.remove(0);
			cntList.add(dao.getCnt("keyboard_t", (String)ProductList.get(i)));
			//System.out.println(i+""+ ProductList.get(i));
			}
			if(ProductList.get(i).equals("10")) {
			ProductList.remove(0);
			cntList.add(dao.getCnt("cooler_t", (String)ProductList.get(i)));
			//System.out.println(i+""+ ProductList.get(i));
			}
			if(ProductList.get(i).equals("11")) {
			ProductList.remove(0);
			cntList.add(dao.getCnt("monitor_t", (String)ProductList.get(i)));
			
			}
			//System.out.println(ProductList.get(i)+"의 재고는"+cntList.get(i)+"개 입니다.");
	}*/

}
}
