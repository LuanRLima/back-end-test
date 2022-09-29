package br.com.oscarcalcados.testedev.domain.dto;

import br.com.oscarcalcados.testedev.domain.Categoria;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Classe DTO para filtro de busca de calçados
 *
 */
@Getter
@Setter
public class CalcadoFilter {

    private String nome;
    private String marca;
    private String cor;
    private String tamanho;
    private Double preco;
    private Integer quantidadeEmEstoque;
    private Categoria categoria;
    private String descricao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDeCadastroInicial;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDeCadastroFinal;

}
