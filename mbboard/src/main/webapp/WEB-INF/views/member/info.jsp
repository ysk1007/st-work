<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 Info</title>

<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style>
	body {
		background-color: #f8f9fa;
	}
	.card {
		border-radius: 1rem;
		box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	}
</style>
</head>

<body>
	<div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
		<div class="col-md-6">
			<div class="card p-4">
				<h3 class="text-center mb-4">
					${loginMember.memberId}님 상세정보
				</h3>

				<ul class="list-group mb-4">
					<li class="list-group-item">
						<strong>역할 :</strong> ${loginMember.memberRole}
					</li>
				</ul>

				<div class="d-flex justify-content-between">
					<a href="/member/updatePw" class="btn btn-outline-warning">비밀번호 수정</a>
					<a href="/login" class="btn btn-outline-secondary">홈으로</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
