package soft.dev.academy.productsapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import soft.dev.academy.productsapp.converters.ProductDtoConverter;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.entity.Product;
import soft.dev.academy.productsapp.entity.ProductType;
import soft.dev.academy.productsapp.exceptions.ProductNameExists;
import soft.dev.academy.productsapp.repository.ProductRepository;
import soft.dev.academy.productsapp.repository.specyfication.ProductSpecification;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {

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
    public void save(ProductDto productDto) throws ProductNameExists {
        Product product = productDtoConverter.convertDto(productDto);
        List<ProductDto> productsByName = this.findByName(productDto.getName());
        if (!CollectionUtils.isEmpty(productsByName)) {
            throw new ProductNameExists("Product with name: " + productDto.getName() + " already exists");
        } else {
            productRepository.save(product);
        }
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }

    @Override
    public List<ProductDto> findByName(String name) {
        return StreamSupport
                .stream(productRepository.findByName(name).spliterator(), false)
                .map(product -> productDtoConverter.convert(product))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findByNameAndType(String name, String type) {

        //assign product filters
        Product filterProduct = new Product();
        filterProduct.setName(name);


        ProductType productType = null;
        if (!StringUtils.isEmpty(type)) {
            productType = ProductType.valueOf(type);
            filterProduct.setType(productType);
        }

        return StreamSupport
                .stream(productRepository.findAll(new ProductSpecification(filterProduct)).spliterator(), true)
                .map(product -> productDtoConverter.convert(product))
                .collect(Collectors.toList());
    }
}
