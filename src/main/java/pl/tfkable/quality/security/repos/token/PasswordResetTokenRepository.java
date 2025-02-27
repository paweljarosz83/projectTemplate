package pl.tfkable.quality.security.repos.token;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pl.tfkable.quality.security.model.token.PasswordResetToken;

public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken,Long>{

	PasswordResetToken findByToken(String token);
	
	@Query("DELETE FROM PasswordResetToken p WHERE p.user.id = :userId")
	@Modifying
	void deleteByUserId(@Param("userId") Long userId);
}
