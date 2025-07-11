package com.example.oauth2client.dto;

import lombok.Data;

@Data
public class PayDto {
	private int payNo;
	private int reservationNo;
	private int amount;
	private String payMethod;
	private String createdate;
}
