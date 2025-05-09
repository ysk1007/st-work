<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 상세</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-5">

	<h1 class="mb-4">📄 게시글 상세</h1>

	<a href="boardList" class="btn btn-secondary mb-4">← 목록으로</a>

	<!-- 게시글 정보 -->
	<div class="card mb-4">
		<div class="card-body">
			<p><strong>번호:</strong> ${board.boardNo}</p>
			<p><strong>제목:</strong> ${board.boardTitle}</p>
		</div>
	</div>

	<!-- 수정/삭제 버튼 -->
	<div class="mb-4">
		<a href="/modifyBoard?boardNo=${board.boardNo}" class="btn btn-warning me-2">✏ 수정</a>
		<a href="/removeBoard?boardNo=${board.boardNo}" class="btn btn-danger">🗑 삭제</a>
	</div>

	<!-- 첨부 파일 -->
	<div class="mb-3">
		<h5>📎 첨부 파일</h5>
		<c:choose>
			<c:when test="${not empty list}">
				<ul class="list-group">
					<c:forEach var="boardfile" items="${list}">
						<li class="list-group-item d-flex justify-content-between align-items-center">
							<a href="/upload/${boardfile.filename}" download="${boardfile.filename}">
								${boardfile.filename}
							</a>
							<a href="/removeFile?boardNo=${boardfile.boardNo}&boardfileNo=${boardfile.boardfileNo}" class="btn btn-sm btn-outline-danger">
								삭제
							</a>
						</li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<p class="text-muted">첨부된 파일이 없습니다.</p>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>
