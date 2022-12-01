package com.notification.demo.service;

import com.notification.demo.entity.NotificationDetails;

public interface NotificationService {
	String sendSimpleMail(NotificationDetails details);

	String sendSMS(NotificationDetails details);

	String sendWhatsAppMsg(NotificationDetails details);
}
