package com.techgel.client;

import com.techgel.common.entity.adminSettings.Mail;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class Utility {
    public static JavaMailSenderImpl prepareMailSender(Mail mail){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(mail.getHost());
        mailSender.setPort(mail.getPort());
        mailSender.setUsername(mail.getUsername());
        mailSender.setPassword(mail.getPassword());

        Properties mailProperties = new Properties();
        mailProperties.setProperty("mail.smtp.auth", String.valueOf(mail.isSmtpAuth()));
        mailProperties.setProperty("mail.smtp.starttls.enable", String.valueOf(mail.isSmtpSecured()));

        mailSender.setJavaMailProperties(mailProperties);

        return mailSender;
    }
}
