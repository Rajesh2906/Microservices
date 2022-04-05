package config.service.email.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import config.service.email.mehods.SMS;

@Controller
public class MailSMSController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/home")
	public String Message() {
		return "login.html";

	}

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public SMS don() {
		return restTemplate.getForObject("http://localhost:8081/message/mm", SMS.class);

	}

}
