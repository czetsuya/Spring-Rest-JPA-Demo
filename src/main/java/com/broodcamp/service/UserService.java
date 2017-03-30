package com.broodcamp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broodcamp.dto.UserDto;
import com.broodcamp.model.Auditable;
import com.broodcamp.model.Role;
import com.broodcamp.model.User;
import com.broodcamp.repository.RoleRepository;
import com.broodcamp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public User create(UserDto userDto) {
		User user = new User();
		user.setCompany(userDto.getCompany());
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		Auditable auditable = new Auditable();
		auditable.setCreated(new Date());
		auditable.setModified(new Date());
		user.setAuditable(auditable);
		user.setPassword("password");
		user.setStatus("Created");

		if (userDto.getRoles() != null && !userDto.getRoles().isEmpty()) {
			for (String roleName : userDto.getRoles()) {
				Role role = roleRepository.findByName(roleName);
				user.getRoles().add(role);
			}
		}

		return userRepository.save(user);
	}

}
