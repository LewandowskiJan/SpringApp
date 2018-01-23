package soft.dev.academy.productsapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import soft.dev.academy.productsapp.dto.ProductDto;
import soft.dev.academy.productsapp.entity.ProductType;
import soft.dev.academy.productsapp.exceptions.ProductNameExists;
import soft.dev.academy.productsapp.services.ProductService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class ProductWebController {

    @Autowired
    private ProductService productService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/products-web/list", produces = MediaType.TEXT_HTML_VALUE, method = RequestMethod.GET)
    public String findProducts(
            @RequestParam(value = "productName", required = false) String productName,
            @RequestParam(value = "productType", required = false) String productType,
            Map<String, Object> model) {

        List<ProductDto> productsDto = productService.findAll();
        //List<ProductDto> productsDto = productService.findByNameAndType(productName, productType);
        model.put("productList", productsDto);
        return "products";

    }

    @RequestMapping(value = "/products-web/edit/{id}")
    public String editProduct(@PathVariable Integer id, Map<String, Object> model) {
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
                              Map<String, Object> model) {
        Map<String, String> productTypes = getProductTypesAsMap();
        model.put("productTypes", productTypes);
        model.put("productModel", productDto);

        if (result.hasErrors()) {
            return "editProduct";
        } else {
            try {
                productService.save(productDto);
            } catch (ProductNameExists e) {
                model.put("errorMessage",
                        messageSource.getMessage(
                                "productModel.nameExists",
                                new String[]{productDto.getName()},
                                Locale.getDefault()));
                return "editProduct";
            }
            return "redirect:/products-web/list";
        }
    }

    @RequestMapping(value = "/products-web/new", method = RequestMethod.GET)
    public String addProduct(Map<String, Object> model) {
        Map<String, String> productTypes = getProductTypesAsMap();

        model.put("productModel", new ProductDto());
        model.put("productTypes", productTypes);
        model.put("edit", false);
        return "editProduct";
    }

    @RequestMapping(value = "/products-web/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Integer id, Map<String, Object> model) {

        productService.delete(id);

        return "redirect:/products-web/list";
    }


    private Map<String, String> getProductTypesAsMap() {
        Map<String, String> productTypes = new HashMap<String, String>();

        for (ProductType productType : ProductType.values()) {
            productTypes.put(productType.name(), productType.getValue());
        }
        return productTypes;
    }
}
