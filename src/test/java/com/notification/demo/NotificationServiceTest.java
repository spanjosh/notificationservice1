package com.notification.demo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.notification.demo.entity.NotificationDetails;
import com.notification.demo.exception.NotificationException;
import com.notification.demo.service.NotificationServiceImpl;

@SpringBootTest
public class NotificationServiceTest {

	 @Autowired
	 NotificationServiceImpl notificationService;

	 @Test
	 void testSendEmail(){
		 	NotificationDetails details = new NotificationDetails("spandana.gunda@joshsoftware.com","Welcome","welcome","","");
	        when(notificationService.sendSimpleMail(details)).thenReturn("Email sent successfully");
	 }
	 
	 @Test
	 void testSendSMS(){
		 	NotificationDetails details = new NotificationDetails("welcome","+91 9632679497","+91 9632679497");
	        when(notificationService.sendSMS(details)).thenReturn("SMS sent successfully");
	 }
	 
	 @Test
	 void testSendWhatsAppMsg(){
		 	NotificationDetails details = new NotificationDetails("welcome","+91 9632679497","+91 9632679497");
	        when(notificationService.sendWhatsAppMsg(details)).thenReturn("whatsapp message successfully");
	 }
	 @Test
	 void testSendEmailException(){
		 	NotificationDetails details = new NotificationDetails("spandana.gunda@joshsoftware.com","Welcome","welcome","","");
	        when(notificationService.sendSimpleMail(details)).thenThrow(NotificationException.class);
	 }
	 
	 @Test
	 void testSendSMSException(){
		 	NotificationDetails details = new NotificationDetails("welcome","+91 9632679497","+91 9632679497");
	        when(notificationService.sendSMS(details)).thenThrow(NotificationException.class);
	 }
	 
	 @Test
	 void testSendWhatsAppMsgException(){
		 	NotificationDetails details = new NotificationDetails("welcome","+91 9632679497","+91 9632679497");
	        when(notificationService.sendWhatsAppMsg(details)).thenThrow(NotificationException.class);
	 }
}
