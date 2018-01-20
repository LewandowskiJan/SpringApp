package soft.dev.academy.productsapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import soft.dev.academy.productsapp.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {



}
