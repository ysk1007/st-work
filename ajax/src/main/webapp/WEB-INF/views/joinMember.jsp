<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function(){
		$('#sn1').keyup(function(){
			if($(this).val().length > 5){
				$('#sn2').focus();
			}
		})
		
		function snCheck(){
			const sn1 = $('#sn1').val();
			const sn2 = $('#sn2').val();

			// 둘다 isNaN 아니면
			if(isNaN(sn1) || isNaN(sn2)){
				$('#gender').val('');
				$('#age').val('');
				return false;
			}
			// sn1.length == 6 && sn2.length == 7
			if(!(sn1.length == 6 && sn2.length == 7)){
				$('#gender').val('');
				$('#age').val('');
				return false;
			}
			
			$.ajax({
				url:'http://localhost:9999/isSn/'+ sn1 + sn2
				, type:'get'
				, success: function(data){
								// 'true' or 'false'
								if(data == true){
									// 성별
									if(sn2.substr(0,1) % 2 == 0){
										$('#gender').val('여');
									}
									else{
										$('#gender').val('남');
									}
									
									const date = new Date();
									const todayYear = date.getFullYear();
									const todayMonth = date.getMonth() + 1;
									const todayDate = date.getDate();
									
									const birthMonth = sn1.substr(2,2);
									const birthDate = sn1.substr(4);
									
									let age = 0;	
									
									// 나이
									if(Number(sn2.substr(0,1)) < 3){	// ~99년생
										age = todayYear - Number('19' + sn1.substr(0,2));
									}
									else{	// ~00년생
										age = todayYear - Number('20' + sn1.substr(0,2));
									}
									
									// 만 나이 구하기
									if(birthMonth >= todayMonth){
										if(birthDate >= todayDate){
											age--;
										}
									}
									
									$('#age').val(age);
									return true;
								}
								else{
									alert('주민번호 인증 실패');
									$('#gender').val('');
									$('#age').val('');
									
									return false;
								}
							}
			});
			
		}
		
		// 주민번호 뒷자리 입력 완료 했을 때
		$('#sn2').blur(snCheck);
		
		// 내부API서버를 호출 - 비동기 구현 필수 X -> 편의상 비동기 호출
		function idCheck(){
			const isAble = $('#isAble');
			// $('#idck').val() 공백이 아니라면
			if($('#idck').val().length < 1) return;
			$.ajax({
				url:'/isId/'+$('#idck').val()
				, type:'get'
				, success: function(data){
					if(data == true){
						alert('사용 불가 아이디 입니다.');
						$('#id').val('');
						isAble.text('중복 아이디');
						isAble.css('color', 'red');
						return false;
					}
					else{
						$('#id').val($('#idck').val());
						isAble.text('사용 가능');
						isAble.css('color', 'green');
						return true;
					}
				}
			})
		}
		
		// 아이디 체크 버튼 클릭
		$('#idckBtn').click(idCheck)
		
		$('#btn').click(function(){
			// 입력값 중복검사
			if(idCheck() == false) return;
			if(snCheck() == false) return;
			
			// pw == pw2 검사
			const pw = $('#pw').val();
			const pw2 = $('#pw2').val();
			if(pw != pw2){
				alert('비밀 번호를 확인하세요');
				return;
			}
			
			
			
			// submit();
			$('#joinForm').submit();
		})
	});
</script>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<h2>주민번호 확인</h2>
	<table border="1">
		<tr>
			<th>주민 번호</th>
			<td>
				<input type="text" id="sn1" name="sn1"> <!-- keyup, length > 6, focus sn2 -->
				-
				<input type="text" id="sn2" name="sn2"> <!-- blur, length == 7, snapi호출, true gender+age, false alert  -->
			</td>		
		</tr>
	</table>
	<hr>
	<h2>ID 검색</h2>
	<table border="1">
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" id="idck">
				<button type="button" id="idckBtn">ID 검색</button><span id="isAble"></span>
			</td>		
		</tr>
	</table>
	
	<form id="joinForm" action="/joinMember" method="post">
		<table border="1">
			<tr>
				<th>성별</th>
				<td><input type="text" id="gender" name="gender" readonly></td>		
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" id="age" name="age" readonly></td>		
			</tr>
			<tr>
				<th>아이디</th>
				<td>
				<input type="text" id="id" name="id" readonly>
				</td>		
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="pw" name="pw">
				확인 - <input type="password" id="pw2" name="pw2"></td>		
			</tr>
			
		</table>
		<button type="button" id="btn">회원가입</button>
	</form>
</body>
</html>