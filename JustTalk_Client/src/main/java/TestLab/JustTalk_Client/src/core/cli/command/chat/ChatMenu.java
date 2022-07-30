package TestLab.JustTalk_Client.src.core.cli.command.chat;

import TestLab.JustTalk_Client.src.core.cli.CliOperate;
import TestLab.JustTalk_Client.src.core.cli.command.ApplicationContextProvider;
import TestLab.JustTalk_Client.src.core.cli.command.ImpCommand;
import TestLab.JustTalk_Client.src.core.cli.dao.CommandDescription;
import TestLab.JustTalk_Common.Message.CommanMessage.UserCommunicationMessage;
import TestLab.JustTalk_Common.Util.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
@Component
public class ChatMenu implements ImpCommand{
    @Autowired
    StatusCode statusCode;
    @Autowired
    CliOperate cliOperate;
    @Autowired
    UserCommunicationMessage userCommunicationMessage;
    @Autowired
    ApplicationContextProvider applicationContextProvider;

    Map<String, ImpChatCommand> commandMap;
    private Logger logger = LoggerFactory.getLogger(getClass());
    String status;

    String CommandName = "FRIEND";
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
    public String execute() {
        logger.info("[ChatMenu][({})]", "Chat Menu Start");
        commandMap = applicationContextProvider.getApplicationContext().getBeansOfType(ImpChatCommand.class);
        creatCommandDescription();
        while(true)
        {
            System.out.print("[CHAT]");
            status = doExecute();

            if(status == statusCode.exit())
            {
                break;
            }
        }
        return statusCode.success();
    }

    public String creatCommandDescription()
    {
        try{
            for( String key : commandMap.keySet() )
            {
                commandMap.get(key).creatDescription();
            }
        }catch (BeansException e)
        {
            status = statusCode.failed();
            logger.error("[ChatMenu][({}) 失败]", "MainMenu_creatCommandDescription");
        }
        return status;
    }
    public String doExecute()
    {
        String UserCommand;
        try {
            UserCommand = cliOperate.CliOperate_getString();
        }catch (IOException e){
            return statusCode.failed();
        }

        try{
            boolean flag = false;
            for( String key : commandMap.keySet() )
            {
                if(UserCommand.equals(commandMap.get(key).getCommandName()) || UserCommand.toUpperCase().equals(commandMap.get(key).getCommandName()) )
                {
                    flag = true;
                    status = commandMap.get(key).execute();
                }
            }
            if( flag == false )
            {
                System.out.println( "wrong command! try \"help\"" );
            }

        }catch (BeansException e)
        {
            status = statusCode.exit();
            logger.error("[ChatMenu][({}) 失败]", "MainMenu_doExecute");
        }
        return status;
    }
}
