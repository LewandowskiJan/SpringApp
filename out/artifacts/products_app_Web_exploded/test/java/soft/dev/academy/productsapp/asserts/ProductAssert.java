package soft.dev.academy.productsapp.asserts;

import org.junit.Assert;
import soft.dev.academy.productsapp.entity.Product;

public class ProductAssert {

    private Product product;

    public ProductAssert(Product product){
        this.product = product;
    }

    public ProductAssert hasName(String name){
        Assert.assertEquals(product.getName(), name);
        return this;
    }

    public ProductAssert hasQuantity(Integer quantity){
        Assert.assertEquals(product.getQuantity(), quantity);
        return this;
    }

}
