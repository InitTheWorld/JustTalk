package JustTalk.Common.Message;

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

    public MessageStruct(String type,String message)
    {
        this.type = type;
        this.message = message;
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

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageStruct{" +
                "type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
