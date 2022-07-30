package TestLab.JustTalk_Common.Message.ServerMessage;

import TestLab.JustTalk_Common.Message.Message;
import org.springframework.stereotype.Component;

@Component
public class ServerResponseMessage implements Message {
    private String serverResponseCode;
    public static final String TYPE = "SERVER_RESPONSE_MESSAGE";

    public static String getTYPE() {
        return TYPE;
    }

    public String getServerResponseCode() {
        return serverResponseCode;
    }

    public void setServerResponseCode(String serverResponseCode) {
        this.serverResponseCode = serverResponseCode;
    }

    @Override
    public String toString() {
        return "ServerResponseMessage{" +
                "serverResponseCode='" + serverResponseCode + '\'' +
                '}';
    }
}
