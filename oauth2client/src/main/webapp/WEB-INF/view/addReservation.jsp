<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블 예약</title>

<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
  .reservation-form {
    max-width: 600px;
    margin: 50px auto;
    padding: 30px;
    background-color: #ffffff;
    border-radius: 12px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
  }
</style>
</head>
<body class="bg-light">

<div class="container">
  <div class="reservation-form">
    <h2 class="mb-4 text-center">📝 테이블 예약</h2>
    
    <form action="/addReservation" method="post" id="reservationDto" name="reservationDto">
      
      <div class="mb-3">
        <label for="roomNo" class="form-label">방 번호</label>
        <input type="text" id="roomNo" name="roomNo" value="${roomNo}" class="form-control" readonly>
      </div>

      <div class="mb-3">
        <label for="roomName" class="form-label">방 이름</label>
        <input type="text" id="roomName" name="roomName" value="${roomName}" class="form-control" readonly>
      </div>

      <div class="mb-3">
        <label for="provider" class="form-label">이름</label>
        <input type="text" id="provider" name="provider" value="${loginUsername}" class="form-control" readonly>
      </div>

      <div class="mb-3">
        <label for="reservationDate" class="form-label">예약 날짜</label>
        <input type="date" id="reservationDate" name="reservationDate" value="${date}" class="form-control" readonly>
      </div>

      <div class="mb-3">
        <label class="form-label">시간</label>
        <div>
          <div class="form-check form-check-inline">
            <input type="radio" class="form-check-input" name="reservationOption" value="AM" ${option == 'AM' ? 'checked' : ''} disabled>
            <label class="form-check-label">오전</label>
          </div>
          <div class="form-check form-check-inline">
            <input type="radio" class="form-check-input" name="reservationOption" value="PM" ${option == 'PM' ? 'checked' : ''} disabled>
            <label class="form-check-label">오후</label>
          </div>
        </div>
        <!-- 실제 서버 전송용 hidden -->
        <input type="hidden" name="reservationOption" value="${option}">
      </div>

      <div class="mb-4">
        <label for="reservationCount" class="form-label">인원</label>
        <input type="number" id="reservationCount" name="reservationCount" class="form-control" placeholder="예: 2명">
      </div>

      <div class="d-grid">
        <button type="submit" class="btn btn-primary">예약하기</button>
      </div>

    </form>
  </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
