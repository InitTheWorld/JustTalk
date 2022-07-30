package TestLab.JustTalk_Client.src.core.cli.command;

import TestLab.JustTalk_Client.src.core.cli.CliOperate;
import TestLab.JustTalk_Client.src.core.communication.Client;
import TestLab.JustTalk_Client.src.core.communication.CommunicationProperty;
import TestLab.JustTalk_Common.Message.UserPropery.UserPropertyLoggingMessage;
import TestLab.JustTalk_Common.Message.UserPropery.UserPropertyRegisterMessage;
import TestLab.JustTalk_Common.Message.MessageStruct;
import TestLab.JustTalk_Common.Util.Encryption;
import TestLab.JustTalk_Common.Util.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserPropertyManage {
    @Autowired
    UserPropertyLoggingMessage userPropertyLoggingMessage;
    @Autowired
    UserPropertyRegisterMessage userPropertyRegisterMessage;
    @Autowired
    CommunicationProperty communicationProperty;
    @Autowired
    StatusCode statusCode;
    @Autowired
    CliOperate cliOperate;
    @Autowired
    Encryption encryption;
    @Autowired
    Client client;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public String getUserProperty()
    {
        String msgType;
        String status = statusCode.failed();
        for (int loop = 0 ; loop < 10 ; loop++)
        {
            System.out.println("[login] please choose register or login");
            try {
                msgType = cliOperate.CliOperate_getString();
            }catch (IOException e){
                return statusCode.failed();
            }
            if(msgType.equals("REGISTER") || msgType.toUpperCase().equals("REGISTER"))
            {
                status = doRegister();
            }
            else
            {
                status = doLogging();
            }

            if(status==statusCode.success())
            {
                break;
            }
        }
        return status;
    }
    public String doLogging()
    {
        String userMail;
        String password;
        String status;

        System.out.println("[login] please write your mail");
        System.out.print("[mail]");
        userPropertyLoggingMessage.setSessionId(communicationProperty.getSessionId());
        System.out.print(communicationProperty.getSessionId());
        try {
            userMail = cliOperate.CliOperate_getString();
        }catch (IOException e){
            return statusCode.failed();
        }
        userPropertyLoggingMessage.setUserMail(userMail);

        System.out.println("[login] please write your password");
        System.out.print("[password]");
        try {
            password = cliOperate.CliOperate_getString();
        }catch (IOException e){
            return statusCode.failed();
        }

        userPropertyLoggingMessage.setPassWord(password);

        MessageStruct messageStruct = new MessageStruct(UserPropertyLoggingMessage.getTYPE(),userPropertyLoggingMessage);

        client.send(messageStruct);
        communicationProperty.setUserMail(userMail);
        status = getServerMsg();
        return status;
    }
    public String doRegister()
    {
        String userName;
        String password;
        String userMail;
        String status;

        System.out.println("[register] please write your name");
        System.out.print("[username]");
        userPropertyRegisterMessage.setSessionId(communicationProperty.getSessionId());

        try {
            userName = cliOperate.CliOperate_getString();
        }catch (IOException e){
            return statusCode.failed();
        }
        userPropertyRegisterMessage.setUserName(userName);

        System.out.println("[register] please write your name");
        System.out.print("[password]");
        try {
            password = cliOperate.CliOperate_getString();
        }catch (IOException e){
            return statusCode.failed();
        }
        userPropertyRegisterMessage.setPassWord(password);

        System.out.println("[register] please write your mail");
        System.out.print("[userMail]");

        try {
            userMail = cliOperate.CliOperate_getString();
        }catch (IOException e){
            return statusCode.failed();
        }
        userPropertyRegisterMessage.setUserMail(userMail);

        MessageStruct messageStruct = new MessageStruct(UserPropertyRegisterMessage.getTYPE(),userPropertyRegisterMessage);

        client.send(messageStruct);
        communicationProperty.setUserMail(userMail);
        status = getServerMsg();
        return status;
    }

    public String getServerMsg()
    {
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        String status = statusCode.failed();
        while(endTime-startTime<5000)
        {
            if(communicationProperty.getLoginFlag())
            {
                status = statusCode.success();
                break;
            }
            endTime = System.currentTimeMillis();
        }

        return status;
    }
}
