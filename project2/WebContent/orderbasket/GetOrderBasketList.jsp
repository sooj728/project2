<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ page import="java.sql.*" %>
<%@ page import="com.shop.model.*" %>
<%@ page import="com.shop.view.*" %>
<%@ page import="com.shop.biz.*" %>
<%@ page import="com.shop.controller.*" %>

    
<%
	ArrayList<OrderBasketVO> orderbasketList = (ArrayList<OrderBasketVO>) request.getAttribute("orderBasketList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 목록</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="./js/jquery-latest.js"></script>
<link rel="stylesheet" href="./js/datatables.min.css"/>
<script src="datatables.min.js"></script>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container">
	<h2>장바구니 목록</h2>
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
			<th class="item1">구매물품</th>
			<th class="item2">수량</th>
			<th class="item3">상세보기</th>
		</tr>
<%
		for(int i=0;i<orderbasketList.size();i++) {
			OrderBasketVO orderbasket = orderbasketList.get(i);
			
%>
		<tr>
			<td class="item1"><%=orderbasket.getOitem() %></td>
			<td class="item2"><%=orderbasket.getCnt() %></td>
			<td class="item3"><a href="GetOrderBasketCtrl?orderbasketid=<%=orderbasket.getOrderbasketid() %>"></a></td>
			
		</tr>
<%
		}
%>
	</table>
	<!-- 버튼 그룹 -->
	<div class="btn-group">
		
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