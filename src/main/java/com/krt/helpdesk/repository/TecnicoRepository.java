package com.krt.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krt.helpdesk.domain.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
