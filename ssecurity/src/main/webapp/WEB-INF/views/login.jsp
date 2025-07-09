<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	
	<form action="/loginAction" method="post" id="userDto" name="userDto">
		아이디 : <input type="text" id="username" name="username"> <br>
		비밀번호 : <input type="password" id="password" name="password"> <br>
		<button type="submit">로그인</button>
	</form>
	<a href="/addUser">회원가입</a>
</body>
</html>