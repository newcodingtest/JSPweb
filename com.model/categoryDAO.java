package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.util.DBManager;

public class categoryDAO {

	
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


public ArrayList SelectCategory(String product) {
	
	
	try{
	Connection();
	
	
	if(product.equals("cpu")) {
		DTO_cpu info = null;
		ArrayList<DTO_cpu> list = new ArrayList<DTO_cpu>();
	String sql = "select* from cpu_t";
	psmt = conn.prepareStatement(sql);
	

	rs = psmt.executeQuery();
	while(rs.next()) {	
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
	
	if(product.equals("mother")) {
		DTO_mother info = null;
		ArrayList<DTO_mother> list = new ArrayList<DTO_mother>();
	String sql = "select* from mainboard_t";
	psmt = conn.prepareStatement(sql);
	

	rs = psmt.executeQuery();
	while(rs.next()) {	
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
	if(product.equals("gpu")) {
		
		String sql = "select* from gpu_t";
		psmt = conn.prepareStatement(sql);
		ArrayList list = SelectGPU();
		return list;
		
	}
	
	if(product.equals("memory")) {
		
		String sql = "select* from memory_t";
		psmt = conn.prepareStatement(sql);
		ArrayList list = SelectMemory();
		return list;
		
	}
	if(product.equals("device")) {
		
		String sql = "select* from device_t";
		psmt = conn.prepareStatement(sql);
		ArrayList list = SelectDevice();
		return list;
		
	}
	if(product.equals("power")) {
		
		String sql = "select* from power_t";
		psmt = conn.prepareStatement(sql);
		ArrayList list = SelectPower();
		return list;
		
	}
	if(product.equals("case")) {
		
		String sql = "select* from case_t";
		psmt = conn.prepareStatement(sql);
		ArrayList list = SelectCase();
		return list;
		
	}
	if(product.equals("mouse")) {
		
		String sql = "select* from mouse_t";
		psmt = conn.prepareStatement(sql);
		ArrayList list = SelectMouse();
		return list;
		
	}
	if(product.equals("keyboard")) {
		
		String sql = "select* from keyboard_t";
		psmt = conn.prepareStatement(sql);
		ArrayList list = SelectKeyboard();
		return list;
		
	}
	if(product.equals("cooler")) {
		
		String sql = "select* from cooler_t";
		psmt = conn.prepareStatement(sql);
		ArrayList list = SelectCooler();
		return list;
		
	}
	if(product.equals("monitor")) {
		
		String sql = "select* from monitor_t";
		psmt = conn.prepareStatement(sql);
		ArrayList list = SelectMonitor();
		return list;
		
	}
	
	
	}catch(SQLException e) {
		e.printStackTrace();
	} finally {
		close();
	}
	return null;
}







public ArrayList SelectCategoryQuery(ArrayList<String> production, String product, String productObject, int count) {

try {
	Connection();
	
	System.out.println("받은카운트= "+count);
	
		String sql = null;
		
			
			
			
			if(count == 1) {
			sql = "select* from "+productObject+" where "+production.get(0)+"= ?";
			
			psmt = conn.prepareStatement(sql);
			production.remove(0);
			System.out.println(production.get(0));
			psmt.setString(1, production.get(0));
			production.remove(0);
			
			}
			if(count == 2) {
			sql = "select* from "+productObject+" where "+production.get(0)+"= ? and "+production.get(2)+"= ?";
					
			psmt = conn.prepareStatement(sql);
			production.remove(0);
			psmt.setString(1, production.get(0));
			production.remove(0);
			production.remove(0);
			psmt.setString(2, production.get(0));
			}
			if(count == 3) {
			sql = "select* from "+productObject+" where "+production.get(0)+"= ? and "+production.get(2)+"= ? and "+production.get(4)+"= ?";
					
			psmt = conn.prepareStatement(sql);
			production.remove(0);
			psmt.setString(1, production.get(0));
			production.remove(0);
			production.remove(0);
			psmt.setString(2, production.get(0));
			production.remove(0);
			production.remove(0);
			psmt.setString(3, production.get(0));
			}
			
			

			
			
			if(product.equals("cpu")) {
				
			//ArrayList<DTO_cpu> list = new ArrayList<DTO_cpu>();
				ArrayList list = SelectCPU();
			return list;
			
		}
			
		
			if(product.equals("mother")) {
				
				ArrayList list = SelectMother();
				return list;
			
		}
			if(product.equals("gpu")) {
				
				ArrayList list = SelectGPU();
				return list;
			
		}
			if(product.equals("memory")) {
				
				ArrayList list = SelectMemory();
				return list;
			
		}
			if(product.equals("device")) {
				
				ArrayList list = SelectDevice();
				return list;
			
		}
			if(product.equals("power")) {
				
				ArrayList list = SelectPower();
				return list;
			
		}
			if(product.equals("case")) {
				
				ArrayList list = SelectCase();
				return list;
			
		}
			if(product.equals("mouse")) {
				
				ArrayList list = SelectMouse();
				return list;
			
		}
			if(product.equals("keyboard")) {
				
				ArrayList list = SelectKeyboard();
				return list;
			
		}
			if(product.equals("cooler")) {
				
				ArrayList list = SelectCooler();
				return list;
			
		}
			if(product.equals("monitor")) {
				
				ArrayList list = SelectMonitor();
				return list;
			
		}
			
		
	
		
	}
	
	
catch(SQLException e) {
	e.printStackTrace();
	
}finally {
	close();
}
return null;

}


public ArrayList SelectCPU() {
	
	
	ArrayList<DTO_cpu> list = new ArrayList<DTO_cpu>();
	
try {
	rs = psmt.executeQuery();
	while(rs.next()) {	
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
		
		DTO_cpu info = new DTO_cpu(model, company, socket, ac, core, thread, clock, clock_b, tdp, mp, vga, lineup, price, cnt);
		list.add(info);
	}}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return list;	
		
}

public ArrayList SelectMother() {
	
	
	ArrayList<DTO_mother> list = new ArrayList<DTO_mother>();
	
try {
	rs = psmt.executeQuery();
	while(rs.next()) {	
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

		
		DTO_mother info = new DTO_mother(model, company, socket, chipset, form, type, lineup, price, cnt, c_company);
		list.add(info);
	}}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return list;	
		
}

public ArrayList SelectGPU() {
	
	
	ArrayList<DTO_vga> list = new ArrayList<DTO_vga>();
	
try {
	rs = psmt.executeQuery();
	while(rs.next()) {	
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
		
		DTO_vga info = new DTO_vga(model, company, chipname, mem, clock, clock_b, length, chip_com, price, cnt);
		list.add(info);
	}}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return list;	
		
}

public ArrayList SelectMemory() {
	
	
	ArrayList<DTO_memory> list = new ArrayList<DTO_memory>();
	
try {
	rs = psmt.executeQuery();
	while(rs.next()) {	
		String model = rs.getString("model");
		String company = rs.getString("company");
		String type = rs.getString("type");
		String mem = rs.getString("mem");
		String clock = rs.getString("clock");
		int price = rs.getInt("price");
		int cnt = rs.getInt("cnt");
		String c_comapny = rs.getString("c_company");
		
		DTO_memory info = new DTO_memory(model, company, type, mem, clock, price, cnt, c_comapny);
		list.add(info);
	}}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return list;	
		
}

public ArrayList SelectDevice() {
	
	
	ArrayList<DTO_storage> list = new ArrayList<DTO_storage>();
	
try {
	rs = psmt.executeQuery();
	while(rs.next()) {	
		String model = rs.getString("model");
		String company = rs.getString("company");
		String form = rs.getString("form");
		String interfaced = rs.getString("interface");
		String mem = rs.getString("mem");
		String type = rs.getString("type");
		int price = rs.getInt("price");
		int cnt = rs.getInt("cnt");
		String kind = rs.getString("kind");
		
		
		DTO_storage info = new DTO_storage(model, company, form, interfaced, mem, type, price, cnt, kind);
		list.add(info);
	}}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return list;	
		
}

public ArrayList SelectPower() {
	
	
	ArrayList<DTO_power> list = new ArrayList<DTO_power>();
	
try {
	rs = psmt.executeQuery();
	while(rs.next()) {	
		String model = rs.getString("model");
		String company = rs.getString("company");
		String form = rs.getString("form");
		String output = rs.getString("output");
		String authen = rs.getString("authen");
		String gurantee = rs.getString("gurantee");
		int price = rs.getInt("price");
		int cnt = rs.getInt("cnt");

		
		DTO_power info = new DTO_power(model, company, form, output, authen, gurantee, price, cnt);
		list.add(info);
	}}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return list;	
		
}

public ArrayList SelectCase() {
	
	
	ArrayList<DTO_case> list = new ArrayList<DTO_case>();
	
try {
	rs = psmt.executeQuery();
	while(rs.next()) {	
		String model = rs.getString("model");
		String company = rs.getString("company");
		String sized = rs.getString("sized");
		String max = rs.getString("max");
		String pane_cnt = rs.getString("pane_cnt");
		int price = rs.getInt("price");
		int cnt = rs.getInt("cnt");

		
		DTO_case info = new DTO_case(model, company, sized, max, pane_cnt, price, cnt);
		list.add(info);
	}}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return list;	
		
}

public ArrayList SelectMouse() {
	
	
	ArrayList<DTO_mouse> list = new ArrayList<DTO_mouse>();
	
try {
	rs = psmt.executeQuery();
	while(rs.next()) {	
		String model = rs.getString("model");
		String company = rs.getString("company");
		String conn = rs.getString("conn");
		int feel = rs.getInt("feel");
		String sensor = rs.getString("sensor");
		String color = rs.getString("color");
		int price = rs.getInt("price");
		int cnt = rs.getInt("cnt");

		
		DTO_mouse info = new DTO_mouse(model, company, conn, feel, sensor, color, price, cnt);
		list.add(info);
	}}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return list;	
		
}

public ArrayList SelectKeyboard() {
	
	
	ArrayList<DTO_keyboard> list = new ArrayList<DTO_keyboard>();
	
try {
	rs = psmt.executeQuery();
	while(rs.next()) {	
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
		
		DTO_keyboard info = new DTO_keyboard(model, company, conn, select_s, s_company, k_switch, array, color, price, cnt);
		list.add(info);
	}}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return list;	
		
}

public ArrayList SelectCooler() {
	
	
	ArrayList<DTO_cooler> list = new ArrayList<DTO_cooler>();
	
try {
	rs = psmt.executeQuery();
	while(rs.next()) {	
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
		
		DTO_cooler info = new DTO_cooler(model, company, ice, fan_size, hitcnt, tdp, radi_length, form, socket, noise, price, cnt);
		list.add(info);
	}}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return list;	
		
}

public ArrayList SelectMonitor() {
	
	
	ArrayList<DTO_monitor> list = new ArrayList<DTO_monitor>();
	
try {
	rs = psmt.executeQuery();
	while(rs.next()) {	
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

		
		DTO_monitor info = new DTO_monitor(model, company, inchi, hae, rate, hz, form, weight, blue, panel, color, price, cnt);
		list.add(info);
	}}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return list;	
		
}



}