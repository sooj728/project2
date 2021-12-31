<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.ArrayList" %>    
<%@ page import = "com.shop.model.UsertbVO" %>    
<%@ page import = "com.shop.biz.UsertbDAO" %>   
<%@ page import = "com.shop.view.GetUsertbCtrl" %>        
    
<%
	UsertbVO usertb = (UsertbVO) request.getAttribute("usertb");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세보기</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>
	<%@ include file="../header.jsp"%>
	
<div class = "container">
	<table class = "table">
		<tr>
			<th class="item1">회원번호</th>
			<td class="item1"><%= usertb.getUsertbid() %>	</td>
		</tr>
		<tr>
			<th class="item2">아이디</th>
			<td class="item2"><%=usertb.getU_id() %></td>
		</tr>
		<tr>
			<th class="item3">이름</th>
			<td class="item3"><%=usertb.getUname() %></td>
		</tr>
		<tr>
			<th class="item4">이메일</th>
			<td class="item4"><%=usertb.getEmail() %></td>
		</tr>
		<tr>
			<th class="item5">질문</th>
			<td class="item5"><%=usertb.getQ() %></td>
		</tr>
		<tr>
			<th class="item6">답</th>
			<td class="item6"><%=usertb.getA() %>
		</tr>
		<tr>
			<th class="item7">우편번호</th>
			<td class="item7"><%=usertb.getAdd1() %>
		</tr>
			<tr>
			<th class="item8">주소</th>
			<td class="item8"><%=usertb.getAdd2() %>
		</tr>
			<tr>
			<th class="item9">가입일</th>
			<td class="item9"><%=usertb.getRegdate() %>
		</tr>
			<tr>
			<th class="item10">쿠폰개수</th>
			<td class="item10"><%=usertb.getCp() %>
		</tr>
	</table>
	
	<!-- 버튼 그룹 -->
	<div class="btn-group">
	
	</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>