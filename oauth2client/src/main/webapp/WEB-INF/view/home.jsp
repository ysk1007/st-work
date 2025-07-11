<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>윤식당 예약</title>

<!-- Bootstrap 5 CSS CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	body {
		background-color: #f8f9fa;
	}
	.container-box {
		max-width: 500px;
		margin-top: 100px;
		padding: 30px;
		background-color: #fff;
		border-radius: 15px;
		box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	}
</style>
</head>
<body>

<div class="container d-flex justify-content-center">
	<div class="container-box text-center">
		<h1 class="mb-4">윤식당 예약</h1>
		<hr>
		
		<c:if test="${loginUsername == 'anonymousUser'}">
			<a href="/login" class="btn btn-primary w-100">예약 하기</a>
		</c:if>
		
		<c:if test="${loginUsername != 'anonymousUser'}">
			<a href="/reservationList" class="btn btn-primary w-100">예약 하기</a>
			<a href="/myPage" class="btn btn-success w-100">마이페이지</a>
		</c:if>
	</div>
</div>

<!-- Bootstrap 5 JS (선택) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
