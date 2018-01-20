package soft.dev.academy.productsapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import soft.dev.academy.productsapp.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    public List<Product> findByName (String name);

    public List<Product> findByNameAndQuantity(String name, Integer quantity);

}
