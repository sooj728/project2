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
<title>회원가입</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>
	<%@ include file="../header.jsp"%>
	
<div class = "container">
	<h2>글 보기</h2>
	<form action="JoinUsertbCtrl" method="post" name="frm">
	<table class = "table">
		<tr>
			<th class="item1">아이디</th>
			<td class="item1"><input type="text" name="usertbid" required ></td>
		</tr>
		<tr>
			<th class="item2">비밀번호</th>
			<td class="item2"><input type="password" name="pw" required ></td>
		</tr>
		<tr>
			<th class="item2">비밀번호확인</th>
			
			<td class="item2"><input type="password" name="pw2"></td>
		</tr>
		<tr>
			<th class="item3">이름</th>
			<td class="item3"><input type="text" name="uname"></td>
		</tr>
		<tr>
			<th class="item4">이메일</th>
			<td class="item4"><input type="email" name="email"></td>
		</tr>
		<tr>
			<th class="item5">질문</th>
			<td class="item5"><input type="text" name="q"></td>
		</tr>
		<tr>
			<th class="item6">답</th>
			<td class="item6"><input type="text" name="a"></td>
		</tr>
		<tr>
			<th class="item7">우편번호</th>
			<td class="item7"><input type="text" name="add1"></td>
			<td><input type="button" value="주소찾기" onclick="findAddr()" /></td>	
		</tr>
			<tr>
			<th class="item7">주소</th>
			<td class="item7"><input type="text" name="add2"></td>
		</tr>
	</table>
	<input type="submit" class ="btn btn-default" value="가입"/>
</form>	
	<!-- 버튼 그룹 -->
	<div class="btn-group">
	<a href="index.jsp" class="btn btn-default">메인 화면으로</a>
	</div>
</div>
<%@ include file="../footer.jsp" %>
	<!-- 회원가입시 바뀐 형식의 주소 및 우편번호 취급 처리 스크립트 -->
    <script>
       //다음카카오의 주소 API이용
        function findAddr(){
            new daum.Postcode({
                oncomplete: function(data) {
                    console.log(data);                   
                    var roadAddr = data.roadAddress; // 도로명 주소 변수
                    var jibunAddr = data.jibunAddress; // 지번 주소 변수
                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('add1').value = data.zonecode;
                    if(roadAddr !== ''){
                        document.getElementById("add2").value = roadAddr;
                    } 
                    else if(jibunAddr !== ''){
                        document.getElementById("add2").value = jibunAddr;
                    }
                }
            }).open();
        }
    </script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
	<!-- 아이디 중복 체크 및 유효성 검증 체크 스크립트 -->
	<script>
	function joinCheck(f){
		if(f.cuspw.value!=f.cuspw2.value) {
			alert("비밀번호와 비밀번호 확인이 서로 다릅니다.");
			return false;
		}
	}
	</script>
</body>
</html>