<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>boardList</h1>
	<a href="addBoard">추가</a>
	<table border="1">
		<tr>
			<td>#</td>
			<td>제목</td>
		</tr>
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.boardNo}</td>
				<td><a href="/boardOne?boardNo=${board.boardNo}">${board.boardTitle}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>