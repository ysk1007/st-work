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
	<form method="post" id="memberForm" name="member" action="/login">
		<div>
			<div>
				아이디 : <input type="text" id="id" name="id">
			</div>
			<div>
				비밀번호 : <input type="password" id="pw" name="pw">
			</div>
		</div>
		<button type="submit">로그인</button>
	</form>
</body>
</html>