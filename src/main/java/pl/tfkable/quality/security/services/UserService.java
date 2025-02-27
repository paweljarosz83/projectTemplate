package pl.tfkable.quality.security.services;

import java.util.List;

import pl.tfkable.quality.security.model.User;

public interface UserService {

	public User findByEmail(String email);
	
	public User findByUsername(String username);
	
	public User findById(Long id);
	
	public void update(User user);

	public List<String> getUsersFromKomorkaOrganizacyjna(String komorkaSelected);
	
	public User findByNazwiskoAndImie(String imie,String nazwisko);

	public User getLoggedUser();
	
	public long countUsers();
	
}
