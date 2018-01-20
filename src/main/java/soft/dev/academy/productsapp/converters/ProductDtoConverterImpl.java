package soft.dev.academy.productsapp.converters;

import org.springframework.stereotype.Component;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.entity.Product;

import java.util.function.Function;

@Component
public class ProductDtoConverterImpl implements ProductDtoConverter /* Function<Product, ProductDto> */{



    @Override
    public ProductDto convert(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setType(product.getType().name());
        productDto.setQuantity(product.getQuantity());

        return productDto;
    }
/*
    @Override
    public ProductDto apply(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setType(product.getType().name());
        productDto.setQuantity(product.getQuantity());

        return productDto;
    }
    */
}
