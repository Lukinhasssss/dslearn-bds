package com.lucasmonteiro.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.lucasmonteiro.dslearn.entities.Resource;

@Controller
public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
