package soft.dev.academy.productsapp.entity;

import javax.persistence.*;

@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Enumerated
    private ProductType type;

    private Integer quantity;


    public Product() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
