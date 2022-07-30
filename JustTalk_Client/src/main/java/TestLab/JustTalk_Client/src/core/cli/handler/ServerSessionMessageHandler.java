package TestLab.JustTalk_Client.src.core.cli.handler;

import TestLab.JustTalk_Client.src.core.communication.CommunicationProperty;
import TestLab.JustTalk_Common.Message.MessageHandler;
import TestLab.JustTalk_Common.Message.ServerMessage.ServerSessionMessage;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServerSessionMessageHandler implements MessageHandler<ServerSessionMessage> {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    CommunicationProperty communicationProperty;
    @Override
    public void execute(Channel channel, ServerSessionMessage message) {
        logger.info("[execute][收到连接({}) 的消息{}]", channel.id(),message.toString());
        communicationProperty.setSessionId(message.getSessionId());
    }

    @Override
    public String getType() {
        return ServerSessionMessage.TYPE;
    }
}
