package soft.dev.academy.productsapp.services;

import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.exceptions.ProductNameExists;


import java.util.List;

public interface ProductService {

    public List<ProductDto> findAll();
    public List<ProductDto> findByName(String name);
    public ProductDto findById(Integer id);
    public void save(ProductDto productDto) throws ProductNameExists;
    public void delete(Integer id);

}
