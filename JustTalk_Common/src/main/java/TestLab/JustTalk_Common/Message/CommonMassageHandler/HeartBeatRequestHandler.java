package TestLab.JustTalk_Common.Message.CommonMassageHandler;

import TestLab.JustTalk_Common.Message.CommanMessage.HeartbeatRequest;
import TestLab.JustTalk_Common.Message.CommanMessage.UserCommunicationMessage;
import TestLab.JustTalk_Common.Message.MessageHandler;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HeartBeatRequestHandler implements MessageHandler<HeartbeatRequest> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(Channel channel, HeartbeatRequest message) {
        logger.info("[execute][收到连接({}) 的消息]", channel.id());
    }

    @Override
    public String getType() {
        return HeartbeatRequest.TYPE;
    }
}
