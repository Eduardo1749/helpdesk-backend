package com.eduardo.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eduardo.helpdesk.domain.Chamado;
import com.eduardo.helpdesk.domain.Cliente;
import com.eduardo.helpdesk.domain.Tecnico;
import com.eduardo.helpdesk.domain.enums.Perfil;
import com.eduardo.helpdesk.domain.enums.Prioridade;
import com.eduardo.helpdesk.domain.enums.Status;
import com.eduardo.helpdesk.repositories.ChamadoRepository;
import com.eduardo.helpdesk.repositories.ClienteRepository;
import com.eduardo.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	
	@Autowired // O spring ficará responsavel por criar a instancia daquela interface, gerencia e destruir a mesma
	private TecnicoRepository tecnicoRepository;
	
	@Autowired 
	private ClienteRepository clienteRepository;
	
	@Autowired 
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Valdir cezar", "63653230268", "valdir@mail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Fabiano Pereira", "39252161031", "fabiano@mail.com", encoder.encode("123"));
		Tecnico tec3 = new Tecnico(null, "Daihana Ribeiro", "69171650008", "daihana@mail.com", encoder.encode("123"));
		Tecnico tec4 = new Tecnico(null, "Eduardo Santos", "33940429082", "eduardo@mail.com", encoder.encode("123"));
		tec4.addPerfil(Perfil.ADMIN);
		Tecnico tec5 = new Tecnico(null, "Marcos Gabriel", "24281358056", "gabriel@mail.com", encoder.encode("123"));
		Tecnico tec6 = new Tecnico(null, "Victoria Luisa", "73459437049", "victoria@mail.com", encoder.encode("123"));
		
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "80527954780", "torvalds@mail.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Vitor Lucas", "23204767094", "vitor@mail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Vitor Chrispim", "09267586084", "chrispim@mail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Rosilda Ribeiro", "12367145040", "rosilda@mail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Maria Adenilza", "67505437070", "nilza@mail.com", encoder.encode("123"));
		Cliente cli6 = new Cliente(null, "Liliane Santos", "14655423021", "liliane@mail.com", encoder.encode("123"));
		

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 02", "Segundo chamado", tec2, cli2);
		Chamado c3 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 03", "Terceiro chamado", tec3, cli3);
		Chamado c4 = new Chamado(null, Prioridade.MEDIA, Status.ENCERRADO, "Chamado 04", "Quarto chamado", tec4, cli4);
		Chamado c5 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 05", "Quinto chamado", tec5, cli5);
		Chamado c6 = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO, "Chamado 06", "Sexto chamado", tec6, cli6);
		
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, tec6));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
		
	}
}
