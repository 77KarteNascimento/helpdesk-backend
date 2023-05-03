package com.krt.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krt.helpdesk.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
