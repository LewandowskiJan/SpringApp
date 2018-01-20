package soft.dev.academy.productsapp.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import soft.dev.academy.productsapp.asserts.ProductAssert;
import soft.dev.academy.productsapp.entity.Product;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void shouldFindProductById(){
       Product product = productRepository.findOne(1);

       new ProductAssert(product).hasName("butter").hasQuantity(5);
        /*
        Assert.assertEquals(product.getName(), "butter");
        Assert.assertEquals(product.getQuantity(), new Integer(5));
        */
    }

}