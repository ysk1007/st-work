<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style>
	body {
		background-color: #f0f2f5;
	}
	.card {
		border-radius: 1rem;
		box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	}
</style>
</head>

<body>

<!-- 로그인이 안되어 있다면 -->
<c:if test="${loginMember == null}">
	<div class="container d-flex align-items-center justify-content-center" style="min-height: 100vh;">
		<div class="col-md-5">
			<div class="card p-4">
				<h3 class="text-center mb-4">로그인</h3>
				
				<!-- 메시지 영역 -->
				<c:if test="${not empty message}">
					<div class="alert alert-warning text-center" role="alert">
						${message}
					</div>
				</c:if>

				<form id="memberForm" name="member" method="post" action="/login">
					<div class="mb-3">
						<label for="memberId" class="form-label">아이디</label>
						<input type="text" class="form-control" id="memberId" name="memberId" required>
					</div>
					
					<div class="mb-3">
						<label for="memberPw" class="form-label">비밀번호</label>
						<input type="password" class="form-control" id="memberPw" name="memberPw" required>
					</div>
					
					<div class="d-grid gap-2">
						<button id="loginBtn" type="button" class="btn btn-primary">로그인</button>
						<a href="/joinMember" class="btn btn-outline-secondary">회원가입</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</c:if>

<script>
	$('#loginBtn').click(function() {
		$('#memberForm').submit();
	});
</script>

</body>
</html>
