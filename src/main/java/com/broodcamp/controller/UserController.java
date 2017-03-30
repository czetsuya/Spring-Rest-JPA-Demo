package com.broodcamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.dto.UserDto;
import com.broodcamp.model.User;
import com.broodcamp.repository.UserRepository;
import com.broodcamp.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<User> create(@RequestBody UserDto userDto) {
		User user = userService.create(userDto);
		return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
	}

	@RequestMapping("/user/find")
	public ResponseEntity<List<User>> find(@RequestParam(value = "p", defaultValue = "lastName") String p,
			@RequestParam(value = "v", defaultValue = "") String v) {
		List<User> result = null;

		if (p.equalsIgnoreCase("LASTNAME")) {
			result = userRepository.findByLastNameIgnoreCaseContaining(v);

		} else if (p.equalsIgnoreCase("FIRSTNAME")) {
			result = userRepository.findByFirstNameIgnoreCaseContaining(v);

		} else if (p.equalsIgnoreCase("EMAIL")) {
			result = userRepository.findByEmailIgnoreCaseContaining(v);
		}

		return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	}

}
