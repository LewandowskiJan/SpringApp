package soft.dev.academy.productsapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.services.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductWebController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products-web")
    public ModelAndView findProducts() {
        List<ProductDto> productsDto = productService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> model = new HashMap<String,Object>();
        model.put("productList", productsDto);

        return new ModelAndView("products", model);
    }

}
