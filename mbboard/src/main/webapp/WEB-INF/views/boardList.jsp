<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드 리스트</title>
<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body class="bg-light">

<div class="container mt-5">

	<h1 class="mb-4">보드 리스트</h1>

	<!-- 글쓰기 버튼 -->
	<div class="mb-3">
		<a href="insertBoard" class="btn btn-primary">글쓰기</a>
	</div>

	<!-- 글이 없을 때 -->
	<c:if test="${empty boardList}">
		<div class="alert alert-warning">글이 없습니다.</div>
	</c:if>

	<form id="boardList" action="boardList" method="get">

		<!-- 게시글 테이블 -->
		<table class="table table-bordered table-hover bg-white">
			<thead class="table-light">
				<tr>
					<th>#</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>생성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td>${board.boardNo}</td>
						<td><a href="/boardOne?boardNo=${board.boardNo}" class="text-decoration-none">${board.boardTitle}</a></td>
						<td>${board.boardUser}</td>
						<td>${board.createDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- 페이지 네비게이션 -->
		<nav aria-label="Page navigation">
			<ul class="pagination justify-content-center">
				<c:if test="${page.currentPage > 1}">
					<li class="page-item">
						<a class="page-link" href="/boardList?currentPage=${page.currentPage - 1}&searchWord=${page.searchWord}">이전</a>
					</li>
				</c:if>
				<li class="page-item disabled">
					<span class="page-link">${page.currentPage} / ${page.lastPage}</span>
				</li>
				<c:if test="${page.currentPage < page.lastPage}">
					<li class="page-item">
						<a class="page-link" href="/boardList?currentPage=${page.currentPage + 1}&searchWord=${page.searchWord}">다음</a>
					</li>
				</c:if>
			</ul>
		</nav>

		<!-- 검색 영역 -->
		<div class="input-group mt-3 mb-5">
			<input type="text" name="searchWord" id="searchWord" class="form-control" value="${page.searchWord}" placeholder="제목/내용 검색">
			<button type="button" id="searchBtn" class="btn btn-outline-secondary">검색</button>
		</div>
	</form>

</div>

<!-- 검색 스크립트 -->
<script>
	$('#searchBtn').click(function(){
		$('#boardList').submit();
	});
</script>

</body>
</html>
