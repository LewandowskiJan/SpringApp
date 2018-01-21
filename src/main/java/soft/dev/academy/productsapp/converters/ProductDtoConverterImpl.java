package soft.dev.academy.productsapp.converters;

import org.springframework.stereotype.Component;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.entity.Product;
import soft.dev.academy.productsapp.entity.ProductType;

import java.util.function.Function;

@Component
public class ProductDtoConverterImpl implements ProductDtoConverter /* Function<Product, ProductDto> */{



    @Override
    public ProductDto convert(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setType(product.getType().getValue());
        productDto.setQuantity(product.getQuantity());

        return productDto;
    }

    @Override
    public Product convertDto(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getName(),
                ProductType.valueOf(productDto.getType()), productDto.getQuantity());
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
