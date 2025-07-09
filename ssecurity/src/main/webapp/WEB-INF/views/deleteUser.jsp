<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 탈퇴</h1>
	
	<form action="/deleteUserAction" method="post" id="userDto" name="userDto">
		<input type="hidden" id="username" name="username" value="${loginUserName}"> <br>
		비밀번호 : <input type="password" id="password" name="password"> <br>
		<button type="submit">탈퇴</button>
	</form>
	<a href="/home">홈으로</a>
</body>
</html>