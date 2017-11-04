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
    JLabel zero = new JLabel("Label");

    zero.setBounds(236, 217,200, 20);
    newLabelFont=new Font(zero.getFont().getName(),zero.getFont().getStyle(),20);
    zero.setFont(newLabelFont); 
    frame.add(zero); 
  
    JLabel one = new JLabel("Label2");

    one.setBounds(235, 217,210, 21);
    newLabelFont=new Font(one.getFont().getName(),one.getFont().getStyle(),21);
    one.setFont(newLabelFont); 
    frame.add(one); 
  
    JTextField two = new JTextField("field");

    two.setBounds(255, 304, 300, 30);
    newLabelFont=new Font(two.getFont().getName(),two.getFont().getStyle(),30);
    two.setFont(newLabelFont); 
    frame.add(two); 
  
    JButton three = new JButton("field");

    three.setBounds(0, 654, 350, 35);
    newLabelFont=new Font(three.getFont().getName(),three.getFont().getStyle(),35);
    three.setFont(newLabelFont); 
    frame.add(three); 
 
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);;
    frame.setVisible(true);
  }
}