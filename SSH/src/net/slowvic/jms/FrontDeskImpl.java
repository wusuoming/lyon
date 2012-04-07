package net.slowvic.jms;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import net.slowvic.modal.bean.Mail;
import net.slowvic.util.SpringBeanUtil;

import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.support.JmsGatewaySupport;
import org.springframework.transaction.annotation.Transactional;

public class FrontDeskImpl extends JmsGatewaySupport implements FrontDesk {

    @Transactional
    public void sendMail(final Mail mail) {
        getJmsTemplate().send(new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                message.setString("from", mail.getFrom());
                message.setString("to", mail.getTo());
                message.setString("subject", mail.getSubject());
                message.setString("content", mail.getContent());
                message.setString("date", new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss")
                    .format(mail.getDate()));
                return message;
            }
        });
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringBeanUtil.getApplicationContext();
        FrontDesk desk = context.getBean("frontDesk", FrontDesk.class);
        BackOffice office = context.getBean("backOffice", BackOffice.class);
        Mail mail = new Mail();
        mail.setFrom("Sherlokk");
        mail.setTo("Milky");
        mail.setSubject("love");
        mail.setContent("I love U");
        mail.setDate(new Date());
        desk.sendMail(mail);
        Mail receivedMail = office.receiveMail();
        System.out.println("发件人  ：" + receivedMail.getFrom());
        System.out.println("收件人  ：" + receivedMail.getTo());
        System.out.println("主题    ：" + receivedMail.getSubject());
        System.out.println("正文    ：" + receivedMail.getContent());
        System.out.println("发送时间："
            + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(receivedMail.getDate()));

    }
}