/* Screen Functions as a home screen to connect to other screens
 * Home screen of the application where users can access multiple features of the application
 * Utilizes components such as JFrame, JPanel, JLabel and JButton
 * Things involved in independent learning include:
 *  1. Calling another class
 *  	settingsButton.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new Settings();
				homeFrame.dispose();
			}
		});
		- to connect one screen to another
 * Coded by Kimberly
 */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Home {
	public Home() {
		//Set ImageIcon
		ImageIcon homeSign = new ImageIcon (Home.class.getResource ("homeSign.png"));
		ImageIcon settingsSign = new ImageIcon (Home.class.getResource ("settingsSign.png"));
		ImageIcon mapSign = new ImageIcon (Home.class.getResource ("mapSign.png"));
		ImageIcon scheduleSign = new ImageIcon (Home.class.getResource ("scheduleSign.png"));
		ImageIcon ticketsSign = new ImageIcon (Home.class.getResource ("ticketSign.png"));
		ImageIcon routeSign = new ImageIcon (Home.class.getResource ("routeSign.png"));
		ImageIcon event1 = new ImageIcon (Home.class.getResource ("event1.png"));
		ImageIcon event2 = new ImageIcon (Home.class.getResource ("event2.png"));
		ImageIcon event3 = new ImageIcon (Home.class.getResource ("event3.png"));
		ImageIcon event4 = new ImageIcon (Home.class.getResource ("event4.png"));
		ImageIcon dot = new ImageIcon (Home.class.getResource ("dot.png"));
		ImageIcon appLogo = new ImageIcon (Home.class.getResource ("appLogo.png"));
		
		//Declare variables
		String username = "JOHN DOE";
		
		//Set JFrame
		final JFrame homeFrame = new JFrame ();
		
		//Set JPanel
		JPanel homePanel = new JPanel ();
		
		//Preset Fonts and Colors
		Font homeFont1 = new Font ("Helveticish", Font.BOLD, 24);
		Font homeFont2 = new Font ("Helveticish", Font.BOLD, 36);
		Font homeFont3 = new Font ("Glacial Indifference", Font.PLAIN, 14);
		Font homeFont4 = new Font ("Glacial Indifference", Font.BOLD, 17);
		Color darkGray = new Color (29,27,30);
		Color gray = new Color (46,46,46);
		Color gold = new Color (225,195,64);
		
		//Preset Borders
		Border homeFrameBorder = BorderFactory.createLineBorder (Color.black, 5);
		Border homeBottom = BorderFactory.createMatteBorder (0,0,1,0, gold);
		Border buttonBorder = BorderFactory.createLineBorder (darkGray, 1);
		
		//Set JComponents
		JLabel greetingCard = new JLabel ("IT'S GOOD TO SEE YOU AGAIN,");
		JLabel usernameLabel = new JLabel (username);
		JLabel homeSubtitle = new JLabel ("<html>FUN FACT:<br>"
				+ "ROVER THE RAILWAY TURNS 5 TODAY :DD </html>");
		JLabel eventsLabel = new JLabel ("EVENTS");
		JLabel rideLabel = new JLabel ("RIDE WITH US");
		final JLabel event1Label = new JLabel (event1);
		final JLabel event2Label = new JLabel (event2);
		final JLabel event3Label = new JLabel (event3);
		final JLabel event4Label = new JLabel (event4);
		JButton mapButton = new JButton ("MAP", mapSign);
		JButton scheduleButton = new JButton ("SCHEDULE", scheduleSign);
		JButton ticketsButton = new JButton ("TICKETS", ticketsSign);
		JButton routesButton = new JButton ("ROUTES", routeSign);
		JButton beginButton = new JButton ("BEGIN JOURNEY");
		JButton settingsButton = new JButton ("", settingsSign);
		JButton homeButton = new JButton ("", homeSign);
		JButton dot1 = new JButton ("", dot);
		JButton dot2 = new JButton ("", dot);
		JButton dot3 = new JButton ("", dot);
		JButton dot4 = new JButton ("", dot);
		
		//Customizations and setBounds
		homeButton.setBackground (darkGray);
		homeButton.setBounds (30, 10, 30, 30);
		homeButton.setBorder (buttonBorder);
		
		settingsButton.setBackground (darkGray);
		settingsButton.setBounds (415, 10, 30, 30);
		settingsButton.setBorder (buttonBorder);
		
		greetingCard.setFont (homeFont1);
		greetingCard.setForeground (Color.white);
		greetingCard.setBounds (30, 30, 450, 50);
		
		usernameLabel.setFont (homeFont2);
		usernameLabel.setForeground (gold);
		usernameLabel.setBounds (30, 70, 450, 50);
		
		homeSubtitle.setFont (homeFont3);
		homeSubtitle.setForeground (Color.white);
		homeSubtitle.setBounds (30, 120, 450, 50);
		
		eventsLabel.setFont (homeFont3);
		eventsLabel.setForeground (gold);
		eventsLabel.setBounds (30, 180, 415, 20);
		eventsLabel.setBorder(homeBottom);
		event1Label.setBounds (30, 210, 415, 248);
		event2Label.setBounds (30, 210, 415, 248);
		event3Label.setBounds (30, 210, 415, 248);
		event4Label.setBounds (30, 210, 415, 248);
		dot1.setBackground (darkGray);
		dot1.setBounds (200, 470, 10, 10);
		dot1.setBorder (buttonBorder);
		dot2.setBackground (darkGray);
		dot2.setBounds (220, 470, 10, 10);
		dot2.setBorder (buttonBorder);
		dot3.setBackground (darkGray);
		dot3.setBounds (240, 470, 10, 10);
		dot3.setBorder (buttonBorder);
		dot4.setBackground (darkGray);
		dot4.setBounds (260, 470, 10, 10);
		dot4.setBorder (buttonBorder);
		
		rideLabel.setFont (homeFont3);
		rideLabel.setForeground (gold);
		rideLabel.setBounds (30, 500, 415, 20);
		rideLabel.setBorder(homeBottom);
		
		mapButton.setBackground (gray);
		mapButton.setForeground (Color.white);
		mapButton.setFont (homeFont4);
		mapButton.setBounds (30, 530, 190, 80);
		mapButton.setBorder (buttonBorder);
		
		scheduleButton.setBackground (gray);
		scheduleButton.setForeground (Color.white);
		scheduleButton.setFont (homeFont4);
		scheduleButton.setBounds (255, 530, 190, 80);
		scheduleButton.setBorder (buttonBorder);
		
		ticketsButton.setBackground (gray);
		ticketsButton.setForeground (Color.white);
		ticketsButton.setFont (homeFont4);
		ticketsButton.setBounds (30, 620, 190, 80);
		ticketsButton.setBorder (buttonBorder);
		
		routesButton.setBackground (gray);
		routesButton.setForeground (Color.white);
		routesButton.setFont (homeFont4);
		routesButton.setBounds (255, 620, 190, 80);
		routesButton.setBorder (buttonBorder);
		
		beginButton.setBackground (gold);
		beginButton.setForeground (darkGray);
		beginButton.setFont (homeFont1);
		beginButton.setBounds (30, 750, 415, 80);
		beginButton.setBorder (buttonBorder);
		
		//Actions and results
		dot1.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				event1Label.setVisible (true);
				event2Label.setVisible (false);
				event3Label.setVisible (false);
				event4Label.setVisible (false);
			}
		});
		
		dot2.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				event1Label.setVisible (false);
				event2Label.setVisible (true);
				event3Label.setVisible (false);
				event4Label.setVisible (false);
			}
		});
		
		dot3.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				event1Label.setVisible (false);
				event2Label.setVisible (false);
				event3Label.setVisible (true);
				event4Label.setVisible (false);
			}
		});
		
		dot4.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				event1Label.setVisible (false);
				event2Label.setVisible (false);
				event3Label.setVisible (false);
				event4Label.setVisible (true);
			}
		});
		
		settingsButton.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new Settings();
				homeFrame.dispose();
			}
		});
		
		mapButton.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new OfflineMap();
				homeFrame.dispose();
			}
		});
		
		ticketsButton.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new test2();
				homeFrame.dispose();
			}
		});
		
		beginButton.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new mode();
				homeFrame.dispose();
			}
		});
		
		//Add to panel
		homePanel.setBorder (homeFrameBorder);
		homePanel.setLayout (null);
		homePanel.setBackground (darkGray);
		homePanel.add (greetingCard);
		homePanel.add (usernameLabel);
		homePanel.add (homeSubtitle);
		homePanel.add (eventsLabel);
		homePanel.add (rideLabel);
		homePanel.add (mapButton);
		homePanel.add (scheduleButton);
		homePanel.add (ticketsButton);
		homePanel.add (routesButton);
		homePanel.add (beginButton);
		homePanel.add (settingsButton);
		homePanel.add (homeButton);
		homePanel.add (event1Label);
		homePanel.add (event2Label);
		homePanel.add (event3Label);
		homePanel.add (event4Label);
		homePanel.add (dot1);
		homePanel.add (dot2);
		homePanel.add (dot3);
		homePanel.add (dot4);
	
		//Add to frame
		homeFrame.add (homePanel);
		homeFrame.setTitle ("RightOnTrack");
		homeFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		homeFrame.setSize (500,900);
		homeFrame.setVisible (true);
		homeFrame.setLocationRelativeTo (null);
		homeFrame.setIconImage (appLogo.getImage());
		homeFrame.setResizable (false);
	}
	
	//Main Method
	public static void main (String [] args) {
		new Home();
	}

}
