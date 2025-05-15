<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 수정</title>

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
	<!-- 비밀번호 수정 페이지 전체 레이아웃 -->
	<div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
		<div class="col-md-6">
			<div class="card p-4">
				<h3 class="text-center mb-4">비밀번호 수정</h3>

				<!-- 뒤로 가기 링크 -->
				<div class="mb-3 text-end">
					<a href="/member/info" class="btn btn-outline-secondary btn-sm">뒤로</a>
				</div>

				<!-- 비밀번호 수정 폼 -->
				<form id="memberForm" name="member" method="post" action="/member/updatePw">
					<!-- 로그인된 사용자 ID (hidden 처리) -->
					<input type="hidden" id="memberId" name="memberId" value="${loginMember.memberId}">

					<!-- 기존 비밀번호 입력 -->
					<div class="mb-3">
						<label for="memberPw" class="form-label">기존 비밀번호</label>
						<input type="password" class="form-control" id="memberPw" name="memberPw" required>
					</div>

					<!-- 새로운 비밀번호 입력 -->
					<div class="mb-4">
						<label for="newPw" class="form-label">새로운 비밀번호</label>
						<input type="password" class="form-control" id="newPw" name="newPw" required>
					</div>

					<!-- 수정 버튼 -->
					<div class="d-grid">
						<button id="updateBtn" type="button" class="btn btn-primary">비밀번호 수정</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
		// 변수 정의
		const isEqual = $('#isEqual');
		const memberId = $('#memberId');
		const memberPw = $('#memberPw');
		const newPw = $('#newPw');
		const updateBtn = $('#updateBtn');

		// 아이디 + 기존 비밀번호 확인
		function equalPw(){
			$.ajax({
				url: '/equalPw',
				type: 'post',
				contentType: 'application/json',
				data: JSON.stringify({
					memberId: memberId.val(),
					memberPw: memberPw.val()
				}),
				success: function(data){
					if(data){	// 아이디 + 비밀번호 일치
						alert("비밀번호 수정이 완료되었습니다.");
						$('#memberForm').submit();
						return;
					} else {	// 일치하지 않음
						alert('기존 비밀번호가 다릅니다.');
						return;
					}
				}
			});
		}

		// 수정 버튼 클릭 이벤트
		updateBtn.click(function(){
			equalPw();
		});
	</script>
</body>
</html>
