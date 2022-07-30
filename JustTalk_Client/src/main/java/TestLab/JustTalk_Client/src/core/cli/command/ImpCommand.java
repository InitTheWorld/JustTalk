package TestLab.JustTalk_Client.src.core.cli.command;

import TestLab.JustTalk_Client.src.core.cli.dao.CommandDescription;


public interface ImpCommand {
    void creatDescription();
    String getCommandName();
    CommandDescription getCommandDescription();
    String execute();
}
