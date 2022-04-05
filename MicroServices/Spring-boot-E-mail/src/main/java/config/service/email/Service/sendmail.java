package config.service.email.Service;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sendmail {

//	@Value("${mail.smtp}")
//	private Properties props;
//	
//	@Autowired
//	private propertiesClass props;

	@Value("#{systemEnvironment['mail']}")
	private Properties props;

	private void sendmail() throws AddressException, MessagingException, IOException {
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("chagantipati.rajesh09@gmail.com", "yldnokcsqwysethv");
			}
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("chagantipati.rajesh09@gmail.com", false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("subhash10560@gmail.com"));
		msg.setSubject("Hey Subhash");
		// msg.setContent("Emleyy vurkeyy", "text/html");
		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("Sarley vuntaa", "text/html");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		MimeBodyPart attachPart = new MimeBodyPart();

		attachPart.attachFile("src\\main\\8687-car-Ferrari-Ferrari_458_Italia-blue_cars.jpg");
		multipart.addBodyPart(attachPart);
		msg.setContent(multipart);
		Transport.send(msg);
	}

	@RequestMapping(value = "/sendemail")
	public String sendEmail() throws AddressException, MessagingException, IOException {
		sendmail();
		return "Email sent successfully";
	}

}
