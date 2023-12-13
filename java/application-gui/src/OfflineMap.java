/* A downloadable offline map where users can utilize when in an area with not wifi signal
 * Things involved in independent learning:
 * 	1. html tag
 * 		description2.setText("<html>Merdeka Square is a square <br />"
				+ "<html> located in Kuala Lumpur, Malaysia.  <br />"
				+ "<html>It is situated  in front of <br />"
				+ "<html> the Sultan Abdul Samad Building.<br />");
		- for text wrapping and formatting
 * Coded by Michelle
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class OfflineMap {

	Font TitleFont = new Font("Helveticish",Font.BOLD,30);
	Font SubTitleFont= new Font("Glacial Indifference", Font.PLAIN,16);
	Font BodyTextFont = new Font ("Argrandir Medium", Font.PLAIN,12);
	
	Color darkGray = new Color(29,27,30);
	Color lightGrey = new Color (113,114,115);
	Color gold = new Color (225,195,64);
	Color white = new Color (255,255,255);
	
	ImageIcon LeftButton = new ImageIcon(OfflineMap.class.getResource ("left arrow.jpg"));
	ImageIcon RightButton = new ImageIcon(OfflineMap.class.getResource ("right arrow.jpg"));
	ImageIcon InfoButton = new ImageIcon(OfflineMap.class.getResource ("Info button.jpg"));
	ImageIcon DownButton = new ImageIcon(OfflineMap.class.getResource ("down button.jpg"));
	ImageIcon AppIcon = new ImageIcon(OfflineMap.class.getResource ("AppIcon.png"));
	ImageIcon KualaLumpur = new ImageIcon(OfflineMap.class.getResource ("KualaLumpur Map.jpg"));
	ImageIcon ToranaGate = new ImageIcon(OfflineMap.class.getResource ("Torana Gates.jpg"));
	ImageIcon LocationButton = new ImageIcon(OfflineMap.class.getResource ("LocationButton.jpg"));
	ImageIcon MerdekaSquare = new ImageIcon(OfflineMap.class.getResource ("MerdekaSquare.jpg"));
	ImageIcon Border = new ImageIcon(SELECTION.class.getResource ("border.png"));
	
	public OfflineMap() {
		JLabel Title = new JLabel();
		Title.setText("OFFLINE MAP");
		Title.setBounds(90,-360,500,800);
		Title.setFont(TitleFont);
		Title.setForeground(white);
		Title.setVisible(true);
		
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
		rightButton.setBounds(240,120,40,40);
		
		JLabel Border1 = new JLabel(Border);
		Border1.setVisible(true);
		Border1.setBounds(0,120,250,40);
		
		JLabel CityName = new JLabel();
		CityName.setText("Enter City Name:");
		CityName.setBounds(30,60,400,50);
		CityName.setFont(SubTitleFont);
		CityName.setForeground(white);
		
		JTextField cityName = new JTextField();
		cityName.setBounds(30,120,250,40);
		cityName.setBackground(darkGray);
		cityName.setFont(BodyTextFont);
		cityName.setForeground(gold);
		cityName.setBorder(BorderFactory.createLineBorder(darkGray));
		cityName.setOpaque(false);
		cityName.setVisible(true);		
		
		JButton map = new JButton(KualaLumpur);
		map.setBounds(10,180,400,400);
		map.setBackground(darkGray);
		map.setVisible(true);
		
		JLabel line = new JLabel();
		line.setText("___________________________________________________________________");
		line.setBounds(0,570,400,50);
		line.setForeground(gold);
		
		JButton toranaGates = new JButton(ToranaGate);
		toranaGates.setBounds(10,610,100,100);
		toranaGates.setBackground(darkGray);
		toranaGates.setVisible(true);
		
		JLabel landmark1 = new JLabel();
		landmark1.setText("Torana Gates");
		landmark1.setBounds(120,590,400,50);
		landmark1.setForeground(white);
		landmark1.setFont(SubTitleFont);
		
		JLabel description1 = new JLabel();
		description1.setText("<html>Torana Gate is a torana in Brickfields, <br />"
				+ "<html>Kuala Lumpur. The gate is a gift  <br />"
				+ "<html>from the Government of India to<br />"
				+ "<html> Malaysia, as a mark of continued  <br />"
				+ " <html>friendship between the two countries. <br />" );
		description1.setBounds(120,620,250,100);
		description1.setForeground(white);
		description1.setFont(BodyTextFont);
		
		JButton Location1 = new JButton(LocationButton);
		Location1.setBounds(315,610,70,100);
		Location1.setBackground(darkGray);
		Location1.setBorder(BorderFactory.createLineBorder(darkGray));
		Location1.setVisible(true);
		
		JLabel line2 = new JLabel();
		line2.setText("___________________________________________________________________");
		line2.setBounds(0,700,400,50);
		line2.setForeground(gold);
		
		JButton merdekaSquare = new JButton(MerdekaSquare);
		merdekaSquare.setBounds(10,740,100,100);
		merdekaSquare.setBackground(darkGray);
		merdekaSquare.setVisible(true);
		
		JLabel landmark2 = new JLabel();
		landmark2.setText("Merdeka Square");
		landmark2.setBounds(120,720,400,50);
		landmark2.setForeground(white);
		landmark2.setFont(SubTitleFont);
		
		JLabel description2 = new JLabel();
		description2.setText("<html>Merdeka Square is a square <br />"
				+ "<html> located in Kuala Lumpur, Malaysia.  <br />"
				+ "<html>It is situated  in front of <br />"
				+ "<html> the Sultan Abdul Samad Building.<br />");
		description2.setBounds(120,740,250,100);
		description2.setForeground(white);
		description2.setFont(BodyTextFont);
		
		JButton Location2 = new JButton(LocationButton);
		Location2.setBounds(315,740,70,100);
		Location2.setBackground(darkGray);
		Location2.setBorder(BorderFactory.createLineBorder(darkGray));
		Location2.setVisible(true);
		
		final JFrame frame = new JFrame();
		frame.setTitle("OFFLINE MAP");
		frame.setIconImage(AppIcon.getImage());
		frame.setLayout(null);
		frame.setSize(400,850);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
		frame.getContentPane().setBackground(darkGray); 
		frame.add(Title);
		frame.add(leftButton);
		frame.add(infoButton);
		frame.add(CityName);
		frame.add(cityName);
		frame.add(rightButton);
		frame.add(map);
		frame.add(line);
		frame.add(toranaGates);
		frame.add(landmark1);
		frame.add(description1);
		frame.add(Location1);
		frame.add(line2);
		frame.add(merdekaSquare);
		frame.add(landmark2);
		frame.add(description2);
		frame.add(Location2);
		frame.add(Border1);
		
		leftButton.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new Home();
				frame.dispose();
			}
		});

	}
	
	public static void main(String[]args) {
		new OfflineMap();
	}
	
}
