package com.rest.email;

import com.rest.properties.ConfigProperties;
import com.rest.properties.SystemConfigProperties;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component("gmail")
public class Gmail implements Email {

    private ConfigProperties prop = new SystemConfigProperties();

    private final String SMTP_HOST_NAME = prop.getStringProperty("smtp.hostname");
    private final int SMTP_HOST_PORT = prop.getIntProperty("smtp.port");
    private final String SMTP_AUTH_USER = prop.getStringProperty("gmail.username");
    private final String SMTP_AUTH_PWD  = prop.getStringProperty("gmail.password");

    @Override
    public void sendEmail() throws Exception{
        Properties props = new Properties();

        props.put("mail.transport.protocol", prop.getStringProperty("gmail.transport.protocol") );
        props.put("mail.smtps.host", SMTP_HOST_NAME);
        props.put("mail.smtps.auth", prop.getStringProperty("gmail.smtps.auth"));
        // props.put("mail.smtps.quitwait", "false");

        Session mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Testing SMTP-SSL");
        message.setContent("This is a test", "text/plain");

        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(prop.getStringProperty("gmail.sendto.address")));

        transport.connect
                (SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);

        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }



}
