<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.ArrayList" %>    
<%@ page import = "com.shop.model.*" %>    
<%@ page import = "com.shop.biz.*" %>   
<%@ page import = "com.shop.view.*" %>    

<%
	String cpuse = request.getParameter("cpuse");
	String pname = request.getParameter("pname");
	int cnt = Integer.parseInt(request.getParameter("cnt"));
	int price = Integer.parseInt(request.getParameter("price"));
	String prolistid = request.getParameter("prolistid");
	int sum = cnt*price;
	if (cpuse!=null) {
		sum=(int)(sum*0.9);
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 창</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="jquery-latest.js"></script>
<link rel="stylesheet" href="datatables.min.css"/>
<script src="datatables.min.js"></script>
<script src="masonry.pkgd.min.js"></script> 
<script src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
<div class="container">
	<%-- <%@ include file="header.jsp" %> --%>
	<form action="InsertBuyCtrl" method="post" onsubmit="return payCheck(this)">
		<input type="hidden" name="price" id="price" value="<%=price %>"/>
		<input type="hidden" name="complete" id="complete" value="no" />
		<input type="hidden" name="cpuse" id="cpuse" value=""/>
		<input type="hidden" name="prolistid" id="prolistid" value="<%=prolistid %>" />
		<table class="table">
			<tbody>
				<tr>
					<th><label for="uid">결제자 아이디</label></th>
					<td><input type="text" name="cusid" id="cusid" value="${session.getAttribute('u_id') }" readonly/></td>
				</tr>
				<tr>
					<th><label for="uname">결제자 이름</label></th>
					<td>
						<input type="text" name="buyer" id="buyer" value="${session.getAttribute('uname') }" readonly/>
					</td>
				</tr>
				<tr>
					<th><label for="email">이메일</label></th>
					<td><input type="text" name="email" id="email" value="${session.getAttribute('email') }" required /></td>
				</tr>
				<tr>
					<th><label for="tel">연락처</label></th>
					<td><input type="text" name="tel" id="tel" placeholder="- 를 제외하고 입력" autofocus required /></td>
				</tr>
				<tr>
					<th><label for="addr">배송지 주소</label></th>
					<td>
							<input type="text" name="add2" id="add2" value="${session.getAttribute('add2') }" required />
							<input type="text" name="add3" id="add3" required /><br>
					</td>
				</tr>
				<tr>
					<th><label for="buyer_addr">요청사항</label></th>
					<td>
							<input type="text" name="note" id="note" />
					</td>
				</tr>
				<tr>
					<th><label for="add1">배송지 우편번호</label></th>
					<td><input type="text" name="add1" id="add1" value="${session.getAttribute('add1') }" required />
							<input type="button" value="주소찾기" onclick="findAddr()" class="btn btn-primary"/>
					</td>
				</tr>
				<tr>
					<th><label for="pname">배송상품</label></th>
					<td>
						<input type="hidden" name="pname" id="pname" value="<%=pname %>"/>
						<input type="text" name="proname" id="proname" value="${prolist.getPname() }" readonly />
					</td>
				</tr>
				<tr>
					<th><label for="cnt">주문수량</label></th>
					<td><input type="text" name="cnt" id="cnt" value="<%=cnt %>" readonly /></td>
				</tr>
				<tr>
					<th><label for="sum">결제할 금액</label></th>
					<td><input type="text" name="sum" id="sum" value="<%=sum %>" readonly /></td>
				</tr>
				<tr>
					<th><label for="paytype">결제방식</label></th>
					<td>
						<select name="paytype" id="paytype">
							<option value="카드">카드</option>
							<option value="계좌이체">계좌이체</option>
<!-- 							<option value="포인트결제">포인트 결제</option>
							<option value="지역화폐">지역화폐</option> -->
						</select>
					</td>
				</tr>
				<tr>
					<th><label for="payprop">결제 번호</label></th>
					<td>
					    <select name="payprop" id="payprop">	
				            <optgroup label="카드" id="payprop0" data-a="0">
				                <option value="신한카드">신한카드</option>
				                <option value="농협카드">농협카드</option>
				                <option value="우리카드">우리카드</option>
				                <option value="롯데카드">롯데카드</option>
				                <option value="현대카드">현대카드</option>
				                <option value="아메리칸익스프레스">아메리칸익스프레스</option>
				                <option value="하나카드">하나카드</option>
				            </optgroup>
				            <optgroup label="계좌이체" id="payprop1" data-a="1">
				                <option value="우리은행" data-val="002-279121-18-311">우리은행</option>
				                <option value="국민은행" data-val="119590-12-799819">국민은행</option>
				                <option value="하나은행" data-val="464-908739-14037">하나은행</option>
				                <option value="외한은행" data-val="921-043726-639">외한은행</option>
				                <option value="시티은행" data-val="453-57359-926-04">시티은행</option>
				                <option value="신한은행" data-val="249-90128-912310">신한은행</option>
				                <option value="농협은행" data-val="108207-64-391366">농협은행</option>
				                <option value="기업은행" data-val="594-166721-97-361">기업은행</option>
				                <option value="우체국" data-val="820833-80-633870">우체국</option>
				                <option value="카카오뱅크" data-val="3333-1234-4321-12">카카오뱅크</option>
				                <option value="토스뱅크" data-val="272-3421-3723-927">토스뱅크</option>
				            </optgroup>
					</select>
				    -
	            	<span id="paymsg1">입금할 계좌 : </span>
	            	<input type="text" name="creditnum" id="creditnum" data-b="0" value="" size="60" required />
	            	<span id="paymsg2">, 예금주 : OO쇼핑</span>
		            <input type="text" name="credipw" id="credipw" data-c="0" value="" size="20" placeholder="카드 비밀번호 입력"/>
					</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="결제완료" class="btn btn-primary"/>
		<input type="reset" value="결제취소" class="btn btn-primary"/>
		<button id="check_module" type="button" class="btn btn-primary">결제하기</button>
	</form>
</div>
<script>
		$(function(){
			var t = "0";
			$("optgroup[data-a]").css("display", "none");
			$("#paytype").change(function(){
				t = $(this).val();
				if(t=="카드"){
					$("#payprop0").css("display","block");
					$("#payprop1").css("display","none");
				} else {
					if(t=="계좌이체"){
						$("#payprop1").css("display","block");
						$("#payprop0").css("display","none");
					}
				}
			}).change();
			$("#paymsg1, #paymsg2").css("display","none");
			$("#payprop").change(function(){
				if(t=="계좌이체"){
					$("#creditnum").attr("placeholder","");
					$("#paymsg1, #paymsg2").css("display","inline-block");					
					$("#creditnum").val($(this).val()+", "+($(this).find("option:selected").attr("data-val")));
					$("#creditnum").prop("readonly","true");
					$("#credipw").css("display","none");
				} else {
					$("#creditnum").val("");
					$("#paymsg1, #paymsg2").css("display","none");
					$("#creditnum").removeProp("readonly");
					$("#creditnum").attr("placeholder","결제할 카드번호를 입력하세요");
					$("#credipw").css("display","inline-block");
				}
			});
		});
		</script>
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
	<script>
	function payCheck(f){
		if(f.complete.value == "yes") {
				f.submit();
		} else {
			alert("결제하기를 하지 않으셨습니다.");
			return false;
		}
		return false;
	}
	</script>
	<script>
	$("#check_module").click(function () {
		$("#complete").val("yes");
		if($("#email").val == "" || $("#u_id").val == "" || $("#tel").val == "" || $("#add1").val == "") {
			alert("결제자에 대한 정보가 모두 입력되지 않았습니다.");
			return false;
		} else {
			$("#complete").val("yes");
		}
		var IMP = window.IMP; // 생략가능
		IMP.init('가맹점식별코드를 넣어주세요');
		// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
		// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
		IMP.request_pay({
		pg: 'inicis', // version 1.1.0부터 지원.
		/*
		'kakao':카카오페이,
		html5_inicis':이니시스(웹표준결제)
		'nice':나이스페이
		'jtnet':제이티넷
		'uplus':LG유플러스
		'danal':다날
		'payco':페이코
		'syrup':시럽페이
		'paypal':페이팔
		*/
		pay_method: 'card',
		/*
		'samsung':삼성페이,
		'card':신용카드,
		'trans':실시간계좌이체,
		'vbank':가상계좌,
		'phone':휴대폰소액결제
		*/
		merchant_uid: 'merchant_' + new Date().getTime(),
		/*
			merchant_uid에 경우
		https://docs.iamport.kr/implementation/payment
		위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
		참고하세요.
		*/
		name: '주문명:결제테스트',
		//결제창에서 보여질 이름
		amount: $("#sum").val(),
		//가격
		buyer_email: $("#email").val(),
		buyer_name: $("#u_id").val(),
		buyer_tel: $("#tel").val(),
		buyer_addr: $("#add2").val(),
		buyer_postcode: $("#add1").val(),
		m_redirect_url: 'https://www.yourdomain.com/payresult.jsp'
		/*
		모바일 결제시,
		결제가 끝나고 랜딩되는 URL을 지정
		(카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
		*/
	}, function (rsp) {
		console.log(rsp);
		if (rsp.success) {
			var msg = '결제가 완료되었습니다.';
			msg += '고유ID : ' + rsp.imp_uid;
			msg += '상점 거래ID : ' + rsp.merchant_uid;
			msg += '결제 금액 : ' + rsp.paid_amount;
			msg += '카드 승인번호 : ' + rsp.apply_num;
		} else {
			var msg = '결제에 실패하였습니다.';
			msg += '에러내용 : ' + rsp.error_msg;
		}
		alert(msg);
		});
	});
	</script>
	<%@ include file="footer.jsp" %>
</body>
</html>