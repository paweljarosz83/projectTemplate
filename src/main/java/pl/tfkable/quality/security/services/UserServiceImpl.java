package pl.tfkable.quality.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.tfkable.quality.security.model.User;
import pl.tfkable.quality.security.model.UserDetailsImpl;
import pl.tfkable.quality.security.repos.UserDao;
import pl.tfkable.quality.security.repos.UserRepository;



@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = findByUsername(username);
		//User user = findByEmail(username);
				
		if(user==null){
			throw new UsernameNotFoundException(username+" not found!");
		}
		return new UserDetailsImpl(user);
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public List<String> getUsersFromKomorkaOrganizacyjna(String komorkaSelected) {
		return userDao.getUsersFromKomorkaOrganizacyjna(komorkaSelected);
	}

	@Override
	public User findByNazwiskoAndImie(String imie, String nazwisko) {
		return userRepository.findByNazwiskoAndImie(imie,nazwisko);
	}

	@Override
	public User getLoggedUser() {
		 return userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	}

	@Override
	public long countUsers() {
		return userDao.countUsers();
	}
	
	
	
	
	
}
