package com.notification.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan({"com.notification.demo.service"})
@Slf4j
public class NotificationServiceApplication {
	
    Logger logger = LoggerFactory.getLogger(NotificationServiceApplication.class);

    public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

}