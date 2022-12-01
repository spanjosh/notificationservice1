package com.notification.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDetails {
 
    private String recipient;
    private String message;
    private String subject;
    private String fromPhNo;
    private String toPhNo;
    
	public String getFromPhNo() {
		return fromPhNo;
	}
	public void setFromPhNo(String fromPhNo) {
		this.fromPhNo = fromPhNo;
	}
	public String getToPhNo() {
		return toPhNo;
	}
	public void setToPhNo(String toPhNo) {
		this.toPhNo = toPhNo;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public NotificationDetails(String recipient, String message, String subject, String fromPhNo, String toPhNo) {
		super();
		this.recipient = recipient;
		this.message = message;
		this.subject = subject;
		this.fromPhNo = fromPhNo;
		this.toPhNo = toPhNo;
	}
	
	public NotificationDetails(String message, String fromPhNo, String toPhNo) {
		super();
		this.message = message;
		this.fromPhNo = fromPhNo;
		this.toPhNo = toPhNo;
	}
	@Override
	public String toString() {
		return "NotificatioDetails [recipient=" + recipient + ", message=" + message + ", subject=" + subject
				+ ", fromPhNo=" + fromPhNo + ", toPhNo=" + toPhNo + "]";
	}
}