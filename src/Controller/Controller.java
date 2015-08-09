package Controller;

import Model.Product;
import View.UI;
import View.UIRealisation;

import javax.swing.*;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by mac on 08.06.15.
 */
public class Controller {
    private ArrayList<Product> products;
    private static final URL URLDirectoryOfSmallImages = Controller.class.getResource("products_images/");
    private static final URL URLDirectoryOfBigImages = Controller.class.getResource("img_max/");
    private UI ui;

    private static Controller instance;

    public static synchronized Controller getInstance(){
        if (instance == null){
            instance = new Controller();

        }
        return instance;
    }

    private Controller(){
        ui = UIRealisation.getInstance();
        ui.init();
        createProductsFromImageFiles();
        randomizeProducts();
        bindProductsToUI();
    }

    public static void main(String[] args) {
        new Controller();
    }

    private ArrayList<Product> createProductsFromImageFiles(){
        products = new ArrayList<>();

        ArrayList<File> smallImgFiles = getImgs(getFileFromURL(URLDirectoryOfSmallImages));
        ArrayList<File> bigImgFiles = getImgs(getFileFromURL(URLDirectoryOfBigImages));

        for (int i = 0; i < smallImgFiles.size(); i++) {
            products.add(productFromFile(smallImgFiles.get(i), bigImgFiles.get(i)));
        }

        return products;
    }

    private File getFileFromURL(URL url){
        File file = null;
        try {
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file;
    }

    private ArrayList<File> getImgs(final File directory){
        ArrayList<File> imgs = new ArrayList<>();
        for (final File fileEntry : directory.listFiles()){
            if (!fileEntry.isDirectory()){
                imgs.add(fileEntry);
            }
        }
        return imgs;
    }

    private Product productFromFile (File fileOfSmallImage, File fileOfBigImage){
        String productTitle = fileOfSmallImage.getName();
        Product tempProduct = null;
        if (productTitle.contains(".")) {
            ImageIcon smallIcon = new ImageIcon(fileOfSmallImage.toString());
            ImageIcon bigIcon = new ImageIcon(fileOfBigImage.toString());
            tempProduct = new Product(productTitle.substring(0, productTitle.lastIndexOf('.')), Product.productsCount, smallIcon, bigIcon);
        }
        return tempProduct;
    }

    private ArrayList<Product> randomizeProducts(){
        long seed = System.nanoTime();
        Collections.shuffle(products, new Random(seed));
        return null;
    }

    private void bindProductsToUI(){
        JButton[][] buttons = ui.getButtons();
        for (int i = 0; i < buttons.length; i++){
            for (int b = 0; b < buttons[i].length; b++){
                switch (b){
                    case 0:
                        buttons[i][b].setIcon(products.get(i).getSmallImage());
                        products.get(i).setId(i + 1);
                        buttons[i][b].setToolTipText("№" + products.get(i).getId() + " " + products.get(i).getName());
                    default:
                        break;
                }
            }
        }
    }

    private void addActionListenersToUI(){

    }


}
