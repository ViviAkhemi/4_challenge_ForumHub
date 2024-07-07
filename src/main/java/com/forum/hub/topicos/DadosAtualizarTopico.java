package com.forum.hub.topicos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(
    @NotNull
    Long id,
    String mensagem,
    String titulo){
}
