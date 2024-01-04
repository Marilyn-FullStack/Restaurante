package com.generation.restaurante.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.restaurante.model.Prato;
import com.generation.restaurante.repository.PratoRepository;

@RestController
@RequestMapping("/pratos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PratoController {

	private final PratoRepository pratoRepository;


    public PratoController(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    @GetMapping
    public List<Prato> getAllPratos() {
        return pratoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Prato getPratoById(@PathVariable Long id) {
        return pratoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Prato createPrato(@RequestBody Prato prato) {
        return pratoRepository.save(prato);
    }

    @PutMapping("/{id}")
    public Prato updatePrato(@PathVariable Long id, @RequestBody Prato prato) {
        if (pratoRepository.existsById(id)) {
            prato.setId(id);
            return pratoRepository.save(prato);
        } else {
            return null; // Ou lançar uma exceção, dependendo dos requisitos
        }
    }

    @DeleteMapping("/{id}")
    public void deletePrato(@PathVariable Long id) {
        pratoRepository.deleteById(id);
    }
}