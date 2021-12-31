<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ page import="java.sql.*" %>
<%@ page import="com.shop.model.*" %>
<%@ page import="com.shop.view.*" %>
<%@ page import="com.shop.biz.*" %>
<%@ page import="com.shop.controller.*" %>
    
<%
	ArrayList<QnaVO> qnaList = (ArrayList<QnaVO>) request.getAttribute("qnaList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="./js/jquery-latest.js"></script>
<link rel="stylesheet" href="./js/datatables.min.css"/>
<script src="./js/datatables.min.js"></script>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container">
	<h2>글 목록</h2>
		<form action="" method="post">
			<table class="table" id="mainList">
				<tr>
					<td>
						<select name="searchType" id="">
							<option value="title">제목</option>
							<option value="conetnt">내용</option>
						</select>
						<input type="text" name="searchKeyword" />
						<input type="submit" value="검색"/>
					</td>
				</tr>
			</table>
		</form>
	<table class = "table">
		<tr>
			<th class="item1">질문번호</th>
			<th class="item2">제목</th>
			<th class="item3">작성자</th>
			<th class="item4">등록일</th>
		</tr>
<%
		for(int i=0;i<qnaList.size();i++) {
			QnaVO qna = qnaList.get(i);
			
%>
		<tr>
			<td class="item1"><%=qna.getQnaid() %></td>
			<td class="item2"><a href="GetQnaCtrl?qnaid=<%=qna.getQnaid() %>"><%=qna.getTit() %></a></td>
			<td class="item3"><%=qna.getAuthor() %></td>
			<td class="item4"><%=qna.getRegdate() %></td>
		</tr>
<%
		}
%>
	</table>
	<!-- 버튼 그룹 -->
	<div class="btn-group">
		<a href="/qna/insertQna.jsp" class="btn btn-default">글쓰기</a>
	</div>
</div>
<%@ include file="../footer.jsp" %>
   <script>
   	$(function() {
   		$("#mainList").DataTable();
   	});
   
   </script>
</body>
</html>