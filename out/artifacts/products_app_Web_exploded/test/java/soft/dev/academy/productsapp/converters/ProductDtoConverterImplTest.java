package soft.dev.academy.productsapp.converters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.entity.Product;
import soft.dev.academy.productsapp.entity.ProductType;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDtoConverterImplTest {

    @Autowired
    private ProductDtoConverter productDtoConverter;

    @Test
    public void shouldConvertProductDtoProperly() {
        //GIVEN
        Product product = new Product(5, "eqq", ProductType.FOOD, 12);
        //WHEN
        ProductDto productDto = productDtoConverter.convert(product);
        //TODO stworzyć ProductDtoAssertObject
        //THEN
        Assert.assertEquals(productDto.getName(), "eqq");
    }
}