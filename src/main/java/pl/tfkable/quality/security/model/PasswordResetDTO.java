package pl.tfkable.quality.security.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PasswordResetDTO {
	
	//required for change password but not for forgot reset
	//so not required, only custom validator
	private String oldPassword;

	@NotNull
	@Size(min = 8, max = 20,message="Podaj nowe hasło, min 8 znaków")
	private String password;
	
	@NotNull
	@Size(min = 8, max = 20,message="Podaj nowe hasło, min 8 znaków")
	private String passwordRepeated;
	
	
	private Long userId;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
