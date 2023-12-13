/* Serves as an alert message for when there is a delay in schedule and estimated time of arrival
 * An apology message is included to appease the anger of commuters waiting for their public transport
 * Things involved in independent learning:
 * 	1. html tag
 * 		Message1.setText( "<html>The time of arrival for the train you have chosen "
				+ "has been delayed from 14:15 to 15:00.<br />"
				+ "This is due to the heavy rain causing water to flood the track.</html>");
		- text wrapping and formatting
 * Coded by Michelle
 * Aided by Kimberly to fix initial issues pertaining setBounds
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class AlertMessage implements ActionListener{

	JPanel panel;
	JButton OK;
	JLabel Message1,Title1;
	
	Font TitleFont = new Font("Helveticish",Font.BOLD,26);
	Font SubTitleFont= new Font("Glacial Indifference", Font.PLAIN,16);
	Font BodyTextFont = new Font ("Argrandir Medium", Font.PLAIN,16);
	
	Color darkGray = new Color(29,27,30);
	Color lightGrey = new Color (113,114,115);
	Color gold = new Color (225,195,64);
	ImageIcon AppIcon = new ImageIcon(AlertMessage.class.getResource ("AppIcon.png"));
	
	public AlertMessage() {
		 OK = new JButton("OK");
			panel = new JPanel();
			panel.add(OK);
			OK.setBounds(200,170,80,30);
			OK.setBackground(darkGray);
			OK.setForeground(gold);
			OK.setBorder(BorderFactory.createLineBorder(gold));
			panel.setBackground(darkGray);
			panel.setLayout(null);
			OK.addActionListener(this);

		Title1 = new JLabel();
		Title1.setText("~~~~~~~~~~~~~OH NO!~~~~~~~~~~~~~");
		Title1.setFont(TitleFont);
		Title1.setForeground(gold);
		Title1.setBounds(0,-100,500,250);
		
		Message1 = new JLabel();
		Message1.setText( "<html>The time of arrival for the train you have chosen "
				+ "has been delayed from 14:15 to 15:00.<br />"
				+ "This is due to the heavy rain causing water to flood the track.</html>");
			Message1.setForeground(new  Color(255,255,255));
		Message1.setFont(SubTitleFont);
		Message1.setBounds(0,-40,500,250);
		
		JFrame frame = new JFrame();
		frame.setTitle("ALERT MESSAGE!");
		frame.setSize(500,250);
		frame.setIconImage(AppIcon.getImage());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		frame.setVisible(true);
		frame.add(Title1);
		frame.add(Message1);
		frame.add(panel);
		frame.getContentPane().setBackground(darkGray); 
		
	 }
	 
 public void ApologyMessage(){
	ImageIcon Apology = new ImageIcon(AlertMessage.class.getResource ("bowing1.jpg"));
	JButton Image = new JButton(Apology);
	Image.setBounds(50,100,388,402);
	Image.setBorder(BorderFactory.createLineBorder(darkGray));
	Image.setVisible(true);
	Image.setBackground(darkGray);
	
	JLabel Message1 = new JLabel();
	Message1.setText("<html> Terribly sorry for any <br /> "
			+ "<html> inconvenience caused! :( <br />");
	Message1.setIcon(Apology);
	Message1.setHorizontalTextPosition(JLabel.CENTER);
	Message1.setVerticalTextPosition(JLabel.BOTTOM);
	Message1.setForeground(new Color(255,255,255));
	Message1.setFont(SubTitleFont);
	Message1.setVerticalAlignment(JLabel.CENTER);
	
	JButton Button1 = new JButton("Its fine..");
	JPanel Panel1 = new JPanel();
	Panel1.add(Button1);
	Button1.setForeground(gold);
	Button1.setBorder(BorderFactory.createLineBorder(gold));
	Button1.setBackground(darkGray);
	Button1.setBounds(320,550,80,30);
	Panel1.setBackground(darkGray);
	Panel1.setLayout(null);
	Button1.addActionListener(this);
	
	JButton Button2 = new JButton("File a complaint");
	JPanel Panel2 = new JPanel();
	Panel2.add(Button2);
	Button2.setForeground(gold);
	Button2.setBorder(BorderFactory.createLineBorder(gold));
	Button2.setBackground(darkGray);
	Button2.setBounds(70,550,130,30);
	Panel2.setLayout(null);
	Button2.addActionListener(this);
	
	JFrame frame1 = new JFrame();
	frame1.setTitle("ALERT MESSAGE!");
	frame1.setLayout(null);
	frame1.setIconImage(AppIcon.getImage());
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	frame1.setSize(500,630);
	frame1.setVisible(true);
	frame1.setLocationRelativeTo(null);
	frame1.getContentPane().setBackground(new Color(0-0-0));
	frame1.add(Button1);
	frame1.add(Button2);
	frame1.add(Message1);
	frame1.add(Image);
	
 }
 
 public void actionPerformed(ActionEvent e) {
	 if(e.getSource()==OK) {
		 ApologyMessage();
	 }
 }

 public static void main(String[]args) {
		new  AlertMessage();
	
 }
 
 
}
	




	




