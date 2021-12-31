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
<title>Q&A 글 보기(관리자)</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>
	<%@ include file="../header.jsp"%>
	
<div class = "container">
	<h2>글 보기</h2>
	<form action="UpdateQnaCtrl" method="post" name="frm">
	<table class = "table">
		<tr>
			<th class="item1">질문번호</th>
			<td class="item1"><%= qna.getQnaid() %>	</td>
		</tr>
		<tr>
			<th class="item2">제목</th>
			<td class="item2"><%=qna.getTit() %></td>
		</tr>
		<tr>
			<th class="item3">내용</th>
			<td class="item3"><%=qna.getCon() %></td>
		</tr>
		<tr>
			<th class="item4">글쓴이</th>
			<td class="item4"><%=qna.getAuthor() %></td>
		</tr>
		<tr>
			<th class="item5">등록일</th>
			<td class="item5"><%=qna.getRegdate() %></td>
		</tr>
		<tr>
			<th class="item6">비밀번호</th>
			<td class="item6"><%=qna.getPw() %>
		</tr>
		<tr>
			<th class="item7">조회수</th>
			<td class="item7"><%=qna.getVisited() %>
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
	function1(data) {
		if(confirm("정말로 삭제할까요?")) {
			location.href="DeleteQnaCtrl?qnaid="+data;
		} else {
			return false;
		}
	}
</script>
</body>
</html>