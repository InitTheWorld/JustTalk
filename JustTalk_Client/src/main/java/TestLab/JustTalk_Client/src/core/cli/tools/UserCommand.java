package TestLab.JustTalk_Client.src.core.cli.tools;

import java.util.ArrayList;
import java.util.Scanner;

public class UserCommand {
    private StringBuilder userCommand ;
    private ArrayList<String> commandList;
    public String getUserCommand( ArrayList<String> commandList )
    {
        this.commandList = commandList;
        StringBuilder userCommand = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while( scanner.hasNext() )
        {
            //TODO
        }

        return userCommand.toString();
    }


    private ArrayList<String> completionCommand( )
    {
        ArrayList<String> mayCommand = new ArrayList<String>();

        return mayCommand;
    }
}
