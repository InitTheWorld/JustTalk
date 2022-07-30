package TestLab.JustTalk_Common.Message.CommanMessage;

import TestLab.JustTalk_Common.Message.Message;
import org.springframework.stereotype.Component;

@Component
public class UserCommunicationMessage implements Message {
    private String txt;
    private String video;
    private String pic;
    private String date;

    public static final String TYPE = "USER_COMMUNICATION_MESSAGE";

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UserCommunicationMessage{" +
                "txt='" + txt + '\'' +
                ", video='" + video + '\'' +
                ", pic='" + pic + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
