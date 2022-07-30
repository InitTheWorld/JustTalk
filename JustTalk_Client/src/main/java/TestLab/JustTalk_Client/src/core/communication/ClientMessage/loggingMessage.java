package TestLab.JustTalk_Client.src.core.communication.ClientMessage;

import TestLab.JustTalk_Common.Message.Message;

public class loggingMessage implements Message {
    public static final String TYPE = "USER_LOGGING";
    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "HeartbeatRequest{}";
    }
}
