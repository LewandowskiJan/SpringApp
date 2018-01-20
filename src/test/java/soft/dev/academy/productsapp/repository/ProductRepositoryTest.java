package soft.dev.academy.productsapp.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import soft.dev.academy.productsapp.asserts.ProductAssert;
import soft.dev.academy.productsapp.entity.Product;
import soft.dev.academy.productsapp.entity.ProductType;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void shouldFindProductById() {
        Product product = productRepository.findOne(1);

        new ProductAssert(product).hasName("butter").hasQuantity(5);
        /*
        Assert.assertEquals(product.getName(), "butter");
        Assert.assertEquals(product.getQuantity(), new Integer(5));
        */
    }

    @Test
    public void shouldFindAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        Assert.assertEquals(2, products.size());
    }

    @Test
    public void shouldSaveProduct(){
        //GIVEN
        Product product = new Product(3, "wine", ProductType.DRINK, 4);
        //WHEN
        productRepository.save(product);
        //THEN
        Product productFromDatabase = productRepository.findOne(3);
        new ProductAssert(productFromDatabase).hasName("wine").hasQuantity(4);
    }

    @Test
    public void shouldFindByName(){
        List<Product> products = productRepository.findByName("water");
        Assert.assertEquals(1, products.size());

    }

}