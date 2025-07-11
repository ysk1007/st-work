<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>예약 실패</title>
	<script>
		window.onload = function () {
			const retry = confirm("예약에 실패했습니다.\n다시 시도하시겠습니까?");
			if (retry) {
				// 팝업 창에서 뒤로 가기 (사용자가 수정 가능)
				history.back();
			} else {
				// 팝업 닫기
				window.close();
			}
		}
	</script>
</head>
<body>

</body>
</html>