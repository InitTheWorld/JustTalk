package TestLab.JustTalk_Common.Util;

import org.springframework.stereotype.Component;

@Component
public class StatusCode {
    public String success( )
    {
        return "SUCCESS";
    }
    public String failed( )
    {
        return "FAILED";
    }
    public String loggingSuccess( ) { return "LOGGING SUCCESS"; }
    public String registerSuccess( ) { return "REGISTER SUCCESS"; }
    public String wrong_command( )
    {
        return "WRONG COMMAND";
    }
    public String exit( )
    {
        return "EXIT";
    }
}
