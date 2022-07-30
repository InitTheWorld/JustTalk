package TestLab.JustTalk_Client.src.core.cli.command.exit;

import TestLab.JustTalk_Client.src.core.cli.command.ImpCommand;
import TestLab.JustTalk_Client.src.core.cli.command.ImpExitCommand;
import TestLab.JustTalk_Client.src.core.cli.dao.CommandDescription;
import TestLab.JustTalk_Client.src.core.communication.Client;
import TestLab.JustTalk_Common.Util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CommandExit implements ImpCommand, ImpExitCommand {
    @Autowired
    StatusCode statusCode;
    @Autowired
    Client client;

    String CommandName = "EXIT";
    private CommandDescription exitDescription;

    @Override
    public void creatDescription(){
        this.exitDescription = new CommandDescription(new StringBuffer(CommandName),new StringBuffer("exit the JUST TALK"));
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
        client.shutdown();
        return statusCode.exit();
    }
}
