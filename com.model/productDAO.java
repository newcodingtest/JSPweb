package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBManager;

public class productDAO {

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



public int selectItemSeq(String productname, String productid) {
	int seq = 0;
	try {
		
		Connection();

		String sql = "select seq from list_t where "+productid+"="+"'"+productname+"'";
		System.out.println("sql문장:"+sql);

		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		if(rs.next()) {
		seq = rs.getInt("seq");
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close();
	}
	
return seq;	
}


public ArrayList selectItem(int join, String producttable, String productid) {

	try {
		
		Connection();

		String sql = "select "+producttable+".* from list_t,"+producttable+ " where list_t."+productid+"= "+producttable+".model and list_t.seq = "+join;
		System.out.println(sql);
		// select cpu_t.* from list_t, cpu_t where list_t.c_model = cpu_t.model and list_t.seq = 3; 
		// list_t는 고정값, 필요한 것은 cpu_t, seq=join, list_t의 컬럼 3개
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		
		if(producttable.equals("cpu_t")) {
			
			DTO_cpu info = null;
			ArrayList<DTO_cpu> list = new ArrayList<DTO_cpu>();
			if(rs.next()) {
				String model = rs.getString("model");
				String company = rs.getString("company");
				String socket = rs.getString("socket");
				String ac = rs.getString("ac");
				int core = rs.getInt("core");
				int thread = rs.getInt("thread");
				String clock = rs.getString("clock");
				String clock_b = rs.getString("clock_b");
				String tdp = rs.getString("tdp");
				String mp = rs.getString("mp");
				String vga = rs.getString("vga");
				String lineup = rs.getString("lineup");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");
				info = new DTO_cpu(model, company, socket, ac, core, thread, clock, clock_b, tdp, mp, vga, lineup, price, cnt);
				list.add(info);
			}
			
			return list;
		}
		
		if(producttable.equals("mainboard_t")) {
			
			DTO_mother info = null;
			ArrayList<DTO_mother> list = new ArrayList<DTO_mother>();
			if(rs.next()) {
				String model = rs.getString("model");
				String company = rs.getString("company");
				String socket = rs.getString("socket");
				String chipset = rs.getString("chipset");
				String form = rs.getString("form");
				String type = rs.getString("type");
				String lineup = rs.getString("lineup");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");
				String c_company = rs.getString("c_company");
				info = new DTO_mother(model, company, socket, chipset, form, type, lineup, price, cnt, c_company);
				list.add(info);
			}
			
			return list;
		}
		if(producttable.equals("gpu_t")) {
			
			DTO_vga info = null;
			ArrayList<DTO_vga> list = new ArrayList<DTO_vga>();
			if(rs.next()) {
				String model = rs.getString("model");
				String company = rs.getString("company");
				String chipname = rs.getString("chipname");
				String mem = rs.getString("mem");
				String clock = rs.getString("clock");
				String clock_b = rs.getString("clock_b");
				String length = rs.getString("length");
				String chip_com = rs.getString("chip_com");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");
				
				info = new DTO_vga(model, company, chipname, mem, clock, clock_b, length, chip_com, price, cnt);
				list.add(info);
			}
			
			return list;
		}
		if(producttable.equals("memory_t")) {
			
			DTO_memory info = null;
			ArrayList<DTO_memory> list = new ArrayList<DTO_memory>();
			if(rs.next()) {
				String model = rs.getString("model");
				String company = rs.getString("company");
				String type = rs.getString("type");
				String mem = rs.getString("mem");
				String clock = rs.getString("clock");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");
				String c_comapny = rs.getString("c_company");
				
				info = new DTO_memory(model, company, type, mem, clock, price, cnt, c_comapny);
				list.add(info);
			}
			
			return list;
		}
		if(producttable.equals("device_t")) {
			
			DTO_storage info = null;
			ArrayList<DTO_storage> list = new ArrayList<DTO_storage>();
			if(rs.next()) {
				String model = rs.getString("model");
				String company = rs.getString("company");
				String form = rs.getString("form");
				String interfaced = rs.getString("interface");
				String mem = rs.getString("mem");
				String type = rs.getString("type");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");
				String kind = rs.getString("kind");
	
				info = new DTO_storage(model, company, form, interfaced, mem, type, price, cnt, kind);
				list.add(info);
			}
			
			return list;
		}
		if(producttable.equals("power_t")) {
			
			DTO_power info = null;
			ArrayList<DTO_power> list = new ArrayList<DTO_power>();
			if(rs.next()) {
				String model = rs.getString("model");
				String company = rs.getString("company");
				String form = rs.getString("form");
				String output = rs.getString("output");
				String authen = rs.getString("authen");
				String gurantee = rs.getString("gurantee");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");

				
				info = new DTO_power(model, company, form, output, authen, gurantee, price, cnt);
				list.add(info);
			}
			
			return list;
		}
		if(producttable.equals("case_t")) {
			
			DTO_case info = null;
			ArrayList<DTO_case> list = new ArrayList<DTO_case>();
			if(rs.next()) {
				String model = rs.getString("model");
				String company = rs.getString("company");
				String sized = rs.getString("sized");
				String max = rs.getString("max");
				String pane_cnt = rs.getString("pane_cnt");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");

				info = new DTO_case(model, company, sized, max, pane_cnt, price, cnt);
				list.add(info);
			}
			
			return list;
		}
		if(producttable.equals("mouse_t")) {
			
			DTO_mouse info = null;
			ArrayList<DTO_mouse> list = new ArrayList<DTO_mouse>();
			if(rs.next()) {
				String model = rs.getString("model");
				String company = rs.getString("company");
				String conn = rs.getString("conn");
				int feel = rs.getInt("feel");
				String sensor = rs.getString("sensor");
				String color = rs.getString("color");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");

				
				info = new DTO_mouse(model, company, conn, feel, sensor, color, price, cnt);
				list.add(info);
			}
			
			return list;
		}
		if(producttable.equals("keyboard_t")) {
			
			DTO_keyboard info = null;
			ArrayList<DTO_keyboard> list = new ArrayList<DTO_keyboard>();
			if(rs.next()) {
				String model = rs.getString("model");
				String company = rs.getString("company");
				String conn = rs.getString("conn");
				String select_s = rs.getString("select_s");
				String s_company = rs.getString("s_company");
				String k_switch = rs.getString("switch");
				String array = rs.getString("array");
				String color = rs.getString("color");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");
				
				info = new DTO_keyboard(model, company, conn, select_s, s_company, k_switch, array, color, price, cnt);
				list.add(info);
			}
			
			return list;
		}
		if(producttable.equals("cooler_t")) {
			
			DTO_cooler info = null;
			ArrayList<DTO_cooler> list = new ArrayList<DTO_cooler>();
			if(rs.next()) {
				String model = rs.getString("model");
				String company = rs.getString("company");
				String ice = rs.getString("ice");
				String fan_size = rs.getString("fan_size");
				String hitcnt = rs.getString("hitcnt");
				String tdp = rs.getString("tdp");
				String radi_length = rs.getString("radi_length");
				String form = rs.getString("form");
				String socket = rs.getString("socket");
				int noise = rs.getInt("noise");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");
				
				info = new DTO_cooler(model, company, ice, fan_size, hitcnt, tdp, radi_length, form, socket, noise, price, cnt);
				list.add(info);
			}
			
			return list;
		}
		if(producttable.equals("monitor_t")) {
			
			DTO_monitor info = null;
			ArrayList<DTO_monitor> list = new ArrayList<DTO_monitor>();
			if(rs.next()) {
				String model = rs.getString("model");
				String company = rs.getString("company");
				int inchi = rs.getInt("inchi");
				String hae = rs.getString("hae");
				String rate = rs.getString("rate");
				String hz = rs.getString("hz");
				String form = rs.getString("form");
				String weight = rs.getString("weight");
				boolean blue = rs.getBoolean("blue");
				String panel = rs.getString("panel");
				String color = rs.getString("color");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");

			
				info = new DTO_monitor(model, company, inchi, hae, rate, hz, form, weight, blue, panel, color, price, cnt);
				list.add(info);
			}
			
			return list;
		}
		
		

		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close();
	}
	
return null;
}



}
