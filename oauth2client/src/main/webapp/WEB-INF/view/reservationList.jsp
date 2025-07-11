<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식당 테이블 예약</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
  function openPopup(roomNo, roomName, date, option) {
    window.open("/addReservation?roomNo=" + roomNo + "&roomName=" + roomName + "&date=" + date + "&option=" + option,
                "popup", "width=600,height=800,scrollbars=no");
  }

  // 날짜나 옵션 바꾸면 갱신 되게
  $(document).ready(function () {
    $('#date').on('change', () => {
      $('#reservationForm').submit();
    });

    $('#option').on('change', () => {
      $('#reservationForm').submit();
    });
  });
</script>

</head>
<body class="bg-light">
<div class="container py-5">
  <h1 class="mb-4 text-center text-primary">윤식당🍴 테이블 예약</h1>
  <hr>
  <div class="text-start my-3">
	  <a href="myPage" class="btn btn-primary">내 예약</a>
  </div>
  <!-- 날짜/옵션 선택 폼 -->
  <form id="reservationForm" action="/reservationList" method="get" class="row g-3 align-items-center mb-4">
    <div class="col-md-4">
      <label for="date" class="form-label">예약 날짜</label>
      <input type="date" class="form-control" id="date" name="date" value="${date}">
    </div>
    <div class="col-md-4">
      <label for="option" class="form-label">시간대</label>
      <select id="option" name="option" class="form-select">
        <option value="AM" ${option == 'AM' ? 'selected' : ''}>오전</option>
        <option value="PM" ${option == 'PM' ? 'selected' : ''}>오후</option>
      </select>
    </div>
  </form>

  <!-- 예약 버튼 리스트 -->
  <div class="row row-cols-1 row-cols-md-3 g-4">
    <c:if test="${list != null}">
      <c:forEach var="room" items="${list}">
        <div class="col">
          <div class="card shadow-sm">
            <div class="card-body">
              <h5 class="card-title">${room.roomNo}번 ${room.roomName}</h5>
              <p class="card-text">최대 인원: ${room.roomLimit}명</p>
              <button type="button"
			        onclick="openPopup(${room.roomNo}, '${room.roomName}', '${date}', '${option}')"
			        class="btn ${room.reservationNo == null ? 'btn-success' : 'btn-danger'} w-100"
			        ${room.reservationNo != null ? 'disabled' : ''}>
			  		${room.reservationNo == null ? '예약 가능' : '예약 불가능'}
			  </button>
            </div>
          </div>
        </div>
      </c:forEach>
    </c:if>
  </div>
</div>
</body>
</html>
