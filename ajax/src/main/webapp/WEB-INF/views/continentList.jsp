<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form1" action="/continentList" method="get">
		<select id="continent" name="continent">
			<option value="">:::대륙선택:::</option>
			<c:forEach var="continent" items="${continentList}">
				<option value="${continent.continentNo}"
				<c:if test="${continent.continentNo == ctnNo}">selected</c:if>>${continent.continentName}</option>
			</c:forEach>
		</select>
		
		<select id="country" name="country">
			<option value="">:::나라선택:::</option>
			<c:forEach var="country" items="${countryList}">
				<option value="${country.countryNo}"
				<c:if test="${country.countryNo == ctNo}">selected</c:if>>${country.countryName}</option>
			</c:forEach>
		</select>
		
		<select id="city" name="city">
			<option value="">:::도시선택:::</option>
			<c:forEach var="city" items="${cityList}">
				<option value="${city.cityNo}"
				<c:if test="${city.cityNo == cNo}">selected</c:if>>${city.cityName}</option>
			</c:forEach>
		</select>
	</form>
</body>
	<script>
		document.querySelector('#continent').addEventListener('change', function(){
			if(this.value == ''){
				alert('대륙을 선택 하세요');
				document.querySelector('#country').value = "";
				document.querySelector('#city').value = "";
				return;
			}
			document.querySelector('#form1').submit();
		})
		
		document.querySelector('#country').addEventListener('change', function(){
			if(this.value == ''){
				alert('나라를 선택 하세요');
				document.querySelector('#city').value = "";
				return;
			}
			document.querySelector('#form1').submit();
		})
	</script>
</html>