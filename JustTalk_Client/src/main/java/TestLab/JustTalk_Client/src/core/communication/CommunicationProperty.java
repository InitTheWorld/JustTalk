package TestLab.JustTalk_Client.src.core.communication;

import org.springframework.stereotype.Component;

@Component
public class CommunicationProperty {
    public static String sessionId;

    public static String userName;

    public static String userMail;

    public static Boolean loginFlag=false;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public Boolean getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(Boolean loginFlag) {
        this.loginFlag = loginFlag;
    }
}
