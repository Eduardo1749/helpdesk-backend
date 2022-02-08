package com.eduardo.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.helpdesk.domain.Pessoa;
import com.eduardo.helpdesk.domain.Tecnico;
import com.eduardo.helpdesk.domain.dtos.TecnicoDTO;
import com.eduardo.helpdesk.repositories.PessoaRepository;
import com.eduardo.helpdesk.repositories.TecnicoRepository;
import com.eduardo.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.eduardo.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {

	// Autowired, é uma forma de fazer injeção de dependência. Mas o que isso significa? Significa que quem ficará responsavel por instanciar o objeto é quem chama (nesse caso o spring).  
	@Autowired
	private TecnicoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: "+ id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
	objDTO.setId(null);
	validaPorCpfEEmail(objDTO);
	Tecnico newObj = new Tecnico(objDTO); 
	return repository.save(newObj);
	}
	
	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		objDTO.setId(id);
		Tecnico oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Tecnico(objDTO);
		return repository.save(oldObj);
	}

	private void validaPorCpfEEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() &&  obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() &&  obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}
	
}
