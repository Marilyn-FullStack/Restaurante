package com.generation.restaurante.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min = 7, max = 100, message = "O atributo nome deve conter no mínimo 7 e no máximo 100 caracteres")
	private String nome;

	@OneToMany(mappedBy = "menu")
	private List<Prato> pratos;

	@UpdateTimestamp
	private LocalDateTime data;

	@ManyToOne
	@JsonIgnoreProperties("menu")
	private Prato prato;

	// Construtor vazio necessário para o JPA
	public Menu() {
	}

	public Menu(Long id,
			@NotBlank(message = "O atributo nome é obrigatório!") @Size(min = 7, max = 100, message = "O atributo nome deve conter no mínimo 7 e no máximo 100 caracteres") String nome,
			List<Prato> pratos, LocalDateTime data) {
		this.id = id;
		this.nome = nome;
		this.pratos = pratos;
		this.data = data;
	}

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

	public List<Prato> getPratos() {
		return pratos;
	}

	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
