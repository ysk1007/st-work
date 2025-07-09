<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	
	<form action="/modifyUserAction" method="post" id="userDto" name="userDto">
		<input type="hidden" id="username" name="username" value="${loginUserName}"> <br>
		현재 비밀번호 : <input type="password" id="password" name="password"> <br>
		새로운 비밀번호 : <input type="password" id="newPassword" name="newPassword"> <br>
		<button type="submit">수정</button>
	</form>
	<a href="/home">홈으로</a>
</body>
</html>