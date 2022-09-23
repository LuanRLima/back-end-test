package br.com.oscarcalcados.testedev.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "calcados")
public class Calcado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;


    private String nome;

    private String marca;

    private String cor;

    private String tamanho;

    //TODO REFATORAR BigDecimal
    private String preco;

    private String quantidadeEmEstoque;

    //TODO CRIAR ENUM
    private String categoria;

    private LocalDate dataDeCadastro;
    private String descricao;

    public Calcado(String nome, String marca, String cor, String tamanho, String preco, String quantidadeEmEstoque, String categoria, String descricao) {
        this.nome = nome;
        this.marca = marca;
        this.cor = cor;
        this.tamanho = tamanho;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    @PrePersist
    private void prePersist() {
        this.dataDeCadastro = LocalDate.now();
    }
}

