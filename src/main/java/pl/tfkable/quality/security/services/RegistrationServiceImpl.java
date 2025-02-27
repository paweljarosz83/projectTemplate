package pl.tfkable.quality.security.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.tfkable.quality.daos.GenericDao;
import pl.tfkable.quality.security.model.Role;
import pl.tfkable.quality.security.model.User;
import pl.tfkable.quality.security.model.UserDTO4Registration;
import pl.tfkable.quality.security.repos.RoleRepository;



@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService{

	private static final Long ROLE_USER = 1L;
	
	@Autowired
	private GenericDao<User, Long> dao;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void register(UserDTO4Registration dto) {
		
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
		
		//user.setPassword(dto.getPassword());
		
		Role role = roleRepository.findById(ROLE_USER).get();
		
		//user.setPicture(createProfilePicture());
		
		role.getUsers().add(user);
		user.getRoles().add(role);
		
		dao.save(user);
	}

	private byte[] createProfilePicture() {
		try {
			File file = new ClassPathResource("static/images/user.png").getFile();
			return Files.readAllBytes(Paths.get(file.getPath()));
		} catch (IOException e) {
			return null;
		}
	}
}
