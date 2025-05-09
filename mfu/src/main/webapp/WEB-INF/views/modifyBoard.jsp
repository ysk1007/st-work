<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>보드 수정</h1>
	<a href="boardList">뒤로</a>
	<form id="modifyForm" method="post" action="${pageContext.request.contextPath}/modifyBoard">
		<input type="hidden" name="boardNo" id="boardNo" value="${board.boardNo}">
		<table border="1">
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="boardTitle" id="boardTitle" value="${board.boardTitle}">
				</td>
			</tr>
		</table>
		<button type="button" id="modifyBtn">수정</button>
	</form>
	
	<script>
		document.querySelector('#modifyBtn').addEventListener('click',()=>{
			// 폼(값) 유효성 검사
			if(document.querySelector('#boardTitle').value == ''){
				alert('제목을 입력하세요');
				return;
			}
			
			document.querySelector('#modifyForm').submit();
		})
	</script>
</body>
</html>