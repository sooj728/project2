<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.ArrayList" %>    
<%@ page import = "com.shop.model.*" %>    
<%@ page import = "com.shop.biz.*" %>   
<%@ page import = "com.shop.view.*" %>
<%
	ArrayList<BoardVO> boardList = (ArrayList<BoardVO>) request.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>게시글 목록</title>
</head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>
	<table>
		<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
			<th>조회수</th>
		</tr>
		</thead>
		<tbody>
			<c:set var="cnt" value="${boardList.size() }" />
			<c:forEach items="${boardList }" var ="board" varStatus="status">
				<tr>
					<td>${cnt }</td>
					<td>
						<a href = "../GetBoardCtrl?num=${board.getNum() }&pageNum=${pageNum }">${board.getSubject() }</a>
					</td>
					<td>${board.getId() }</td>
					<td>${board.getDate() }</td>
					<td>${board.getId() }</td>
				</tr>
				<c:set var="cnt" value="${cnt-1 }" />
			</c:forEach>
		</tbody>
	</table>
		<div class="pageGroup">
		<c:if test="${startPage != 1 }">
			<a href="GetBoardListCtrl?page=${startPage - 1 }">[이전]</a>
		</c:if>
		<c:forEach var="pageNum" begin="${startPage }" end="${endPage }"> 
			<c:if test="${pageNum == sPage }">
				${pageNum }&nbsp;&nbsp;
			</c:if>
			<c:if test="${pageNum != sPage }">
				<a href="GetBoardListCtrl?page=${pageNum }">${pageNum }&nbsp;&nbsp;</a>
			</c:if>
		</c:forEach>
		<c:if test="${endPage != maxPage }">
			<a href="GetBoardListCtrl?page=${endPage + 1 }">[이전]</a>
		</c:if>
	</div>
	<div id ="searchForm">
	  <form>
		<select name = "opt">
			<option value="0">제목</option>
			<option value="1">내용</option>
			<option value="2">제목+내용</option>
			<option value="3">글쓴이</option>
		</select>
		<input type="text" size="20" name="condition" />&nbsp;
		<input type="submit" value="검색" />
	  </form>
	</div>
</body>
</html>