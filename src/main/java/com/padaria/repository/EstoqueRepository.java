package com.padaria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.padaria.domain.Estoque;

@Repository
public interface EstoqueRepository extends MongoRepository<Estoque, String> {
	
}
