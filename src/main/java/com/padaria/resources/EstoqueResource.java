package com.padaria.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.padaria.domain.Estoque;
import com.padaria.dto.EstoqueDTO;
import com.padaria.services.EstoqueService;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueResource {
	
	@Autowired
	private EstoqueService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EstoqueDTO>> findAll(){
		List<Estoque> list = service.findAll();
		List<EstoqueDTO> listDto = list.stream().map(x -> new EstoqueDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
