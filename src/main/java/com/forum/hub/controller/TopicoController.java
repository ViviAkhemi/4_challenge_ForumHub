package com.forum.hub.controller;

import com.forum.hub.topicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosNovoTopico dados){
        repository.save(new Topico(dados));
    }

    @GetMapping
    public Page<DadosListagemTopico> listar(@PageableDefault(size = 10, sort = {"Id"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemTopico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarTopico dados){
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        topico.excluir();
    }

}
