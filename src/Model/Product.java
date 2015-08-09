package Model;

import javax.swing.*;
import java.io.File;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by mac on 08.06.15.
 */
public class Product {
    private String name;
    private int id = 0;
    private String description;
    public static int productsCount = 0;
    private ImageIcon smallImage;
    private ImageIcon zoomedImage;

    boolean isSelected;

    public Product(String name, int id, ImageIcon smallImage, ImageIcon zoomedImage) {
        productsCount++;
        this.id = id;
        this.name = name;
        this.smallImage = smallImage;
        this.zoomedImage = zoomedImage;
    }

    public Product(String name, int id) {
        productsCount++;
        this.id = id;
        this.name = name;
    }

    public Product(String name) {
        productsCount++;
        this.name = name;
    }

    public Product(){
    }


    public static void main(String[] args) {
//        new Product().getProductsTitlesFromDirectory();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageIcon getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(ImageIcon smallImage) {
        this.smallImage = smallImage;
    }

    public ImageIcon getZoomedImage() {
        return zoomedImage;
    }

    public void setZoomedImage(ImageIcon zoomedImage) {
        this.zoomedImage = zoomedImage;
    }
}
