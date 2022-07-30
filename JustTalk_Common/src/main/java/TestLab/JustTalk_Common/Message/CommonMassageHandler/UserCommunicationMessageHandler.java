package TestLab.JustTalk_Common.Message.CommonMassageHandler;

import TestLab.JustTalk_Common.Message.CommanMessage.UserCommunicationMessage;
import TestLab.JustTalk_Common.Message.MessageHandler;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserCommunicationMessageHandler implements MessageHandler<UserCommunicationMessage> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(Channel channel, UserCommunicationMessage message) {
        logger.info("[execute][收到连接({}) 的消息{}]", channel.id(),message.toString());
    }

    @Override
    public String getType() {
        return UserCommunicationMessage.TYPE;
    }
}
