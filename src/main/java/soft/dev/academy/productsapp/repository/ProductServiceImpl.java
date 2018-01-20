package soft.dev.academy.productsapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.dev.academy.productsapp.converters.ProductDtoConverter;
import soft.dev.academy.productsapp.converters.ProductDtoConverterImpl;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.services.ProductService;

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
}
