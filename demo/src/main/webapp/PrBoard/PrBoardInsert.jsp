<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="java.util.*" %>
    <%
    List<Map<String,Object>> PrBoardList=(List)request.getAttribute("PrBoardList");
    out.print(PrBoardList);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
인서트 성공!!
</body>
</html>