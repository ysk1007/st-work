<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 추가</title>
	<!-- ✅ Bootstrap 5 CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-5">

	<h1 class="mb-4">게시글 추가</h1>
	<a href="boardList" class="btn btn-secondary mb-4">← 뒤로가기</a>

	<form id="addForm" method="post" action="${pageContext.request.contextPath}/addBoard" enctype="multipart/form-data">
		<div class="mb-3">
			<label for="boardTitle" class="form-label">제목</label>
			<input type="text" name="boardTitle" id="boardTitle" class="form-control" placeholder="제목을 입력하세요">
		</div>

		<div class="mb-3">
			<label class="form-label">파일</label>
			<div class="d-flex gap-2 align-items-center mb-2">
				<button type="button" id="appendFile" class="btn btn-outline-primary btn-sm">파일 추가</button>
			</div>
			<div id="fileDiv">
				<input type="file" name="boardfile" class="form-control mb-2 boardfile">
			</div>
		</div>

		<button type="button" id="addBtn" class="btn btn-primary">입력</button>
	</form>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

	<script>
		document.querySelector('#appendFile').addEventListener('click', () => {
			let flag = false;
			let boardfiles = document.querySelectorAll('.boardfile');
			boardfiles.forEach(e => {
				if (e.value === '') {
					alert('첨부하지 않은 파일이 있습니다.');
					flag = true;
					return;
				}
			});
			if (flag) return;

			let inputFile = document.createElement('input');
			inputFile.setAttribute('type', 'file');
			inputFile.setAttribute('name', 'boardfile');
			inputFile.setAttribute('class', 'form-control mb-2 boardfile');
			document.querySelector('#fileDiv').appendChild(inputFile);
		});

		document.querySelector('#addBtn').addEventListener('click', () => {
			if (document.querySelector('#boardTitle').value === '') {
				alert('제목을 입력하세요');
				return;
			}
			let boardfiles = document.querySelectorAll('.boardfile');
			boardfiles.forEach(e => {
				if (e.value === '') {
					e.remove();
				}
			});
			document.querySelector('#addForm').submit();
		});
	</script>
</body>
</html>
