package View;

import Model.Product;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mac on 09.08.15.
 */
public class DescriptionPanel implements DescriptionPanelInterface {
    JFrame frame;
    JLabel title;
    JTextArea description;
    JLabel bigIcon;
    JPanel mainPanel;
    private static final String detailedInformation = "Подробная информация";

    @Override
    public JFrame init(int index, Product product) {
        frame = new JFrame(detailedInformation);
        mainPanel = new JPanel();
        title = new JLabel(product.getName());
        bigIcon = new JLabel(product.getZoomedImage());
        description = new JTextArea(product.getDescription());

        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        bigIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        description.setAlignmentX(Component.CENTER_ALIGNMENT);
        description.setMargin(new Insets(5, 10, 5, 10));
        description.setLineWrap(true);
        description.setEditable(false);
        description.setWrapStyleWord(true);
        description.setOpaque(false);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(title);
        mainPanel.add(bigIcon);
        mainPanel.add(description);

        frame.add(mainPanel, BorderLayout.NORTH);
        frame.setResizable(false);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
//        frame.pack();
        frame.setVisible(true);




        return null;
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public void setIcon(ImageIcon imageIcon) {

    }
}
