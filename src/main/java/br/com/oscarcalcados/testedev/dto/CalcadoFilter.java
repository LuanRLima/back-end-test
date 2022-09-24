package br.com.oscarcalcados.testedev.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class CalcadoFilter {

    private String nome;
    private String marca;
    private String cor;
    private String tamanho;
    private Double preco;
    private Integer quantidadeEmEstoque;
    private String categoria;
    private String descricao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDeCadastroInicial;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDeCadastroFinal;

}
