package net.slowvic.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class SimpleMessageListener implements MessageListener {

    public void onMessage(Message msg) {
        if (msg instanceof TextMessage) {
            TextMessage txtMessage = (TextMessage) msg;
            try {
                System.out.println("已接收,消息为:" + txtMessage.getText());
            }
            catch (JMSException e) {
                System.out.println("this is not a text message.");
                e.printStackTrace();
            }
        }
    }
}
