<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.ArrayList" %>    
<%@ page import = "com.shop.model.*" %>    
<%@ page import = "com.shop.biz.*" %>   
<%@ page import = "com.shop.view.*" %>        

<%
	BoardVO board = (BoardVO) request.getAttribute("board");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>답변형 게시판 글쓰기</title>
</head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>
    <form method="post" action="../InsertResBoardCtrl" name="boardForm" enctype="multipart/form-data">
    <input type="hidden" name="board_id" value="admin">
    <table class="table">
        <tr>
            <td id="title">작성자</td>
            <td><input type="text" name="result_name" value="관리자" readonly /></td>
        </tr>
            <tr>
            <td id="title">제 목</td>
            <td><input name="board_subject" type="text" size="70" maxlength="100" value=""/></td>        
        </tr>
        <tr>
            <td id="title">내 용</td>
            <td><textarea name="board_content" cols="72" rows="20"></textarea></td>        
        </tr>
        <tr>
            <td id="title">파일첨부</td>
            <td><input type="file" name="board_file" /></td>    
        </tr>
        <tr align="center" valign="middle">
            <td colspan="5">
                <input type="reset" value="작성취소" class="btn btn-primary">
                <input type="submit" value="등록" class="btn btn-primary">
                <input type="button" value="목록" class="btn btn-primary">            
            </td>
        </tr>
    </table>    
    </form>
</body>
</html>