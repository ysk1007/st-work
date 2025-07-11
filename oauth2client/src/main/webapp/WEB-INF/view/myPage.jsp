<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My 페이지</title>

<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	.card-container {
		max-width: 800px;
		margin: 50px auto;
	}
	.profile-box {
		background-color: #f8f9fa;
		border-radius: 10px;
		padding: 20px;
		box-shadow: 0 4px 10px rgba(0,0,0,0.05);
	}
	.reservation-card {
		margin-top: 20px;
	}
</style>
</head>
<body class="bg-light">

<div class="container card-container">
	<div class="profile-box text-center mb-4">
		<h2 class="mb-3">My 페이지</h2>
		<p class="lead mb-1"><strong>${loginUsername}</strong> 님 반갑습니다!</p>
		<p class="text-muted mb-2">계정 : <span class="badge bg-secondary">${role}</span></p>
		<a href="/reservationList" class="btn btn-outline-success mt-2">예약하기</a>
		<a href="/logout" class="btn btn-outline-danger mt-2">로그아웃</a>
	</div>

	<!-- 예약 목록 -->
	<c:if test="${list != null}">
		<h4 class="mb-3">📋 예약 내역</h4>
		<c:forEach items="${list}" var="rv">
			<div class="card reservation-card shadow-sm">
				<div class="card-body">
					<h5 class="card-title">예약 번호: ${rv.reservationNo}</h5>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">방 번호: <strong>${rv.roomNo}</strong></li>
						<li class="list-group-item">방 이름: <strong>${rv.roomName}</strong></li>
						<li class="list-group-item">📅 예약 날짜: <strong>${rv.reservationDate}</strong></li>
						<li class="list-group-item">⏰ 시간: <strong>${rv.rservationOption}</strong></li>
						<li class="list-group-item">📝 예약 방법: <strong>${rv.rservationId}</strong></li>
						<li class="list-group-item">👥 예약 인원: <strong>${rv.rservationCount}</strong>명</li>
					</ul>
				</div>
			</div>
		</c:forEach>
	</c:if>

	<c:if test="${list == null || list.isEmpty()}">
		<div class="alert alert-warning text-center mt-4" role="alert">
			예약 내역이 없습니다.
		</div>
	</c:if>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
