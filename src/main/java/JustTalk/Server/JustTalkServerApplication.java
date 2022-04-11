package JustTalk.Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = {"JustTalk.Server", "JustTalk.Common"})
public class JustTalkServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(JustTalkServerApplication.class, args);
    }
}
