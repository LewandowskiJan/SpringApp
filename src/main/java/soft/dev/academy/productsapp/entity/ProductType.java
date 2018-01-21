package soft.dev.academy.productsapp.entity;

public enum ProductType {

    FOOD("Food category"),
    DRINK("Drinks"),
    ELECTRONICS("Electronic");

    private String value;

    ProductType (String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
