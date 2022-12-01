# Read Me First
The project "NotificationService" application is used to send Notifications through different channels like
	a. eMail notification
	b. simple SMS
	c. Whatsapp message

API's :
/sendMail
	This API is used to send the email which would required the input details as : Notification details as recipient,message body and subject
	Throws NotificationException
	
/sendSMS
	This API is used to send the  SMS which would required the input details as : Notification details as from phone number,to phone number and message to send
	Throws NotificationException
	
/sendWhatsapp
	This API is used to send the  SMS which would required the input details as : Notification details as as from phone number,to phone number and message to send
	Throws NotificationException
