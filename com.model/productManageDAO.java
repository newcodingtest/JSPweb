package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBManager;

public class productManageDAO {
	
	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	DBManager db = new DBManager();
	
	
	public void Connection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String dbid = "cowsys";
			String dbpw = "cowsys";
			String dburl = "jdbc:oracle:thin:@www.smhrd.net:1521:xe";
					
		
		conn = DriverManager.getConnection(dburl, dbid, dbpw);
	}catch(Exception e) {
		e.printStackTrace();

	}

	}

	//select  수행한 후 리소스 해제를 위한
	public void close() {
		try { 
			if(rs!=null) {
				rs.close();
			}
			if(psmt!=null) { 
		// DB닫기
		psmt.close();
			}if(conn!=null) {
				conn.close();
			}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}
	
	public ArrayList SelectProductList() {
		categoryDTO info = null;
		ArrayList<categoryDTO> list = new ArrayList<categoryDTO>();
		try {
			Connection();

			String sql = "select* from list_t";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String c_model = rs.getString("c_model");
				String m_model = rs.getString("m_model");
				String g_model = rs.getString("g_model");
				String me_model = rs.getString("me_model");
				String d_model = rs.getString("d_model");
				String p_model = rs.getString("p_model");
				String ca_model = rs.getString("ca_model");
				String ms_model = rs.getString("ms_model");
				String k_model = rs.getString("k_model");
				String cl_model = rs.getString("cl_model");
				String mon_model = rs.getNString("mon_model");
				
				
				info = new categoryDTO(seq, c_model, m_model, g_model, me_model, d_model, p_model, ca_model, ms_model, k_model, cl_model, mon_model);
				list.add(info);
				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {close();}
		
		return list;
	}
	
	public ArrayList getCnt(ArrayList ProductCount) {
		System.out.println("법규"+ProductCount.get(1));
		String product= null;
		String product_b= null;
		ArrayList list = new ArrayList<>();
		int cnt=0;
		
		try {
			
			for(int i=0; i<ProductCount.size(); i++) {
				Connection();
				
			if(ProductCount.get(0).equals("1")) {product = "cpu_t"; product_b = "c_model"; }
			else if(ProductCount.get(0).equals("2")) {product = "mainboard_t"; product_b = "m_model"; }
			else if(ProductCount.get(0).equals("3")) {product = "gpu_t"; product_b = "g_model";  }
			else if(ProductCount.get(0).equals("4")) {product = "memory_t"; product_b = "me_model"; }
			else if(ProductCount.get(0).equals("5")) {product = "device_t"; product_b = "d_model"; }
			else if(ProductCount.get(0).equals("6")) {product = "power_t"; product_b = "p_model"; }
			else if(ProductCount.get(0).equals("7")) {product = "case_t"; product_b = "ca_model"; }
			else if(ProductCount.get(0).equals("8")) {product = "mouse_t"; product_b = "ms_model"; }
			else if(ProductCount.get(0).equals("9")) {product = "keyboard_t"; product_b = "k_model"; }
			else if(ProductCount.get(0).equals("10")) {product = "cooler_t"; product_b = "cl_model"; }
			else if(ProductCount.get(0).equals("11")) {product = "monitor_t"; product_b = "mon_model"; }
			
			
				
			String sql = "select "+product+".cnt from "+product+", list_t where "+product+".model=list_t."+product_b+" and model="+"'"+ProductCount.get(1)+"'";
			
			//select cpu_t.cnt from cpu_t, list_t where cpu_t.model=list_t.c_model and model='i9-10900k'
			System.out.println(sql);
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				cnt = rs.getInt("cnt");
				list.add(cnt);
			}
			ProductCount.remove(0);
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {close();}
		
		return list;
	}
	
}
