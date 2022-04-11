package JustTalk.Common.Message;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Component
@ChannelHandler.Sharable
public class MessageDispatcher extends SimpleChannelInboundHandler<MessageStruct> {

    private MessageHandlerContainer messageHandlerContainer;
    @Autowired
    public MessageDispatcher( MessageHandlerContainer messageHandlerContainer )
    {
        this.messageHandlerContainer = messageHandlerContainer;
    }

    private final ExecutorService executor =  Executors.newFixedThreadPool(200);
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageStruct messageStruct) {
        MessageHandler messageHandler = messageHandlerContainer.getMessageHandler(messageStruct.getType());
        // 获得  MessageHandler 处理器 的消息类
        Class<? extends Message> messageClass = MessageHandlerContainer.getMessageClass(messageHandler);
        // 解析消息
        Message message = JSON.parseObject(messageStruct.getMessage(), messageClass);
        // 执行逻辑
        executor.submit(new Runnable() {

            @Override
            public void run() {
                // noinspection unchecked
                messageHandler.execute(ctx.channel(), message);
            }
        });
    }
}
