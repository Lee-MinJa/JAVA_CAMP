<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%
	List<Map<String,Object>> freeCmntList = (List)request.getAttribute("freeCmntList");
	out.print(freeCmntList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getFreeCmntList.jsp</title>
</head>
<body>

</body>
</html>