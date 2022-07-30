package TestLab.JustTalk_Common.Message.CommanMessage;


import TestLab.JustTalk_Common.Message.Message;

public class HeartbeatRequest implements Message {
    public static final String TYPE = "HEARTBEAT_REQUEST";

    @Override
    public String toString() {
        return "HeartbeatRequest{}";
    }
}
