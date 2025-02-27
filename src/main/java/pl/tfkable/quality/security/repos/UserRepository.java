package pl.tfkable.quality.security.repos;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.tfkable.quality.security.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

	 User findByEmail(String email);
	
	 User findByUsername(String username);

	List<User> findAll(Sort by);

	User findByNazwiskoAndImie(String nazwisko,String imie);
	 
	 
	

}
