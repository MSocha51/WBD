package com.wbd.kotki.application.servicies;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import com.wbd.kotki.model.entities.Client;
import com.wbd.kotki.model.entities.Role;
import com.wbd.kotki.model.entities.User;
import com.wbd.kotki.model.repositories.ClientRepository;
import com.wbd.kotki.model.repositories.RoleRepository;
import com.wbd.kotki.model.repositories.UserRepository;
import com.wbd.kotki.web.dtos.RegisterDTO;
@Service
public class UserService {
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired RoleRepository roleRepo;
	@Transactional
	public void addClientUser(RegisterDTO registerDto){
		encodeDto(registerDto);
		User user = createUser(registerDto);
		Client client = createClient(registerDto);
		client = clientRepo.save(client);
		Role role = roleRepo.findByName("ROLE_USER");
		user.setRole(role);
		user = userRepo.save(user);
		user.setClient(client);
		client.setUser(user);
		userRepo.save(user);
	}



	private void encodeDto(RegisterDTO registerDto) {
		Function<String,String> escape = (from) -> HtmlUtils.htmlEscape(from);
		registerDto.setFirstName(escape.apply(registerDto.getFirstName()));
		registerDto.setSurname(escape.apply(registerDto.getSurname()));
		registerDto.setCity(escape.apply(registerDto.getCity()));
		registerDto.setStreet(escape.apply(registerDto.getStreet()));
		registerDto.setPostCode(escape.apply(registerDto.getPostCode()));
		registerDto.setLocalNumber(escape.apply(registerDto.getLocalNumber()));
	}
	private User createUser(RegisterDTO registerDto) {
		User newUser = new User();
		newUser.setMail(registerDto.getMail());
		newUser.setPassword(registerDto.getPassword());
		return newUser;
	}

	private Client createClient(RegisterDTO registerDto) {
		Function<String,Long> convert = (from) -> Long.parseLong(from);
		Client newClient = new Client();
		newClient.setFirstName(registerDto.getFirstName());
		newClient.setSurname(registerDto.getSurname());
		newClient.setCity(registerDto.getCity());
		newClient.setStreet(registerDto.getStreet());
		newClient.setPostCode(registerDto.getPostCode());
		newClient.setLocalNumber(registerDto.getLocalNumber());
		newClient.setMail(registerDto.getMail());
		newClient.setPesel(convert.apply(registerDto.getPesel()));
		newClient.setPhone(convert.apply(registerDto.getPhone()));
		return newClient;
	}
	public Client getByMail(String mail){
		Client client = clientRepo.findByMail(mail);
		return client;
	}

}
