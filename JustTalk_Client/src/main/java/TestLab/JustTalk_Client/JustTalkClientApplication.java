package TestLab.JustTalk_Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"TestLab.JustTalk_Client", "TestLab.JustTalk_Common"})
public class JustTalkClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustTalkClientApplication.class, args);
	}

}
