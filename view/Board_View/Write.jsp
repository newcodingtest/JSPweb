<%@page import="com.model.BoardDAO"%>
<%@page import="com.model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<div>
	<form action="../write" method="post" enctype="multi/form-data">
		아이디:<input type="text" name="id" >
		비밀번호:<input type="text" name="pass" ><br>
		제목:<input type="text" name="title" ><br>
		내용:<textarea rows="10" cols="30" name="content" style="resize :none"; ></textarea><br>
		파일첨부:<input type="file" name="file" size=40>
		<input type="submit">
		</form>
	</div>

</body>
</html>