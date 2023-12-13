/* Screen serves more as a gateway to other screens
 * Serves as a settings screen where users can change settings according to their liking as well as access customer support such as the Lost & Found section
 * Utilizes components such as JFrame, JPanel, JLabel and JButton
 * Things involved in independent learning include:
 *  1. MatteBorder
 *  	Border subSettingsBottom = BorderFactory.createMatteBorder (0,0,1,0, lightGray);
 *  	- to set bottom border
 *  2. Calling another class
 *  	back.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new Home();
				settingsFrame.dispose();
			}
		});
		- to connect one screen to another
 * Coded by Kimberly
 */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings {
	public Settings() {
		//Set ImageIcon
		ImageIcon backSign = new ImageIcon (Settings.class.getResource ("backSign.png"));
		ImageIcon arrowSign = new ImageIcon (Settings.class.getResource ("arrowSign.png"));
		ImageIcon appLogo = new ImageIcon (Settings.class.getResource ("appLogo.png"));
		
		//Set JFrame
		final JFrame settingsFrame = new JFrame ();
		
		//Set JPanel
		JPanel settingsPanel = new JPanel ();
		
		//Preset Fonts and Colors
		Font settingsFont1 = new Font ("Helveticish", Font.BOLD, 36);
		Font settingsFont2 = new Font ("Glacial Indifference", Font.PLAIN, 14);
		Font settingsFont3 = new Font ("Helveticish", Font.BOLD, 20);
		Color darkGray = new Color (29,27,30);
		Color lightGray = new Color (113,114,115);
		Color gold = new Color (225,195,64);
		
		//Preset Borders
		Border settingsFrameBorder = BorderFactory.createLineBorder (Color.black, 5);
		Border settingsBottom = BorderFactory.createMatteBorder (0,0,1,0, gold);
		Border subSettingsBottom = BorderFactory.createMatteBorder (0,0,1,0, lightGray);
		Border buttonBorder = BorderFactory.createLineBorder (darkGray, 1);
		
		//Set JComponents
		JLabel settingsTitle = new JLabel ("SETTINGS");
		JLabel settingsSubtitle = new JLabel ("SEARCHING FOR SOMETHING IN PARTICULAR?");
		JLabel account = new JLabel ("ACCOUNT");
		JLabel profile = new JLabel ("PROFILE");
		JLabel pointsAndRedemptions = new JLabel ("POINTS AND REDEMPTIONS");
		JLabel settings = new JLabel ("SETTINGS");
		JLabel notification = new JLabel ("NOTIFICATION SETTINGS");
		JLabel privacy = new JLabel ("PRIVACY SETTINGS");
		JLabel language = new JLabel ("LANGUAGE / BAHASA / YǓYÁN / MOḺI");
		JLabel support = new JLabel ("SUPPORT");
		JLabel FAQButton = new JLabel ("FAQ");
		JLabel helpCentre = new JLabel ("HELP CENTRE");
		JLabel lostAndFound = new JLabel ("LOST & FOUND");
		JLabel policies = new JLabel ("POLICIES");
		JButton logout = new JButton ("LOGOUT");
		JButton back = new JButton ("", backSign);
		JButton arrow1 = new JButton ("", arrowSign);
		JButton arrow2 = new JButton ("", arrowSign);
		JButton arrow3 = new JButton ("", arrowSign);
		JButton arrow4 = new JButton ("", arrowSign);
		JButton arrow5 = new JButton ("", arrowSign);
		JButton arrow6 = new JButton ("", arrowSign);
		JButton arrow7 = new JButton ("", arrowSign);
		JButton arrow8 = new JButton ("", arrowSign);
		JButton arrow9 = new JButton ("", arrowSign);
		
		//Customizations and setBounds
		back.setBackground (darkGray);
		back.setBounds (30, 10, 30, 30);
		back.setBorder (buttonBorder);
		
		settingsTitle.setFont (settingsFont1);
		settingsTitle.setForeground (Color.white);
		settingsTitle.setBounds (30, 30, 450, 50);
		
		settingsSubtitle.setFont (settingsFont2);
		settingsSubtitle.setForeground (Color.white);
		settingsSubtitle.setBounds (30, 70, 450, 50);
		
		account.setFont (settingsFont2);
		profile.setFont (settingsFont2);
		pointsAndRedemptions.setFont (settingsFont2);
		settings.setFont (settingsFont2);
		notification.setFont (settingsFont2);
		privacy.setFont (settingsFont2);
		language.setFont (settingsFont2);
		support.setFont (settingsFont2);
		FAQButton.setFont (settingsFont2);
		helpCentre.setFont (settingsFont2);
		lostAndFound.setFont (settingsFont2);
		policies.setFont (settingsFont2);
		
		account.setForeground (gold);
		settings.setForeground (gold);
		support.setForeground (gold);
		
		account.setBorder (settingsBottom);
		settings.setBorder (settingsBottom);
		support.setBorder (settingsBottom);
		
		profile.setForeground (Color.white);
		pointsAndRedemptions.setForeground (Color.white);
		notification.setForeground (Color.white);
		privacy.setForeground (Color.white);
		language.setForeground (Color.white);
		FAQButton.setForeground (Color.white);
		helpCentre.setForeground (Color.white);
		lostAndFound.setForeground (Color.white);
		policies.setForeground (Color.white);
		
		profile.setBorder (subSettingsBottom);
		pointsAndRedemptions.setBorder (subSettingsBottom);
		notification.setBorder (subSettingsBottom);
		privacy.setBorder (subSettingsBottom);
		language.setBorder (subSettingsBottom);
		FAQButton.setBorder (subSettingsBottom);
		helpCentre.setBorder (subSettingsBottom);
		lostAndFound.setBorder (subSettingsBottom);
		policies.setBorder (subSettingsBottom);
		
		account.setBounds (30, 120, 415, 20);
		profile.setBounds (30, 150, 415, 20);
		pointsAndRedemptions.setBounds (30, 180, 415, 20);
		settings.setBounds (30, 210, 415, 20);
		notification.setBounds (30, 240, 415, 20);
		privacy.setBounds (30, 270, 415, 20);
		language.setBounds (30, 300, 415, 20);
		support.setBounds (30, 330, 415, 20);
		FAQButton.setBounds (30, 360, 415, 20);
		helpCentre.setBounds (30, 390, 415, 20);
		lostAndFound.setBounds (30, 420, 415, 20);
		policies.setBounds (30, 450, 415, 20);
		
		logout.setBackground (gold);
		logout.setForeground (darkGray);
		logout.setBounds (160, 510, 150, 40);
		logout.setFont (settingsFont3);
		logout.setBorder (buttonBorder);
		
		arrow1.setBorder (buttonBorder);
		arrow2.setBorder (buttonBorder);
		arrow3.setBorder (buttonBorder);
		arrow4.setBorder (buttonBorder);
		arrow5.setBorder (buttonBorder);
		arrow6.setBorder (buttonBorder);
		arrow7.setBorder (buttonBorder);
		arrow8.setBorder (buttonBorder);
		arrow9.setBorder (buttonBorder);
		
		arrow1.setBackground (darkGray);
		arrow2.setBackground (darkGray);
		arrow3.setBackground (darkGray);
		arrow4.setBackground (darkGray);
		arrow5.setBackground (darkGray);
		arrow6.setBackground (darkGray);
		arrow7.setBackground (darkGray);
		arrow8.setBackground (darkGray);
		arrow9.setBackground (darkGray);
		
		arrow1.setBounds (425, 145, 20, 20);
		arrow2.setBounds (425, 175, 20, 20);
		arrow3.setBounds (425, 235, 20, 20);
		arrow4.setBounds (425, 265, 20, 20);
		arrow5.setBounds (425, 295, 20, 20);
		arrow6.setBounds (425, 355, 20, 20);
		arrow7.setBounds (425, 385, 20, 20);
		arrow8.setBounds (425, 415, 20, 20);
		arrow9.setBounds (425, 445, 20, 20);
		
		//Actions and Results
		back.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new Home();
				settingsFrame.dispose();
			}
		});
		
		arrow6.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new FAQ();
				settingsFrame.dispose();
			}
		});
		
		arrow8.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new A2_LFS();
				settingsFrame.dispose();
			}
		});
		
		logout.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new aa();
				settingsFrame.dispose();
			}
		});
		
		
		//Add to panel
		settingsPanel.setBorder (settingsFrameBorder);
		settingsPanel.setLayout (null);
		settingsPanel.setBackground (darkGray);
		settingsPanel.add (settingsTitle);
		settingsPanel.add (settingsSubtitle);
		settingsPanel.add (account);
		settingsPanel.add (profile);
		settingsPanel.add (pointsAndRedemptions);
		settingsPanel.add (settings);
		settingsPanel.add (notification);
		settingsPanel.add (privacy);
		settingsPanel.add (language);
		settingsPanel.add (support);
		settingsPanel.add (FAQButton);
		settingsPanel.add (helpCentre);
		settingsPanel.add (lostAndFound);
		settingsPanel.add (policies);
		settingsPanel.add (logout);
		settingsPanel.add (back);
		settingsPanel.add (arrow1);
		settingsPanel.add (arrow2);
		settingsPanel.add (arrow3);
		settingsPanel.add (arrow4);
		settingsPanel.add (arrow5);
		settingsPanel.add (arrow6);
		settingsPanel.add (arrow7);
		settingsPanel.add (arrow8);
		settingsPanel.add (arrow9);
		
		//Add to frame
		settingsFrame.add (settingsPanel);
		settingsFrame.setTitle ("RightOnTrack");
		settingsFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		settingsFrame.setSize (500,900);
		settingsFrame.setVisible (true);
		settingsFrame.setLocationRelativeTo (null);
		settingsFrame.setIconImage (appLogo.getImage());
		settingsFrame.setResizable (false);
		
	}
	
	//Main Method
	public static void main (String [] args) {
		new Settings();
	}
	
}

