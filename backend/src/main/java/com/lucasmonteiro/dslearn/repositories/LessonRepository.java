package com.lucasmonteiro.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.lucasmonteiro.dslearn.entities.Lesson;

@Controller
public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
