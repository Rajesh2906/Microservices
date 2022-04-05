package config.service.sms.twilio;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping("/message")
public class TwilioController implements ApplicationRunner {

//	@Autowired
//	private twilio twilio;

	private final static String accountid = "AC7dc737df471c387e638c38bcdebba3a5";
	private final static String authid = "9ef5d86db00b5abcb16959e97aa08d7d";

	static {
		Twilio.init(accountid, authid);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		Message.creator(new PhoneNumber("+919398419855"), new PhoneNumber("+12185177445"), "Message form Rajesh")
				.create();
	}

//	@GetMapping("/mm")
//	public String sendMessage() throws Exception {
//		run(null);
//		return "Message sent";
//	}

}
