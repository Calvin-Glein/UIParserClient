import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class NoLayoutTest extends JFrame {

  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("UI Output");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null); 
    JLabel zero = new JLabel("Label");

    zero.setBounds(236, 217,200, 20);
    frame.add(zero); 
  
    JLabel one = new JLabel("Label2");

    one.setBounds(235, 217,210, 21);
    frame.add(one); 
  
    JTextField two = new JTextField("field");

    two.setBounds(255, 304, 300, 30);
    frame.add(two); 
  
    JButton three = new JButton("field");

    three.setBounds(0, 654, 350, 35);
    frame.add(three); 
 
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);;
    frame.setVisible(true);
  }
}