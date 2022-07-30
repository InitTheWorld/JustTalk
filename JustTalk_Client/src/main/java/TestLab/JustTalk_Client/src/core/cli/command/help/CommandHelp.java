package TestLab.JustTalk_Client.src.core.cli.command.help;

import TestLab.JustTalk_Client.src.core.cli.command.ApplicationContextProvider;
import TestLab.JustTalk_Client.src.core.cli.command.ImpCommand;
import TestLab.JustTalk_Client.src.core.cli.command.ImpHelpCommand;
import TestLab.JustTalk_Client.src.core.cli.dao.CommandDescription;
import TestLab.JustTalk_Common.Util.StatusCode;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CommandHelp implements ImpCommand, ImpHelpCommand {
    @Autowired
    StatusCode statusCode;

    String CommandName = "HELP";
    private CommandDescription helpDescription;
    @Autowired
    ApplicationContextProvider applicationContextProvider;
    @Override
    public void creatDescription(){
        this.helpDescription = new CommandDescription(new StringBuffer(CommandName),new StringBuffer("help menu"));
    }
    @Override
    public CommandDescription getCommandDescription(){
        return this.helpDescription;
    }
    @Override
    public String getCommandName(){
        return CommandName;
    }
    @Override
    public String execute(){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("HELP MENU");
        System.out.println("----------------------------------------------------------------------");

        try{
            Map<String, ImpCommand> commandMap = applicationContextProvider.getApplicationContext().getBeansOfType(ImpCommand.class);
            for( String key : commandMap.keySet() )
            {
                System.out.println(commandMap.get(key).getCommandDescription().toString());
            }
        }catch (BeansException e)
        {
            //todo
        }

        System.out.println("----------------------------------------------------------------------");
        System.out.println("END");
        System.out.println("----------------------------------------------------------------------");
        return statusCode.success();
    }
}
