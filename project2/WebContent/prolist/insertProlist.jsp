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
<title>상품 입력</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>
	<%@ include file="../header.jsp"%>
	
<div class = "container">
	<h2>상품 입력</h2>
	<form action="../InsertProlistCtrl" method="post" name="frm">
	<table class = "table">
		<tr>
			<th class="item1">상품명</th>
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
	<input type="submit" class ="btn btn-default" value="완료"/>
	<a href="GetProlistListCtrl" class="btn btn-default">목록</a>
	<a href="DeleteProlistListCtrl?prolistid=<%=prolist.getProlistid() %>" class="btn btn-default">글 삭제</a>
	<button class="btn btn-default" onclick="function1(<%=prolist.getProlistid() %>)" ></button>
	</div>
</div>
<%@ include file="../footer.jsp" %>
<script>
	function1() {
		if(confirm("정말로 삭제할까요?")) {
			location.href="DeleteProlistCtrl?prolistid="+data;
		} else {
			return false;
		}
	}
</script>
</body>
</html>