package com.example.NTT.manytomany.dtos.response;

import lombok.Data;

@Data
public class ObjectRespone {
	
	private String status;
	private String message;
	private Object data;
	
	public ObjectRespone(String status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	
}
