package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	Connection conn=null;
	PreparedStatement psmt=null;
	ResultSet rs=null;
	int cnt =0;
	MemberDTO dto=null;
	AdminDTO admin=null;
	
	//db접속
	public void conn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
			String url="jdbc:oracle:thin:@www.smhrd.net:1521:xe";
			String dbid="cowsys";
			String dbpw="cowsys";
		
			conn=DriverManager.getConnection(url,dbid,dbpw);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	
	
	//db해제
	public void close() {

		try {
			if(rs!=null) 
				rs.close();
			if(conn!=null) 
				conn.close();
			if(psmt!=null)
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	//회원가입
	public int join(MemberDTO dto) {
		
		conn();
		try {
			String sql="insert into member(seq,email,pw,name,tel,address) values(mem_seq.nextval,?,?,?,?,?)";
			psmt=conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getEmail());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getTel());
			psmt.setString(5, dto.getAddress());
			
			cnt=psmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close();
		}
		return cnt;
	}

	//로그인  *선행조건(LoginCheck) 먼저 실행
	public MemberDTO Login(String email) {
		conn();
		try {
			String sql="select * from member where email=?";
			psmt=conn.prepareStatement(sql);
			
			psmt.setString(1, email);
			
			rs=psmt.executeQuery();
			
			
			if(rs.next()) {
				
				String em=rs.getString("Email");
				String pw=rs.getString("pw");
				String name=rs.getString("name");
				String tel=rs.getString("Tel");
				String addr=rs.getString("Address");
				dto=new MemberDTO(em,pw,name,tel,addr);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	

	//로그인 시도시 일반회원 존재여부 확인
	public int LoginCheck(String email,String pw) { 
		conn();
		int check=0;
		try {
			String sql="select * from member where email=?";
			psmt=conn.prepareStatement(sql);
			
			psmt.setString(1, email);
	
			rs=psmt.executeQuery();
			
			
			//결과존재한다면
			if(rs.next()) {

				if(rs.getString("pw").equals(pw)) { //rs=psmt.executeQuery(); 실행하면 기존의 존재하는 pw 란 데이터가 나올것이고 이걸 입력pw랑 비교 
					System.out.println("비번일치");
					System.out.println("LoginCheck:"+rs.getString("pw")+","+pw);
					check=1;  //비밀번호 일치
				}else { 
					System.out.println("LoginCheck:비번 불일치");
					check=2; //비밀번호 불일치
				}
			}else { //아이디 없으면
				System.out.println("LoginCheck:아이디가 없어 장애야");
			check= 3; //-1출력
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return check; //db접속오류
	}
	
	//로그인 시도시 관리자 존재여부 확인
	public int AdminCheck(String email,String pw) { 
		conn();
		int check=0;
		try {
			String sql="select * from admin where id=?";
			psmt=conn.prepareStatement(sql);
			
			psmt.setString(1, email);
	
			rs=psmt.executeQuery();
			
			
			//결과존재한다면
			if(rs.next()) {

				if(rs.getString("pw").equals(pw)) { //rs=psmt.executeQuery(); 실행하면 기존의 존재하는 pw 란 데이터가 나올것이고 이걸 입력pw랑 비교 
					System.out.println("AdminCheck: 관리자 비번일치");
					System.out.println(rs.getString("pw")+","+pw);
					check=1;  //비밀번호 일치
				}else { 
					System.out.println("AdminCheck:비번 불일치");
					check=2; //비밀번호 불일치
				}
			}else { //아이디 없으면
				System.out.println("AdminCheck:아이디가 없어");
			check= 3; //-1출력
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return check; //db접속오류
	}
	
	
	// 관리자 로그인  
	public AdminDTO AdminLogin(String email) {
		conn();
		try {  
			String sql="select * from admin where id=?";
			psmt=conn.prepareStatement(sql);
			
			psmt.setString(1, email);
			rs=psmt.executeQuery();
			if(rs.next()) {
				
				String id=rs.getString("id");
				String pass=rs.getString("pw");
				
				admin=new AdminDTO(id,pass);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return admin;
	}
	
	//마이페이지 수정
	public int Update(MemberDTO dto) {
		conn();
		try {
			String sql="update member set pw=?,name=?,tel=?,address=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getPw());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getTel());
			psmt.setString(4, dto.getAddress());
			
			cnt=psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
		
	}

	//회원탈퇴
	public int deleteMember(MemberDTO dto) {
		conn();
		try {
			String sql="delete from member where email=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getEmail());
			
			int cnt=psmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("deleteMember메서드: 회원탈퇴 성공");
			}else {
				System.out.println("deleteMember메서드: 회원탈퇴 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
			}
		return cnt;
	}
	
	
	//아이디 중복체크
	public boolean idCheck(String email) {
		boolean check=true;
		conn();
		try {
			String sql="select * from member where email=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, email);
			
			rs=psmt.executeQuery();
			if(rs.next()) {
				check=true;
			}else {
				check=false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return check;
	}
	
	public ArrayList<MemberDTO> SelectMember(){
		conn();
		ArrayList<MemberDTO> list=new ArrayList<MemberDTO>();
		try {
			
			String sql="select * from member";
			psmt=conn.prepareStatement(sql);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
					int seq=rs.getInt("seq");
					String email=rs.getString("email");
					String pw=rs.getString("pw");
					String name=rs.getString("name");
					String tel=rs.getString("tel");
					String address=rs.getString("address");
						
					MemberDTO dto=new MemberDTO(seq,email,pw,name,tel,address);
					list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
		
	}
}
