package JustTalk.Server.src.core.communication;

import JustTalk.Commom.Message.MessageStruct;
import JustTalk.Commom.StatusCode;
import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class ChannelManager {
    private static final AttributeKey<String> CHANNEL_ATTR_KEY_USER = AttributeKey.newInstance("user");
    private Logger logger = LoggerFactory.getLogger(getClass());
    /*store user, channel id and channel*/
    private ConcurrentMap<ChannelId, Channel> channels = new ConcurrentHashMap<>();
    private ConcurrentMap<String, Channel> userChannels = new ConcurrentHashMap<>();

    private StatusCode statusCode;
    @Autowired
    public void MessageManager (StatusCode statusCode){
        this.statusCode = statusCode;
    }

    public void add(Channel channel)
    {
        channels.put(channel.id(),channel);
        logger.info("[add][连接channel.id = ({})加入]", channel.id());
    }

    public void adduser(Channel channel , String user)
    {
        if( channels.containsKey(channel.id()) )
        {
            logger.info("[adduser][连接channel.id = ({})不存在]", channel.id());
            return;
        }
        channel.attr(CHANNEL_ATTR_KEY_USER).set(user);
        userChannels.put(user,channel);
    }

    public void remove(Channel channel)
    {
        channels.remove(channel.id());
        if (channel.hasAttr(CHANNEL_ATTR_KEY_USER)) {
            userChannels.remove(channel.attr(CHANNEL_ATTR_KEY_USER).get());
        }
        logger.info("[remove][连接({})离开]", channel.id());
    }

    public String sendMsgtoOne(String user , MessageStruct message)
    {
        Channel channel = userChannels.get(user);
        if( channel == null )
        {
            logger.info("[sendMsgtoOne][连接user = ({})不存在]", user);
            return statusCode.failed();
        }
        if( !channel.isActive() )
        {
            logger.info("[sendMsgtoOne][连接 channel.id = ({})未激活]", channel.id());
            return statusCode.failed();
        }
        channel.writeAndFlush(message);
        return statusCode.success();
    }

    public String sendMsgtoGroup(String[] users , MessageStruct message )
    {
        for(String user : users)
        {
            sendMsgtoOne(user,message);
        }
        return statusCode.success();
    }

}
