package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aleksandrlihovidov on 07.08.15.
 */
public class Cell extends JPanel {

    public Cell create(){
        setLayout(new BorderLayout());

        JPanel pe = new JPanel();
        pe.add(new JButton(">"));
        add(pe, BorderLayout.EAST);

        JPanel pn = new JPanel();
        pn.add(new JButton("|"));
        add(pn, BorderLayout.NORTH);

        JPanel pw = new JPanel();
        pw.add(new JButton("<"));
        add(pw, BorderLayout.WEST);

        JPanel ps = new JPanel();
        ps.add(new JButton("X"));
        add(ps, BorderLayout.SOUTH);
        ps.add(new JButton("|"));
        add(ps, BorderLayout.SOUTH);
        ps.add(new JButton("O"));
        add(ps, BorderLayout.SOUTH);

        add(new JButton("Fruit"), BorderLayout.CENTER);

        return this;
    }
}
