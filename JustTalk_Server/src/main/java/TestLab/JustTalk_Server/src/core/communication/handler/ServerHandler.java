package TestLab.JustTalk_Server.src.core.communication.handler;

import TestLab.JustTalk_Common.Message.MessageStruct;
import TestLab.JustTalk_Common.Message.ServerMessage.ServerSessionMessage;
import TestLab.JustTalk_Server.src.core.communication.ChannelManager;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
@ChannelHandler.Sharable
public class ServerHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ChannelManager channelManager;

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        // 从管理器中添加
        channelManager.add(ctx.channel());
        UUID uuid = UUID.randomUUID();
        String sessionId =  uuid.toString().replace("-", "");
        channelManager.addUser(ctx.channel(),sessionId);
        System.out.println("sessionId = "+sessionId);
        ServerSessionMessage serverSessionMessage = new ServerSessionMessage(sessionId);
        MessageStruct messageStruct = new MessageStruct(ServerSessionMessage.getTYPE(),serverSessionMessage);
        channelManager.sendMsgtoOne(sessionId,messageStruct);

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) {
        // 从管理器中移除
        channelManager.remove(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.error("[exceptionCaught][连接({}) 发生异常]", ctx.channel().id(), cause);
        // 断开连接
        ctx.channel().close();
    }

}
