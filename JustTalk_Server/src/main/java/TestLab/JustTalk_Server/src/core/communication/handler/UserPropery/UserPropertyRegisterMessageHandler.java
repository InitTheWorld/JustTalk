package TestLab.JustTalk_Server.src.core.communication.handler.UserPropery;

import TestLab.JustTalk_Common.Message.MessageHandler;
import TestLab.JustTalk_Common.Message.MessageStruct;
import TestLab.JustTalk_Common.Message.ServerMessage.ServerResponseMessage;
import TestLab.JustTalk_Common.Message.UserPropery.UserPropertyRegisterMessage;
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
public class UserPropertyRegisterMessageHandler implements MessageHandler<UserPropertyRegisterMessage> {
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
    public void execute(Channel channel, UserPropertyRegisterMessage message) {
        UserProperty userProperty = new UserProperty();
        userProperty.setUser_epassword(encryption.encode(message.getPassWord()));
        userProperty.setUser_mail(message.getUserMail());
        userProperty.setUser_name(message.getUserName());
        userProperty.setUser_state(1);

        long id = userPropertyMapper.insertUser(userProperty);
        ServerResponseMessage serverResponseMessage = new ServerResponseMessage();

        if( id > 0 )
        {
            serverResponseMessage.setServerResponseCode(statusCode.registerSuccess());
            MessageStruct messageStruct = new MessageStruct(ServerResponseMessage.getTYPE(),serverResponseMessage );
            channelManager.sendMsgtoOne(message.getSessionId(),messageStruct);
        }
        else
        {
            serverResponseMessage.setServerResponseCode(statusCode.failed());
            MessageStruct messageStruct = new MessageStruct(ServerResponseMessage.getTYPE(),serverResponseMessage );
            channelManager.sendMsgtoOne(message.getSessionId(),messageStruct);
        }
        System.out.print(id);
    }
    @Override
    public String getType() {
        return UserPropertyRegisterMessage.TYPE;
    }
}
