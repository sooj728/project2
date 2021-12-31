<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ page import="java.sql.*" %>
<%@ page import="com.shop.model.*" %>
<%@ page import="com.shop.view.*" %>
<%@ page import="com.shop.biz.*" %>
<%@ page import="com.shop.controller.*" %>

    
<%
	ArrayList<BuyVO> buyList = (ArrayList<BuyVO>) request.getAttribute("adminGetBuyList");
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
<link rel="stylesheet" href="datatables.min.css"/>
<script src="./js/datatables.min.js"></script>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container">
	<h2>구매 목록</h2>
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
			<th class="item1">구매번호</th>
			<th class="item2">구매코드</th>
			<th class="item3">구매자</th>
			<th class="item4">수량</th>
			<th class="item5">가격</th>
			<th class="item6">구매물품</th>
			<th class="item7">쿠폰사용여부</th>
		</tr>
<%
		for(int i=0;i<buyList.size();i++) {
			BuyVO buy = buyList.get(i);
			
%>
		<tr>
			<td class="item1"><%=buy.getBuyid() %></td>
			<td class="item2"><a href="GetBuyCtrl?buyid=<%=buy.getBuyid() %>"><%=buy.getBcode() %></a></td>
			<td class="item3"><%=buy.getBuyer() %></td>
			<td class="item4"><%=buy.getCnt() %></td>
			<td class="item4"><%=buy.getAmount() %></td>
			<td class="item4"><%=buy.getBitem() %></td>
			<td class="item4"><%=buy.getCpuse() %></td>
		</tr>
<%
		}
%>
	</table>
	<!-- 버튼 그룹 -->
	<div class="btn-group">
		<a href="/buy/insertBuy.jsp" class="btn btn-default">글쓰기</a>
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