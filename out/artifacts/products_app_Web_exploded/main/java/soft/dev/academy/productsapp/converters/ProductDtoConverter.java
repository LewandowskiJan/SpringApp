package soft.dev.academy.productsapp.converters;

import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.entity.Product;

public interface ProductDtoConverter {

    public ProductDto convert(Product product);
    public Product convertDto(ProductDto productDto);

}
