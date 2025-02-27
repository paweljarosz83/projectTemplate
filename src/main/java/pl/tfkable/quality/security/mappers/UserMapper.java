package pl.tfkable.quality.security.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import pl.tfkable.quality.security.model.Role;
import pl.tfkable.quality.security.model.User;
import pl.tfkable.quality.security.model.UserDTO;

@Component
public class UserMapper {
	
	
	
	private final Role rolaTworzyWnosek = new Role("ROLE_TWORZY_WNIOSEK");
	private final Role rolaWidziWniosek = new Role("ROLE_WIDZI_WNIOSEK");
	
	private final Role rolaTworzyPostepowanie = new Role("ROLE_TWORZY_POSTEPOWANIE");
	private final Role rolaWidziPostepowanie = new Role("ROLE_WIDZI_POSTEPOWANIE");

	private final Role rolaTworzyRaport = new Role("ROLE_TWORZY_RAPORT");
	private final Role rolaWidziRaport = new Role("ROLE_WIDZI_RAPORT");
	
	private final Role rolaTworzyKoszty = new Role("ROLE_TWORZY_KOSZTY");
	private final Role rolaWidziKoszty= new Role("ROLE_WIDZI_KOSZTY");
	
	private final Role rolaTworzySprawozdanie= new Role("ROLE_TWORZY_SPRAWOZDANIE");
	
	
	
	public UserDTO mapToDto(User entity){
		
		UserDTO dto = new UserDTO();
		dto.setId(entity.getId());
		
		dto.setImie(entity.getImie());
		dto.setNazwisko(entity.getNazwisko());

		
		dto.setUsername((entity.getUsername()));
		dto.setEmail((entity.getEmail()==null)?"":entity.getEmail());
		dto.setTel((entity.getTel()==null)?"":entity.getTel());
		
		
		StringBuilder sb = new StringBuilder();

		for(Role r:entity.getRoles()){
			
			if(r.equals(rolaTworzyWnosek)){
				dto.setTworzyWniosek(true);
			}
			if(r.equals(rolaWidziWniosek)){
				dto.setWidziWniosek(true);
			}
			
			if(r.equals(rolaTworzyPostepowanie)){
				dto.setTworzyPostepowanie(true);
			}
			if(r.equals(rolaWidziPostepowanie)){
				dto.setWidziPostepowanie(true);
			}
			
			if(r.equals(rolaTworzyRaport)){
				dto.setTworzyRaport(true);
			}
			if(r.equals(rolaWidziRaport)){
				dto.setWidziRaport(true);
			}
			
			if(r.equals(rolaTworzyKoszty)){
				dto.setTworzyKoszty(true);
			}
			if(r.equals(rolaWidziKoszty)){
				dto.setWidziKoszty(true);
			}
			
			if(r.equals(rolaTworzySprawozdanie)){
				dto.setTworzySprawozdanie(true);
			}
			
		}
		
//		dto.setOdpowiedzialny(entity.getOdpowiedzialny());
//		dto.setOpracowujePostepowanie(entity.getOpracowujePostepowanie());
//		dto.setProponujeStanowiskoBhp(entity.getProponujeStanowiskoBhp());
//		dto.setPelnomocnikZarzadu(entity.getPelnomocnikZarzadu());
//		dto.setDyrektor(entity.getDyrektor());
//		dto.setOpracowujeRaport(entity.getOpracowujeRaport());
//		dto.setOcenyRaportuDokonal(entity.getOcenyRaportuDokonal());
		
		
		dto.setRoles(sb.toString());
		return dto;
	}
	
	
	
	
	
	
	
	public User mapToEntity(UserDTO dto){
		
		User entity = new User();
		
		entity.setId(dto.getId());
		entity.setImie(dto.getImie());
		entity.setNazwisko(dto.getNazwisko());

		entity.setUsername(dto.getUsername());
		entity.setEmail(dto.getEmail());
		entity.setTel(dto.getTel());
//	
//		entity.setOdpowiedzialny(dto.getOdpowiedzialny());
//		entity.setOpracowujePostepowanie(dto.getOpracowujePostepowanie());
//		entity.setProponujeStanowiskoBhp(dto.getProponujeStanowiskoBhp());
//		entity.setPelnomocnikZarzadu(dto.getPelnomocnikZarzadu());
//		entity.setDyrektor(dto.getDyrektor());
//		entity.setOpracowujeRaport(dto.getOpracowujeRaport());
//		entity.setOcenyRaportuDokonal(dto.getOcenyRaportuDokonal());

		return entity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<UserDTO>map(List<User> users){
		return users.stream().map(u->mapToDto(u)).collect(Collectors.toList());
	}

}







