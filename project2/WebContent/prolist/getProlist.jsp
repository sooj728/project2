<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.ArrayList" %>    
<%@ page import = "com.shop.model.ProlistVO" %>    
<%@ page import = "com.shop.biz.ProlistDAO" %>   
<%@ page import = "com.shop.view.AdminGetProlistCtrl" %>        
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
<%
	ProlistVO prolist = (ProlistVO) request.getAttribute("prolist");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>상품목록(사용자)</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
	body, html { width: 100%; }
    ul { list-style: none; }
    a { text-decoration: none; }
    .proview li {text-align:center }  
    main {margin-top:100px; }
	
</style>
<body>
	
	
<div class = "wrapper">
	<%-- <%@ include file="../header.jsp"%> --%>
	  <div class="main">
		<div class="product">
			<h2>제품 보기</h2>
			<ul class="proview">
				<li><img src="${prolist.getImg() }" alt="책" /></li>
				<li>제품명: ${prolist.getPname() }</li>
				<li>남은수량: ${prolist.getCnt() }</li>
				<li>가격: ${prolist.getPrice() }</li>
			</ul>
		</div>
			<div class="orderform">
				<form action="payment.jsp" method="post" name="frm" onclick="return cpCheck(this)">
					<label for="prolisstid"></label>
					<input type="hidden" name ="prolistid" id ="prolistid" value="${prolist.getProlistid() }" readonly />
					<label for="u_id"></label>
					<input type="hidden" name ="u_id" id ="u_id" value="${session.getAttribute('u_id') }" readonly />
					<label for="pname"></label>
					<input type="hidden" name="pname" id="pname" value ="${prolist.getPname() }" readonly  />
					<label for="price"></label>
					<input type="hidden" name="price" id="price" value ="${prolist.getPrice() }" readonly  />
					<label for="cnt">주문수량: </label>
					<input type="number" name ="cnt" id ="cnt" min="1" max="${prolist.getCnt() }" value="1"   />
					<label for="cpuse">10% 할인쿠폰을 사용할까요? </label>
					<input type="checkbox" name ="cpuse" id="cpuse" />
					<label for="cp">보유쿠폰 개수: </label>
					<input type="number" name="cp" id="cp" value="${session.getAttribute('cp') }" readonly />
					<input type="submit" class ="btn btn-primary" value="구매"/>
					<input type="reset" class ="btn btn-primary" value="취소"/>
				</form>	
			</div>
	<!-- 버튼 그룹 -->
	<div class="btn-group">
	<a href="./InsertOrderBasketCtrl?Prolistid=${prolist.getProlistid() }&usertbid=${session.getAttribute('u_id') }" class="btn btn-primary">장바구니 담기</a>
	<a href="./GetProlistListCtrl" class="btn btn-primary">상품목록</a>
	</div>
  </div>
</div>
<%@ include file="../footer.jsp" %>
<!-- <script>
	function cpCheck(f){
		if(f.cp.value != 0) {
				f.submit();
		} else {
			alert("보유쿠폰이 부족합니다.");
			return false;
		}
		return false;
	}
</script> -->
</body>
</html>