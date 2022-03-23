<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>freeCmntWriteForm.jsp</title>
</head>
<body>
<h3>자유게시판 댓글쓰기 화면</h3>
    <form method="post" action="insertFreeCmnt">
        <table width="1000px" border="1">
            <tr>
                <th width="300px">댓글번호</th>
                <td width="700px"><input type="number" name="FREE_CMNT_NUM" size="100"></td>
            </tr>
            <tr>
                <th width="300px">글번호</th>
                <td width="700px"><input type="number" name="FREE_NUM" size="100"></td>
            </tr>
            <tr>
                <th width="300px">댓글내용</th>
                <td width="700px">
                    <textarea name="FREE_CMNT_CONTENT" cols="100" rows="5"></textarea>
                </td>
            </tr>
        </table>
        <input type="submit" value="저장">
    </form>
</body>
</html>