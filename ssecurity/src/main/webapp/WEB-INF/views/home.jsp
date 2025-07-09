<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>home</h1>
	사용자 이름 : ${loginUserName}
	<div>
		<a href="/logout">로그아웃</a>
		<a href="/modifyUser">회원정보수정</a>
		<a href="/deleteUser">회원탈퇴</a>
	</div>
</body>
</html>