package com.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.model.BoardDAO;
import com.model.BoardDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		//===================���� ���ε� ����===========================//
	      
//	      String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
//
//	      System.out.println("���� ���� ���: "+uploadPath);
//	      
//	       int size = 1024 * 1024 * 10; // ���尡���� ���� ũ��
//	       String file = ""; // ���ε� �� ������ �̸�(�̸��� ����ɼ� �ִ�)
//	       String originalFile = ""; // �̸��� ����Ǳ� �� ���� ���� �̸�
//
//	       // ������ ���� ���ε��ϴ� ����
//	   
//	           MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
//
//	           Enumeration files = multi.getFileNames();
//	           String str = (String)files.nextElement(); // ���� �̸��� �޾ƿ� string���� ����
//
//	           file = multi.getFilesystemName(str); // ���ε� �� ���� 7�̸� ������
//	           originalFile = multi.getOriginalFileName(str); // ������ �����̸� ������
//
//	           System.out.println(originalFile);
	   
	           
	      //===================���� ���ε� ��===========================//

		
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		BoardDTO dto=new BoardDTO(title,content,id,pw);
		
		BoardDAO dao=new BoardDAO();
		int cnt=dao.write(dto);
		
		if(cnt>0) {
		System.out.println("�۾��� ����");
	
		}else {
			System.out.println("�۾��� ����");
		}
		
		request.getRequestDispatcher("ListServiceCon").forward(request, response);
	}


}
