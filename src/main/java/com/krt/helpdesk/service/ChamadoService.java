package com.krt.helpdesk.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krt.helpdesk.domain.dtos.ChamadoDTO;
import com.krt.helpdesk.domain.enums.Prioridade;
import com.krt.helpdesk.domain.enums.Status;
import com.krt.helpdesk.domain.model.Chamado;
import com.krt.helpdesk.domain.model.Cliente;
import com.krt.helpdesk.domain.model.Tecnico;
import com.krt.helpdesk.repository.ChamadoRepository;
import com.krt.helpdesk.service.exception.ObjectNotFoundException;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = chamadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id));
	}


	public List<Chamado> findAll() {
		return chamadoRepository.findAll();
	}


	public Chamado create(@Valid ChamadoDTO objDTO) {
		return chamadoRepository.save(newChamado(objDTO));
	}
	
	public Chamado update(Integer id, @Valid ChamadoDTO objDTO) {
		objDTO.setId(id);
		Chamado oldObj = findById(id);
		oldObj = newChamado(objDTO);
		return chamadoRepository.save(oldObj);
	}
	
	
	private Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());//pegando id do tecnico
		Cliente cliente = clienteService.findById(obj.getCliente());//pegando id do cliente
		
		Chamado chamado = new Chamado();
		
		if (obj.getId() != null) {
			chamado.setId(obj.getId());
		}
		
		if (obj.getStatus().equals(2)) {
			chamado.setDataFechamento(LocalDate.now());
		}
		
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		chamado.setStatus(Status.toEnum(obj.getStatus()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservacoes(obj.getObservacoes());
		
		return chamado;
		
	}

	

}
