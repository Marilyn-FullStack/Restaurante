package com.generation.restaurante.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_prato")
public class Prato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	private String nome;

	@Column(length = 100)
	private String descricao;

	@Digits(integer = 6, fraction = 2, message = "O preço deve ter no máximo 8 dígitos, sendo 6 inteiros e 2 decimais.")
	@NotNull(message = "O atributo preço é obrigatório!")
	private BigDecimal preco;

	@ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu menu;

	// Construtor vazio necessário para o JPA
	public Prato() {
	}

	public Prato(Long id, String nome, String descricao, BigDecimal preco, Menu menu) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.menu = menu;
	}

	// Getters e Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
