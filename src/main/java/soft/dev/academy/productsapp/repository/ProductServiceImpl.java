package soft.dev.academy.productsapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.dev.academy.productsapp.converters.ProductDtoConverter;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.services.ProductService;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDtoConverter productDtoConverter;


    @Override
    public List<ProductDto> findAll() {

        StreamSupport.stream(productRepository.findAll().spliterator(), false).;

        productRepository.findAll();

        return null;
    }
}
