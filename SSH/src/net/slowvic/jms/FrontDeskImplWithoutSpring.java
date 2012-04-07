package net.slowvic.jms;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import net.slowvic.modal.bean.Mail;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class FrontDeskImplWithoutSpring implements FrontDesk {

    public void sendMail(Mail mail) {
        ConnectionFactory cf = new ActiveMQConnectionFactory(
            "tcp://localhost:61616");
        Destination destination = new ActiveMQQueue("mail.queue");
        Connection conn = null;
        try {
            conn = cf.createConnection();
            Session session = conn.createSession(false,
                Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);

            MapMessage message = session.createMapMessage();
            message.setString("from", mail.getFrom());
            message.setString("to", mail.getTo());
            message.setString("subject", mail.getSubject());
            message.setString("content", mail.getContent());
            message.setString("date", new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss")
                .format(mail.getDate()));
            producer.send(message);

            session.close();
        }
        catch (JMSException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (JMSException e) {

                }
            }
        }
    }

    public static void main(String[] args) {
        FrontDesk desk = new FrontDeskImplWithoutSpring();
        Mail mail = new Mail();
        mail.setFrom("Sherlokk");
        mail.setTo("Milky");
        mail.setSubject("love");
        mail.setContent("I love U");
        mail.setDate(new Date());
        desk.sendMail(mail);
    }
}