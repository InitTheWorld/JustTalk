package TestLab.JustTalk_Client.src.core.cli.command.chat;

import TestLab.JustTalk_Client.src.core.cli.CliOperate;
import TestLab.JustTalk_Client.src.core.cli.dao.CommandDescription;
import TestLab.JustTalk_Client.src.core.communication.Client;
import TestLab.JustTalk_Common.Message.CommanMessage.UserCommunicationMessage;
import TestLab.JustTalk_Common.Message.MessageStruct;
import TestLab.JustTalk_Common.Util.StatusCode;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class CommandChat implements ImpChatCommand {
    @Autowired
    StatusCode statusCode;
    @Autowired
    Client client;
    @Autowired
    CliOperate cliOperate;
    @Autowired
    UserCommunicationMessage userCommunicationMessage;

    String CommandName = "CHAT";
    private CommandDescription chatDescription;

    @Override
    public void creatDescription(){
        this.chatDescription = new CommandDescription(new StringBuffer(CommandName),new StringBuffer("into the chat menu"));
    }

    @Override
    public CommandDescription getCommandDescription(){
        return this.chatDescription;
    }
    @Override
    public String getCommandName(){
        return CommandName;
    }
    @Override
    public String execute(){
        userCommunicationMessage.setDate(new Date().toString());
        String txt;
        try {
            txt = cliOperate.CliOperate_getString();
        }catch (IOException e){
            return statusCode.failed();
        }
        userCommunicationMessage.setTxt(txt);

        MessageStruct messageStruct = new MessageStruct("USER_COMMUNICATION_MESSAGE",userCommunicationMessage);
        client.send(messageStruct);

        return statusCode.success();
    }

}
