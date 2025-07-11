package com.example.oauth2client.dto;

import lombok.Data;

@Data
public class ReservationDto {
	private Integer reservationNo;
	private int roomNo;
	private String reservationDate;
	private String reservationOption;
	private String reservationId;
	private int reservationCount;
	private String provider;
	private String createdate;
	private String updatedate;
}
