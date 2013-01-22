package net.slowvic.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import net.slowvic.util.AppContextUtil;

import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SpringApp {
    private JmsTemplate jmsTemplate;

    private Destination destination;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void sendMessage() {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session)
                throws JMSException {
                return session.createTextMessage("使用spring发送jms消息");
            }
        });
    }

    public static void main(String[] args) {
        ApplicationContext ctx = AppContextUtil.getApplicationContext();
        SpringApp sa = ctx.getBean(SpringApp.class);
        sa.sendMessage();
        System.exit(1);
    }
}
