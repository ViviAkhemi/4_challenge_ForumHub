package com.forum.hub.topicos;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record DadosNovoTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        @Future
        @JsonAlias({"dataCriacao", "data_criacao"})
        LocalDateTime dataCriacao,
        @NotNull
        Status status,
        @NotBlank
        String autor,
        @NotNull
        Cursos curso,
        @NotBlank
        String respostas) {

        private static final String dataCadastro = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    public DadosNovoTopico(@NotBlank
                           String titulo, @NotBlank
                           String mensagem, @NotBlank
                           LocalDateTime dataCriacao, @NotNull
                           Status status, @NotBlank
                           String autor, @NotNull
                           Cursos curso, @NotBlank
                           String respostas) {



        this.dataCriacao = dataCriacao;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.respostas = respostas;
    }
}
