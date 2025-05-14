<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body class="bg-light">

<div class="container mt-5">

	<!-- 페이지 제목 -->
	<h1 class="mb-4">글쓰기</h1>

	<!-- 리스트로 돌아가기 버튼 -->
	<div class="mb-3">
		<a href="boardList" class="btn btn-secondary">리스트</a>
	</div>

	<!-- 글쓰기 폼 -->
	<form id="boardForm" name="board" action="insertBoard" method="post" class="card p-4 shadow-sm bg-white">
		<!-- 제목 -->
		<div class="mb-3">
			<label for="boardTitle" class="form-label">제목</label>
			<input type="text" id="boardTitle" name="boardTitle" class="form-control" placeholder="제목">
		</div>

		<!-- 내용 -->
		<div class="mb-3">
			<label for="boardContent" class="form-label">내용</label>
			<textarea cols="60" rows="9" id="boardContent" name="boardContent" class="form-control" placeholder="내용.."></textarea>
		</div>

		<!-- 글쓴이 -->
		<div class="mb-3">
			<label for="boardUser" class="form-label">글쓴이</label>
			<input type="text" id="boardUser" name="boardUser" class="form-control" placeholder="닉네임">
		</div>

		<!-- 제출 버튼 -->
		<button type="button" id="insertBtn" class="btn btn-primary">글쓰기</button>
	</form>
</div>

<!-- 유효성 검사 및 제출 -->
<script>
	const title = $('#boardTitle');
	const content = $('#boardContent'); 
	const user = $('#boardUser'); 
	
	$('#insertBtn').click(function(){
		// 검증
		if(title.val().length < 1){
			alert("제목을 입력하세요");
			return;
		}
		if(content.val().length < 1){
			alert("내용을 입력하세요");
			return;
		}
		if(user.val().length < 1){
			alert("글쓴이를 입력하세요");
			return;
		}
		boardForm.submit();		
	})
</script>

</body>
</html>
