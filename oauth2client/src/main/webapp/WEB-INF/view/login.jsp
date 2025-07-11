<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>예약 로그인</title>
	<!-- Bootstrap 5 CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

	<style>
		body {
			background-color: #f8f9fa;
		}
		.login-container {
			max-width: 500px;
			margin: 120px auto;
			padding: 40px;
			background-color: white;
			border-radius: 20px;
			box-shadow: 0 5px 20px rgba(0, 0, 0, 0.1);
		}
		.oauth-btn {
			display: flex;
			align-items: center;
			justify-content: flex-start;
			font-size: 1.1rem;
			font-weight: 500;
			padding: 12px 16px;
			background-color: white;
			border: 2px solid;
			border-radius: 10px;
		}
		.oauth-btn img {
			width: 24px;
			height: 24px;
			margin-right: 8px;
		}
		.naver-btn {
			border-color: #03c75a;
			color: #03c75a;
		}
		.naver-btn:hover {
			background-color: #e9f9f1;
		}
		.kakao-btn {
			border-color: #FEE500;
			color: #3c1e1e;
		}
		.kakao-btn:hover {
			background-color: #fff8d1;
		}
		.google-btn {
			border-color: #4285F4;
			color: #4285F4;
		}
		.google-btn:hover {
			background-color: #eaf1fd;
		}
	</style>
</head>
<body>

	<div class="login-container text-start">
		<h3 class="mb-4 text-center fw-bold">윤식당 예약 서비스</h3>

		<a href="/oauth2/authorization/naver" class="btn oauth-btn naver-btn w-100 mb-3">
			<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/Naver_logo_initial.svg/640px-Naver_logo_initial.svg.png" alt="Naver">
			네이버로 예약하기
		</a>

		<a href="/oauth2/authorization/google" class="btn oauth-btn google-btn w-100 mb-3">
			<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Google_%22G%22_logo.svg/640px-Google_%22G%22_logo.svg.png" alt="Google">
			구글로 예약하기
		</a>

		<a href="/oauth2/authorization/kakao" class="btn oauth-btn kakao-btn w-100">
			<img src="https://upload.wikimedia.org/wikipedia/commons/e/e3/KakaoTalk_logo.svg" alt="Kakao">
			카카오로 예약하기
		</a>
	</div>

	<!-- Bootstrap JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
