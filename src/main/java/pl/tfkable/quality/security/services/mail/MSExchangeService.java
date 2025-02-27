package pl.tfkable.quality.security.services.mail;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.springframework.stereotype.Service;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.MessageBody;

@Service
public class MSExchangeService {
	
	
	
//	private static final String EMAIL_PASSWORD = "DHQ7XYMaY4";
//	private static final String EMAIL_USERNAME = "reklamacje.dev";
//	private static final String EMAIL_URL = "https://mail.tfkable.com/ews/exchange.asmx";
//	private static final ExchangeCredentials credentials = new WebCredentials(EMAIL_USERNAME, EMAIL_PASSWORD);


	private static final String EMAIL_PASSWORD = "Ijsaz42sasxks!!a";
	private static final String EMAIL_USERNAME = "reklamacje";
	private static final String EMAIL_URL = "https://mail.tfkable.com/ews/exchange.asmx";
	private static final ExchangeCredentials credentials = new WebCredentials(EMAIL_USERNAME, EMAIL_PASSWORD);

	
	public void wyslijLinkDoResetuHasla(String url,String email) {

		EmailMessage msg = null;
		try {
			msg = new EmailMessage(getExchangeService());
			msg.setSubject("Reset hasła w TK Reklamacje");
			
			String kontentMaila = getEmailTemplateFromFile();
			
			kontentMaila  = kontentMaila.replaceAll("naglowek", "Ustaw nowe hasło");
			kontentMaila  = kontentMaila.replaceAll("kontent", "Otwórz poniższy link aby wprowadzić nowe hasło:");
			kontentMaila  = kontentMaila.replaceAll("dataWystawieniaWnioskuMail", "");
			
			
			//kontentMaila  = kontentMaila.replaceAll("otworzLink", url);
			kontentMaila  = kontentMaila.replaceAll("LinkAdres", url);
			
		
			msg.setBody(MessageBody.getMessageBodyFromText(kontentMaila));
			
			msg.getBccRecipients().add(email);
			
			msg.save();
			msg.send();
			
		} catch (Exception e) {
			System.out.println("e "+e);
		}
	}
	
	
	private ExchangeService getExchangeService(){

		ExchangeService eservice = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
		try {
			eservice.setUrl(new java.net.URI(EMAIL_URL));
			eservice.setCredentials(credentials);
		} catch (URISyntaxException e) {
			System.out.println("e "+e);
		}
		return eservice;
	}
	
	private String getEmailTemplateFromFile() {
		
		String filename = "/mailik.html";

		try {
			InputStream in = getClass().getResourceAsStream(filename); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			StringBuilder builder = new StringBuilder();

			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				builder.append(line);
			}
			String result = builder.toString();
			reader.close();
			return result;

		} catch (Exception e) {
			System.out.println("error ");
			return "empty";
		}
	}

}
