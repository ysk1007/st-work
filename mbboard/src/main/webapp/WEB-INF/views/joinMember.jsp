<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
				<h3 class="text-center mb-3">회원가입</h3>
				<div class="text-end mb-3">
					<a href="login" class="btn btn-sm btn-outline-primary">뒤로</a>
				</div>

				<form id="memberForm" name="member" method="post" action="/joinMember">
					<!-- 아이디 입력 -->
					<div class="mb-3">
						<label for="memberId" class="form-label">아이디</label>
						<div class="input-group">
							<input type="text" class="form-control" id="memberId" name="memberId">
							<button id="idCheck" type="button" class="btn btn-secondary">중복 검사</button>
						</div>
						<span id="isAble" class="form-text"></span>
					</div>

					<!-- 비밀번호 입력 -->
					<div class="mb-3">
						<label for="memberPw" class="form-label">비밀번호</label>
						<input type="password" class="form-control" id="memberPw" name="memberPw">
					</div>

					<!-- 비밀번호 확인 -->
					<div class="mb-3">
						<label for="checkPw" class="form-label">비밀번호 확인</label>
						<input type="password" class="form-control" id="checkPw" name="checkPw">
						<span id="isEqual" class="form-text"></span>
					</div>

					<!-- 회원가입 버튼 -->
					<div class="d-grid">
						<button id="joinBtn" type="button" class="btn btn-primary">회원가입</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
		let isIdAvailable = false;
		const isAble = $('#isAble');
		const isEqual = $('#isEqual');
		const memberId = $('#memberId');
		const memberPw = $('#memberPw');
		const checkPw = $('#checkPw');
		const joinBtn = $('#joinBtn');

		// 중복 검사 버튼 클릭
		$('#idCheck').click(function(){
			checkId();
		})

		// 비밀번호 확인
		checkPw.keyup(function(){
			equalPw();
		})

		// 비밀번호 확인
		function equalPw(){
			if(checkPw.val() != memberPw.val()){
				isEqual.text('비밀번호를 확인 하세요.');
				isEqual.css('color','red');
				return false;
			}
			else{
				isEqual.text('');
				return true;
			}
		}

		// 아이디 중복 검사
		function checkId(){
			$.ajax({
				url:'/isId/' + memberId.val()
				, type:'get'
				, success: function(data){
					if(data){	// 아이디 사용 불가
						isAble.text('이미 아이디가 존재 합니다.');
						isAble.css('color','red');
						isIdAvailable = false;
					}
					else{		// 아이디 사용 가능
						isAble.text('사용 가능한 아이디 입니다.');
						isAble.css('color','green');
						isIdAvailable = true;
					}
				}
			})
		}

		// 회원가입 버튼 클릭
		$('#joinBtn').click(function(){
			checkId(); // 비동기이므로 타이밍 문제가 생길 수 있음
			setTimeout(function() {
				if(!isIdAvailable){
					alert('아이디를 확인하세요.');
					return;
				}

				if(equalPw() == false){
					alert('비밀번호가 다릅니다.');
					return;
				}

				alert("회원가입이 완료되었습니다.");
				$('#memberForm').submit();
			}, 300); // 약간의 대기 추가
		})
	</script>
</body>
</html>
