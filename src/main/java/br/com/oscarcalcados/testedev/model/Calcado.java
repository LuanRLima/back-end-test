package br.com.oscarcalcados.testedev.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String cor;
    @Column(nullable = false)
    private String tamanho;
    @Column(nullable = false)
    private String preco;
    @Column(name = "quantidade_estoque" ,nullable = false)
    private String quantidadeEmEstoque;
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
    private LocalDateTime dataDeCadastro;

    public Calcado(String nome, String marca, String cor, String tamanho, String preco, String quantidadeEmEstoque, String categoria) {
        this.nome = nome;
        this.marca = marca;
        this.cor = cor;
        this.tamanho = tamanho;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.categoria = categoria;
    }

    @PrePersist
    private void prePersist() {
        this.dataDeCadastro = LocalDateTime.now();
    }

}
