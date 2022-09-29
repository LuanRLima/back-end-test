package br.com.oscarcalcados.testedev.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe DTO para o objeto Calcado
 *
 * @author Luan Rodrigues
 * @since 1.0 (10/09/2020)
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CalcadoDTO {

    private Long id;
    private String nome;
    private String marca;
    private String cor;
    private String tamanho;
    private Double preco;
    private Integer quantidadeEmEstoque;
    private String categoria;
    private String descricao;

}

