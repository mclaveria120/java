package com.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.dto.ErrorResponse;
import com.exceptions.MyException;

@Component
public class Util {


	public  Response buildErrorResponse(int statusCode, MyException entity ){
		return Response.status(statusCode).entity(new ErrorResponse(statusCode,entity.getMessage())).build();
	}
	

	 public  String getDate(){
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			return df.format(new Date());
	 }
	 
	 public  boolean isParameterValid(String value){
			return value!=null && !isStringEmpty(value);
	}
	 
	public  boolean isStringEmpty(String value){
			return "".equals(value);
	}
}
