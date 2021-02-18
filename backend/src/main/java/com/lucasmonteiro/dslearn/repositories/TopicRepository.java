package com.lucasmonteiro.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.lucasmonteiro.dslearn.entities.Topic;

@Controller
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
