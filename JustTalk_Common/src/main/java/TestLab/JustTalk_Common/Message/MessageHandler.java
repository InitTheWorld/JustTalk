package TestLab.JustTalk_Common.Message;

import io.netty.channel.Channel;

public interface  MessageHandler<T extends Message> {

    void execute(Channel channel, T message);

    /**
     * @return 消息类型，即每个 Message 实现类上的 TYPE 静态字段
     */
    String getType();
}
