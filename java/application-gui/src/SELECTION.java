/* Screen where users can enter their boarding location, destination and PAX
 * Based on boarding time input, the screen will display the estimated time of arrival
 * Things involved in independent learning:
 * 	1. Formatted JTextField
 * 		JFormattedTextField noPassenger = new JFormattedTextField();
 * 		- allow only numbers to be typed
 *  2. MaskFormatter
 *  	MaskFormatter mf = new MaskFormatter("##:##");
 *  	- set placeholder text in text field
 *  3. Custom JComboBox
 *  	- allow JComboBox to fit in with the background
 *  4. setOpaque
 *  	LocationComboBox.setOpaque(false);
 *  	- toggle object transparency
 *  	- for designing purposes and to customize JComboBox
 *  Coded by Michelle
 *  Aided by Xiwei to customise JComboBox and fix issues related to available time of boarding not showing up properly
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.Component;
public class SELECTION implements ActionListener {
	
	Font TitleFont = new Font("Helveticish",Font.BOLD,30);
	Font SubTitleFont= new Font("Glacial Indifference", Font.PLAIN,16);
	Font BodyTextFont = new Font ("Argrandir Medium", Font.PLAIN,16);
	
	Color darkGray = new Color(29,27,30);
	Color lightGrey = new Color (113,114,115);
	Color gold = new Color (225,195,64);
	Color white = new Color (255,255,255);
	
	ImageIcon LeftButton = new ImageIcon(SELECTION.class.getResource ("left arrow.jpg"));
	ImageIcon RightButton = new ImageIcon(SELECTION.class.getResource ("right arrow.jpg"));
	ImageIcon InfoButton = new ImageIcon(SELECTION.class.getResource ("Info button.jpg"));
	ImageIcon DownButton = new ImageIcon(SELECTION.class.getResource ("down button.jpg"));
	ImageIcon AppIcon = new ImageIcon(SELECTION.class.getResource ("AppIcon.png"));
	ImageIcon Ads = new ImageIcon(SELECTION.class.getResource ("Advertisement.jpg"));
	ImageIcon Border = new ImageIcon(SELECTION.class.getResource ("border.png"));
	
	JFormattedTextField TOB = new JFormattedTextField();
	JTextField ATOB = new JTextField();
	
	class test4 extends DefaultListCellRenderer {
		//custom combo box list + drop down button
		JLabel a = new JLabel();

		public test4() {
		a.setOpaque(true);
		a.setFont(new Font("Calibri",Font.PLAIN,16));
		a.setBackground(new Color(46,46,46));
		a.setForeground(new Color(223,195,64));
		}

		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

		a.setText(value.toString());
		return a;
		}
		}

		class CbUI extends BasicComboBoxUI {

		protected JButton createArrowButton() {
		final JButton button = new JButton(new ImageIcon("DownButton"));
		button.setName("ComboBox.arrowButton"); //Mandatory
		button.setOpaque(false);
		button.setContentAreaFilled(false); //no fill
		button.setBorder(null); //no border
		button.setFocusable(false);
		button.setFocusPainted(false);

		return button;
		}
		}
	public  SELECTION()  {
		JLabel Title = new JLabel();
		Title.setText("ROUTE");
		Title.setBounds(140,-360,500,800);
		Title.setFont(TitleFont);
		Title.setForeground(white);
		Title.setVisible(true);
		
		JLabel BoardingLocation = new JLabel();
		BoardingLocation.setText("Select Boarding Location");
		BoardingLocation.setBounds(10,100,400,50);
		BoardingLocation.setFont(SubTitleFont);
		BoardingLocation.setForeground(white);
		
		JLabel Destination = new JLabel();
		Destination.setText("Select Destination");
		Destination.setBounds(10,200,400,50);
		Destination.setFont(SubTitleFont);
		Destination.setForeground(white);
		
		JLabel DesiredTOB = new JLabel();
		DesiredTOB.setText("Enter Time of Boarding");
		DesiredTOB.setBounds(10,300,400,50);
		DesiredTOB.setFont(SubTitleFont);
		DesiredTOB.setForeground(white);

		JLabel AvailableTOB = new JLabel();
		AvailableTOB.setText("Available Time of Boarding");
		AvailableTOB.setBounds(10,400,400,50);
		AvailableTOB.setFont(SubTitleFont);
		AvailableTOB.setForeground(white);
	
		JLabel NoPassenger = new JLabel();
		NoPassenger.setText("Enter No of Passengers");
		NoPassenger.setBounds(10,500,400,50);
		NoPassenger.setFont(SubTitleFont);
		NoPassenger.setForeground(white);
		
		JButton leftButton = new JButton(LeftButton);
		leftButton.setBackground(darkGray);
		leftButton.setBorder(BorderFactory.createLineBorder(darkGray));
		leftButton.setVisible(true);
		leftButton.setBounds(0,0,80,80);
		
		JButton infoButton = new JButton(InfoButton);
		infoButton.setBackground(darkGray);
		infoButton.setBorder(BorderFactory.createLineBorder(darkGray));
		infoButton.setVisible(true);
		infoButton.setBounds(300,0,80,80);

		JButton rightButton = new JButton(RightButton);
		rightButton.setBackground(darkGray);
		rightButton.setBorder(BorderFactory.createLineBorder(darkGray));
		rightButton.setVisible(true);
		rightButton.setBounds(300,550,80,80);
		rightButton.addActionListener(this);
		
		JButton downButton1 = new JButton(DownButton);
		downButton1.setBackground(darkGray);
		downButton1.setBorder(BorderFactory.createLineBorder(darkGray));
		downButton1.setVisible(true);
		downButton1.setBounds(160,160,25,25);
		
		String Location[]= {"Klang","KL Sentral","Batu Caves","Kajang",
				"Port Klang","Tanjung Malim","Nilai","Seremban","Sungai Buloh",
				"Subang Jaya","Shah Alam"};
		
		JLabel Border1 = new JLabel(Border);
		Border1.setVisible(true);
		Border1.setBounds(0,150,200,40);
		
		JLabel Border2 = new JLabel(Border);
		Border2.setVisible(true);
		Border2.setBounds(0,250,200,40);
		
		JLabel Border3 = new JLabel(Border);
		Border3.setVisible(true);
		Border3.setBounds(0,350,200,40);
		
		JLabel Border4 = new JLabel(Border);
		Border4.setVisible(true);
		Border4.setBounds(0,450,200,40);
		
		JLabel Border5 = new JLabel(Border);
		Border5.setVisible(true);
		Border5.setBounds(0,550,200,40);
		
		JComboBox LocationComboBox = new JComboBox(Location);
		LocationComboBox.setRenderer(new test4());
		LocationComboBox.setUI(new CbUI());
		LocationComboBox.setEditable(true);
		LocationComboBox.getEditor().getEditorComponent().setFont(new Font ("Calibri",Font.PLAIN,17));
		LocationComboBox.getEditor().getEditorComponent().setForeground(gold);
		LocationComboBox.getEditor().getEditorComponent().setBackground(null);
		((JTextField) LocationComboBox.getEditor().getEditorComponent()).setBorder(null);
		((JTextField) LocationComboBox.getEditor().getEditorComponent()).setOpaque(false);
		LocationComboBox.getEditor().getEditorComponent().setFocusable(false);

		LocationComboBox.setBounds(10,150,200,40);
		LocationComboBox.setBackground(null);
		LocationComboBox.setFont(BodyTextFont);
		LocationComboBox.setForeground(gold);
		LocationComboBox.setOpaque(false);
		
		JComboBox DestinationComboBox = new JComboBox(Location);
		DestinationComboBox.setRenderer(new test4());
		DestinationComboBox.setUI(new CbUI());
		DestinationComboBox.setEditable(true);
		DestinationComboBox.getEditor().getEditorComponent().setFont(new Font ("Calibri",Font.PLAIN,17));
		DestinationComboBox.getEditor().getEditorComponent().setForeground(gold);
		DestinationComboBox.getEditor().getEditorComponent().setBackground(null);
		((JTextField) DestinationComboBox.getEditor().getEditorComponent()).setBorder(null);
		((JTextField) DestinationComboBox.getEditor().getEditorComponent()).setOpaque(false);
		DestinationComboBox.getEditor().getEditorComponent().setFocusable(false);

		DestinationComboBox.setBounds(10,250,200,40);
		DestinationComboBox.setBackground(darkGray);
		DestinationComboBox.setFont(BodyTextFont);
		DestinationComboBox.setForeground(gold);
		DestinationComboBox.setOpaque(false);
		
		JButton downButton2 = new JButton(DownButton);
		downButton2 .setBackground(darkGray);
		downButton2.setBorder(BorderFactory.createLineBorder(darkGray));
		downButton2.setVisible(true);
		downButton2.setBounds(160,260,25,25);
		
		try {
		 MaskFormatter mf = new MaskFormatter("##:##");
		mf.setPlaceholderCharacter('#');
		TOB = new JFormattedTextField(mf);
		TOB.setColumns(4);
		}catch(Exception e) {
	         e.printStackTrace();
	      } 
		TOB.setBounds(10,350,200,40);
		TOB.setBackground(darkGray);
		TOB.setFont(BodyTextFont);
		TOB.setForeground(gold);
		TOB.setOpaque(false);
		TOB.setVisible(true);
		TOB.setBorder(BorderFactory.createLineBorder(darkGray));
				
		ATOB.setBounds(10,450,200,40);
		ATOB.setBackground(darkGray);
		ATOB.setFont(BodyTextFont);
		ATOB.setForeground(gold);
		ATOB.setBorder(BorderFactory.createLineBorder(darkGray));
		ATOB.setVisible(true);
		ATOB.setOpaque(false);
		
		JFormattedTextField noPassenger = new JFormattedTextField();
		try {
			 MaskFormatter mf1 = new MaskFormatter("##");
			mf1.setPlaceholderCharacter('#');
			noPassenger = new JFormattedTextField(mf1);
			noPassenger.setColumns(2);
			}catch(Exception a) {
		         a.printStackTrace();
		      } 
		noPassenger.setBounds(10,550,200,40);
		noPassenger.setBackground(darkGray);
		noPassenger.setFont(BodyTextFont);
		noPassenger.setForeground(gold);
		noPassenger.setBorder(BorderFactory.createLineBorder(darkGray));
		noPassenger.setVisible(true);
		noPassenger.setOpaque(false);
		
		JButton ads = new JButton(Ads);
		ads.setBounds(0,650,400,150);
		ads.setBackground(darkGray);
		ads.setVisible(true);
		
		final JFrame frame = new JFrame();
		frame.setTitle("ROUTES");
		frame.setIconImage(AppIcon.getImage());
		frame.setLayout(null);
		frame.setSize(400,800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
		frame.add(rightButton);
		frame.add(infoButton);
		frame.add(BoardingLocation);
		frame.add(Destination);
		frame.add(DesiredTOB);
		frame.add(AvailableTOB);
		frame.add(NoPassenger);
		frame.add(LocationComboBox);
		frame.add(leftButton);
		frame.add(Title);
		frame.add(downButton1);
		frame.add(DestinationComboBox);
		frame.add(downButton2);
		frame.add(TOB);
		frame.add(ATOB);
		frame.add(noPassenger);
		frame.add(ads);
		frame.add(Border1);
		frame.add(Border2);
		frame.add(Border3);
		frame.add(Border4);
		frame.add(Border5);
		frame.getContentPane().setBackground(darkGray); 
		
		leftButton.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new Home();
				frame.dispose();
			}
		});
		
	}
	public void actionPerformed(ActionEvent e) {
		String Time = TOB.getText();
		if(Time.trim().equals("09:00")) {
			ATOB.setText("09:04");
		}	
	}
	
	
	
	public static void main(String[]args) {
		new SELECTION();
	}
	
	
}
