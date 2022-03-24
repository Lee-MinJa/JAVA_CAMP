<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getFreeBoardList.jsp</title>
</head>
<body>
<h3>자유게시판 글목록</h3>
<%
	List<Map<String,Object>> freeBoardList = (List)request.getAttribute("freeBoardList");
	for(int i=0;i<freeBoardList.size();i++) {
		out.print(freeBoardList.get(i)+"<br>");
	}
%>
</body>
</html>
