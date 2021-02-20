package com.model;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	int cnt=0;
	PreparedStatement psmt=null;
	Connection conn=null;
	ResultSet rs=null;
	
	
	
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
	//db��������
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

	//��ü �۸���Ʈ �����ٶ�
	public ArrayList<BoardDTO> list() {
		
	
		ArrayList<BoardDTO> list=new ArrayList<BoardDTO>(); 
		conn();
		
		try {
			String sql="select comid,title,id,to_char(comdate,'HH:MM:SS') comdate,visit from community order by comid desc";
			psmt=conn.prepareStatement(sql);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto=new BoardDTO();
				dto.setComid(rs.getInt("comid"));
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setComdate(rs.getString("comdate"));
				dto.setVisit(rs.getInt("visit"));
	
				list.add(dto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	//�۵��
	public int write(BoardDTO dto){
		conn();
		ArrayList<BoardDTO> list=null;
		try {
			String sql="insert into community(comid, title, content, id, pw,comdate,visit) values(community_seq.nextval,?,?,?,?,sysdate,0)";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());
			psmt.setString(4, dto.getPw());
			
			cnt=psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return cnt;
	}

	//��ü���⿡�� �� ���� ������ �󼼺���
	public BoardDTO detail(int comid) {
		
		BoardDTO dto=null;
		conn();
		String sql="";
		try {

			sql="select comid,title,content,id,to_char(comdate,'HH:MM:SS') comdate,visit from community where comid=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, comid);
			
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				dto=new BoardDTO();
				dto.setComid(rs.getInt("comid"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setComdate(rs.getString("comdate"));
				dto.setVisit(rs.getInt("visit")); 
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
		
		
	}

	//�� ����
	public int delete(int comid){
		conn();
	
		try {
			String sql="delete  from community where comid=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, comid);
	
			cnt=psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return cnt;
	}
	
	//�ۼ���
	public int update(String id,String pw,String title,String content,int comid){
		conn();
	
		try {
			String sql="update community set id=?,pw=?,title=?,content=? where comid=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, title);
			psmt.setString(4, content);
			psmt.setInt(5, comid);
	
			cnt=psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return cnt;
	}

	//��ȸ�� ����
		public int increase(int comid) {

			conn();
			
			try {
				String sql="update community set visit=visit+1 where comid=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1, comid);
				
				cnt=psmt.executeUpdate();
				if(cnt>0) {
					System.out.println("��ȸ�� ���� ����");
					
				}else {
					System.out.println("��ȸ�� 1���� ����");
				}

				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return cnt;
			
			
		}

	
}
