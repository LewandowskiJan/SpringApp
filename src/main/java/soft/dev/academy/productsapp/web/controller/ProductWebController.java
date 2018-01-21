package soft.dev.academy.productsapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class ProductWebController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products-web/list", produces = MediaType.TEXT_HTML_VALUE, method = RequestMethod.GET)
    public String findProducts(Map<String, Object> model) {
        List<ProductDto> productsDto = productService.findAll();
        model.put("productList", productsDto);
        return "products";
    }

    @RequestMapping(value = "/products-web/edit/{id}")
    public String editProduct(@PathVariable Integer id, Map<String, Object> model){
        ProductDto productDto = productService.findById(id);
        model.put("productModel", productDto);
        return "editProduct";
    }

    @RequestMapping(value = "/products-web/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute(value = "productModel") ProductDto productDto){

        productService.save(productDto);

        return "redirect:/products-web/list";
    }

    @RequestMapping(value = "/products-web/new", method = RequestMethod.GET)
    public String addProduct(Map<String, Object> model){
        model.put("productModel", new ProductDto());


        return "editProduct";
    }


}
