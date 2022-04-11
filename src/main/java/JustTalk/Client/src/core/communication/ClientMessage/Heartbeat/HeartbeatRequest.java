package JustTalk.Client.src.core.communication.ClientMessage.Heartbeat;

import JustTalk.Common.Message.Message;

public class HeartbeatRequest implements Message {
    public static final String TYPE = "HEARTBEAT_REQUEST";

    @Override
    public String toString() {
        return "HeartbeatRequest{}";
    }
}
