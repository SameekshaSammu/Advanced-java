/*
 4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is pressed by implementing the event handling mechanism with addActionListener( ).
 */
package lab4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonDemo extends JFrame implements ActionListener {

    JButton btnClock, btnHourglass;
    JLabel messageLabel;

    public ImageButtonDemo() {

        setTitle("Image Button Program");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ✅ Label to display message
        messageLabel = new JLabel("Click any image button");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(messageLabel);

        // ✅ Load images
        ImageIcon clockIcon = new ImageIcon("clock.png");
        ImageIcon hourglassIcon = new ImageIcon("hourglass.png");

        // ✅ Create buttons with images
        btnClock = new JButton(clockIcon);
        btnHourglass = new JButton(hourglassIcon);

        // ✅ Add action listener
        btnClock.addActionListener(this);
        btnHourglass.addActionListener(this);

        // ✅ Add buttons to frame
        add(btnClock);
        add(btnHourglass);

        setVisible(true);
    }

    // ✅ Event Handling
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnClock) {
            messageLabel.setText("You have pressed Digital Clock!");
        } else if (e.getSource() == btnHourglass) {
            messageLabel.setText("You have pressed Hour Glass!");
        }
    }

    public static void main(String[] args) {
        new ImageButtonDemo();
    }
}