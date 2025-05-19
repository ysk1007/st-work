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
	<h1>새로운 비밀번호로 수정</h1>
	
	<c:if test="${not empty message}">
		<script>
		    let msg = "${message}";
		    alert(msg);
		</script>
	</c:if>
	
	<form method="post" action="/rechangeMemberPw">
		<div>
			아이디 <input type="text" name="memberId">
		</div>
		<div>
			메일로 받은 PW <input type="password" name="memberPw">
		</div>
		<div>
			변경할 PW <input type="password" name="reMemberPw">
		</div>
		<button type="submit">패스워드 변경</button>
	</form>
</body>
</html>