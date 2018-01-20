package soft.dev.academy.productsapp.converters;

import org.springframework.stereotype.Component;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.entity.Product;

@Component
public class ProductDtoConverterImpl implements ProductDtoConverter {

    @Override
    public ProductDto convert(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setType(product.getType().name());
        productDto.setQuantity(product.getQuantity());

        return productDto;
    }

}
