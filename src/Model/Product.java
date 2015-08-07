package Model;

/**
 * Created by mac on 08.06.15.
 */
public class Product {
    private String name;
    public int id = 0;
    private String description;
    public static int productsCount = 0;

    boolean isSelected;
    TypesOfProducts type;

//    public Product getNewProduct(){
//        productsCount++;
//        return new Product();
//    }


    public Product(String name, TypesOfProducts type) {
        productsCount++;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
