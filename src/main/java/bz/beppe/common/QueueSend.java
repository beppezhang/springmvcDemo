package bz.beppe.common;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class QueueSend {

	@Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 发送一条消息到指定的队列（目标）
     * 
     * @param queueName
     *            队列名称
     * @param message
     *            消息内容
     */
    public void send(String queueName, final String message) {
    	jmsTemplate.send(queueName, new MessageCreator() {
           

			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(message);
			}
        });
    }
}
