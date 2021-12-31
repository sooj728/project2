<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ page import="java.sql.*" %>
<%@ page import="com.shop.model.*" %>
<%@ page import="com.shop.view.*" %>
<%@ page import="com.shop.biz.*" %>
<%@ page import="com.shop.controller.*" %>
    
    
    
<%
	ArrayList<UsertbVO> usertbList = (ArrayList<UsertbVO>) request.getAttribute("usertbList");
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
<script src="jquery-latest.js"></script>
<link rel="stylesheet" href="datatables.min.css"/>
<script src="datatables.min.js"></script>
</head>
<body>
	<%@ include file="../header.jsp"%>
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
<div class = "tb">
	<table class = "table">
		<tr>
			<th class="item1">회원번호</th>
			<th class="item2">회원아이디</th>
			
			<th class="item4">회원명</th>
			
		</tr>
<%
		for(int i=0;i<usertbList.size();i++) {
			UsertbVO usertb = usertbList.get(i);
			
%>
		<tr>
			<td class="item1"><%=usertb.getUsertbid() %></td>
			<td class="item2"><%=usertb.getU_id() %></td>
			
			<td class="item4"><%=usertb.getUname() %></td>
		
		</tr>
<%
		}
%>
	</table>
	<!-- 페이지네이션(PageNation): 목록의 값이 한 페이지 분량을 초과할 경우 나누어 표시하고, 해당 페이지 링크를 누르면
	그 페이지에 해당하ㅏ는 내용만 표시 -->
	<ul class="ul pagenation">
		<li><a href="" arial-label="previous"><span arial-hidden="true">&laquo;</span></a></li>
	
		<li><a href="GetusertbListCtrl">1</a></li>
		
		<li><a href="" arial-label="next"><span arial-hidden="true">&raquo;</span></a></li>
	
	</ul>
	<!-- 버튼 그룹 -->
	<div class="btn-group">
		<a href="" class="btn btn-default">글쓰기</a>
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