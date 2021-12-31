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
<title>Pw찾기(2/2)</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>
	<%@ include file="../header.jsp"%>
	
<div class = "container">
	<h2>Pw 찾기(2/2)</h2>
	<form action="../GetFindPwCtrl" method="post" name="frm">
	<table class = "table">
		<tr>
			<th class="item1">가입시 입력하신 질문입니다.</th>
			<td class="item1"><input type="text" name="q" value="${usertb.getQ() }" readonly ></td>
		</tr>
		<tr>
			<th class="item2">질문에 대한 답을 입력하세요.</th>
			<td class="item2"><input type="text" name="a" required ></td>
		</tr>
	</table>
	<input type="hidden" name="usertbid" value="${usertb.getUsertbid() }" />
	<input type="submit" class ="btn btn-default" value="PW찾기" />
</form>	
	<!-- 버튼 그룹 -->
	<div class="btn-group">
	<a href="index.jsp" class="btn btn-default">메인 화면으로</a>
	</div>
</div>
<%@ include file="../footer.jsp" %>

	
</body>
</html>