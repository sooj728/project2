<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.ArrayList" %>    
<%@ page import = "com.shop.model.UsertbVO" %>    
<%@ page import = "com.shop.biz.UsertbDAO" %>   
<%@ page import = "com.shop.controller.JoinUsertbCtrl" %>
    
<%
	UsertbVO Usertb = (UsertbVO) request.getAttribute("Usertb");
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
<%   
		String mid = (String) session.getAttribute("mid");
		if (mid==null) {
%>
			<%@ include file="../header.jsp" %>
<%
		} else {
			response.sendRedirect("../index.jsp");
		} 
%>

	
<div class = "container">
	<h2>회원가입</h2>
	<form action="../InsertUsertbCtrl" method="post" name="jonform" onsubmit="return joinCheck(this)">
	<table class = "table">
		<tr>
			<th class="item1">아이디</th>
			<td class="item1">
				<input type="text" name="mid" id="mid" value="" required>
				<input type="button" value="중복확인" class="pushdata" onclick="idCheck()">
				<input type="hidden" name="passbtn1" id="passbtn1">
			</td>
		</tr>
		<tr>
			<th class="item2">비밀번호</th>
			<td class="item2"><input type="password" name="pw" id="pㅈ" value="" required/></td>
		</tr>
		<tr>
			<th class="item2">비밀번호확인</th>
			<td class="item2"><input type="password" name="pw2" id="pw2" value="" required/></td>
		</tr>
		<tr>
			<th class="item3">이름</th>
			<td class="item3"><input type="text" name="name" id="name" value="" required/></td>
		</tr>
		<tr>
			<th class="item4">이메일</th>
			<td class="item4">
				<input type="text" name="email" id="email" value="" pattern="\w+@\w+\.\w+" required/>
				<input type="button" value="중복확인" class="pushdata" onclick="emailCheck()">
				<input type="hidden" name="passbtn2" id="passbtn2">
			</td>
		</tr>
		<tr>
			<th class="item5">우편번호</th>
			<td class="item5">
			<input type="text" name="postcode" id="postcode"  class="indata"/>
			<input type="button" value="주소찾기" onclick="findAddr()" class="pushdata"/>
			</td>
		</tr>
		<tr>
			<th class="item6">주소</th>
			<td class="item6"><input type="text" name="address" id="address"  class="indata"/></td>
		</tr>	
	</table>
	
</form>
	<!-- 버튼 그룹 -->
	<div class="btn-group">
	<input type="submit" class ="btn btn-default" value="회원가입"/>
	</div>
</div>
<%@ include file="../footer.jsp" %>
<script>
	//다음카카오의 주소 API 이용
        function findAddr(){
            new daum.Postcode({
                oncomplete: function(data) {
                    console.log(data);                   
                    var roadAddr = data.roadAddress; // 도로명 주소 변수
                    var jibunAddr = data.jibunAddress; // 지번 주소 변수
                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('postcode').value = data.zonecode;
                    if(roadAddr !== ''){
                        document.getElementById("address").value = roadAddr;
                    } 
                    else if(jibunAddr !== ''){
                        document.getElementById("address").value = jibunAddr;
                    }
                }
            }).open();
        }
    </script>
	<script src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	function idCheck() { 
		window.open("../idCheckForm.jsp","idwin","width:400, height:620")
	}
	function emailCheck() {
		window.open("../emailCheckForm.jsp","emailwin","width:400, height:620")
	}
	function joinCheck(f) {
		if (f.passbtn1.value!="yes") {
			alert("아이디 중복 검사를 해주세요");
			return false;
		}
		if(f.pw.value!=f.pw2.value) {
			alert("비밀번호와 비밀번호 확인을 일치시키세요")
			return false;
		}
		if (f.passbtn2.value!="yes") {
			alert("이메일 중복 검사를 해주세요");
			return false;
		}
	}

	</script>

</body>
</html>