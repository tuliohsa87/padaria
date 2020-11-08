package com.padaria.dto;

import java.io.Serializable;

import com.padaria.domain.Estoque;

public class EstoqueDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String nome;
	private String descricao;
	private Integer qtd;
	private Double preco;
	
	public EstoqueDTO() {
	}
	
	public EstoqueDTO(Estoque obj) {
		id = obj.getId();
		nome = obj.getNome();
		descricao = obj.getDescricao();
		qtd = obj.getQtd();
		preco = obj.getPreco();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
