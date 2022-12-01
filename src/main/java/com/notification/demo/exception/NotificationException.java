package com.notification.demo.exception;

public class NotificationException  extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NotificationException(String errorMessage) {  
	    super(errorMessage);  
	    }  
}
