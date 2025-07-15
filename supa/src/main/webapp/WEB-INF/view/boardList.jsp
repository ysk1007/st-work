<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드 리스트</title>
</head>
<body>
	<h1>보드 리스트</h1>
	<a href="/addBoard">글쓰기</a>
	<c:if test="${boardList != null}">
		<table border = "1">
			<tr>
				<th>#</th><th>제목</th><th>생성일</th><th>수정</th><th>삭제</th>
			</tr>
			<c:forEach items="${boardList}" var="b">
				<tr>
					<td>${b.id}</td><td>${b.title}</td><td>${b.createAt}</td>
					<td><a href="/editBoard?id=${b.id}">수정</a></td>
					<td><a href="/deleteBoard?id=${b.id}">삭제</a></td>
				</tr>
			</c:forEach>
		</table>	
	</c:if>
	
	<c:if test="${boardList == null}">
		게시글이 없습니다.
	</c:if>
</body>
</html>