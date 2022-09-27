package br.com.oscarcalcados.testedev.specification;

import br.com.oscarcalcados.testedev.dto.CalcadoFilter;
import br.com.oscarcalcados.testedev.model.Calcado;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CalcadoSpecification {

    public Specification<Calcado> calcados(CalcadoFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (!ObjectUtils.isEmpty(filter.getNome())) {
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.upper(root.get("nome")), filter.getNome().toUpperCase().concat("%")
                        )
                );
            }
            if (!ObjectUtils.isEmpty(filter.getMarca())) {
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.upper(root.get("marca")), filter.getMarca().toUpperCase().concat("%")
                        )
                );
            }
            if (!ObjectUtils.isEmpty(filter.getCor())) {
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.upper(root.get("cor")), filter.getCor().toUpperCase().concat("%")
                        )
                );
            }
            if (!ObjectUtils.isEmpty(filter.getTamanho())) {
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.upper(root.get("tamanho")), filter.getTamanho().toUpperCase().concat("%")
                        )
                );
            }
            if (!ObjectUtils.isEmpty(filter.getPreco())) {
                predicateList.add(
                        criteriaBuilder.equal(root.get("preco"), filter.getPreco())
                );
            }


            if (!ObjectUtils.isEmpty(filter.getDataDeCadastroFinal())) {
                predicateList.add(
                        criteriaBuilder.lessThanOrEqualTo(
                                root.get("dataDeCadastro"), filter.getDataDeCadastroFinal()
                        )
                );
            }

            if (!ObjectUtils.isEmpty(filter.getQuantidadeEmEstoque())) {
                predicateList.add(
                        criteriaBuilder.equal(root.get("quantidadeEmEstoque"), filter.getQuantidadeEmEstoque())
                );
            }

            if (!ObjectUtils.isEmpty(filter.getCategoria())) {
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.upper(root.get("categoria")), filter.getCategoria().toUpperCase().concat("%")
                        )
                );
            }

            if (!ObjectUtils.isEmpty(filter.getDataDeCadastroInicial())) {
                predicateList.add(
                        criteriaBuilder.greaterThanOrEqualTo(
                                root.get("dataDeCadastro"), filter.getDataDeCadastroInicial()
                        )
                );
            }
            if (!ObjectUtils.isEmpty(filter.getDataDeCadastroFinal())) {
                predicateList.add(
                        criteriaBuilder.lessThanOrEqualTo(
                                root.get("dataDeCadastro"), filter.getDataDeCadastroFinal()
                        )
                );
            }
            if (!ObjectUtils.isEmpty(filter.getDescricao())) {
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.upper(root.get("descricao")), filter.getDescricao().toUpperCase().concat("%")
                        )
                );
            }
            query.orderBy(criteriaBuilder.asc(root.get("id")));
            return criteriaBuilder.and(predicateList.toArray(Predicate[]::new));
        };

    }
}
