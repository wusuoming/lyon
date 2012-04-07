package net.slowvic.jms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import net.slowvic.modal.bean.Mail;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class BackOfficeImplWithoutSpring implements BackOffice {

    public Mail receiveMail() {
        ConnectionFactory cf = new ActiveMQConnectionFactory(
            "tcp://localhost:61616");
        Destination destination = new ActiveMQQueue("mail.queue");
        Connection conn = null;
        try {
            conn = cf.createConnection();
            Session session = conn.createSession(false,
                Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(destination);

            conn.start();
            MapMessage message = (MapMessage) consumer.receive();
            Mail mail = new Mail();
            mail.setFrom(message.getString("from"));
            mail.setTo(message.getString("to"));
            mail.setSubject(message.getString("subject"));
            mail.setContent(message.getString("content"));
            mail.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse(message.getString("date")));
            session.close();
            return mail;
        }
        catch (JMSException e) {
            throw new RuntimeException(e);
        }
        catch (ParseException e) {
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
        BackOffice office = new BackOfficeImplWithoutSpring();
        Mail mail = office.receiveMail();
        System.out.println("发件人  ：" + mail.getFrom());
        System.out.println("收件人  ：" + mail.getTo());
        System.out.println("主题    ：" + mail.getSubject());
        System.out.println("正文    ：" + mail.getContent());
        System.out.println("发送时间："
            + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(mail.getDate()));
    }
}