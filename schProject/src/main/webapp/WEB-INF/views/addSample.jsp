<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>
	$(document).ready(function(){
		$('#addBtn').click(function(){			
			$('#addForm').submit();
		})
	});
</script>

</head>
<body>

	<h1>addSample</h1>
	<form method="post" action="/addSample" id="addForm">
		<div>
			이름 : <input type="text" id="name" name="name"> <span>${nameError}</span>
		</div>
		<div>
			나이 : <input type="number" id="age" name="age" min="0" max="200"> <span>${ageError}</span>
		</div>
		<div>
			<button type="button" id="addBtn">입력</button>
		</div>
	</form>

</body>
</html>