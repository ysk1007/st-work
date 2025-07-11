<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>예약 성공</title>
	<script>
		// 팝업창 닫고 부모창 이동
		window.onload = function() {
			alert("예약이 완료되었습니다.");
			window.opener.location.href = "/reservationList";
			window.close();
		}
	</script>
</head>
<body>

</body>
</html>