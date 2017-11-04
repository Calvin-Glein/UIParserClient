import javax.xml.parsers.DocumentBuilderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class Main extends JFrame{

	public static ArrayList<ElementImported> elements = new ArrayList<ElementImported>();
	public static JFrame frame;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		JFrame.setDefaultLookAndFeelDecorated(true);
	    frame = new JFrame("UI Output");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(null);
	    
	    
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);;
	    frame.setVisible(true);
		
		try {

			File fXmlFile = new File(fileChooser());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("Element");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					elements.add(new ElementImported(eElement.getElementsByTagName("Type").item(0).getTextContent(),
							eElement.getElementsByTagName("Text").item(0).getTextContent(),
							(int) Math.round(Float
									.parseFloat(eElement.getElementsByTagName("XCoordinate").item(0).getTextContent())),
							(int) Math.round(Float
									.parseFloat(eElement.getElementsByTagName("YCoordinate").item(0).getTextContent())),
							Integer.parseInt(eElement.getElementsByTagName("Width").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("Height").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("Layer").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("FontSize").item(0).getTextContent())));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

parseElements();

		
	
		
	}
	

	

	public static String fileChooser() {
		JFileChooser fileChooser;

		fileChooser = new JFileChooser();

		File path;

		String type;
		int approve = fileChooser.showOpenDialog(null);
		if (approve == JFileChooser.APPROVE_OPTION) {
			System.out.println("getCurrentDirectory(): " + fileChooser.getCurrentDirectory());
			System.out.println("getSelectedFile() : " + fileChooser.getSelectedFile());
		}

		path = fileChooser.getSelectedFile();
		type = path.toString();
		return fileChooser.getSelectedFile().toString();
	}
	
	public static void parseElements() {
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getType().equals("label")) {
				JLabel test = new JLabel(elements.get(i).getText());
				test.setBounds(elements.get(i).getxCoordinate(), elements.get(i).getyCoordinate(), elements.get(i).getWidth(), elements.get(i).getHeight());
				Font newLabelFont; 
			    newLabelFont=new Font(test.getFont().getName(),test.getFont().getStyle(),elements.get(i).getFontSize());
			    test.setFont(newLabelFont); 
				frame.add(test);
				frame.revalidate();
				frame.repaint();
				/*// init
				content += " \r\n    JLabel " + NumberToWords(i) + " = new JLabel(\"" + elements.get(i).getText()
						+ "\");\r\n";
				// setbounds
				content += "\r\n    " + NumberToWords(i) + ".setBounds(" + elements.get(i).getxCoordinate() + ", "
						+ elements.get(i).getyCoordinate() + "," + elements.get(i).getWidth() + ", "
						+ elements.get(i).getHeight() + ");";
				// setfont
				content += "\r\n    newLabelFont=new Font(" + NumberToWords(i) + ".getFont().getName(),"
						+ NumberToWords(i) + ".getFont().getStyle()," + elements.get(i).getFontSize() + ");";
				content += "\r\n    " + NumberToWords(i) + ".setFont(newLabelFont); ";
				// add to frame
				content += "\r\n    frame.add(" + NumberToWords(i) + "); \r\n "*/;

			} else if (elements.get(i).getType().equals("textfield")) {
				JTextField test = new JTextField(elements.get(i).getText());
				test.setBounds(elements.get(i).getxCoordinate(), elements.get(i).getyCoordinate(), elements.get(i).getWidth(), elements.get(i).getHeight());
				Font newLabelFont; 
			    newLabelFont=new Font(test.getFont().getName(),test.getFont().getStyle(),elements.get(i).getFontSize());
			    test.setFont(newLabelFont); 
				frame.add(test);
				frame.revalidate();
				frame.repaint();
				/*// init
				content += " \r\n    JTextField " + NumberToWords(i) + " = new JTextField(\""
						+ elements.get(i).getText() + "\");\r\n";
				// setbounds
				content += "\r\n    " + NumberToWords(i) + ".setBounds(" + elements.get(i).getxCoordinate() + ", "
						+ elements.get(i).getyCoordinate() + ", " + elements.get(i).getWidth() + ", "
						+ elements.get(i).getHeight() + ");";
				// setfont
				content += "\r\n    newLabelFont=new Font(" + NumberToWords(i) + ".getFont().getName(),"
						+ NumberToWords(i) + ".getFont().getStyle()," + elements.get(i).getFontSize() + ");";
				content += "\r\n    " + NumberToWords(i) + ".setFont(newLabelFont); ";
				// add to frame
				content += "\r\n    frame.add(" + NumberToWords(i) + "); \r\n ";*/

			} else if (elements.get(i).getType().equals("button")) {
				
				JButton test = new JButton(elements.get(i).getText());
				test.setBounds(elements.get(i).getxCoordinate(), elements.get(i).getyCoordinate(), elements.get(i).getWidth(), elements.get(i).getHeight());
				Font newLabelFont; 
			    newLabelFont=new Font(test.getFont().getName(),test.getFont().getStyle(),elements.get(i).getFontSize());
			    test.setFont(newLabelFont); 
				frame.add(test);
				frame.revalidate();
				frame.repaint();
				// init
				/*content += " \r\n    JButton " + NumberToWords(i) + " = new JButton(\"" + elements.get(i).getText()
						+ "\");\r\n";
				// setbounds
				content += "\r\n    " + NumberToWords(i) + ".setBounds(" + elements.get(i).getxCoordinate() + ", "
						+ elements.get(i).getyCoordinate() + ", " + elements.get(i).getWidth() + ", "
						+ elements.get(i).getHeight() + ");";
				// setfont
				content += "\r\n    newLabelFont=new Font(" + NumberToWords(i) + ".getFont().getName(),"
						+ NumberToWords(i) + ".getFont().getStyle()," + elements.get(i).getFontSize() + ");";
				content += "\r\n    " + NumberToWords(i) + ".setFont(newLabelFont); ";
				// add to frame
				content += "\r\n    frame.add(" + NumberToWords(i) + "); \r\n ";
*/
			}
		}
	}

	public static void WriteToFile() {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String header = "import javax.swing.JFrame;\r\n" + "import javax.swing.JLabel;\r\n"
					+ "import javax.swing.JButton;\r\n" + "import javax.swing.JTextField;\r\n" + "\r\n"
					+ "import java.awt.Font;\r\n" + "public class UIOutput extends JFrame {\r\n" + "\r\n"
					+ "  public static void main(String[] args) {\r\n"
					+ "    JFrame.setDefaultLookAndFeelDecorated(true);\r\n"
					+ "    JFrame frame = new JFrame(\"UI Output\");\r\n"
					+ "    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\r\n" + "    frame.setLayout(null);"
					+ "Font newLabelFont;";

			String content = "";

			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).getType().equals("label")) {
					// init
					content += " \r\n    JLabel " + NumberToWords(i) + " = new JLabel(\"" + elements.get(i).getText()
							+ "\");\r\n";
					// setbounds
					content += "\r\n    " + NumberToWords(i) + ".setBounds(" + elements.get(i).getxCoordinate() + ", "
							+ elements.get(i).getyCoordinate() + "," + elements.get(i).getWidth() + ", "
							+ elements.get(i).getHeight() + ");";
					// setfont
					content += "\r\n    newLabelFont=new Font(" + NumberToWords(i) + ".getFont().getName(),"
							+ NumberToWords(i) + ".getFont().getStyle()," + elements.get(i).getFontSize() + ");";
					content += "\r\n    " + NumberToWords(i) + ".setFont(newLabelFont); ";
					// add to frame
					content += "\r\n    frame.add(" + NumberToWords(i) + "); \r\n ";

				} else if (elements.get(i).getType().equals("textfield")) {
					// init
					content += " \r\n    JTextField " + NumberToWords(i) + " = new JTextField(\""
							+ elements.get(i).getText() + "\");\r\n";
					// setbounds
					content += "\r\n    " + NumberToWords(i) + ".setBounds(" + elements.get(i).getxCoordinate() + ", "
							+ elements.get(i).getyCoordinate() + ", " + elements.get(i).getWidth() + ", "
							+ elements.get(i).getHeight() + ");";
					// setfont
					content += "\r\n    newLabelFont=new Font(" + NumberToWords(i) + ".getFont().getName(),"
							+ NumberToWords(i) + ".getFont().getStyle()," + elements.get(i).getFontSize() + ");";
					content += "\r\n    " + NumberToWords(i) + ".setFont(newLabelFont); ";
					// add to frame
					content += "\r\n    frame.add(" + NumberToWords(i) + "); \r\n ";

				} else if (elements.get(i).getType().equals("button")) {
					// init
					content += " \r\n    JButton " + NumberToWords(i) + " = new JButton(\"" + elements.get(i).getText()
							+ "\");\r\n";
					// setbounds
					content += "\r\n    " + NumberToWords(i) + ".setBounds(" + elements.get(i).getxCoordinate() + ", "
							+ elements.get(i).getyCoordinate() + ", " + elements.get(i).getWidth() + ", "
							+ elements.get(i).getHeight() + ");";
					// setfont
					content += "\r\n    newLabelFont=new Font(" + NumberToWords(i) + ".getFont().getName(),"
							+ NumberToWords(i) + ".getFont().getStyle()," + elements.get(i).getFontSize() + ");";
					content += "\r\n    " + NumberToWords(i) + ".setFont(newLabelFont); ";
					// add to frame
					content += "\r\n    frame.add(" + NumberToWords(i) + "); \r\n ";

				}
			}
			content += "\r\n    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);"
					+ ";\r\n    frame.setVisible(true);\r\n";
			content += "  }\r\n" + "}";

			fw = new FileWriter(new File("C:\\School\\Eclipse EE\\CMPILERUIParser\\src", "‪UIOutput.java"));
			bw = new BufferedWriter(fw);
			bw.write(header + content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

	static String unitsMap[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	static String tensMap[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };

	public static String NumberToWords(int number) {
		if (number == 0)
			return "zero";

		if (number < 0)
			return "minus " + NumberToWords(Math.abs(number));

		String words = "";

		if ((number / 1000000000) > 0) {
			words += NumberToWords(number / 1000000000) + " billion ";
			number %= 1000000000;
		}

		if ((number / 1000000) > 0) {
			words += NumberToWords(number / 1000000) + " million ";
			number %= 1000000;
		}

		if ((number / 1000) > 0) {
			words += NumberToWords(number / 1000) + " thousand ";
			number %= 1000;
		}

		if ((number / 100) > 0) {
			words += NumberToWords(number / 100) + " hundred ";
			number %= 100;
		}

		if (number > 0) {
			if (number < 20)
				words += unitsMap[number];
			else {
				words += tensMap[number / 10];
				if ((number % 10) > 0)
					words += "-" + unitsMap[number % 10];
			}
		}

		return words;
	}
}
