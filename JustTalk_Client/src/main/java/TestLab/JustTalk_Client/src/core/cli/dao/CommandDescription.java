package TestLab.JustTalk_Client.src.core.cli.dao;

public class CommandDescription {

    private StringBuffer commandDescribe_Name;

    private StringBuffer commandDescribe_Description;

    public CommandDescription()
    {

    }

    public CommandDescription(StringBuffer commandDescribe_Name,StringBuffer commandDescribe_Description)
    {
        this.commandDescribe_Description = commandDescribe_Description;
        this.commandDescribe_Name = commandDescribe_Name;
    }

    public String getCommandDescribe_Name() {
        return commandDescribe_Name.toString();
    }

    public void setCommandDescribe_Name(StringBuffer commandDescribe_Name) {
        commandDescribe_Name = commandDescribe_Name;
    }

    public String getCommandDescribe_Description() {
        return commandDescribe_Description.toString();
    }

    public void setCommandDescribe_Description(StringBuffer commandDescribe_Description) {
        commandDescribe_Description = commandDescribe_Description;
    }

    @Override
    public String toString() {
        int LINE_COMMAND_NAME_LEN = 20;
        int LINE_COMMAND_DESCRIPTION_LEN = 40;
        int NAME_LEN=0,DESCRIPTION_LEN=0;
        StringBuffer commandDescription = new StringBuffer();
        while(NAME_LEN<commandDescribe_Name.length()||DESCRIPTION_LEN<commandDescribe_Description.length())
        {
            if(NAME_LEN<commandDescribe_Name.length())
            {
                int NAME_LEN_next = (NAME_LEN+LINE_COMMAND_NAME_LEN)>commandDescribe_Name.length()?commandDescribe_Name.length():NAME_LEN+LINE_COMMAND_NAME_LEN;
                commandDescription.append(commandDescribe_Name.subSequence(NAME_LEN,NAME_LEN_next));
                for(int i = 0;i<30-NAME_LEN_next+NAME_LEN;i++)
                {
                    commandDescription.append(" ");
                }
                NAME_LEN = NAME_LEN_next;
            }
            else
            {
                commandDescription.append("                              ");
            }

            if(DESCRIPTION_LEN<commandDescribe_Description.length())
            {
                int DESCRIPTION_LEN_next = (DESCRIPTION_LEN+LINE_COMMAND_DESCRIPTION_LEN)>commandDescribe_Description.length()?commandDescribe_Description.length():DESCRIPTION_LEN+LINE_COMMAND_DESCRIPTION_LEN;
                commandDescription.append(commandDescribe_Description.subSequence(DESCRIPTION_LEN,DESCRIPTION_LEN_next));
                DESCRIPTION_LEN = DESCRIPTION_LEN_next;
            }
            commandDescription.append("\n");

        }

        return commandDescription.toString();
    }
}
