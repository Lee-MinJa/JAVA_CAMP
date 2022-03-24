<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%
	List<Map<String,Object>> freeBoardDetail = (List)request.getAttribute("freeBoardDetail");
	String f_num = null;
	String m_num = null;
	String f_subject = null;
	String f_title = null;
	String f_content = null;
	String f_views = null;
	String f_regdate = null;
	if(freeBoardDetail != null && freeBoardDetail.size()>0) {
		Map<String,Object> rMap = freeBoardDetail.get(0);
		f_num = rMap.get("FREE_NUM").toString();
		m_num = rMap.get("MEM_NUM").toString();
		f_subject = rMap.get("FREE_SUBJECT").toString();
		f_title = rMap.get("FREE_TITLE").toString();
		f_content = rMap.get("FREE_CONTENT").toString();
		f_views = rMap.get("FREE_VIEWS").toString();
		f_regdate = rMap.get("FREE_REGDATE").toString();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getFreeBoardDetail.jsp</title>
</head>
<body>
<h3>자유게시판 상세글보기 화면</h3>
	<table width="1000px" border="1">
		<tr>
			<th width="300px">글번호</th>
			<td width="700px"><input value="<%=f_num%>" readonly></td>
		</tr>
		<tr>
			<th width="300px">회원번호</th>
			<td width="700px"><input value="<%=m_num%>" readonly></td>
		</tr>
		<tr>
			<th width="300px">주제</th>
			<td width="700px"><input value="<%=f_subject%>" readonly></td>
		</tr>
		<tr>
			<th width="300px">글제목</th>
			<td width="700px"><input value="<%=f_title%>" readonly></td>
		</tr>
		<tr>
			<th width="300px">글내용</th>
			<td width="700px"><input value="<%=f_content%>" readonly></td>
		</tr>
		<tr>
			<th width="300px">조회수</th>
			<td width="700px"><input value="<%=f_views%>" readonly></td>
		</tr>
		<tr>
			<th width="300px">등록일</th>
			<td width="700px"><input value="<%=f_regdate%>" readonly></td>
		</tr>
	</table>
</body>
</html>