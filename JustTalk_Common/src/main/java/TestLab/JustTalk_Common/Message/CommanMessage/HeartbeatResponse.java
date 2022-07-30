package TestLab.JustTalk_Common.Message.CommanMessage;

import TestLab.JustTalk_Common.Message.Message;

public class HeartbeatResponse implements Message {

    /**
     * 类型 - 心跳响应
     */
    public static final String TYPE = "HEARTBEAT_RESPONSE";

    @Override
    public String toString() {
        return "HeartbeatResponse{}";
    }

}