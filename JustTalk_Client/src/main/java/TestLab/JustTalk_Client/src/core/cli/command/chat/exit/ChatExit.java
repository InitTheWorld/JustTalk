package TestLab.JustTalk_Client.src.core.cli.command.chat.exit;

import TestLab.JustTalk_Client.src.core.cli.command.ImpExitCommand;
import TestLab.JustTalk_Client.src.core.cli.command.chat.ImpChatCommand;
import TestLab.JustTalk_Client.src.core.cli.dao.CommandDescription;
import TestLab.JustTalk_Common.Util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ChatExit implements ImpChatCommand, ImpExitCommand {
    @Autowired
    StatusCode statusCode;


    String CommandName = "EXIT";
    private CommandDescription exitDescription;

    @Override
    public void creatDescription(){
        this.exitDescription = new CommandDescription(new StringBuffer(CommandName),new StringBuffer("exit chat menu"));
    }

    @Override
    public CommandDescription getCommandDescription(){
        return this.exitDescription;
    }
    @Override
    public String getCommandName(){
        return CommandName;
    }
    @Override
    public String execute(){

        return statusCode.exit();
    }
}
