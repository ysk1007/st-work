<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어드민 홈</title>

<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style>
	.roleList {
		min-width: 120px;
	}
	.container {
		max-width: 900px;
		margin-top: 40px;
	}
	.action-links a {
		margin-right: 15px;
	}
</style>
</head>
<body>

<div class="container">

	<h1 class="mb-4">${loginMember.memberId} 관리자</h1>
	
	<div class="action-links mb-4">
		<a href="/logout" class="btn btn-outline-danger btn-sm">로그아웃</a>
		<a href="/member/memberHome" class="btn btn-outline-secondary btn-sm">뒤로</a>
	</div>

	<h2 class="mb-3">멤버리스트</h2>

	<!-- 
		memberRole 수정
	 -->
	<table class="table table-bordered table-hover align-middle">
		<thead class="table-light">
			<tr>
				<th scope="col">아이디</th>
				<th scope="col">역할</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${memberList}">
				<tr>
					<td>${member.memberId}</td>
					<td>
						<select class="form-select roleList" name="roleList" aria-label="역할 선택">
							<option value="ADMIN" ${member.memberRole == 'ADMIN' ? 'selected' : ''}>admin</option>
							<option value="MEMBER" ${member.memberRole == 'MEMBER' ? 'selected' : ''}>member</option>
						</select>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
	$(document).ready(function() {
		// class로 이벤트 바인딩
		$('.roleList').change(function() {
			const newRole = $(this).val(); // 변경된 역할
			const memberId = $(this).closest('tr').find('td:first').text(); // 같은 행의 아이디 가져오기
			
			// console.log('변경된 역할:', newRole);
			// console.log('해당 아이디:', memberId);
	
			// 서버에 역할 변경 요청 보내기
			$.ajax({
				url: '/member/updateRole',
				type: 'post',
				contentType: 'application/json',
				data: JSON.stringify({ memberId: memberId, memberRole: newRole }),
				success: function(response) {
					if(response){
						alert('역할이 변경되었습니다.');
					}
					else{
						alert('역할 변경 실패.');
					}
				}
			});
		});
	});
</script>

</body>
</html>
