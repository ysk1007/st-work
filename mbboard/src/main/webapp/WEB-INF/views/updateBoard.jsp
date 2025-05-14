<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body class="bg-light">

<div class="container mt-5">

	<!-- 제목 -->
	<h1 class="mb-4">글 수정</h1>

	<!-- 뒤로 가기 버튼 -->
	<div class="mb-3">
		<a href="boardOne?boardNo=${board.boardNo}" class="btn btn-secondary">뒤로</a>
	</div>

	<!-- 수정 폼 -->
	<form id="boardForm" name="board" action="updateBoard" method="post" class="card p-4 shadow-sm bg-white">
		<!-- boardNo hidden -->
		<input type="hidden" id="boardNo" name="boardNo" value="${board.boardNo}">

		<!-- 제목 -->
		<div class="mb-3">
			<label for="boardTitle" class="form-label">제목</label>
			<input type="text" id="boardTitle" name="boardTitle" class="form-control" value="${board.boardTitle}">
		</div>

		<!-- 내용 -->
		<div class="mb-3">
			<label for="boardContent" class="form-label">내용</label>
			<textarea cols="60" rows="9" id="boardContent" name="boardContent" class="form-control">${board.boardContent}</textarea>
		</div>

		<!-- 글쓴이 -->
		<div class="mb-3">
			<label for="boardUser" class="form-label">글쓴이</label>
			<input type="text" id="boardUser" name="boardUser" class="form-control" value="${board.boardUser}">
		</div>

		<!-- 수정 버튼 -->
		<button type="button" id="updateBtn" class="btn btn-primary">수정</button>
	</form>
</div>

<!-- 유효성 검사 및 제출 -->
<script>
	const title = $('#boardTitle');
	const content = $('#boardContent'); 
	const user = $('#boardUser'); 

	$('#updateBtn').click(function(){
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
