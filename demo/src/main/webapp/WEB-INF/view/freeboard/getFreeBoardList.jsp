<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.example.demo.PageBar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getFreeBoardList.jsp</title>
</head>
<body>
<h3>자유게시판 글목록</h3>
<%
	List<Map<String,Object>> freeBoardList = (List<Map<String,Object>>)request.getAttribute("freeBoardList");

//	for(int i=0;i<freeBoardList.size();i++) {
//		out.print(freeBoardList.get(i)+"<br>");
//	}
	int size = 0;
	if(freeBoardList != null) {
		size = freeBoardList.size();
	}
	int numPerPage = 3;
	int totalRecord = size;
	int nowPage = 0;
	if(request.getParameter("nowPage") != null) {
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}
%>
</body>
<table width="1000px" border="1">
	<tbody>

<%
	if(size == 0) {
%>
			<tr>
				<td colspan="7">조회결과X</td>
			</tr>
<%
	}else if(size > 0){
		for(int i=nowPage*numPerPage;i<(nowPage*numPerPage)+numPerPage;i++){
			if(size == i) break;
			Map<String,Object> rMap = freeBoardList.get(i);
%>
			<tr>
				<td><%=rMap.get("FREE_NUM") %></td>
				<td><%=rMap.get("MEM_NUM") %></td>
				<td><%=rMap.get("FREE_SUBJECT") %></td>
				<td><%=rMap.get("FREE_TITLE") %></td>
				<td><%=rMap.get("FREE_CONTENT") %></td>
				<td><%=rMap.get("FREE_VIEWS") %></td>
				<td><%=rMap.get("FREE_REGDATE") %></td>
			</tr>
<%
		}
	}
%>
	</tbody>
</table>
<div>
<%
	String pagePath = "getFreeBoardList";
	PageBar pb = new PageBar(numPerPage, totalRecord, nowPage, pagePath);
	out.print(pb.getPageBar());
%>
</div>
</html>
