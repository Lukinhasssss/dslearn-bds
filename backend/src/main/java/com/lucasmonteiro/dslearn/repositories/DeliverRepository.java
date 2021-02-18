package com.lucasmonteiro.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.lucasmonteiro.dslearn.entities.Deliver;

@Controller
public interface DeliverRepository extends JpaRepository<Deliver, Long> {

}
