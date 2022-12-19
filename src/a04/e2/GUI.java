package a04.e2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {

    private static final int SIZE = 4;

    public GUI() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*SIZE, 100*SIZE);
        

        Logic logic = new LogicImpl(SIZE);

        JPanel panel = new JPanel(new GridLayout(SIZE,SIZE));
        this.getContentPane().add(BorderLayout.CENTER,panel);

        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                final JButton jb = new JButton();

                int y = i;
                int x = j;
                ActionListener al = (e)->{
                    final JButton bt = (JButton)e.getSource();
                    if (logic.isValid(x, y)) {
                        bt.setEnabled(false);
                    }
                    if (logic.isOver()) {
                        System.exit(0);
                    }
                };
                
                jb.addActionListener(al);
                panel.add(jb);
            }
        }

        this.setVisible(true);
    }
}
