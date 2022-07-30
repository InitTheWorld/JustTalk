package TestLab.JustTalk_Server.src.dao;


public class UserProperty {
    private long id;
    private String user_name;
    private String user_mail;
    private String user_epassword;
    private int user_state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getUser_epassword() {
        return user_epassword;
    }

    public void setUser_epassword(String user_epassword) {
        this.user_epassword = user_epassword;
    }

    public int getUser_state() {
        return user_state;
    }

    public void setUser_state(int user_state) {
        this.user_state = user_state;
    }

    @Override
    public String toString() {
        return "UserProperty{" +
                "id=" + id +
                ", user_name=" + user_name +
                ", user_mail=" + user_mail +
                ", user_epassword=" + user_epassword +
                ", user_state=" + user_state +
                '}';
    }
}
