package pl.tfkable.quality.security.services;

import pl.tfkable.quality.security.model.UserDTO4Registration;

public interface RegistrationService {

	void register(UserDTO4Registration dto);
}
