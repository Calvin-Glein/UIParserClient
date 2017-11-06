import javax.swing.*;

import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.util.ArrayList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UIParser {

	public ArrayList<ElementImported> elements = new ArrayList<ElementImported>();
	public JFrame frame;

	public UIParser() {
		JFrame frame = new JFrame("UIParser");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(new MigLayout("", "[][][][][][][]", "[][][][][][][]"));
						
						JLabel lblUiParser = new JLabel("UI Parser");
						lblUiParser.setFont(new Font("Tahoma", Font.PLAIN, 25));
						frame.getContentPane().add(lblUiParser, "cell 6 1,alignx center");
						
						JLabel label = new JLabel("1.");
						frame.getContentPane().add(label, "cell 3 2 2 1,alignx right");
						
						JLabel lblUseTheUi = new JLabel("Use the UI Designer Web client");
						frame.getContentPane().add(lblUseTheUi, "cell 6 2");
						
						JLabel label_1 = new JLabel("2.");
						frame.getContentPane().add(label_1, "cell 3 3 2 1,alignx right");
						
						JLabel lblDesignTheUi = new JLabel("Design the UI layout");
						frame.getContentPane().add(lblDesignTheUi, "cell 6 3");
						
						JLabel lblNewLabel = new JLabel("3.");
						frame.getContentPane().add(lblNewLabel, "cell 4 4,alignx right");
						
						JLabel lblExportdownloadTheXml = new JLabel("Export/Download the XML file");
						frame.getContentPane().add(lblExportdownloadTheXml, "cell 6 4");
						
								JButton btnNewButton = new JButton("Import XML");
								btnNewButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										openAndParse();
									}
								});
								frame.getContentPane().add(btnNewButton, "cell 6 6,alignx center");


		frame.setSize(261, 223);
		frame.setVisible(true);


	}

	public void initializeCanvas() {
		frame = new JFrame("UI Output");
		frame.getContentPane().setLayout(null);


		frame.setSize(1366, 768);
		frame.setVisible(true);
	}

	public void openAndParse() {
		
		try {
			File fXmlFile = new File(fileChooser());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("Element");

			System.out.println("----------------------------");

			//re init arraylist of elements

			elements = new ArrayList<ElementImported>();



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

		initializeCanvas();	
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

	public void parseElements() {
		for (int i = elements.size() - 1; i > 0; i--) {
			if (elements.get(i).getType().equals("label")) {
				JLabel test = new JLabel(elements.get(i).getText());
				test.setBounds(elements.get(i).getxCoordinate(), elements.get(i).getyCoordinate(),
						elements.get(i).getWidth(), elements.get(i).getHeight());
				Font newLabelFont;
				newLabelFont = new Font(test.getFont().getName(), test.getFont().getStyle(),
						elements.get(i).getFontSize());
				test.setFont(newLabelFont);

				test.setSize( test.getPreferredSize() );

				frame.getContentPane().add(test);
				frame.revalidate();
				frame.repaint();
				/*
				 * // init content += " \r\n    JLabel " + NumberToWords(i) + " = new JLabel(\""
				 * + elements.get(i).getText() + "\");\r\n"; // setbounds content += "\r\n    "
				 * + NumberToWords(i) + ".setBounds(" + elements.get(i).getxCoordinate() + ", "
				 * + elements.get(i).getyCoordinate() + "," + elements.get(i).getWidth() + ", "
				 * + elements.get(i).getHeight() + ");"; // setfont content +=
				 * "\r\n    newLabelFont=new Font(" + NumberToWords(i) + ".getFont().getName(),"
				 * + NumberToWords(i) + ".getFont().getStyle()," + elements.get(i).getFontSize()
				 * + ");"; content += "\r\n    " + NumberToWords(i) +
				 * ".setFont(newLabelFont); "; // add to frame content += "\r\n    frame.add(" +
				 * NumberToWords(i) + "); \r\n "
				 */;

			} else if (elements.get(i).getType().equals("textfield")) {
				JTextField test = new JTextField(elements.get(i).getText());
				test.setBounds(elements.get(i).getxCoordinate(), elements.get(i).getyCoordinate(),
						elements.get(i).getWidth(), elements.get(i).getHeight());
				Font newLabelFont;
				newLabelFont = new Font(test.getFont().getName(), test.getFont().getStyle(),
						elements.get(i).getFontSize());
				test.setFont(newLabelFont);
				test.setBorder(null);

				frame.getContentPane().add(test);
				frame.revalidate();
				frame.repaint();
				/*
				 * // init content += " \r\n    JTextField " + NumberToWords(i) +
				 * " = new JTextField(\"" + elements.get(i).getText() + "\");\r\n"; // setbounds
				 * content += "\r\n    " + NumberToWords(i) + ".setBounds(" +
				 * elements.get(i).getxCoordinate() + ", " + elements.get(i).getyCoordinate() +
				 * ", " + elements.get(i).getWidth() + ", " + elements.get(i).getHeight() +
				 * ");"; // setfont content += "\r\n    newLabelFont=new Font(" +
				 * NumberToWords(i) + ".getFont().getName()," + NumberToWords(i) +
				 * ".getFont().getStyle()," + elements.get(i).getFontSize() + ");"; content +=
				 * "\r\n    " + NumberToWords(i) + ".setFont(newLabelFont); "; // add to frame
				 * content += "\r\n    frame.add(" + NumberToWords(i) + "); \r\n ";
				 */

			} else if (elements.get(i).getType().equals("button")) {

//				JPanel component = new JPanel();
//
//				LayoutManager overlay = new OverlayLayout(component);

				JButton button = new JButton();
				button.setBounds(elements.get(i).getxCoordinate(), elements.get(i).getyCoordinate(),
						elements.get(i).getWidth(), elements.get(i).getHeight());

				JLabel label = new JLabel(elements.get(i).getText());
				label.setLayout(new BorderLayout());
//				label.add(button);

				label.setBounds(elements.get(i).getxCoordinate(), elements.get(i).getyCoordinate(),
						elements.get(i).getWidth(), elements.get(i).getHeight());
				Font newLabelFont;
				newLabelFont = new Font(label.getFont().getName(), label.getFont().getStyle(),
						elements.get(i).getFontSize());
				label.setFont(newLabelFont);
				Dimension dimension = new Dimension(label.getPreferredSize().width + 10, label.getPreferredSize().height);
				label.setSize(dimension);

//				component.add(label);
//				component.add(button);

				//test.setSize( test.getPreferredSize() );
//				test.setMargin(new Insets(0,0,0,0));
//				test.setBorder(null);
				if (button.getHeight() <= label.getHeight() || button.getWidth() <= label.getWidth()){
					label.setBorder(new EmptyBorder(0,10,0,0));//top,left,bottom,right
					frame.getContentPane().add(label);
					frame.getContentPane().add(button);
				}
				else{
					button.setText(label.getText());
					button.setBorder(null);
					button.setFont(newLabelFont);
					frame.getContentPane().add(button);
				}
				frame.revalidate();
				frame.repaint();
				// init
				/*
				 * content += " \r\n    JButton " + NumberToWords(i) + " = new JButton(\"" +
				 * elements.get(i).getText() + "\");\r\n"; // setbounds content += "\r\n    " +
				 * NumberToWords(i) + ".setBounds(" + elements.get(i).getxCoordinate() + ", " +
				 * elements.get(i).getyCoordinate() + ", " + elements.get(i).getWidth() + ", " +
				 * elements.get(i).getHeight() + ");"; // setfont content +=
				 * "\r\n    newLabelFont=new Font(" + NumberToWords(i) + ".getFont().getName(),"
				 * + NumberToWords(i) + ".getFont().getStyle()," + elements.get(i).getFontSize()
				 * + ");"; content += "\r\n    " + NumberToWords(i) +
				 * ".setFont(newLabelFont); "; // add to frame content += "\r\n    frame.add(" +
				 * NumberToWords(i) + "); \r\n ";
				 */
			}
		}
	}

}
