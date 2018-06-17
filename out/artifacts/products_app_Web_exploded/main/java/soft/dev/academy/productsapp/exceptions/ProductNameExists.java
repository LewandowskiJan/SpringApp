package soft.dev.academy.productsapp.exceptions;

public class ProductNameExists extends RuntimeException {


    public ProductNameExists(String message) {
        super(message);
    }

}
