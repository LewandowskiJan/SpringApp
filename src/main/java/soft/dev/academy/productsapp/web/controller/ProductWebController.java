package soft.dev.academy.productsapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.services.ProductService;

import java.util.List;
import java.util.Map;

@Controller
public class ProductWebController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products-web/", produces = MediaType.TEXT_HTML_VALUE, method = RequestMethod.GET)
    public String findProducts(Map<String, Object> model) {
        List<ProductDto> productsDto = productService.findAll();
        model.put("productList", productsDto);
        return "products";
    }

    @RequestMapping(value = "/products-web/{id}")
    public String findProduct(@PathVariable Integer id, Map<String, Object> model){
        ProductDto productDto = productService.findById(id);
        model.put("product", productDto);
        return "editProduct";
    }

}
