package View;

import Model.Product;

import javax.swing.*;

/**
 * Created by mac on 09.08.15.
 */
public interface DescriptionPanelInterface {
    public JFrame init(int index, Product product);
    public void setTitle(String title);
    public void setDescription(String description);
    public void setIcon(ImageIcon imageIcon);
}
