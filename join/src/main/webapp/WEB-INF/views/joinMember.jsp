<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form id = "joinForm" method="post" action="${pageContext.request.contextPath}/joinMember">
	
	<table border="1">
            <!-- 아이디 -->
            <tr>
                <td>아이디</td>
                <td><input type="text" name="id" id="id"></td><!-- 4자이상 -->
            </tr>
            <!-- 비밀번호 -->
            <tr>
                <td>
                    <div>비밀번호</div><!-- 8자이상 -->
                    <div>비밀번호확인</div>
                </td>
                <td>
                    <div><input type="password" name="pw" id="pw"></div>
                    <div><input type="password" name="pwCheck" id="pwCheck"></div>
                </td>
            </tr>
            <!-- 이름 -->
            <tr>
                <td>이름</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <!-- 생일 -->
            <tr>
                <td>생일</td>
                <td><input type="date" name="birth" id="birth"></td>
            </tr>
            <!-- 나이 -->
            <tr>
                <td>나이</td>
                <td><input type="number" name="age" id="age"></td>
            </tr>
            <!-- 성별 -->
            <tr>
                <td>성별</td>
                <td>
                    <input type="radio" name="gender" value="남" class="gender">남
                    <input type="radio" name="gender" value="여" class="gender">여
                </td>
            </tr>
            <!-- 취미 -->
            <tr>
                <td>취미</td>
                <td>
                    <input type="checkbox" name="hobby" value="여행" class="hobby">여행
                    <input type="checkbox" name="hobby" value="게임" class="hobby">게임
                    <input type="checkbox" name="hobby" value="등산" class="hobby">등산
                </td>
            </tr>
            <!-- 메일주소 -->
            <tr>
                <td>메일</td>
                <td>
                    <span><input type="text" name="emailId" id="emailId" value="gd"></span>
                    <span>@</span>
                    <select name="emailAddr" id="emailAddr">
                        <option value="">선택</option>
                        <option value="naver.com">naver.com</option>
                        <option value="daum.net">daum.net</option>
                        <option value="gmail.com">gmail.com</option>
                    </select>
                </td>
            </tr>
            <!-- 메모 -->
            <tr>
                <td>메모</td>
                <td>
                    <textarea cols="50" rows="5" name="memo" id="memo"></textarea>
                </td>
            </tr>
        </table>
        <button type="button" onclick="join()">회원가입</button>
	</form>
	<script>
		function join(){
			if(document.querySelector('#id').value.length < 4){
				alert('아이디는 4자 이상이어야 합니다.');
			}
			else if(document.querySelector('#pw').value.length < 8){
				alert('비밀번호는 8자 이상이어야 합니다.');
			}
			else if(document.querySelector('#pw').value !== document.querySelector('#pwCheck').value){
				alert('비밀번호를 확인하세요.');
			}
			else if(document.querySelector('#name').value.length < 2){
				alert('이름은 2자 이상.')
			}
			else if(document.querySelector('#birth').value.length < 1){	// 공백만 검사
				alert('생일을 입력하세요')
			}
			else if(document.querySelector('#age').value.length < 1	// 공백이거나
					|| isNaN(document.querySelector('#age').value)){	// isNaN(value) : value가 숫자가 아니면 true
				alert('나이는 숫자를 입력하세요')
			}
			else if(document.querySelectorAll('.gender:checked').length < 1){	// .gender중에 checked가 없다
				alert("성별을 선택하세요");
			}
			else if(document.querySelectorAll('.hobby:checked').length < 2){
				alert("취미는 2개 이상 선택하세요");
			}
			else if(document.querySelector('#emailId').value.length < 1 
					|| document.querySelector('#emailAddr').value.length < 1) {
				alert('이메일을 확인하세요');
			}
			else if(document.querySelector('#memo').value.length < 1){
				alert('메모를 입력하세요')
			}
			else{
				//document.querySelector('#joinForm').submit();
			}
		}
	</script>
</body>
</html>