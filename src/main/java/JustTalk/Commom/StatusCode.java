package JustTalk.Commom;

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
}