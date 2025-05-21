<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<form method="post" id="memberForm" name="member" action="/modifyPw">
		<div>
			<span style="color:red">${errorMsg}</span>
			<input type="hidden" id="id" name="id" value="${loginMember.id}">
			<div>
				기존 비밀번호 : <input type="password" id="pw" name="pw">
			</div>
			<div>
				새로운 비밀번호 : <input type="password" id="newPw" name="newPw">
				<button type="button" id="newPwCheck" name="newPwCheck">확인</button>
				<span id="msg" style="color:green"></span>
			</div>
		</div>
		<button type="button" id="modifyPwBtn" name="modifyPwBtn">비밀번호 수정</button>
	</form>
	
	<script>
		let isAble = false;
		const id = $('#id');
		const pw = $('#newPw');
		const msg = $('#msg');
		const memberForm = $('#memberForm');
		
		function newPwCheck(){
			$.ajax({
				url:'/pwHistoryCheck',
				type:'post',
				contentType: 'application/json',
				data: JSON.stringify({
					id: id.val(),
					pw: pw.val()
				}),
				success:function(data){
					if(data){
						isAble = true;
						msg.text('사용 가능한 비밀번호입니다.').css('color', 'green');
					}
					else{
						isAble = false;
						msg.text('이전에 사용했던 비밀번호입니다.').css('color', 'red');
					}
				}
			})
		}
		
		$('#newPwCheck').click(function() {
			newPwCheck();
		})
		
		$('#modifyPwBtn').click(function(){
			newPwCheck();
			
			if(!isAble){
				alert('양식을 다시 확인 해주세요.');
				return;
			}
			
			memberForm.submit();
		})
	</script>
</body>
</html>