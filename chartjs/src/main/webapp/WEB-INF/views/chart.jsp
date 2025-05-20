<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chart.js 실습</title>
<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Chart.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
</head>
<body>

<div class="container py-4">
  <h2 class="text-center mb-4">Chart.js 차트 대시보드</h2>
  <div class="row g-4">
    
    <div class="col-md-6">
      <div class="card h-100 shadow-sm">
        <div class="card-body d-flex flex-column justify-content-center">
          <h5 class="card-title text-center">1) 나라별 평균 나이</h5>
          <canvas id="chart1" style="max-width:100%; height:300px;"></canvas>
        </div>
      </div>
    </div>
    
    <div class="col-md-6">
      <div class="card h-100 shadow-sm">
        <div class="card-body d-flex flex-column justify-content-center">
          <h5 class="card-title text-center">2) 성별 가입자 수</h5>
          <canvas id="chart2" style="max-width:100%; height:300px;"></canvas>
        </div>
      </div>
    </div>
    
    <div class="col-md-6">
      <div class="card h-100 shadow-sm">
        <div class="card-body d-flex flex-column justify-content-center">
          <h5 class="card-title text-center">3) 연도별 나라별 가입자 수</h5>
          <canvas id="chart3" style="max-width:100%; height:300px;"></canvas>
        </div>
      </div>
    </div>
    
    <div class="col-md-6">
      <div class="card h-100 shadow-sm">
        <div class="card-body d-flex flex-column justify-content-center">
          <h5 class="card-title text-center">4) 연도별 누적 가입자 수</h5>
          <canvas id="chart4" style="max-width:100%; height:300px;"></canvas>
        </div>
      </div>
    </div>

  </div>
</div>


<!-- chart1 -->
<script>
	// char 1
	$.ajax({
		url :'/rest/avgAgeByCountry',
		type :'post',
		success : function(data){
			// chart1에 bar차트를 출력 start
			// chart.js가 bar chart에 요구하는 모델
			const xValues = [];	// 나라
			const yValues = [];	// 평균 나이
			const barColors = ["#ffc940", "#45ff55","#45d7ff","#ff4f90"];

			$(data).each(function(i, e){
				xValues.push(e.country);
				yValues.push(e.age);
			})

			new Chart("chart1", {
			  type: "bar",
			  data: {
			    labels: xValues,
			    datasets: [{
			      backgroundColor: barColors,
			      data: yValues
			    }]
			  },
			  options: {
			    legend: {display: false},
			    scales: {
			      yAxes: [{
			        ticks: {
			          beginAtZero: true
			        }
			      }]
			    },
			    title: {
			      display: true,
			      text: "나라별 평균 나이"
			    }
			  }
			});
			// chart1에 bar차트를 출력 end
		}
	});
</script>

<!-- chart2 -->
<script>
	$.ajax({
		url:'/rest/countByGender',
		type:'post',
		success: function(data){				
			const xValues = [];	// 성별
			const yValues = [];	// 카운트

			$(data).each(function(i,e){
				xValues.push(e.gender);
				yValues.push(e.count);
			})

			const barColors = ["#4775ff", "#ff4747"];

			new Chart("chart2", {
			  type: "pie",
			  data: {
			    labels: xValues,
			    datasets: [{
			      backgroundColor: barColors,
			      data: yValues
			    }]
			  },
			  options: {
			    title: {
			      display: true,
			      text: "성별 가입자 수"
			    }
			  }
			});
		}
	});
</script>

<!-- chart3 -->
<script>
	$.ajax({
		url:'/rest/countByYearAndCountry',
		type:'post',
		success: function(data){
			// 출력 시작
			const xValues = [];	// 년도
			const d0 = [];	// 독일
			const d1 = [];	// 미국
			const d2 = [];	// 한국
			const d3 = [];	// 호주

			$(data).each(function(i,e){
				if(i%4==0){
					xValues.push(e.year);
					d0.push(e.count);
				}
				else if(i%4==1){
					d1.push(e.count);
				}
				else if(i%4==2){
					d2.push(e.count);
				}
				else if(i%4==3){
					d3.push(e.count);
				}
			});

			new Chart("chart3", {
			  type: "line",
			  data: {
			    labels: xValues,
			    datasets: [{
				  label:'독일', 
			      data: d0,
			      borderColor: "#ffc940",
			      fill: false
			    }, {
			      label:'미국', 
			      data: d1,
			      borderColor: "#45ff55",
			      fill: false
			    }, { 
			      label:'한국',
			      data: d2,
			      borderColor: "#45d7ff",
			      fill: false
			    },{ 
			      label:'호주',
			      data: d3,
			      borderColor: "#ff4f90",
			      fill: false
			    }]
			  },
			  options: {
			    legend: {display: true}
			  }
			});
			// 출력 종료
		}
	});
</script>

<!-- chart4 -->
<script>
	$.ajax({
		url:'/rest/totalCountByYear',
		type:'post',
		success:function(data){
			console.log(data);
			const xValues = [];	// 년도
			const yValues = [];	// 누적 가입자 수

			$(data).each(function(i,e){
				xValues.push(e.year);
				yValues.push(e.count);
			})
			
			new Chart("chart4", {
			  type: "line",
			  data: {
			    labels: xValues,
			    datasets: [{
			      fill: true,
			      pointRadius: 1,
			      borderColor: "#e86b6b",
			      data: yValues
			    }]
			  },    
			  options: {
			    legend: {display: false},
			    title: {
			      display: true,
			      text: "연도별 누적 가입자 수",
			      fontSize: 16
			    }
			  }
			});
		}
	});
</script>

<!-- Bootstrap 5 JS Bundle (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
