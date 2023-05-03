package com.krt.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krt.helpdesk.domain.model.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
