<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/modifyPw">비밀번호 수정</a>
	<c:if test="${not empty memberList}">
		<table border="1">
		
			<tr>
				<th>아이디</th>
				<th>이메일</th>
				<th>계정 상태</th>
			</tr>
			<c:forEach var="member" items="${memberList}">
			<tr>
				<td>${member.id}</td>
				<td>${member.email}</td>
				<td>${member.active}</td>
			</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>