package Controller;

import Model.Product;
import View.DescriptionPanel;
import View.UI;
import View.UIRealisation;
import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        final JButton[][] buttons = ui.getButtons();
        for (int i = 0; i < buttons.length; i++){
            for (int b = 0; b < buttons[i].length; b++){
                final int y = i;
                final int v = b;
                switch (b){
                    case 0:
                        final int j = i;
                        final int p = b;
                        buttons[y][p].setIcon(products.get(y).getSmallImage());
                        products.get(y).setId(y + 1);
                        buttons[y][p].setToolTipText("№" + products.get(y).getId() + " " + products.get(y).getName());
                        buttons[y][p].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                DescriptionPanel descriptionPanel = new DescriptionPanel();
                                descriptionPanel.init(j, products.get(j));
                            }
                        });
                        break;
                    case 1:

                        buttons[i][b].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                    Product rightProduct = new Product(products.get(y).getName(), products.get(y).getId(), products.get(y).getSmallImage(), products.get(y).getZoomedImage());
                                    Product leftProduct = new Product(products.get(y - 1).getName(), products.get(y - 1).getId(), products.get(y - 1).getSmallImage(), products.get(y - 1).getZoomedImage());
                                    products.get(y - 1).setName(rightProduct.getName());
                                    products.get(y - 1).setSmallImage(rightProduct.getSmallImage());
                                    products.get(y - 1).setZoomedImage(rightProduct.getZoomedImage());
                                    products.get(y - 1).setDescription(rightProduct.getDescription());

                                    products.get(y).setName(leftProduct.getName());
                                    products.get(y).setSmallImage(leftProduct.getSmallImage());
                                    products.get(y).setZoomedImage(leftProduct.getZoomedImage());
                                    products.get(y).setDescription(leftProduct.getDescription());

                                    buttons[y][v - 1].setToolTipText("№" + products.get(y).getId() + " " + products.get(y).getName());
                                    buttons[y - 1][v - 1].setToolTipText("№" + products.get(y - 1).getId() + " " + products.get(y - 1).getName());
                                    buttons[y][v - 1].setIcon(products.get(y).getSmallImage());
                                    buttons[y - 1][v - 1].setIcon(products.get(y - 1).getSmallImage());
                                }

                        });
                        break;
                    case 2:
                        buttons[y][v].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Product upperProduct = new Product(products.get(y - 4).getName(), products.get(y - 4).getId(), products.get(y - 4).getSmallImage(), products.get(y - 4).getZoomedImage());
                                Product downProduct = new Product(products.get(y).getName(), products.get(y).getId(), products.get(y).getSmallImage(), products.get(y).getZoomedImage());

                                products.get(y - 4).setName(downProduct.getName());
                                products.get(y - 4).setSmallImage(downProduct.getSmallImage());
                                products.get(y - 4).setZoomedImage(downProduct.getZoomedImage());
                                products.get(y - 4).setDescription(downProduct.getDescription());

                                products.get(y).setName(upperProduct.getName());
                                products.get(y).setSmallImage(upperProduct.getSmallImage());
                                products.get(y).setZoomedImage(upperProduct.getZoomedImage());
                                products.get(y).setDescription(upperProduct.getDescription());

                                buttons[y][v - 2].setToolTipText("№" + products.get(y).getId() + " " + products.get(y).getName());
                                buttons[y - 4][v - 2].setToolTipText("№" + products.get(y - 4).getId() + " " + products.get(y - 4).getName());
                                buttons[y][v - 2].setIcon(products.get(y).getSmallImage());
                                buttons[y - 4][v - 2].setIcon(products.get(y - 4).getSmallImage());

                            }
                        });
                        break;
                    case 3:
                        buttons[y][v].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Product rightProduct = new Product(products.get(y + 1).getName(), products.get(y + 1).getId(), products.get(y + 1).getSmallImage(), products.get(y + 1).getZoomedImage());
                                Product leftProduct = new Product(products.get(y).getName(), products.get(y).getId(), products.get(y).getSmallImage(), products.get(y).getZoomedImage());

                                products.get(y + 1).setName(leftProduct.getName());
                                products.get(y + 1).setSmallImage(leftProduct.getSmallImage());
                                products.get(y + 1).setZoomedImage(leftProduct.getZoomedImage());
                                products.get(y + 1).setDescription(leftProduct.getDescription());

                                products.get(y).setName(rightProduct.getName());
                                products.get(y).setSmallImage(rightProduct.getSmallImage());
                                products.get(y).setZoomedImage(rightProduct.getZoomedImage());
                                products.get(y).setDescription(rightProduct.getDescription());

                                buttons[y][v - 3].setToolTipText("№" + products.get(y).getId() + " " + products.get(y).getName());
                                buttons[y + 1][v - 3].setToolTipText("№" + products.get(y + 1).getId() + " " + products.get(y + 1).getName());
                                buttons[y][v - 3].setIcon(products.get(y).getSmallImage());
                                buttons[y + 1][v - 3].setIcon(products.get(y + 1).getSmallImage());

                            }
                        });
                        break;
                    case 5:
                        buttons[y][v].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Product downProduct = new Product(products.get(y + 4).getName(), products.get(y + 4).getId(), products.get(y + 4).getSmallImage(), products.get(y + 4).getZoomedImage());
                                Product upperProduct = new Product(products.get(y).getName(), products.get(y).getId(), products.get(y).getSmallImage(), products.get(y).getZoomedImage());

                                products.get(y + 4).setName(upperProduct.getName());
                                products.get(y + 4).setSmallImage(upperProduct.getSmallImage());
                                products.get(y + 4).setZoomedImage(upperProduct.getZoomedImage());
                                products.get(y + 4).setDescription(upperProduct.getDescription());

                                products.get(y).setName(downProduct.getName());
                                products.get(y).setSmallImage(downProduct.getSmallImage());
                                products.get(y).setZoomedImage(downProduct.getZoomedImage());
                                products.get(y).setDescription(downProduct.getDescription());

                                buttons[y][v - 5].setToolTipText("№" + products.get(y).getId() + " " + products.get(y).getName());
                                buttons[y + 4][v - 5].setToolTipText("№" + products.get(y + 4).getId() + " " + products.get(y + 4).getName());
                                buttons[y][v - 5].setIcon(products.get(y).getSmallImage());
                                buttons[y + 4][v - 5].setIcon(products.get(y + 4).getSmallImage());
                            }
                        });
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void addActionListenersToUI(){

    }

    private JFrame frameWithInformationForIndex(int p){

        return null;
    }


}
