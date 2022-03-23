<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>freeBoardWriteForm.jsp</title>
</head>
<body>
<h3>자유게시판 글쓰기 화면</h3>
    <form method="post" action="insertFreeBoard">
        <table width="1000px" border="1">
            <tr>
                <th width="300px">글번호</th>
                <td width="700px"><input type="number" name="FREE_NUM" size="100"></td>
            </tr>
            <tr>
                <th width="300px">회원번호</th>
                <td width="700px"><input type="number" name="MEM_NUM" size="100"></td>
            </tr>
            <tr>
                <th width="300px">주제</th>
                <td width="700px"><input type="text" name="FREE_SUBJECT" size="100"></td>
            </tr>
            <tr>
                <th width="300px">글제목</th>
                <td width="700px"><input type="text" name="FREE_TITLE" size="100"></td>
            </tr>
            <tr>
                <th width="300px">글내용</th>
                <td width="700px">
                    <textarea name="FREE_CONTENT" cols="100" rows="30"></textarea>
                </td>
            </tr>
        </table>
        <input type="submit" value="저장">
    </form>
</body>
</html>