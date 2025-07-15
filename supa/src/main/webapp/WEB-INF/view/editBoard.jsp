<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<h1>수정</h1>
	<a href="/">뒤로</a><br>
	<form action="/editBoard" method="post" id="boardDto" name="boardDto">
		<input type="hidden" name="id" id="id" value="${board.id}">
		제목 : <input type="text" name="title" id="title" value="${board.title}"><br>
		<button type="submit">수정</button>
	</form>
</body>
</html>