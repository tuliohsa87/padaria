package com.padaria.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.padaria.domain.Estoque;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Estoque>> findAll(){
		Estoque estoque1 = new Estoque("1", "Coxinha", "Camarão com catupiry", 10, 3.5);
		Estoque estoque2 = new Estoque("2", "Pizza", "Muzalera", 10, 25.0);
		List<Estoque> list = new ArrayList<>();
		list.addAll(Arrays.asList(estoque1, estoque2));
		return ResponseEntity.ok().body(list);
	}

}
