package View;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import javax.swing.border.BevelBorder;
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

    private static UIRealisation instance;

    private UIRealisation(){}

    public static synchronized UIRealisation getInstance(){
        if (instance == null){
            instance = new UIRealisation();
        }
        return instance;
    }

    @Override
    public JFrame init() {
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
            cells[i].setBorder(new BevelBorder(BevelBorder.RAISED));
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
            downPanels[i].setLayout(new GridBagLayout());
//            downPanels[i].add(new JPanel());
        }

        for (int i = 0; i < 16; i++){
            buttons[i] = new JButton[7];
            for (int b = 0; b < 7; b++){
                buttons[i][b] = new JButton();
                switch (b){
                    case 0:
                        buttons[i][b].setIcon(new ImageIcon("/Users/mac/Desktop/MAIN/ПРОГРАММИРОВАНИЕ/progschool/java2/PROJECTS/Market/src/View/img/kapusta.jpg"));
                        JPanel lPanel = new JPanel();
                        lPanel.setLayout(new GridBagLayout());
                        lPanel.add(buttons[i][b], new GridBagConstraints(0, 1, 2, 2, 4, 3, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                        lPanel.add(new JPanel(), new GridBagConstraints(0, 2, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                        cells[i].add(lPanel, BorderLayout.CENTER);
                        break;
                    case 1:
                        if (i == 0 || i == 4 || i == 8 || i == 12) buttons[i][b].setEnabled(false);
                        buttons[i][b].setText("←");
                        JPanel sPanel = new JPanel();
                        sPanel.setLayout(new BoxLayout(sPanel, BoxLayout.Y_AXIS));
                        sPanel.add(new JPanel());
                        sPanel.add(buttons[i][b]);
                        sPanel.add(new JPanel());
                        cells[i].add(sPanel, BorderLayout.WEST);
                        break;
                    case 2:
                        if (i >= 0 && i <= 3) buttons[i][b].setEnabled(false);
                        buttons[i][b].setText("↑");
                        JPanel rPanel = new JPanel();
                        rPanel.setLayout(new BoxLayout(rPanel, BoxLayout.X_AXIS));
                        rPanel.add(new JPanel());
                        rPanel.add(buttons[i][b]);
                        rPanel.add(new JPanel());
                        cells[i].add(rPanel, BorderLayout.NORTH);
                        break;
                    case 3:
                        if (i == 3 || i == 7 || i == 11 || i == 15) buttons[i][b].setEnabled(false);
                        buttons[i][b].setText("→");
                        JPanel yPanel = new JPanel();
                        yPanel.setLayout(new BoxLayout(yPanel, BoxLayout.Y_AXIS));
                        yPanel.add(new JPanel());
                        yPanel.add(buttons[i][b]);
                        yPanel.add(new JPanel());
                        cells[i].add(yPanel, BorderLayout.EAST);
                        break;
                    case 4:
                        downPanels[i].add(buttons[i][b], new GridBagConstraints(0, 1, 0, 0, 1, 1, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                        cells[i].add(downPanels[i], BorderLayout.SOUTH);
                        buttons[i][b].setText("...");
                        break;
                    case 5:
                        if (i > 11 && i < 16) buttons[i][b].setEnabled(false);
                        buttons[i][b].setText("↓");
                        downPanels[i].add(buttons[i][b], new GridBagConstraints(1, 1, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                        break;
                    case 6:
                        downPanels[i].add(buttons[i][b], new GridBagConstraints(2, 1, 0, 0, 1, 1, GridBagConstraints.LINE_END, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                        buttons[i][b].setText("X");
                        break;
                }
            }
        }

        mainFrame.add(mainPanel);
        mainFrame.setSize(950, 580);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        return mainFrame;
    }

    public static void main(String[] args) {
        UIRealisation uiRealisation = new UIRealisation();
        uiRealisation.init();
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public void setButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }

    public JPanel[] getCells() {
        return cells;
    }

    public void setCells(JPanel[] cells) {
        this.cells = cells;
    }

    public JPanel[] getDownPanels() {
        return downPanels;
    }

    public void setDownPanels(JPanel[] downPanels) {
        this.downPanels = downPanels;
    }

    public JPanel[] getLines() {
        return lines;
    }

    public void setLines(JPanel[] lines) {
        this.lines = lines;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
