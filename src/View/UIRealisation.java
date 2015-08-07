package View;

import javax.swing.*;
import java.awt.*;
import java.awt.peer.LabelPeer;

/**
 * Created by mac on 08.06.15.
 */
public class UIRealisation implements UI {
    private JFrame mainFrame;
    private JButton[][] buttons;
    private JPanel mainPanel;
    private JPanel[] lines;
    private JPanel[] cells;
    private JPanel[] downPanels;
    private JPanel[] centerPanels;

    @Override
    public void init() {
        mainFrame = new JFrame();
        buttons = new JButton[16][7];
        lines = new JPanel[4];
        cells = new JPanel[16];
        mainPanel = new JPanel();
        downPanels = new JPanel[16];
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < lines.length; i++){
            lines[i] = new JPanel();
            lines[i].setLayout(new BoxLayout(lines[i], BoxLayout.X_AXIS));
            mainPanel.add(lines[i]);
        }

        for (int i = 0; i < cells.length; i++){
            cells[i] = new JPanel();
            cells[i].setLayout(new BorderLayout());
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

        for (int i = 0; i < downPanels.length; i++){
            downPanels[i] = new JPanel();
            downPanels[i].setLayout(new BoxLayout(downPanels[i], BoxLayout.X_AXIS));
//            downPanels[i].add(new JPanel());
        }

        for (int i = 0; i < 16; i++){
            buttons[i] = new JButton[7];
            for (int b = 0; b < 7; b++){
                buttons[i][b] = new JButton();
                switch (b){
                    case 0:
                        JPanel lPanel = new JPanel();
                        lPanel.setLayout(new GridBagLayout());
                        lPanel.add(new JPanel(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                        lPanel.add(buttons[i][b], new GridBagConstraints(0, 1, 1, 1, 1, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                        lPanel.add(new JPanel(), new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                        cells[i].add(lPanel, BorderLayout.CENTER);
                        break;
                    case 1:
                        JPanel sPanel = new JPanel();
                        sPanel.setLayout(new BoxLayout(sPanel, BoxLayout.Y_AXIS));
                        sPanel.add(new JPanel());
                        sPanel.add(buttons[i][b]);
                        sPanel.add(new JPanel());
                        cells[i].add(sPanel, BorderLayout.WEST);
                        break;
                    case 2:
                        JPanel rPanel = new JPanel();
                        rPanel.setLayout(new BoxLayout(rPanel, BoxLayout.X_AXIS));
                        rPanel.add(new JPanel());
                        rPanel.add(buttons[i][b]);
                        rPanel.add(new JPanel());
                        cells[i].add(rPanel, BorderLayout.NORTH);
                        break;
                    case 3:
                        JPanel yPanel = new JPanel();
                        yPanel.setLayout(new BoxLayout(yPanel, BoxLayout.Y_AXIS));
                        yPanel.add(new JPanel());
                        yPanel.add(buttons[i][b]);
                        yPanel.add(new JPanel());
                        cells[i].add(yPanel, BorderLayout.EAST);
                        break;
                    case 4:
                        downPanels[i].add(buttons[i][b]);
                        cells[i].add(downPanels[i], BorderLayout.SOUTH);
                        break;
                    case 5:
                        downPanels[i].add(buttons[i][b]);
                        break;
                    case 6:
                        downPanels[i].add(buttons[i][b]);
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
