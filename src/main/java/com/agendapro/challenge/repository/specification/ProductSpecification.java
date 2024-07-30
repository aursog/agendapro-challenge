package com.agendapro.challenge.repository.specification;

import com.agendapro.challenge.dto.FilterDto;
import com.agendapro.challenge.model.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

  public static Specification<Product> columnEqual(List<FilterDto> filters) {
    return new Specification<Product>() {
      private static final long serialVersionUID = 1L;

      @Override
      public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        filters.forEach(filter -> {
          if (!filter.columnValue().isEmpty()) {
            switch (filter.columnValue()) {
              case "descripcion":
                predicates.addAll(filterByTags(filter.columnValue(),
                    (tag) -> filterByPartialText(tag, filter.columnName(), criteriaBuilder, root)
                ));
                break;
            }
          }
        });
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
      }
    };
  }

  private static List<Predicate> filterByTags(String tags, Function<String, Predicate> criteriaBuilder) {
    return Arrays.stream(tags.split(","))
        .map(criteriaBuilder)
        .collect(Collectors.toList());
  }

  private static Predicate filterByPartialText(String partialText, String columnName, CriteriaBuilder criteriaBuilder, Root<Product> root) {
    return criteriaBuilder.like(root.get(columnName).as(String.class), "%" + partialText + "%");
  }
}
