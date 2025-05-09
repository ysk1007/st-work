<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>addBoard</h1>
	<a href="boardList">뒤로</a>
	<form id="addForm" method="post" action="${pageContext.request.contextPath}/addBoard" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="boardTitle" id="boardTitle">
				</td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
					<div>
						<button type="button" id="appendFile">파일 추가</button>
					</div>
					<div id="fileDiv">
						<input type="file" name="boardfile" class="boardfile">
					</div>
				</td>
			</tr>
		</table>
		<button type="button" id="addBtn">입력</button>
	</form>
	
	<script>
		document.querySelector('#appendFile').addEventListener('click',()=>{
			let flag = false;	// flag 초기화

			// input type=file 추가 : 파일들이 선택되어 있다면
			let boardfiles = document.querySelectorAll('.boardfile');
			boardfiles.forEach(e=>{
				if(e.value == ''){
					alert('첨부하지 않은 파일이 있다.');
					flag = true;
					return;	// forEach 콜백함수를 탈출
				}
			});
			
			if(flag) return;
			
			let inputFile = document.createElement('input');
			inputFile.setAttribute('type','file');
			inputFile.setAttribute('name','boardfile');
			inputFile.setAttribute('class','boardfile');
			
			document.querySelector('#fileDiv').appendChild(inputFile);
		})
	
		document.querySelector('#addBtn').addEventListener('click',()=>{
			// 폼(값) 유효성 검사
			if(document.querySelector('#boardTitle').value == ''){
				alert('제목을 입력하세요');
				return;
			}
			
			// 파일이 추가되지않은 node(input type=file)를 삭제하고
			let boardfiles = document.querySelectorAll('.boardfile');
			boardfiles.forEach(e=>{
				if(e.value == ''){
					e.remove();	// node 삭제
				}
			})
			
			document.querySelector('#addForm').submit();
		})
	</script>
</body>
</html>