package com.model;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageDAO {

	Connection conn=null;
	PreparedStatement psmt=null;
	ResultSet rs=null;
	int cnt=0;

	
	
	
	public void conn() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@www.smhrd.net:1521:xe";
			String id="cowsys";
			String pw="cowsys";
			
			conn=DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
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
	
	//사용자-고객센터문의글 전송
	public int AddAsk(MessageDTO dto) {
		conn();
		try {
			String sql="insert into message(seq,kind,title,content,m_date,m_email) values(m_seq.nextval,?,?,?,sysdate,?)";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getKind());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getE_mail());
			
			cnt=psmt.executeUpdate();
			if(cnt>0) {
				System.out.println("AddAsk() 메서드 에서 고객센터 문의에 성공하였습니다"); 
				
			}else {
				System.out.println("AddAsk() 메서드 에서 고객센터 문의에 실패하였습니다"); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
		
	}
	
	public ArrayList<MessageDTO> ViewAllMessage() {
		conn();
		ArrayList<MessageDTO> list=new ArrayList<MessageDTO>();
		try {
			String sql="select * from message";
			psmt=conn.prepareStatement(sql);
			
			rs=psmt.executeQuery();

			while(rs.next()) {
				MessageDTO dto=new MessageDTO();
			    dto.setSeq(rs.getInt("seq"));
				dto.setKind(rs.getString("kind"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setM_date(rs.getString("m_date"));
				dto.setE_mail(rs.getString("m_email"));
				
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
