package TestLab.JustTalk_Common.Message.ServerMessage;

import TestLab.JustTalk_Common.Message.Message;

public class ServerSessionMessage implements Message {
    public static final String TYPE = "SERVER_SESSION_MESSAGE";
    private String sessionId;
    public ServerSessionMessage(String sessionId)
    {
        this.sessionId = sessionId;
    }
    public static String getTYPE() {
        return TYPE;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "ServerSessionMessage{" +
                "sessionId='" + sessionId + '\'' +
                '}';
    }
}
