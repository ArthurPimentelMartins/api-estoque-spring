package com.example.projeto.estoque.web.controller;

import com.example.projeto.estoque.web.model.entity.Usuario;
import com.example.projeto.estoque.web.model.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {

        Usuario usuarioExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        usuarioExistente.setLogin(usuarioAtualizado.getLogin());
        usuarioExistente.setSenha(usuarioAtualizado.getSenha());

        return repository.save(usuarioExistente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
