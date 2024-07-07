package com.forum.hub.topicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    //@Column(name = "dataCriacao")
    private LocalDate dataCriacao = LocalDate.now();
    private String respostas;
    private String autor;

    @Enumerated(EnumType.STRING)
    private Cursos curso;
    @Enumerated(EnumType.STRING)
    private Status status;

    private Boolean ativo;


    public Topico(DadosNovoTopico dados) {
        this.ativo = true;
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.dataCriacao = (dados.dataCriacao() != null) ? dados.dataCriacao().toLocalDate() : LocalDate.now();
        this.mensagem = dados.mensagem();
        this.respostas = dados.respostas();
        this.titulo = dados.titulo();
        this.status = dados.status();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getId() {
        return new String(String.valueOf(id));
    }

    public LocalDateTime getdataCriacao() {
        return dataCriacao.atStartOfDay();
    }

    public void atualizarInformacoes(DadosAtualizarTopico dados) {
        if (dados.titulo() != null){
            this.autor = dados.titulo();
        }
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
    }

    public void excluir() {
        this.ativo=false;
    }
}
