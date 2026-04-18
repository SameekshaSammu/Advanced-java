/*
 5d. Develop a Swing program in Java to create a Tabbed Pan of Cyan, Magenta and Yellow and display the concerned color whenever the specific tab is selected in the Pan
 */
package lab5;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class TabbedColorDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Tabbed Colors");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ✅ Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // ✅ Panels with colors
        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);

        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);

        // ✅ Add tabs
        tabbedPane.addTab("Cyan", cyanPanel);
        tabbedPane.addTab("Magenta", magentaPanel);
        tabbedPane.addTab("Yellow", yellowPanel);

        // ✅ Event handling (tab selection)
        tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                int index = tabbedPane.getSelectedIndex();
                String title = tabbedPane.getTitleAt(index);

                System.out.println("Selected Tab: " + title);
            }
        });

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}