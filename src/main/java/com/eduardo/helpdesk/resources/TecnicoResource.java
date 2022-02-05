package com.eduardo.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.helpdesk.domain.Tecnico;
import com.eduardo.helpdesk.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos") // QUando fizer uma requisição para qualquer serviço relacionado aos tecnicos irá chegar aqui e a url deve ser: localhost:8080/tecnicos
public class TecnicoResource {

	@Autowired
	private TecnicoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tecnico> findById(@PathVariable Integer id){ // O que é um responseEntity? É utilizado qundo você quer representar toda resposta http, com ele você pode controlar qualquer coisa da requisição
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}