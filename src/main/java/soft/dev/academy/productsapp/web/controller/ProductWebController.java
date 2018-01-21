package soft.dev.academy.productsapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.entity.Product;
import soft.dev.academy.productsapp.entity.ProductType;
import soft.dev.academy.productsapp.exceptions.ProductNameExists;
import soft.dev.academy.productsapp.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductWebController {

    @Autowired
    private ProductService productService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/products-web/list", produces = MediaType.TEXT_HTML_VALUE, method = RequestMethod.GET)
    public String findProducts(Map<String, Object> model) {
        List<ProductDto> productsDto = productService.findAll();
        model.put("productList", productsDto);
        return "products";
    }

    @RequestMapping(value = "/products-web/edit/{id}")
    public String editProduct(@PathVariable Integer id, Map<String, Object> model){
        ProductDto productDto = productService.findById(id);
        Map<String, String> productTypes = getProductTypesAsMap();

        model.put("productModel", productDto);
        model.put("productTypes", productTypes);
        model.put("edit", true);
        return "editProduct";
    }

    @RequestMapping(value = "/products-web/save", method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute(value = "productModel") ProductDto productDto,
                              BindingResult result,
                              Map<String, Object> model){

        if (result.hasErrors()){
            Map<String, String> productTypes = getProductTypesAsMap();
            model.put("productTypes", productTypes);
            model.put("productModel", productDto);
            return "editProduct";
        } else {
            try{
                productService.save(productDto);
            } catch (ProductNameExists e){

            }
            return "redirect:/products-web/list";
        }
    }

    @RequestMapping(value = "/products-web/new", method = RequestMethod.GET)
    public String addProduct(Map<String, Object> model){
        Map<String,String> productTypes = getProductTypesAsMap();

        model.put("productModel", new ProductDto());
        model.put("productTypes", productTypes);
        model.put("edit", false);
        return "editProduct";
    }

    @RequestMapping(value = "/products-web/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Integer id, Map<String, Object> model){

        productService.delete(id);

        return "redirect:/products-web/list";
    }


    private Map<String, String> getProductTypesAsMap() {
        Map<String, String> productTypes = new HashMap<String, String>();

        for (ProductType productType : ProductType.values()){
            productTypes.put(productType.name(), productType.getValue());
        }
        return productTypes;
    }
}
