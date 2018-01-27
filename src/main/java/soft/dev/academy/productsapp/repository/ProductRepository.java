package soft.dev.academy.productsapp.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import soft.dev.academy.productsapp.entity.Product;
import soft.dev.academy.productsapp.entity.ProductType;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>,
        JpaSpecificationExecutor<Product> {

    public List<Product> findAll(Specification<Product> specification);

    public List<Product> findByName (String name);

    public List<Product> findByNameAndQuantity(String name, Integer quantity);

    public List<Product> findByNameAndType(String name, ProductType productType);

}
