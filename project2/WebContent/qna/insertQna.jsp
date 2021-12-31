<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.ArrayList" %>    
<%@ page import = "com.shop.model.QnaVO" %>    
<%@ page import = "com.shop.biz.QnaDAO" %>   
<%@ page import = "com.shop.view.GetQnaCtrl" %>        
    
<%
	QnaVO qna = (QnaVO) request.getAttribute("qna");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>
	<%@ include file="../header.jsp"%>
	
<div class = "container">
	<h2>글 작성</h2>
	<form action="../InsertQnaCtrl" method="post" name="frm">
	<table class = "table">
		<tr>
			<th class="item1">제목</th>
			<td class="item1"><input type="text" name="tit" id="tit" value="tit" /></td>
		</tr>
		<tr>
			<th class="item2">내용</th>
			<td class="item2"><textarea name="con" id="con" cols="100" rows="20"></textarea></td>
		</tr>
		<tr>
			<th class="item3">글쓴이</th>
			<td class="item3">
			<input type="hidden" name="author" value="author" />
			</td>
		</tr>
			<tr>
			<th class="item4">삭제비밀번호</th>
			<td class="item4">
			<input type="number" name="pw" value="pw" />
			</td>
		</tr>
	</table>
</form>	
	<!-- 버튼 그룹 -->
	<div class="btn-group">
	<input type="submit" class ="btn btn-default" value="글 수정"/>
	<a href="GetQnaListCtrl" class="btn btn-default">목록</a>
	<a href="DeleteQnaListCtrl?qnaid=<%=qna.getQnaid() %>" class="btn btn-default">글 삭제</a>
	<button class="btn btn-default" onclick="function1(<%=qna.getQnaid() %>)" ></button>
	</div>
</div>
<%@ include file="../footer.jsp" %>
<script>
	function1() {
		if(confirm("정말로 삭제할까요?")) {
			location.href="DeleteQnaCtrl?qnaid="+data;
		} else {
			return false;
		}
	}
</script>
</body>
</html>