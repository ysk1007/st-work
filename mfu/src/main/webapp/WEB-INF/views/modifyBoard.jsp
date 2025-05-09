<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 수정</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-5">

	<h1 class="mb-4">✏ 게시글 수정</h1>
	<a href="boardList" class="btn btn-secondary mb-4">← 목록으로</a>

	<form id="modifyForm" method="post" action="${pageContext.request.contextPath}/modifyBoard" class="card p-4">
		<input type="hidden" name="boardNo" id="boardNo" value="${board.boardNo}">

		<div class="mb-3">
			<label for="boardTitle" class="form-label">제목</label>
			<input type="text" name="boardTitle" id="boardTitle" value="${board.boardTitle}" class="form-control">
		</div>

		<button type="button" id="modifyBtn" class="btn btn-primary">수정</button>
	</form>

	<script>
		document.querySelector('#modifyBtn').addEventListener('click', () => {
			if (document.querySelector('#boardTitle').value.trim() === '') {
				alert('제목을 입력하세요');
				return;
			}
			document.querySelector('#modifyForm').submit();
		});
	</script>

</body>
</html>
