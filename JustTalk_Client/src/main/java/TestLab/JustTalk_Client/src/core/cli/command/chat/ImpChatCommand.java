package TestLab.JustTalk_Client.src.core.cli.command.chat;

import TestLab.JustTalk_Client.src.core.cli.dao.CommandDescription;

public interface ImpChatCommand {
    void creatDescription();
    String getCommandName();
    CommandDescription getCommandDescription();
    String execute();
}
