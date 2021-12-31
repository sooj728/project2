<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ page import="java.sql.*" %>
<%@ page import="com.shop.model.*" %>
<%@ page import="com.shop.view.*" %>
<%@ page import="com.shop.biz.*" %>
<%@ page import="com.shop.controller.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
	ArrayList<ProlistVO> prolistList = (ArrayList<ProlistVO>) request.getAttribute("prolistList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>국내 도서 목록(사용자)</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="./js/jquery-latest.js"></script>
<link rel="stylesheet" href="./js/datatables.min.css"/>
<script src="./js/datatables.min.js"></script>
<script src="./js/masonry.pkgd.min.js"></script> 
<style>
	body, html { width: 100%; }
    ul { list-style: none; }
    a { text-decoration: none; }  
    .wrap { width: 100%; }
    proview {margin:5 }
	.proview p {text-align:center }
	.proview a {display:inline }
	li {line-height:1 }
	mason {marin-top:100px; }
</style>
</head>
<body>
	<div class="wrap">
		<%@ include file="../header.jsp"%>
		<div class="proview" >
			<ul id="mason">
				<c:set var="num" value="${prolistList.size() }" />
				<c:forEach items="${prolistList }" var="prolist" >
				<li>
				<p class="protit"><a href="./GetProlistCtrl?prolistid=${prolist.getProlistid() }"><img src="${prolist.getImg() }" alt="상품이미지" /></a></p>
				<p><a href="./GetProlistCtrl?prolistid=${prolist.getProlistid() }">${prolist.getPname() }</a></p>
				<p>남은수량: ${prolist.getCnt() }</p>
				
				</li>		
				</c:forEach>
			</ul>
		</div>
		<%@ include file="../footer.jsp" %>
	</div>
   <script>
   	$("#mason").masonry();
   </script>
</body>
</html>