package TestLab.JustTalk_Client.src.core.cli.command;

import TestLab.JustTalk_Client.src.core.cli.CliOperate;
import TestLab.JustTalk_Client.src.core.cli.command.exit.CommandExit;
import TestLab.JustTalk_Client.src.core.communication.Client;
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
public class MainMenu {
    @Autowired
    StatusCode statusCode;
    @Autowired
    CliOperate cliOperate;
    @Autowired
    UserCommunicationMessage userCommunicationMessage;
    @Autowired
    Client client;
    @Autowired
    ApplicationContextProvider applicationContextProvider;
    @Autowired
    UserPropertyManage userPropertyManage;

    private Logger logger = LoggerFactory.getLogger(getClass());

    Map<String, ImpCommand> commandMap;
    String status;
    public String execute()
    {

        logger.info("[MainMenu][({})]", "Main Menu Start");
        commandMap = applicationContextProvider.getApplicationContext().getBeansOfType(ImpCommand.class);
        creatCommandDescription();
        MainMenu_PrintTile();

        status = userPropertyManage.getUserProperty();
        if(status==statusCode.failed())
        {
            logger.info("[MainMenu][({})]", "Should login first");
            commandMap.get(CommandExit.class).execute();
            MainMenu_PrintEnd();
            return status;
        }

        while(true)
        {

            System.out.print("[MainTable]");
            status = doExecute();

            if(status == statusCode.exit())
            {
                break;
            }
        }
        MainMenu_PrintEnd();
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
            logger.error("[MainMenu][({}) 失败]", "MainMenu_creatCommandDescription");
        }
        return status;
    }
    public String doExecute()
    {
        String userCommand;
        try {
            userCommand = cliOperate.CliOperate_getString();
        }catch (IOException e){
            return statusCode.failed();
        }

        try{

            for( String key : commandMap.keySet() )
            {
                if(userCommand.equals(commandMap.get(key).getCommandName()) || userCommand.toUpperCase().equals(commandMap.get(key).getCommandName()) )
                {
                    status = commandMap.get(key).execute();
                }
            }

        }catch (BeansException e)
        {
            status = statusCode.exit();
            logger.error("[MainMenu][({}) 失败]", "MainMenu_doExecute");
        }
        return status;
    }

    public void MainMenu_PrintTile()
    {
        System.out.println("######################################################################");
        System.out.println("############################# JUST  TALK #############################");
        System.out.println("######################################################################");
    }

    public void MainMenu_PrintEnd()
    {
        System.out.println("######################################################################");
        System.out.println("#############################     END    #############################");
        System.out.println("######################################################################");
    }


}
