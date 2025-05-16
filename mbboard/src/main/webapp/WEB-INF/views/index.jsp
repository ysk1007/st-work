<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>전체</h2>
	<table border="1">
		<tr>
			<th>전체</th>
			<th>멤버</th>
			<th>관리자</th>
		</tr>
		<tr>
			<td>${connectCountAll.ANONYMOUS}</td>
			<td>${connectCountAll.MEMBER}</td>
			<td>${connectCountAll.ADMIN}</td>
		</tr>
	</table>
	
	<h2>현재 서버의 접속자 수:${currentConnectCount}
	</h2>

	<h2>오늘</h2>
		<table border="1">
		<tr>
			<th>전체</th>
			<th>멤버</th>
			<th>관리자</th>
		</tr>
		<tr>
			<td>${connectCountToday.ANONYMOUS}</td>
			<td>${connectCountToday.MEMBER}</td>
			<td>${connectCountToday.ADMIN}</td>
		</tr>
	</table>
	
</body>
</html>