package E_commerceDbachna;

import E_commerceDbachna.models.Role;
import E_commerceDbachna.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class E_commerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(E_commerceApplication.class, args);
	}

	@Autowired
	private IRoleRepository roleRepository;

	@PostConstruct
	public void addRoles(){
		if(roleRepository.findAll().size()<5){
			List<Role> roles=new ArrayList<>();
			Role r1=roleRepository.save(new Role(1,"ADMIN"));
			Role r2=roleRepository.save(new Role(2,"CLIENT"));
			roles.add(r1);
			roles.add(r2);
			roleRepository.saveAll(roles);
		}
	}
}
