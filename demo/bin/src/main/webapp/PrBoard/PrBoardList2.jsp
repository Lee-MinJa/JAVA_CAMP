<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
    <%@page import= "com.example.demo.util.PageBar" %>
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
    <form action="./PrBoardInsert" method="post" enctype="Multipart/form-data">
        <!-- 올린 사람 : <input type="text" name="name" /><br/>
        제목        : <input type="text" name="subject" /><br/> -->
        <!--
            파일 업로드는 input type="file"로 지정한다.
         -->
        회원번호 : <input type="text" name="MEM_NUM" /><br/>
        지역 : <input type="text" name="PROMO_REGION" /><br/>
        캠핑장명 : <input type="text" name="PROMO_CAMPSITE" /><br/>
        한줄소개 : <input type="text" name="PROMO_MAIN_CONTENT" /><br/>
        내용 : <input type="text" name="PROMO_DETAIL_CONTENT" /><br/>
        태그 : <input type="text" name="TAG_NAME" /><br/>
        첨부파일 : <input type="file"  multiple="multiple" name="IMAGE_FILENAME" /><br/>
        <input type="submit" value="전송" />  
        <input type="reset" value="취소" />
    </form>
</center>
</body>
</html>