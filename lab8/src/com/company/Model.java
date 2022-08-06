package com.company;
import com.company.View;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

public class Model {
    public static boolean sendMail(String recipient, String head, String text, String coding) {
        String username="sender.pyth@gmail.com";
        String password = "sender.pyth191102";
        String SMTP = "smtp.gmail.com";
        String port = "465";
        boolean success = true;

        String code = null;
        if(coding.equals("1")) code = "UTF-8";
        if(coding.equals("2")) code = "cp1251";
        if(coding.equals("3")) code = "ASCII";
        if(code==null) {
            View.view("Допустимы цифры от 1 до 3!");
            System.exit(0);
        }
        String textCode = null;
        try {
            textCode = new String(text.getBytes(), code);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.host", SMTP);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, null);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(head);
            message.setText(textCode);
            Transport.send(message, username, password);
            View.view("Сообщение успешно отправлено");
        }
        catch (MessagingException e){
            View.view(e.getMessage());
            success = false;
        }
        return success;
    }
}