package com.lucasmonteiro.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.lucasmonteiro.dslearn.entities.Notification;

@Controller
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}