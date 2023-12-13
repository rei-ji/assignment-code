/* Screen has no actual functionality and working buttons are just for video purpose
 * Serves as an FAQ screen where users can receive answers to their questions
 * Utilizes components such as JFrame, JPanel, JLabel and JButton
 * Things involved in independent learning include:
 *  1. MatteBorder
 * 		final Border FAQQuestionBottom = BorderFactory.createMatteBorder (0,0,1,0, gold); 
 *  	- to set bottom border
 *  2. Calling another class
 *  	back.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new Settings();
				FAQFrame.dispose();
			}
		});
		- to connect one screen to another
	3. FAQPanel.setLayout (null);
		- to allow setBounds to work and remove FlowLayout as the default
	4. posted.setVisible (true);
		- toggle item visibility to simulate item functionality
	5. html tag
		JLabel FAQQuestion = new JLabel ("<html>CAN'T FIND AN ANSWER? <br>"
				+ "POST YOUR OWN QUESTIONS NOW AND AWAIT AN ANSWER FROM OUR CUSTOMER SERVICE PROMPTLY.</html>");
		- for text wrapping and formatting
 * Coded by Kimberly
 */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class FAQ {
	public FAQ () {
		//Set ImageIcon
		ImageIcon plusSign = new ImageIcon (FAQ.class.getResource ("plusSign.png"));
		ImageIcon minusSign = new ImageIcon (FAQ.class.getResource ("minusSign.png"));
		ImageIcon backSign = new ImageIcon (FAQ.class.getResource ("backSign.png"));
		ImageIcon appLogo = new ImageIcon (FAQ.class.getResource ("appLogo.png"));
		
		//SetJFrame
		final JFrame FAQFrame = new JFrame ();
		
		//SetJPanel
		JPanel FAQPanel = new JPanel ();
		
		//Preset Fonts and Colors
		Font FAQFont1 = new Font ("Helveticish", Font.BOLD, 36);
		Font FAQFont2 = new Font ("Glacial Indifference", Font.PLAIN, 14);
		Font FAQFont3 = new Font ("Agrandir Medium", Font.PLAIN, 13);
		Font FAQFont4 = new Font ("Agrandir Medium", Font.PLAIN, 12);
		Font FAQFont5 = new Font ("Glacial Indifference", Font.PLAIN, 10);
		Color darkGray = new Color (29,27,30);
		Color lightGray = new Color (113,114,115);
		Color gold = new Color (225,195,64);
		
		//Preset Borders
		Border FAQFrameBorder = BorderFactory.createLineBorder (Color.black, 5);
		final Border FAQQuestionBottom = BorderFactory.createMatteBorder (0,0,1,0, gold);
		Border buttonBorder = BorderFactory.createLineBorder (darkGray, 1);
		
		//Set JComponents
		JLabel FAQTitle = new JLabel ("FAQ");
		JLabel FAQSubtitle = new JLabel ("GOT QUESTIONS YOU NEED ANSWERS TO?");
		final JTextField FAQSearchField = new JTextField (20);
		JButton FAQSearchButton = new JButton ("SEARCH");
		final JLabel question1 = new JLabel ("How do I use my ticket after purchase?");
		final JLabel question2 = new JLabel ("What extra functions does the premium version of the app have?");
		final JLabel question3 = new JLabel ("How do I enter the coupon code for discounts?");
		final JLabel question4 = new JLabel ("How do I redeem free gifts with the points I have collected?");
		final JLabel question5 = new JLabel ("How do I download an offline map?");
		final JLabel question6 = new JLabel ("Where can I purchase a plushie of Rover the Railway?");
		final JLabel question7 = new JLabel ("How do I earn redemption points?");
		final JLabel answer8 = new JLabel ("No. Rover has rights too :cc");
		final JLabel question8 = new JLabel ("Can I enslave Rover the Railway?");
		JLabel FAQQuestion = new JLabel ("<html>CAN'T FIND AN ANSWER? <br>"
				+ "POST YOUR OWN QUESTIONS NOW AND AWAIT AN ANSWER FROM OUR CUSTOMER SERVICE PROMPTLY.</html>");
		final JTextField FAQPostField = new JTextField (20);
		JButton FAQPostButton = new JButton ("POST");
		final JButton expand1 = new JButton ("", plusSign);
		final JButton expand2 = new JButton ("", plusSign);
		final JButton expand3 = new JButton ("", plusSign);
		final JButton expand4 = new JButton ("", plusSign);
		final JButton expand5 = new JButton ("", plusSign);
		final JButton expand6 = new JButton ("", plusSign);
		final JButton expand7 = new JButton ("", plusSign);
		final JButton expand8 = new JButton ("", plusSign);
		final JButton shrink2 = new JButton ("", minusSign);
		final JButton shrink8 = new JButton ("", minusSign);
		JButton back = new JButton ("", backSign);
		final JLabel posted = new JLabel ("<html>YOUR QUESTION HAS BEEN POSTED."
				+ "<br>KINDLY AWAIT AN ANSWER FROM OUR CUSTOMER SERVICE.</html>");
		
		//Customizations and setBounds
		back.setBackground (darkGray);
		back.setBounds (30, 10, 30, 30);
		back.setBorder (buttonBorder);
		
		FAQTitle.setFont (FAQFont1);
		FAQTitle.setForeground (Color.white);
		FAQTitle.setBounds (30, 30, 450, 50);
		
		FAQSubtitle.setFont (FAQFont2);
		FAQSubtitle.setForeground (Color.white);
		FAQSubtitle.setBounds (30, 70, 450, 50);
		
		FAQSearchField.setBounds (50, 120, 250, 20);
		FAQSearchField.setText ("WHAT IS YOUR QUESTION?");
		FAQSearchField.setForeground (lightGray);
		FAQSearchField.setBorder (buttonBorder);
		FAQSearchButton.setForeground (darkGray);
		FAQSearchButton.setBackground (gold);
		FAQSearchButton.setBounds (350, 120, 85, 20);
		FAQSearchButton.setBorder (buttonBorder);
		
		FAQQuestion.setFont (FAQFont2);
		FAQQuestion.setForeground (Color.white);
		FAQQuestion.setBounds (30, 600, 400, 100);
		FAQPostField.setBounds (30, 700, 420, 100);
		FAQPostField.setText ("TYPE YOUR QUESTION HERE");
		FAQPostField.setForeground (lightGray);
		FAQPostField.setBorder (buttonBorder);
		FAQPostButton.setForeground (darkGray);
		FAQPostButton.setBackground (gold);
		FAQPostButton.setBounds (365, 820, 85, 20);
		FAQPostButton.setBorder (buttonBorder);
		
		question1.setFont (FAQFont3);
		question2.setFont (FAQFont3);
		question3.setFont (FAQFont3);
		question4.setFont (FAQFont3);
		question5.setFont (FAQFont3);
		question6.setFont (FAQFont3);
		question7.setFont (FAQFont3);
		question8.setFont (FAQFont3);
		
		question1.setForeground (Color.white);
		question2.setForeground (Color.white);
		question3.setForeground (Color.white);
		question4.setForeground (Color.white);
		question5.setForeground (Color.white);
		question6.setForeground (Color.white);
		question7.setForeground (Color.white);
		question8.setForeground (Color.white);
		
		question1.setBorder (FAQQuestionBottom);
		question2.setBorder (FAQQuestionBottom);
		question3.setBorder (FAQQuestionBottom);
		question4.setBorder (FAQQuestionBottom);
		question5.setBorder (FAQQuestionBottom);
		question6.setBorder (FAQQuestionBottom);
		question7.setBorder (FAQQuestionBottom);
		question8.setBorder (FAQQuestionBottom);
		
		expand1.setBounds (30, 160, 20, 20);
		expand1.setBackground (darkGray);
		expand1.setBorder (buttonBorder);
		question1.setBounds (70, 160, 380, 20);
		
		expand2.setBounds (30, 190, 20, 20);
		expand2.setBackground (darkGray);
		expand2.setBorder (buttonBorder);
		question2.setBounds (70, 190, 380, 20);
		shrink2.setBounds (31, 190, 20, 20);
		shrink2.setBackground (darkGray);
		shrink2.setBorder (buttonBorder);
		shrink2.setVisible (false);
		
		expand3.setBounds (30, 220, 20, 20);
		expand3.setBackground (darkGray);
		expand3.setBorder (buttonBorder);
		question3.setBounds (70, 220, 380, 20);
		
		expand4.setBounds (30, 250, 20, 20);
		expand4.setBackground (darkGray);
		expand4.setBorder (buttonBorder);
		question4.setBounds (70, 250, 380, 20);
		
		expand5.setBounds (30, 280, 20, 20);
		expand5.setBackground (darkGray);
		expand5.setBorder (buttonBorder);
		question5.setBounds (70, 280, 380, 20);
		
		expand6.setBounds (30, 310, 20, 20);
		expand6.setBackground (darkGray);
		expand6.setBorder (buttonBorder);
		question6.setBounds (70, 310, 380, 20);
		
		expand7.setBounds (30, 340, 20, 20);
		expand7.setBackground (darkGray);
		expand7.setBorder (buttonBorder);
		question7.setBounds (70, 340, 380, 20);
		
		expand8.setBounds (30, 370, 20, 20);
		expand8.setBackground (darkGray);
		expand8.setBorder (buttonBorder);
		shrink8.setBounds (31, 370, 20, 20);
		shrink8.setBackground (darkGray);
		shrink8.setBorder (buttonBorder);
		shrink8.setVisible (false);
		question8.setBounds (70, 370, 380, 20);
		answer8.setFont (FAQFont4);
		answer8.setForeground (Color.white);
		answer8.setBorder (FAQQuestionBottom);
		answer8.setBounds (70, 390, 380, 20);
		answer8.setVisible (false);
		
		posted.setFont (FAQFont5);
		posted.setForeground (Color.white);
		posted.setBounds (30, 805, 380, 40);
		posted.setVisible (false);
		
		//Actions and Results
		back.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new Settings();
				FAQFrame.dispose();
			}
		});
		
		expand8.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				question8.setBorder (null);
				expand8.setVisible (false);
				shrink8.setVisible (true);
				answer8.setVisible (true);
			}
		});
		
		shrink8.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				question8.setBorder (FAQQuestionBottom);
				expand8.setVisible (true);
				shrink8.setVisible (false);
				answer8.setVisible (false);
			}
		});
		
		FAQPostField.addMouseListener (new MouseAdapter() {
			public void mouseClicked (MouseEvent click) {
				FAQPostField.setText ("");
			}
		});
		
		FAQPostButton.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				posted.setVisible (true);
			}
		});
		
		FAQSearchField.addMouseListener (new MouseAdapter() {
			public void mouseClicked (MouseEvent click) {
				FAQSearchField.setText ("");
			}
		});
		
		FAQSearchButton.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				question1.setVisible (false);
				question2.setVisible (false);
				question3.setVisible (false);
				question4.setVisible (false);
				question5.setVisible (false);
				question7.setVisible (false);
				expand3.setVisible (false);
				expand4.setVisible (false);
				expand5.setVisible (false);
				expand6.setVisible (false);
				expand7.setVisible (false);
				expand8.setVisible (false);
				
				question6.setBounds (70, 160, 380, 20);
				question8.setBounds (70, 190, 380, 20);
			}
		});
		
		expand2.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				question8.setBorder (null);
				expand2.setVisible (false);
				shrink2.setVisible (true);
				answer8.setBounds (70, 210, 380, 20);
				answer8.setVisible (true);
			}
		});
		
		shrink2.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				question8.setBorder (FAQQuestionBottom);
				expand2.setVisible (true);
				shrink2.setVisible (false);
				answer8.setVisible (false);
			}
		});
		
		//Add to panel
		FAQPanel.setBorder (FAQFrameBorder);
		FAQPanel.setLayout (null);
		FAQPanel.setBackground (darkGray);
		FAQPanel.add (FAQTitle);
		FAQPanel.add (FAQSubtitle);
		FAQPanel.add (FAQSearchField);
		FAQPanel.add (FAQSearchButton);
		FAQPanel.add (question1);
		FAQPanel.add (question2);
		FAQPanel.add (question3);
		FAQPanel.add (question4);
		FAQPanel.add (question5);
		FAQPanel.add (question6);
		FAQPanel.add (question7);
		FAQPanel.add (question8);
		FAQPanel.add (FAQQuestion);
		FAQPanel.add (FAQPostField);
		FAQPanel.add (FAQPostButton);
		FAQPanel.add (expand1);
		FAQPanel.add (expand2);
		FAQPanel.add (expand3);
		FAQPanel.add (expand4);
		FAQPanel.add (expand5);
		FAQPanel.add (expand6);
		FAQPanel.add (expand7);
		FAQPanel.add (expand8);
		FAQPanel.add (shrink8);
		FAQPanel.add (back);
		FAQPanel.add (answer8);
		FAQPanel.add (posted);
		FAQPanel.add (shrink2);
		
		//Add to frame
		FAQFrame.add (FAQPanel);
		FAQFrame.setTitle ("RightOnTrack");
		FAQFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		FAQFrame.setSize (500,900);
		FAQFrame.setVisible (true);
		FAQFrame.setLocationRelativeTo (null);
		FAQFrame.setIconImage (appLogo.getImage());
		FAQFrame.setResizable (false);
	}
	
	//Main Method
	public static void main (String [] args) {
		new FAQ();
	}
	

}
