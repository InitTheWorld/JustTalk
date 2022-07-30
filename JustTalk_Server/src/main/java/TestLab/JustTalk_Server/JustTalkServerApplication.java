package TestLab.JustTalk_Server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"TestLab.JustTalk_Server", "TestLab.JustTalk_Common"})
@MapperScan("TestLab.JustTalk_Server.src.dao")
public class JustTalkServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustTalkServerApplication.class, args);
	}

}
