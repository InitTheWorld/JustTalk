package TestLab.JustTalk_Server.src.core.communication.handler;

import TestLab.JustTalk_Common.Message.Coder.InvocationDecoder;
import TestLab.JustTalk_Common.Message.Coder.InvocationEncoder;
import TestLab.JustTalk_Common.Message.MessageDispatcher;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/*
* add custom function to channel
*/
@Component
public class ServerHandlerInitializer extends ChannelInitializer<Channel> {
    //Heartbeat time
    private static final Integer READ_TIMEOUT_SECONDS = 3 * 60;

    private MessageDispatcher messageDispatcher;
    private ServerHandler serverHandler;
    @Autowired
    public void ServerHandlerInitializer (MessageDispatcher messageDispatcher,ServerHandler serverHandler){
        this.messageDispatcher = messageDispatcher;
        this.serverHandler = serverHandler;
    }

    @Override
    protected void initChannel(Channel channel){
        ChannelPipeline channelPipeline = channel.pipeline();
        channelPipeline
                .addLast( new ReadTimeoutHandler(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)) // timeout check
                .addLast( new InvocationEncoder() )                                       // Message Encoder
                .addLast( new InvocationDecoder() )                                       // Message Decoder
                .addLast( messageDispatcher )                                             // messageDispatcher
                .addLast( serverHandler );

    }
}
