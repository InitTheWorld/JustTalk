package TestLab.JustTalk_Common.Message;

import com.alibaba.fastjson.JSON;

public class MessageStruct {
    /**
     * 类型
     */
    private String type;
    /**
     * 消息，JSON 格式
     */
    private String message;


    public MessageStruct()
    {

    }

    public MessageStruct(String type,Message message)
    {
        this.type = type;
        this.message = JSON.toJSONString(message);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public MessageStruct setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "MessageStruct{" +
                "type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
