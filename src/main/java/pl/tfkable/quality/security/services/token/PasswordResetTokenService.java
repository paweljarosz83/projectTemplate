package pl.tfkable.quality.security.services.token;

import pl.tfkable.quality.security.model.token.PasswordResetToken;

public interface PasswordResetTokenService {

	String validatePasswordResetToken(Long id, String token);

	void save(PasswordResetToken token);

	PasswordResetToken findByToken(String token);
	
	void deleteToken(PasswordResetToken token);

	void invalidateOtherTokensForUser(long id);

}
