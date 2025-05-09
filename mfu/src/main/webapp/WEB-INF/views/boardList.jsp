<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 목록</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-5">

	<h1 class="mb-4">📋 게시글 목록</h1>

	<a href="addBoard" class="btn btn-primary mb-3">+ 게시글 추가</a>

	<table class="table table-bordered table-hover">
		<thead class="table-light">
			<tr>
				<th style="width: 10%">#</th>
				<th>제목</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${list}">
				<tr>
					<td>${board.boardNo}</td>
					<td>
						<a href="/boardOne?boardNo=${board.boardNo}" class="text-decoration-none">
							${board.boardTitle}
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
