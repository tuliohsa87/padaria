package com.padaria.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<EstoqueDTO> findById(@PathVariable String id){
		Estoque obj =  service.findById(id);
		return ResponseEntity.ok().body(new EstoqueDTO(obj));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody EstoqueDTO objDto){
		Estoque obj =  service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody EstoqueDTO objDto, @PathVariable String id){
		Estoque obj =  service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

}
