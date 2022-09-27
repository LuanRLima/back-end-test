package br.com.oscarcalcados.testedev.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "calcados")
public class Calcado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String cor;
    @Column(nullable = false)
    private String tamanho;

    @Column(nullable = false)
    //TODO REFATORAR BigDecimal
    private Double preco;
    @Column(nullable = false)
    private Integer quantidadeEmEstoque;
    @Column(nullable = false)
    //TODO CRIAR ENUM
    private String categoria;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeCadastro;
    @Column(nullable = false)
    private String descricao;

    public Calcado(String nome, String marca, String cor, String tamanho, Double preco, Integer quantidadeEmEstoque, String categoria, String descricao) {
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

