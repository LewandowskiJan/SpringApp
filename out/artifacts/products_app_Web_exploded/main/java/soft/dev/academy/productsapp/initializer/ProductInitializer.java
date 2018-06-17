package soft.dev.academy.productsapp.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import soft.dev.academy.productsapp.entity.Product;
import soft.dev.academy.productsapp.entity.ProductType;
import soft.dev.academy.productsapp.repository.ProductRepository;

import javax.annotation.PostConstruct;

@Component
public class ProductInitializer {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void initializeData(){
        productRepository.save(new Product(1, "butter", ProductType.FOOD, 5 ));
        productRepository.save(new Product(2, "water", ProductType.DRINK, 7 ));
    }

}
