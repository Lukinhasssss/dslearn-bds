package com.lucasmonteiro.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.lucasmonteiro.dslearn.entities.Role;

@Controller
public interface RoleRepository extends JpaRepository<Role, Long> {

}
