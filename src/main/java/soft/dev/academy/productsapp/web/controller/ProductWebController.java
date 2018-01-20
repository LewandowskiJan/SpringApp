package soft.dev.academy.productsapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.services.ProductService;

import java.util.List;

@Controller
public class ProductWebController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products-web/")
    public String findProducts(Model model) {
        List<ProductDto> productsDto = productService.findAll();

        model.addAttribute("productList", productsDto);

        return "products";
    }

}
