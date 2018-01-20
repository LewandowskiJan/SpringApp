package soft.dev.academy.productsapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/")
    public List<ProductDto> findAll(){
        return productService.findAll();
    }

    @RequestMapping(value = "/{id}")
    public ProductDto findById(@PathVariable Integer id){
        return productService.findById(id);
    }


}
