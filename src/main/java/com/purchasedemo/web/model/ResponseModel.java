package com.purchasedemo.web.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResponseModel {

	private Object purchaseData;
	private Object productData;
	private Integer statusCode;
	
	public static ResponseModel getInstance()
	{
		ResponseModel response = new ResponseModel();
		response.setStatusCode(HttpStatus.OK.value());
		return response;
	}
}
