<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h1>글쓰기</h1>
	<a href="/">뒤로</a><br>
	<form action="/addBoard" method="post" id="boardDto" name="boardDto">	
		제목 : <input type="text" name="title" id="title"><br>
		<button type="submit">작성</button>
	</form>
</body>
</html>