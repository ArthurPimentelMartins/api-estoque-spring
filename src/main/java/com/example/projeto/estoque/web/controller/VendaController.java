package com.example.projeto.estoque.web.controller;

import com.example.projeto.estoque.web.model.entity.Venda;
import com.example.projeto.estoque.web.model.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaRepository repository;

    @GetMapping
    public List<Venda> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Venda salvar(@RequestBody Venda venda) {
        return repository.save(venda);
    }

    @PutMapping("/{id}")
    public Venda atualizar(@PathVariable Long id, @RequestBody Venda vendaAtualizada) {

        Venda vendaExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));

        vendaExistente.setCliente(vendaAtualizada.getCliente());
        vendaExistente.setProduto(vendaAtualizada.getProduto());
        vendaExistente.setQuantidadeComprada(vendaAtualizada.getQuantidadeComprada());

        return repository.save(vendaExistente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}