package net.slowvic.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class BaseApp {
    public static void main(String[] args) throws Exception {
        sendMsg();
        revMsg();
    }

    /**
     * 发送消息
     * @throws JMSException
     */
    public static void sendMsg() throws JMSException {
        // 创建Connection工厂
        ConnectionFactory fac = new ActiveMQConnectionFactory(
            ActiveMQConnection.DEFAULT_USER,
            ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
        // 创建Connection
        Connection conn = fac.createConnection();
        // 启动Connection
        conn.start();
        // 创建操作上下文，第一个参数true表示PTP模型
        Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
        // 创建生产者队列 备注：Queue是Destination的子接口
        Queue sendQ = new ActiveMQQueue("sendinfo");
        // 创建生产者
        MessageProducer producer = session.createProducer(sendQ);
        // 创建消息
        Message msg = session.createTextMessage("JMS测试");
        // 设置消息发送模式 PERSISTENT表示JMS服务器重启后仍旧能获取消息
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        // 发送消息
        producer.send(msg);
        // 提交session
        session.commit();
        // 关闭连接
        conn.close();
    }

    /**
     * 异步接收消息
     * @throws Exception
     */
    public static void revMsg() throws Exception {
        ConnectionFactory fac = new ActiveMQConnectionFactory(
            ActiveMQConnection.DEFAULT_USER,
            ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
        Connection conn = fac.createConnection();
        final Session session = conn.createSession(true,
            Session.AUTO_ACKNOWLEDGE);
        // 创建消费者队列
        Queue revQ = new ActiveMQQueue("sendinfo");
        // 消费者
        MessageConsumer consumer = session.createConsumer(revQ);
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message msg) {
                if (msg instanceof TextMessage) {
                    TextMessage txtMessage = (TextMessage) msg;
                    try {
                        MessageProducer reply = session.createProducer(msg
                            .getJMSReplyTo());
                        reply.send(session.createTextMessage("已收到"));
                        System.out.println(txtMessage.getText());
                    }
                    catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        conn.start();
        session.commit();
        conn.close();
    }

    /**
     * 同步接收消息
     * @throws Exception
     */
    public static void synRevMsg() throws Exception {
        ConnectionFactory fac = new ActiveMQConnectionFactory(
            ActiveMQConnection.DEFAULT_USER,
            ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
        Connection conn = fac.createConnection();
        conn.start();
        final Session session = conn.createSession(true,
            Session.AUTO_ACKNOWLEDGE);
        // 创建消费者队列
        Queue revQ = new ActiveMQQueue("sendinfo");
        // 消费者
        MessageConsumer consumer = session.createConsumer(revQ);
        while (true) {
            TextMessage message = (TextMessage) consumer.receive(1000);
            if (null != message)
                System.out.println("收到消息：" + message.getText());
            else
                break;
        }
        session.commit();
        conn.close();
    }
}
