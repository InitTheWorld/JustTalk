package JustTalk.Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"JustTalk.Client", "JustTalk.Common"})
public class JustTalkClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(JustTalk.Client.JustTalkClientApplication.class, args);
    }
}
