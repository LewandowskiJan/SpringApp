package soft.dev.academy.productsapp.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Product {


    @Id
    private Integer id;

    private String name;

    @Enumerated
    private ProductType type;

    private Integer quantity;


    public Product() {
    }

    public Product(Integer id, String name, ProductType type, Integer quantity) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductType getType() {
        return type;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
