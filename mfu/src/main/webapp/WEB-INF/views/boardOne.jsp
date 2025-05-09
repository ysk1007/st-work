<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세 페이지</h1>
	<a href="boardList">뒤로</a>
	
	<div>
		# : ${board.boardNo}
		<br>
		제목 : ${board.boardTitle}
	</div>
	<div>
	    <a href="/modifyBoard?boardNo=${board.boardNo}">수정</a>
	    <a href="/removeBoard?boardNo=${board.boardNo}">삭제</a>
	</div>
	
	<div>
	첨부 파일
	<c:forEach var="boardfile" items="${list}">
		<div>
           <a href="/upload/${boardfile.filename}" download="${boardfile.filename}">${boardfile.filename}</a>
           <a href="/removeFile?boardNo=${boardfile.boardNo}&boardfileNo=${boardfile.boardfileNo}">삭제</a>
         </div>
	</c:forEach>
	
	</div>
</body>
</html>