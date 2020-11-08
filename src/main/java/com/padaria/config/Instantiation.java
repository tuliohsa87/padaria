package com.padaria.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.padaria.domain.Estoque;
import com.padaria.repository.EstoqueRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		estoqueRepository.deleteAll();

		Estoque e1 = new Estoque(null, "Empada", "Camarão", 8, 3.5);
		Estoque e2 = new Estoque(null, "Pastel", "Queijo", 16, 3.0);
		Estoque e3 = new Estoque(null, "Enroladinho", "Salsicha", 32, 3.25);
		Estoque e4 = new Estoque(null, "Pizza", "Muzarela com calabresa", 10, 30.0);
		Estoque e5 = new Estoque(null, "Coxinha", "Camarão com catupiry", 10, 3.25);
		
		estoqueRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5));
	}

}
