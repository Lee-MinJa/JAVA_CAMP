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
</head>
<body>
   <h3>파일 업로드 폼</h3>
<center>
    <!--
        파일업로드를 위해선 반드시 method="post" enctype="Multipart/form-data"여야함!
     -->
    <form action="fileUpload.jsp" method="post" enctype="Multipart/form-data">
        <!-- 올린 사람 : <input type="text" name="name" /><br/>
        제목        : <input type="text" name="subject" /><br/> -->
        <!--
            파일 업로드는 input type="file"로 지정한다.
         -->
        파일명1 : <input type="file" name="IMAGE_FILENAME" /><br/>
        <input type="submit" value="전송" />  
        <input type="reset" value="취소" />
    </form>
</center>
</body>
</html>