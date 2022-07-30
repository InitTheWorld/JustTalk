package TestLab.JustTalk_Common.Message.UserPropery;

import TestLab.JustTalk_Common.Message.Message;
import org.springframework.stereotype.Component;

@Component
public class UserPropertyLoggingMessage implements Message {
    private String sessionId;
    private String userName;
    private String passWord;
    private String userMail;
    private String verifyCode;
    public static final String TYPE = "USER_LOGGING_MESSAGE";

    public static String getTYPE() {
        return TYPE;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String encodePassWord) {
        this.passWord = encodePassWord;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    @Override
    public String toString() {
        return "UserPropertyMessage{" +
                "userName='" + userName + '\'' +
                ", encodePassWord='" + passWord + '\'' +
                ", userMail='" + userMail + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
