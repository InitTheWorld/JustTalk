package TestLab.JustTalk_Server.src.core.communication.handler.UserPropery;

import TestLab.JustTalk_Common.Message.MessageStruct;
import TestLab.JustTalk_Common.Message.ServerMessage.ServerResponseMessage;
import TestLab.JustTalk_Common.Message.UserPropery.UserPropertyLoggingMessage;
import TestLab.JustTalk_Common.Message.MessageHandler;
import TestLab.JustTalk_Common.Util.Encryption;
import TestLab.JustTalk_Common.Util.StatusCode;
import TestLab.JustTalk_Server.src.core.communication.ChannelManager;
import TestLab.JustTalk_Server.src.dao.UserProperty;
import TestLab.JustTalk_Server.src.mapper.UserPropertyMapper;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UserPropertyLoggingMessageHandler implements MessageHandler<UserPropertyLoggingMessage> {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserPropertyMapper userPropertyMapper;
    @Autowired
    Encryption encryption;
    @Autowired
    private ChannelManager channelManager;
    @Autowired
    StatusCode statusCode;
    @Override
    public void execute(Channel channel, UserPropertyLoggingMessage message) {

        UserProperty userProperty = userPropertyMapper.findUserByEmail(message.getUserMail());
        ServerResponseMessage serverResponseMessage = new ServerResponseMessage();

        if(encryption.decode(userProperty.getUser_epassword(), message.getPassWord()))
        {
            serverResponseMessage.setServerResponseCode(statusCode.loggingSuccess());
            MessageStruct messageStruct = new MessageStruct(ServerResponseMessage.getTYPE(),serverResponseMessage );
            channelManager.sendMsgtoOne(message.getSessionId(),messageStruct);
        }
        else
        {
            serverResponseMessage.setServerResponseCode(statusCode.failed());
            MessageStruct messageStruct = new MessageStruct(ServerResponseMessage.getTYPE(),serverResponseMessage );
            channelManager.sendMsgtoOne(message.getSessionId(),messageStruct);
        }
    }

    @Override
    public String getType() {
        return UserPropertyLoggingMessage.TYPE;
    }

}
