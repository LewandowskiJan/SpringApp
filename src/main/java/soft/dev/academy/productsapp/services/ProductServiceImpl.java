package soft.dev.academy.productsapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.dev.academy.productsapp.converters.ProductDtoConverter;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.entity.Product;
import soft.dev.academy.productsapp.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDtoConverter productDtoConverter;


    @Override
    public List<ProductDto> findAll() {

      return StreamSupport
                .stream(productRepository.findAll().spliterator(), false)
                .map(product -> productDtoConverter.convert(product))
                .collect(Collectors.toList());

    }

    @Override
    public ProductDto findById(Integer id) {
        Product product = productRepository.findOne(id);
        return productDtoConverter.convert(product);
    }

    @Override
    public void save(ProductDto productDto) {
        Product product = productDtoConverter.convertDto(productDto);
        productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }

}
