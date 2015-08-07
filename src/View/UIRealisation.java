package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mac on 08.06.15.
 */
public class UIRealisation implements UI {
    private JFrame mainFrame;
    private JButton[][] buttons;
    private JPanel mainPanel;
    private JPanel[] lines;
    private JPanel[] cells;

    @Override
    public void init() {
        mainFrame = new JFrame();
        buttons = new JButton[16][7];
        lines = new JPanel[4];
        cells = new JPanel[16];
        mainPanel = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < lines.length; i++){
            lines[i] = new JPanel();
            lines[i].setLayout(new BoxLayout(lines[i], BoxLayout.X_AXIS));
            mainPanel.add(lines[i]);
        }

        for (int i = 0; i < cells.length; i++){
            cells[i] = new JPanel();
            cells[i].setLayout(new GridBagLayout());
            if (i < 4 && i >= 0){
                lines[0].add(cells[i]);
            } else if (i < 8 && i >= 4){
                lines[1].add(cells[i]);
            } else if (i < 12 && i >= 8){
                lines[2].add(cells[i]);
            } else if (i < 16 && i >= 12){
                lines[3].add(cells[i]);
            }
        }



        for (int i = 0; i < 16; i++){
            buttons[i] = new JButton[7];
            for (int b = 0; b < 7; b++){
                buttons[i][b] = new JButton();
                switch (b){
                    case 0:
                        cells[i].add(buttons[i][b], new GridBagConstraints(2, 3, 1, 4, 3, 3, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                        break;
                    case 1:
                        cells[i].add(new JPanel(), new GridBagConstraints(1, 2, 1, 1, 0, 2, GridBagConstraints.ABOVE_BASELINE, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
                        cells[i].add(new JPanel(), new GridBagConstraints(0, 2, 1, 0, 0, 0, GridBagConstraints.ABOVE_BASELINE, GridBagConstraints.NONE, new Insets(0, 1, 0, 0), 0, 0));
                        cells[i].add(buttons[i][b], new GridBagConstraints(1, 3, 1, 1, 0, 3, GridBagConstraints.ABOVE_BASELINE, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
                        break;
                    case 2:
//                        cells[i].add(new JPanel(), new GridBagConstraints(1, 0, 2, 1, 2, 1, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, new Insets(0, 4, 0, 0), 0, 0));
                        cells[i].add(buttons[i][b], new GridBagConstraints(2, 0, 1, 3, 3, 3, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 50, 0, 0), 0, 0));
                        break;
                    case 3:
                        cells[i].add(buttons[i][b], new GridBagConstraints(4, 2, 1, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                        break;
                    case 4:
                        cells[i].add(buttons[i][b], new GridBagConstraints(4, 4, 1, 2, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                        break;
                    case 5:
                        cells[i].add(buttons[i][b], new GridBagConstraints(3, 4, 1, 2, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                        break;
                    case 6:
                        cells[i].add(buttons[i][b], new GridBagConstraints(2, 4, 1, 2, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                        break;

                }
            }
        }



        mainFrame.add(mainPanel);

        mainFrame.setSize(700, 700);
//        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

//        mainPanel.setLayout(new );



    }

    public static void main(String[] args) {
        UIRealisation uiRealisation = new UIRealisation();
        uiRealisation.init();
    }

}
