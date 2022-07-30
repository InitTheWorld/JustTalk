package TestLab.JustTalk_Client.src.core.cli.handler;

import TestLab.JustTalk_Client.src.core.communication.CommunicationProperty;
import TestLab.JustTalk_Common.Message.MessageHandler;
import TestLab.JustTalk_Common.Message.ServerMessage.ServerResponseMessage;
import TestLab.JustTalk_Common.Util.StatusCode;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServerResponseMessageHandler implements MessageHandler<ServerResponseMessage> {
    @Autowired
    StatusCode statusCode;
    @Autowired
    CommunicationProperty communicationProperty;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void execute(Channel channel, ServerResponseMessage message) {
        logger.info("[execute][收到连接({}) 的消息{}]", channel.id(),message.toString());
        if ( message.getServerResponseCode().equals(statusCode.loggingSuccess()) )
        {
            communicationProperty.setLoginFlag(true);
            System.out.println("logging successes " + communicationProperty.getLoginFlag());
        }
        else if( message.getServerResponseCode().equals(statusCode.loggingSuccess()) )
        {
            communicationProperty.setLoginFlag(true);
        }


    }

    @Override
    public String getType() {
        return ServerResponseMessage.TYPE;
    }
}
