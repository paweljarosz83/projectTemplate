package pl.tfkable.quality.security.services.token;

import java.util.Arrays;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.tfkable.quality.security.model.User;
import pl.tfkable.quality.security.model.token.PasswordResetToken;
import pl.tfkable.quality.security.repos.token.PasswordResetTokenRepository;



@Service
@Transactional
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;

	@Override
	public String validatePasswordResetToken(Long id, String token) {
		
		final PasswordResetToken passToken = passwordResetTokenRepository.findByToken(token);
		
		
		
		

		
		if ((passToken == null) || (passToken.getUser().getId().equals(id)==false)) {
			return "invalidToken";
		}

		final Calendar cal = Calendar.getInstance();
		
		
		System.out.println(passToken.getExpiryDate().getTime());
		System.out.println(cal.getTime().getTime());
		System.out.println(passToken.getExpiryDate().getTime() - cal.getTime().getTime());
		
		
		if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			return "expired";
		}

		final User user = passToken.getUser();
		final Authentication auth = new UsernamePasswordAuthenticationToken(user, null, Arrays.asList(new SimpleGrantedAuthority("CHANGE_PASSWORD_PRIVILEGE")));
		
		SecurityContextHolder.getContext()
		.setAuthentication(auth);
		
		return null;
	}

	@Override
	public void save(PasswordResetToken token) {
		passwordResetTokenRepository.save(token);		
	}

	@Override
	public PasswordResetToken findByToken(String token) {
		return passwordResetTokenRepository.findByToken(token);
	}

	@Override
	public void deleteToken(PasswordResetToken token) {
		passwordResetTokenRepository.delete(token);
	}

	@Override
	public void invalidateOtherTokensForUser(long userId) {
		passwordResetTokenRepository.deleteByUserId(userId);
		
	}
	
	
	
	
	
}
