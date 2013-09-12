package com.codexsoft.yormoney.services;

import com.codexsoft.yormoney.domain.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@Service
public class MailService {
    private final Logger log = Logger.getLogger(MailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    public void send(String email, String text, String subject){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            log.info(subject + " : " + email);
            MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
            MimeMultipart mp  = new MimeMultipart();
            MimeBodyPart mbp1 = new MimeBodyPart();
            DataHandler dh = new DataHandler(text , "text/html");
            mbp1.setDataHandler(dh);
            mp.addBodyPart(mbp1);
            helper.setTo(email);
            helper.setSubject(subject);
            message.setContent(mp);
            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("Error, subject: " + email);
            e.printStackTrace();
        }
    }
}
