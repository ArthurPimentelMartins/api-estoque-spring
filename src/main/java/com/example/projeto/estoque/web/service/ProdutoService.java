package com.example.projeto.estoque.web.service;

import com.example.projeto.estoque.web.exception.BusinessException;
import com.example.projeto.estoque.web.exception.ResourceNotFoundException;
import com.example.projeto.estoque.web.model.entity.Produto;
import com.example.projeto.estoque.web.model.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Produto salvar(Produto produto) {

        validarRegrasNegocio(produto);

        return repository.save(produto);
    }

    @Transactional
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produtoExistente = buscarPorId(id);

        validarRegrasNegocio(produtoAtualizado);

        produtoExistente.setNome(produtoAtualizado.getNome());
        produtoExistente.setQuantidade(produtoAtualizado.getQuantidade());
        produtoExistente.setPreco(produtoAtualizado.getPreco());

        return repository.save(produtoExistente);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produto com ID " + id + " não encontrado");
        }
        repository.deleteById(id);
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Produto com ID " + id + " não encontrado"
                ));
    }

    private void validarRegrasNegocio(Produto produto) {
        List<String> erros = new ArrayList<>();

        if (repository.existsByNomeAndIdNot(produto.getNome(), produto.getId() != null ? produto.getId() : -1L)) {
            erros.add("Já existe um produto com este nome");
        }

        if (produto.getPreco() > 5000 && produto.getQuantidade() > 100) {
            erros.add("Produtos acima de R$ 5000 não podem ter estoque superior a 100 unidades");
        }

        if (produto.getPreco() < 10 && produto.getQuantidade() < 10) {
            erros.add("Produtos abaixo de R$ 10 devem ter estoque mínimo de 10 unidades");
        }

        if (!erros.isEmpty()) {
            throw new BusinessException(String.join("; ", erros));
        }
    }

    public void baixarEstoque(Long produtoId, Integer quantidade) {
        Produto produto = buscarPorId(produtoId);

        if (produto.getQuantidade() < quantidade) {
            throw new BusinessException(
                    String.format("Estoque insuficiente. Disponível: %d, Solicitado: %d")
            );
        }

        produto.setQuantidade(produto.getQuantidade() - quantidade);
        repository.save(produto);
    }
}