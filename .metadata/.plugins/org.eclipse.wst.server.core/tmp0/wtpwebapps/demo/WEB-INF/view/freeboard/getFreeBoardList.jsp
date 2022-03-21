<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%
	List<Map<String,Object>> freeBoardList = (List)request.getAttribute("freeBoardList");
	out.print(freeBoardList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getFreeBoardList.jsp</title>
</head>
<body>

</body>
</html>