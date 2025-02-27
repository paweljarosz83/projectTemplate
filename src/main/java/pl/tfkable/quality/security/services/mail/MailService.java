package pl.tfkable.quality.security.services.mail;

public interface MailService {
	
	public void sendPasswordRecoveryEmail(String url,String email);

}
