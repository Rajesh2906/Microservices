package config.service.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSmsApplication {

//	private final static String accountid = "AC7dc737df471c387e638c38bcdebba3a5";
//	private final static String authid = "9ef5d86db00b5abcb16959e97aa08d7d";
//
//	static {
//		Twilio.init(accountid, authid);
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSmsApplication.class, args);
	}

//	@Override
//	public void run(ApplicationArguments arg0) throws Exception {
//		Message.creator(new PhoneNumber("+916302127226"), new PhoneNumber("+12185177445"), "Jaiiiiiiii Balayyaaa")
//				.create();
//	}
}
