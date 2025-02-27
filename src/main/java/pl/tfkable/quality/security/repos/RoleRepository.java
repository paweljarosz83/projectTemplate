package pl.tfkable.quality.security.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.tfkable.quality.security.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
	
	Optional<Role> findById(Long id);
	
	Role findByRole(String role);

}
