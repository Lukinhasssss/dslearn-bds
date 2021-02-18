package com.lucasmonteiro.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.lucasmonteiro.dslearn.entities.Offer;

@Controller
public interface OfferRepository extends JpaRepository<Offer, Long> {

}
