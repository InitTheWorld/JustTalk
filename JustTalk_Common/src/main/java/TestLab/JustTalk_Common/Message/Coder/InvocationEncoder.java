package TestLab.JustTalk_Common.Message.Coder;

import TestLab.JustTalk_Common.Message.MessageStruct;
import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvocationEncoder extends MessageToByteEncoder<MessageStruct> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageStruct invocation, ByteBuf out) {
        // 将 Invocation 转换成 byte[] 数组
        byte[] content = JSON.toJSONBytes(invocation);
        // 写入 length
        out.writeInt(content.length);
        // 写入内容

        out.writeBytes(content);
        logger.info("[encode][连接({}) 编码了一条消息({})]", ctx.channel().id(), invocation.toString());
    }

}