package soft.dev.academy.productsapp.repository.specyfication;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import soft.dev.academy.productsapp.entity.Product;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification implements Specification<Product> {


    private Product product;

    // TO DO if we need to add 2 field "more than" "less than"
    // TO DO we should create ProductDtoSearcher with field lessTan and moreThan
    public ProductSpecification(Product filter) {
        this.product = filter;
    }

    @Override
    public Predicate toPredicate(Root<Product> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {

        Predicate p = criteriaBuilder.and();

        if (!StringUtils.isEmpty(product.getName())) {
            p.getExpressions().add(criteriaBuilder.like(
                    root.get("name"), "%" + product.getName() + "%"));
        }

        if (product.getType() != null){
            p.getExpressions().add(criteriaBuilder.equal(root.get("type"), product.getType()));
        }

        return p;
    }
}
