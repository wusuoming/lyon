package net.slowvic.jms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.jms.JMSException;
import javax.jms.MapMessage;

import net.slowvic.modal.bean.Mail;

import org.springframework.jms.core.support.JmsGatewaySupport;
import org.springframework.transaction.annotation.Transactional;

public class BackOfficeImpl extends JmsGatewaySupport implements BackOffice {

    @Transactional
    public Mail receiveMail() {
        MapMessage message = (MapMessage) getJmsTemplate().receive();
        Mail mail = new Mail();
        try {
            mail.setFrom(message.getString("from"));
            mail.setTo(message.getString("to"));
            mail.setSubject(message.getString("subject"));
            mail.setContent(message.getString("content"));
            mail.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse(message.getString("date")));
            return mail;
        }
        catch (JMSException e) {
            throw new RuntimeException(e);
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}