<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>메인 화면</title>
	<%@ include file="head.jsp" %>
</head>
<body>
	<div class="wrap">
<%   
		String u_id = (String) session.getAttribute("u_id");
		if (u_id!=null) {
%>
			<%@ include file='tnb2.jsp'%>
<%
		} else {
%>
			<%@ include file='tnb1.jsp'%>
<%
		}
%>
		<%@include file='header.jsp' %>
       <div class="content fix">
           <figure class="vs">
               <ul class="img_box">
                   <li>
                   	     
                       <a href="introduce.jsp">
                           <img src="./img/figure_company.png" alt="회사이미지" class="vs_img">
                           
                       </a>
                       
                   </li>
                   <li>
                   	     
                       <a href="">
                           <img src="./img/figure_child.png" alt="아동도서 목록" class="vs_img">
                       </a>
                       
                   </li>
                   <li>
                   	     
                       <a href="">
                           <img src="./img/figure_coupon.png" alt="쿠폰받기" class="vs_img">
                       </a>
                       
                   </li>
               </ul>
           </figure>
           <script src="./js/ban.js"></script>
           <section class="page fix" id="page1">
               
           </section> 
           <section class="page fix" id="page2">
               
           </section> 
           <section class="page fix" id="page3">
               
           </section>
       </div>
       <%@ include file="footer.jsp" %>
    </div>
</body>
</html>