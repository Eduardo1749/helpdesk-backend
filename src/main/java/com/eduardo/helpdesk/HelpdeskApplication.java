package com.eduardo.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eduardo.helpdesk.domain.Chamado;
import com.eduardo.helpdesk.domain.Cliente;
import com.eduardo.helpdesk.domain.Tecnico;
import com.eduardo.helpdesk.domain.enums.Perfil;
import com.eduardo.helpdesk.domain.enums.Prioridade;
import com.eduardo.helpdesk.domain.enums.Status;
import com.eduardo.helpdesk.repositories.ChamadoRepository;
import com.eduardo.helpdesk.repositories.ClienteRepository;
import com.eduardo.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired // O spring ficará responsavel por criar a instancia daquela interface, gerencia e destruir a mesma
	private TecnicoRepository tecnicoRepository;
	
	@Autowired 
	private ClienteRepository clienteRepository;
	
	@Autowired 
	private ChamadoRepository chamadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
		
	}

	// Esse metodo será executado sempre que o programa for executado pois a classe implementa o CommandLineRunner
	@Override
	public void run(String... args) throws Exception { 
		Tecnico tec1 = new Tecnico(null, "Valdir cezar", "63653230268", "valdir@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "80527954780", "torvalds@mail.com", "123");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	}

}
