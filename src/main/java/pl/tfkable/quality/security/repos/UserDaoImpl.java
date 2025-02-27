package pl.tfkable.quality.security.repos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import pl.tfkable.quality.daos.GenericDaoImpl;
import pl.tfkable.quality.security.mappers.UserMapper;
import pl.tfkable.quality.security.model.Role;
import pl.tfkable.quality.security.model.User;
import pl.tfkable.quality.security.model.UserDTO;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User,Long> implements UserDao{

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UserMapper mapper;

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RoleRepository roleRepo;
	






	public UserDTO findUserDTOById(Long id) {
		return mapper.mapToDto(repo.findById(id).get());
	}



	public String mergeUser(User u){
		em.merge(u);
		return "ok";
	}




	@Override
	public User findUserById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<UserDTO> findAllDTOs() {

		List<User>users =  new ArrayList<>();
		repo.findAll(Sort.by(Sort.Direction.DESC, "id")).forEach(users::add);
		return mapper.map(users);
	}
	
	@Override
	public List<User> findAll() {

		List<User>users =  new ArrayList<>();
		repo.findAll(Sort.by(Sort.Direction.DESC, "id")).forEach(users::add);
		return users;
	}


	public String saveUserFromDTO(UserDTO dto) {

		if(dto.getId()==null){
			return zapiszNowegoUsera(dto);
		}else{
			return aktualizujUsera(dto);
		}
	}
	
	public void saveUser(User user) {
		em.merge(user);
	}



	public String usunDaneOsobowe(Long userId) {

		
		User user = repo.findById(userId).get();
		user.setNazwisko("XXX");
		user.setImie("XXX");
		user.setRoles(new HashSet<>());
		user.setIsEnabled(false);
		user.setEmail("XXX");
		
		
//		user.setOdpowiedzialny(false);
//		user.setOpracowujeRaport(false);
//		user.setOpracowujePostepowanie(false);
//		user.setProponujeStanowiskoBhp(false);
//		user.setPelnomocnikZarzadu(false);
//		user.setDyrektor(false);
//		user.setOcenyRaportuDokonal(false);
		
		em.merge(user);
		return "Dane osobowe usunięte";
	}



	private String aktualizujUsera(UserDTO dto) {

		User user = repo.findById(dto.getId()).get();

		String stareImie = user.getImie();
		String stareNazwisko = user.getNazwisko();
		
		String noweImie = dto.getImie();
		String noweNazwisko = dto.getNazwisko();
		
		
		
		updateFields(user,dto);
		
		user.setRoles(new HashSet<Role>());
		updateListy(dto, user);
		updateRoles(dto, user);
		em.merge(user);
		
		return "zapisany";
	}

	









	private void updateListy(UserDTO dto, User user) {
		
//		user.setOdpowiedzialny(dto.getOdpowiedzialny());
//		user.setOpracowujePostepowanie(dto.getOpracowujePostepowanie());
//		user.setProponujeStanowiskoBhp(dto.getProponujeStanowiskoBhp());
//		user.setPelnomocnikZarzadu(dto.getPelnomocnikZarzadu());
//		user.setDyrektor(dto.getDyrektor());
//		user.setOpracowujeRaport(dto.getOpracowujeRaport());
//		user.setOcenyRaportuDokonal(dto.getOcenyRaportuDokonal());

		
	}




	private void updateFields(User entity,UserDTO dto){
		
		entity.setId(dto.getId());
		entity.setImie(dto.getImie());
		entity.setNazwisko(dto.getNazwisko());

		entity.setUsername(dto.getUsername());
		entity.setEmail(dto.getEmail());
		entity.setTel(dto.getTel());
		entity.setUsername(dto.getUsername());
		entity.setEmail(dto.getEmail());

		
	}


	






	private String zapiszNowegoUsera(UserDTO dto) {

		
	//	for(int i=0;i<87;i++){
			
		
	//	try {
			
			
			User user = mapper.mapToEntity(dto);
			
			
			updateRoles(dto, user);

			if(dto.getPassword()==null){
				user.setPassword(new BCryptPasswordEncoder().encode("abc123"));
			}else{
				user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
			}
			
			repo.save(user);
//	} catch (Exception e) {
//		System.out.println("e"+e);
//	}
//		}
		
		return "zapisany";
	}




	private void updateRoles(UserDTO dto, User user) {
		
		if(dto.getTworzyWniosek()){
			Role role = roleRepo.findByRole("ROLE_TWORZY_WNIOSEK");
			role.getUsers().add(user);
			user.getRoles().add(role);
		}
		
		if(dto.getWidziWniosek()){
			Role role = roleRepo.findByRole("ROLE_WIDZI_WNIOSEK");
			role.getUsers().add(user);
			user.getRoles().add(role);
		}
		
		if(dto.getTworzyPostepowanie()){
			Role role = roleRepo.findByRole("ROLE_TWORZY_POSTEPOWANIE");
			role.getUsers().add(user);
			user.getRoles().add(role);
		}
		
		if(dto.getWidziPostepowanie()){
			Role role = roleRepo.findByRole("ROLE_WIDZI_POSTEPOWANIE");
			role.getUsers().add(user);
			user.getRoles().add(role);
		}
		
		if(dto.getTworzyKoszty()){
			Role role = roleRepo.findByRole("ROLE_TWORZY_KOSZTY");
			role.getUsers().add(user);
			user.getRoles().add(role);
		}
		
		if(dto.getWidziKoszty()){
			Role role = roleRepo.findByRole("ROLE_WIDZI_KOSZTY");
			role.getUsers().add(user);
			user.getRoles().add(role);
		}
		
		if(dto.getTworzyRaport()){
			Role role = roleRepo.findByRole("ROLE_TWORZY_RAPORT");
			role.getUsers().add(user);
			user.getRoles().add(role);
		}
		
		if(dto.getWidziRaport()){
			Role role = roleRepo.findByRole("ROLE_WIDZI_RAPORT");
			role.getUsers().add(user);
			user.getRoles().add(role);
		}
		
		if(dto.getTworzySprawozdanie()){
			Role role = roleRepo.findByRole("ROLE_TWORZY_SPRAWOZDANIE");
			role.getUsers().add(user);
			user.getRoles().add(role);
		}
	}


























	@Override
	public List<String> getSpecjalisci() {
		
		List<String>specjalisci = new ArrayList<>();
		specjalisci.add("Gliatask Andrzej");
		specjalisci.add("Jaworski Andrzej");
		
		
//		repo.findAll(Sort.by(Sort.Direction.ASC, "nazwisko")).forEach(u->{
//			String in = u.getNazwisko()+" "+u.getImie();
//			specjalisci.add(in);
//		});

		return specjalisci;
	}

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<String> getDoListy(String parametr) {
		
		List<String>odpowiedzialni = new ArrayList<>();
		String param = "u."+parametr+" = true";
		TypedQuery<User>query = em.createQuery("SELECT u FROM User u WHERE "+param+" AND u.isEnabled = true",User.class);
		//query.setParameter(1, param);
		
		query.getResultList().forEach(u->{
			String in = u.getNazwisko()+" "+u.getImie();
			odpowiedzialni.add(in);
		});
		odpowiedzialni.sort(Comparator.naturalOrder());
		return odpowiedzialni;
	}
	
	
	@Override
	public List<String> getAllDoListy() {
		
		List<String>allusers = new ArrayList<>();
		TypedQuery<User>query = em.createQuery("SELECT u FROM User u",User.class);
		
		query.getResultList().forEach(u->{
			String in = u.getNazwisko()+" "+u.getImie();
			allusers.add(in);
		});
		allusers.sort(Comparator.naturalOrder());
		return allusers;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	@Override
	public List<String> getKomorkiOrganizacyjne() {
		TypedQuery<String> query = em.createQuery("SELECT DISTINCT u.komorkaOrganizacyjna FROM User u",String.class);
		return query.getResultList();
	}




	@Override
	public List<String> getUsersFromKomorkaOrganizacyjna(String komorkaSelected) {

		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.komorkaOrganizacyjna = ?1",User.class);
		query.setParameter(1,komorkaSelected);

		final List<String>userNames = 

				query.getResultList().stream().map(u->u.getImie()+" "+u.getNazwisko()).collect(Collectors.toList());

		return userNames;
	}




	@Override
	public long countUsers() {
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(id) FROM User u",Long.class);
		return query.getSingleResult();
	}








	public void usunUsera(Long userId) {
		
		User u = repo.findById(userId).get();
		u.getRoles().clear();
		repo.delete(u);
		
		
	}




























}
