package com.padaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padaria.domain.Estoque;
import com.padaria.dto.EstoqueDTO;
import com.padaria.repository.EstoqueRepository;
import com.padaria.services.exception.ObjectNotFoundException;

@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository repo;
	
	public List<Estoque> findAll(){
		return repo.findAll();
	}
	
	public Estoque findById(String id) {
		Optional<Estoque> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Estoque insert(Estoque obj) {
		return repo.insert(obj);
	}
	
	public Estoque fromDTO(EstoqueDTO objDto) {
		return new Estoque(objDto.getId(), objDto.getNome(), objDto.getDescricao(), objDto.getQtd(), objDto.getPreco());
	}

}
