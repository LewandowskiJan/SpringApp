package soft.dev.academy.productsapp.services;

import soft.dev.academy.productsapp.dto.ProductDto;


import java.util.List;

public interface ProductService {

    public List<ProductDto> findAll();
    public ProductDto findById(Integer id);
    public void save(ProductDto productDto);
    public void delete(Integer id);

}
