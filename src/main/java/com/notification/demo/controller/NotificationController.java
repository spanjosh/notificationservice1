package com.notification.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notification.demo.entity.NotificationDetails;
import com.notification.demo.service.NotificationServiceImpl;

@RestController
public class NotificationController {

	
	@Autowired
	private NotificationServiceImpl notificationService;

	@PostMapping("/sendMail")
    public void  sendSimpleMail(@RequestBody NotificationDetails details)
    {
		notificationService.sendSimpleMail(details);
	}

	@PostMapping("/sendSMS")
	public void  sendSMS(@RequestBody NotificationDetails details)
	{
		notificationService.sendSMS(details);
	}

	@PostMapping("/sendWhatsapp")
	public void  sendWhatsApp(@RequestBody NotificationDetails details)
	{
		notificationService.sendWhatsAppMsg(details);
	}
}