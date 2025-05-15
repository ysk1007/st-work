<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 홈</title>

<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style>
	body {
		background-color: #f8f9fa;
	}
	.navbar-custom {
		background-color: #0d6efd;
	}
	.navbar-custom .nav-link, .navbar-custom .navbar-brand {
		color: white;
	}
	.card {
		border-radius: 1rem;
		box-shadow: 0 4px 12px rgba(0,0,0,0.05);
	}
</style>
</head>

<body>

<!-- 네비게이션 바 -->
<nav class="navbar navbar-expand-lg navbar-custom">
	<div class="container-fluid">
		<span class="navbar-brand">${loginMember.memberId}님 반갑습니다</span>
		<div class="ms-auto">
			<a class="nav-link d-inline" href="/logout">로그아웃</a>
			<c:if test="${loginMember.memberRole == 'ADMIN' }">
				<a class="nav-link d-inline" href="/admin/adminHome">멤버관리</a>
			</c:if>
			<a class="nav-link d-inline" href="/member/info">회원정보</a>
		</div>
	</div>
</nav>

<!-- 본문 -->
<div class="container mt-5">
	<div class="row justify-content-center">
		<div class="col-md-8">
			<div class="card text-center">
				<div class="card-body">
					<h4 class="card-title">환영합니다, ${loginMember.memberId}님!</h4>
					<p class="card-text">이 페이지는 로그인한 멤버의 홈입니다.</p>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>
