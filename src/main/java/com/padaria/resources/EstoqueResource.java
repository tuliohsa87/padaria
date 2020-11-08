package com.padaria.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.padaria.domain.Estoque;
import com.padaria.services.EstoqueService;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueResource {
	
	@Autowired
	private EstoqueService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Estoque>> findAll(){
		List<Estoque> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
