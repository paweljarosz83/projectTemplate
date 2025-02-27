package pl.tfkable.quality.security.repos;

import java.util.List;

import pl.tfkable.quality.daos.GenericDao;
import pl.tfkable.quality.security.model.User;
import pl.tfkable.quality.security.model.UserDTO;



public interface UserDao extends GenericDao<User,Long>{
	
	User findUserById(Long id);
	
	List<UserDTO> findAllDTOs();
	
	List<User> findAll();

	String saveUserFromDTO(UserDTO dto);

	List<String> getSpecjalisci();

	List<String> getKomorkiOrganizacyjne();

	List<String> getUsersFromKomorkaOrganizacyjna(String komorkaSelected);

	long countUsers();

	List<String> getDoListy(String parametr);

	List<String> getAllDoListy();



}
