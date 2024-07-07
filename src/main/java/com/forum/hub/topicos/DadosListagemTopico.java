package com.forum.hub.topicos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosListagemTopico(Long Id, String titulo, String mensagem, LocalDateTime dataCriacao) {

    public DadosListagemTopico(Topico topico){

        this(Long.valueOf(topico.getId()), topico.getTitulo(), topico.getMensagem(), topico.getdataCriacao());
    }
}

