package com.notification.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.notification.demo.NotificationServiceApplication;
import com.notification.demo.constants.AppConstants;
import com.notification.demo.entity.NotificationDetails;
import com.notification.demo.exception.NotificationException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class NotificationServiceImpl implements NotificationService {

    Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);
    
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	/**
	 * Methos used to send Email
	 * 
	 * @param NotificationDetails
	 * @exception NotificationException
	 */
	public String sendSimpleMail(NotificationDetails details) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMessage());
			mailMessage.setSubject(details.getSubject());
			javaMailSender.send(mailMessage);
			return "Mail Sent Successfully...";
		} catch (Exception e) {
			throw new NotificationException("Error while Sending Mail");
		}
	}

	/**
	 * Method used to send SMS
	 * 
	 * @param from    mobile number
	 * @param to      mobile number
	 * @param message to send
	 * @exception NotificationException
	 */
	public String sendSMS(NotificationDetails details) {
		try {
			Twilio.init(AppConstants.SMS_ACCOUNT_SID, AppConstants.SMS_AUTH_TOKEN);
			Message message = Message.creator(new com.twilio.type.PhoneNumber("to" + details.getToPhNo()),
					new com.twilio.type.PhoneNumber("from" + details.getFromPhNo()), details.getMessage().toString()).create();
			logger.info("SMS sent successfully");
			return "SMS sent successfully";
		} catch (Exception e) {
			throw new NotificationException("Error while Sending SMS");
		}
	}

	/**
	 * Method used to send whatsapp message
	 * 
	 * @param from    whatsapp number
	 * @param to      whatsapp number
	 * @param message to send
	 * @exception NotificationException
	 */
	public String sendWhatsAppMsg(NotificationDetails details) {
		try {
			Twilio.init(AppConstants.WHATS_APP_ACCOUNT_SID, AppConstants.WHATS_APP_AUTH_TOKEN);
			Message message = Message.creator(new com.twilio.type.PhoneNumber(details.getToPhNo()),
					new com.twilio.type.PhoneNumber(details.getFromPhNo()), details.getMessage()).create();
			logger.info(message.getSid());
			return "whats app message sent successfully";
		} catch (Exception e) {
			throw new NotificationException("Error while Sending hatsapp");
		}
	}
}
