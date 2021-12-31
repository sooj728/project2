<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.ArrayList" %>    
<%@ page import = "com.shop.model.ProlistVO" %>    
<%@ page import = "com.shop.biz.ProlistDAO" %>   
<%@ page import = "com.shop.view.AdminGetProlistCtrl" %>        
    
<%
	ProlistVO prolist = (ProlistVO) request.getAttribute("prolist");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록 (관리자)</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>
	<%@ include file="../header.jsp"%>
	
<div class = "container">
	<h2>상품 보기</h2>
	<form action="UpdateProlistCtrl" method="post" name="frm">
	<table class = "table">
		<tr>
			<th class="item1">상품번호</th>
			<td class="item1"><%= prolist.getProlistid() %>	</td>
		</tr>
		<tr>
			<th class="item2">상품코드</th>
			<td class="item2"><%=prolist.getPcode() %></td>
		</tr>
		<tr>
			<th class="item3">상품명</th>
			<td class="item3"><%=prolist.getPname() %></td>
		</tr>
		<tr>
			<th class="item4">지역</th>
			<td class="item4"><%=prolist.getNat() %></td>
		</tr>
		<tr>
			<th class="item5">장르</th>
			<td class="item5"><%=prolist.getGenre() %></td>
		</tr>
		<tr>
			<th class="item6">가격</th>
			<td class="item6"><%=prolist.getPrice() %></td>
		</tr>
		<tr>
			<th class="item7">이미지</th>
			<td class="item7"><img src="<%=prolist.getImg() %>"></td>
		</tr>
	</table>
</form>	
	<!-- 버튼 그룹 -->
	<div class="btn-group">
	<input type="submit" class ="btn btn-default" value="제품 수정"/>
	<a href="AdminGetProlistListCtrl" class="btn btn-default">목록</a>
	<a href="DeleteProlistListCtrl?Prolistid=<%=prolist.getProlistid() %>" class="btn btn-default">제품 삭제</a>
	<button class="btn btn-default" onclick="function1(<%=prolist.getProlistid() %>)" ></button>
	</div>
</div>
<%@ include file="../footer.jsp" %>
<script>
	function1(data) {
		if(confirm("정말로 삭제할까요?")) {
			location.href="DeleteProlistCtrl?prolistid="+data;
		} else {
			return false;
		}
	}
</script>
</body>
</html>