package com.padaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padaria.domain.Estoque;
import com.padaria.repository.EstoqueRepository;

@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository repo;
	
	public List<Estoque> findAll(){
		return repo.findAll();
	}

}
