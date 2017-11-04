import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;
public class UIOutput extends JFrame {

  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("UI Output");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);Font newLabelFont;
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);;
    frame.setVisible(true);
  }
}