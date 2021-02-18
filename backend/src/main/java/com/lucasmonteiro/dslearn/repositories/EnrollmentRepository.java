package com.lucasmonteiro.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.lucasmonteiro.dslearn.entities.Enrollment;
import com.lucasmonteiro.dslearn.entities.pk.EnrollmentPK;

@Controller
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {

}
