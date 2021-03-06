package com.padaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.padaria.domain.Estoque;
import com.padaria.dto.EstoqueDTO;
import com.padaria.repository.EstoqueRepository;
import com.padaria.services.exception.ObjectNotFoundException;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository repo;

	public List<Estoque> findAll() {
		return repo.findAll();
	}

	public Estoque findById(String id) {
		Optional<Estoque> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Estoque insert(Estoque obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public Estoque update(Estoque obj) {
		Estoque newObj = repo.findById(obj.getId()).get();
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Estoque newObj, Estoque obj) {
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
		newObj.setQtd(obj.getQtd());
		newObj.setPreco(obj.getPreco());
	}

	public Estoque fromDTO(EstoqueDTO objDto) {
		return new Estoque(objDto.getId(), objDto.getNome(), objDto.getDescricao(), objDto.getQtd(), objDto.getPreco());
	}

}
