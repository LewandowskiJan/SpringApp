package soft.dev.academy.productsapp.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import soft.dev.academy.productsapp.services.ProductService;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @Autowired
    private ProductService productService;




}