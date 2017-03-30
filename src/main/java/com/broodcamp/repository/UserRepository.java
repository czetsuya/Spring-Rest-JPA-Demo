package com.broodcamp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.broodcamp.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByLastNameIgnoreCaseContaining(String lastName);

	List<User> findByFirstNameIgnoreCaseContaining(String firstName);

	List<User> findByEmailIgnoreCaseContaining(String email);

}
