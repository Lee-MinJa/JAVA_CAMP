<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getFreeCmntList.jsp</title>
</head>
<body>
<h3>자유게시판 댓글목록</h3>
<%
	List<Map<String,Object>> freeCmntList = (List)request.getAttribute("freeCmntList");
	for(int i=0;i<freeCmntList.size();i++) {
		out.print(freeCmntList.get(i)+"<br>");		
	}
%>
</body>
</html>
