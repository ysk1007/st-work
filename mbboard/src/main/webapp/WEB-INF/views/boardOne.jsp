<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드 상세 페이지</title>
<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body class="bg-light">

<div class="container mt-5">

	<!-- 제목 -->
	<h1 class="mb-4">보드 상세</h1>
	
	<!-- 리스트로 돌아가기 버튼 -->
	<div class="mb-3">
		<a href="boardList" class="btn btn-secondary">리스트</a>
	</div>

	<!-- 잘못된 접근 -->
	<c:if test="${board == null}">
		<div class="alert alert-danger">잘못된 페이지</div>
	</c:if>

	<!-- 정상 데이터 표시 -->
	<c:if test="${board != null}">
		<div class="card">
			<div class="card-header">
				게시글 정보
			</div>
			<div class="card-body">
				<table class="table table-bordered">
					<tr>
						<th style="width: 20%;">#</th>
						<td>${board.boardNo}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${board.boardTitle}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>${board.boardContent}</td>
					</tr>
					<tr>
						<th>글쓴이</th>
						<td>${board.boardUser}</td>
					</tr>
					<tr>
						<th>생성일</th>
						<td>${board.createDate}</td>
					</tr>
					<tr>
						<th>수정일</th>
						<td>${board.updateDate}</td>
					</tr>
				</table>
				<!-- 수정 및 삭제 버튼 -->
				<div class="mt-3">
					<a href="updateBoard?boardNo=${board.boardNo}" class="btn btn-warning me-2">수정</a>
					<a href="deleteBoard?boardNo=${board.boardNo}" class="btn btn-danger">삭제</a>
				</div>
			</div>
		</div>
	</c:if>

</div>

</body>
</html>
