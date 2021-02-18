package com.lucasmonteiro.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.lucasmonteiro.dslearn.entities.User;

@Controller
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
