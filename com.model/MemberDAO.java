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
	
	//db����
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
	
	
	//db����
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
	
	//ȸ������
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

	//�α���  *��������(LoginCheck) ���� ����
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
	

	//�α��� �õ��� �Ϲ�ȸ�� ���翩�� Ȯ��
	public int LoginCheck(String email,String pw) { 
		conn();
		int check=0;
		try {
			String sql="select * from member where email=?";
			psmt=conn.prepareStatement(sql);
			
			psmt.setString(1, email);
	
			rs=psmt.executeQuery();
			
			
			//��������Ѵٸ�
			if(rs.next()) {

				if(rs.getString("pw").equals(pw)) { //rs=psmt.executeQuery(); �����ϸ� ������ �����ϴ� pw �� �����Ͱ� ���ð��̰� �̰� �Է�pw�� �� 
					System.out.println("�����ġ");
					System.out.println("LoginCheck:"+rs.getString("pw")+","+pw);
					check=1;  //��й�ȣ ��ġ
				}else { 
					System.out.println("LoginCheck:��� ����ġ");
					check=2; //��й�ȣ ����ġ
				}
			}else { //���̵� ������
				System.out.println("LoginCheck:���̵� ���� ��־�");
			check= 3; //-1���
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return check; //db���ӿ���
	}
	
	//�α��� �õ��� ������ ���翩�� Ȯ��
	public int AdminCheck(String email,String pw) { 
		conn();
		int check=0;
		try {
			String sql="select * from admin where id=?";
			psmt=conn.prepareStatement(sql);
			
			psmt.setString(1, email);
	
			rs=psmt.executeQuery();
			
			
			//��������Ѵٸ�
			if(rs.next()) {

				if(rs.getString("pw").equals(pw)) { //rs=psmt.executeQuery(); �����ϸ� ������ �����ϴ� pw �� �����Ͱ� ���ð��̰� �̰� �Է�pw�� �� 
					System.out.println("AdminCheck: ������ �����ġ");
					System.out.println(rs.getString("pw")+","+pw);
					check=1;  //��й�ȣ ��ġ
				}else { 
					System.out.println("AdminCheck:��� ����ġ");
					check=2; //��й�ȣ ����ġ
				}
			}else { //���̵� ������
				System.out.println("AdminCheck:���̵� ����");
			check= 3; //-1���
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return check; //db���ӿ���
	}
	
	
	// ������ �α���  
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
	
	//���������� ����
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

	//ȸ��Ż��
	public int deleteMember(MemberDTO dto) {
		conn();
		try {
			String sql="delete from member where email=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getEmail());
			
			int cnt=psmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("deleteMember�޼���: ȸ��Ż�� ����");
			}else {
				System.out.println("deleteMember�޼���: ȸ��Ż�� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
			}
		return cnt;
	}
	
	
	//���̵� �ߺ�üũ
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
