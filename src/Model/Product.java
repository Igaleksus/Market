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

    public static final String авокадо = "Авока́до, или Персе́я америка́нская (лат. Persēa americāna) — вечнозелёное плодовое растение; " +
            "вид рода Персея семейства Лавровые (Lauraceae). Типовой вид рода; важная плодовая культура.";
    public static final String актимель = "Actimel® — это пробиотический кисломолочный продукт. В отличие от других кисломолочных продуктов, он содержит " +
            "особые полезные лактобактерии — L.Casei Imunitass. Также в нем есть важные для иммунитета витамины В6 и Д3.";
    public static final String апельсин = "Апельси́н (нидерл. appelsien, sinaasappel, лат. Cītrus sinēnsis) — плодовое дерево; вид рода Цитрус семейства Рутовые; а также плод этого дерева.";
    public static final String артишок = "Артишо́к (лат. Cȳnara) — род растений семейства Астровые (Asteraceae)";
    public static final String брокколи = "Бро́кколи, или Спа́ржевая капу́ста (лат. Brassica oleracea или Brassica sylvestris) — однолетнее овощное растение семейства Капустные, разновидность капусты огородной. Ближайший родственник и генетический предшественник цветной капусты[1]";
    public static final String гранат = "Грана́тина (лат. balaūsta) — плод, характерен для представителей рода гранат (Punica).\n" +
            "\n" +
            "Русское название происходит от лат. granatum, далее из granum «зерно», от праиндоевр. *gre-no- «зерно». Научное латинское название — от лат. balaustĭum";
    public static final String грибы = "Грибы́ (лат. Fungi или Mycota) — царство живой природы, объединяющее эукариотические организмы, сочетающие в себе некоторые признаки как растений, так и животных. ";
    public static final String груши = "Гру́ша (лат. Pýrus) — род плодовых и декоративных деревьев и кустарников семейства Розовые (Rosaceae).";
    public static final String икра = "Икра́ — масса из яиц самок рыб, земноводных, моллюсков, иглокожих[1]. Неоплодотворённую икру используют как продукт питания, употребляя её как в сыром, " +
            "так и в приготовленном виде.";
    public static final String имбирь = "Имби́рь (лат. Zíngiber) — род многолетних травянистых растений из семейства Имбирные (Zingiberaceae).";
    public static final String йогурт = "Йо́гу́рт[1] (от тур. yoğurt) — кисломолочный продукт с повышенным содержанием обезжиренных веществ молока, изготовляемый путём сквашивания протосимбиотической смесью " +
            "чистых культур Lactobacillus bulgaricus (болгарская палочка) и Streptococcus thermophilus (термофильный стрептококк)";
    public static final String капуста = "Капу́ста огоро́дная[1]:460 (лат. Brássica olerácea) — двулетнее растение, сельскохозяйственная культура; вид рода Капуста (лат. Brassica) семейства Капустные (Крестоцветные).";
    public static final String кефир = "Кефи́р — кисломолочный напиток, получаемый из цельного или обезжиренного коровьего молока путём кисломолочного и спиртового брожения";
    public static final String киви = "Ки́ви — название плодов культурных сортов растений, принадлежащих к роду Актини́дия, виду Актини́дия кита́йская (лат. Actinidia chinensis) или Актинидия деликатесная (лат. Actinidia deliciosa)." +
            " Сами растения представляют собой крупные древовидные лианы родом из Китая, поэтому киви иногда называют «китайским крыжовником».";
    public static final String кокаКола = "Coca-Cola («Кока-кола») — безалкогольный газированный напиток, производимый компанией «The Coca-Cola Company».\n" +
            "\n" +
            "«Кока-Кола» была признана самым дорогим брендом в мире в 2005—2015 годах в рейтинге международного исследовательского агентства Interbrand";
    public static final String колбаса = "Колбаса́ — пищевой продукт, вид колбасных изделий, представляющий собой мясной фарш в продолговатой оболочке. Может содержать один или несколько видов мяса, " +
            "содержать различные наполнители, подвергаться температурной обработке (варке, иногда многократной; обжарке) или ферментации[1].";
    public static final String молоко = "Молоко́ — питательная жидкость, вырабатываемая молочными железами самок млекопитающих. Естественное предназначение молока — " +
            "вскармливание детёнышей (в том числе и у человека), которые ещё не способны переваривать другую пищу.";
    public static final String фрутоНяня = "Детский сок, 100% натуральный, без сахара, гипоаллергенный.";



    private JButton currentButton;

    boolean isSelected;

    public Product(String name, int id, ImageIcon smallImage, ImageIcon zoomedImage) {
        productsCount++;
        this.id = id;
        this.name = name;
        this.smallImage = smallImage;
        this.zoomedImage = zoomedImage;
        settingDescriptionFromTitle(name);

    }

    public Product(String name, int id, ImageIcon smallImage, ImageIcon zoomedImage, String description) {
        productsCount++;
        this.id = id;
        this.name = name;
        this.smallImage = smallImage;
        this.zoomedImage = zoomedImage;
        this.description = description;
    }


    public Product(String name, int id) {
        productsCount++;
        this.id = id;
        this.name = name;
        settingDescriptionFromTitle(name);
    }

    public Product(String name) {
        productsCount++;
        this.name = name;
        settingDescriptionFromTitle(name);
    }

    private void settingDescriptionFromTitle(String name){
        switch (name) {
            case "авокадо":
                description = авокадо;
                break;
            case "актимель":
                description = актимель;
                break;
            case "апельсин":
                description = апельсин;
                break;
            case "артишок":
                description = артишок;
                break;
            case "брокколи":
                description = брокколи;
                break;
            case "гранат":
                description = гранат;
                break;
            case "грибы":
                description = грибы;
                break;
            case "груши":
                description = груши;
                break;
            case "икра":
                description = икра;
                break;
            case "имбирь":
                description = имбирь;
                break;
            case "йогурт":
                description = йогурт;
                break;
            case "капуста":
                description = капуста;
                break;
            case "кефир":
                description = кефир;
                break;
            case "киви":
                description = киви;
                break;
            case "кока-кола":
                description = кокаКола;
                break;
            case "колбаса":
                description = колбаса;
                break;
            case "молоко":
                description = молоко;
                break;
            case "фрутоняня":
                description = фрутоНяня;
                break;
        }
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

    public JButton getCurrentButton() {
        return currentButton;
    }

    public void setCurrentButton(JButton currentButton) {
        this.currentButton = currentButton;
    }
}

interface Descriptions {

}
