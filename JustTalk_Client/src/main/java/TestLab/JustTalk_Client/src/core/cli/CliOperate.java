package TestLab.JustTalk_Client.src.core.cli;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Component
public class CliOperate {
    public String CliOperate_getString() throws IOException {
        String command;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader( System.in ) ) ;
        command = bufferedReader.readLine();
        return command;
    }
}
