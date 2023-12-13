/* Language options where users can pick their desired language for the application
 * 4 languages are offered to suit a wider audience
 * Things involved in independent learning:
 * 	1. html tag
 * 		JLabel Title = new JLabel ("<html>Language<br> Option</html>");
 * 		- for text wrapping and formatting
 * 	2. setOpaque
 * 		a.setOpaque(false)
 * 		- toggle object transparency for designing purposes
 * Coded by Ruban
 * Aided by Xiwei in checking the written codes
 */
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test30 {
	
	JLabel Title = new JLabel ("<html>Language<br> Option</html>");
	JPanel Panel = new JPanel();
	JButton a = new JButton(new ImageIcon("src/01.png"));
	JFrame frame = new JFrame();
	
	ImageIcon logo = new ImageIcon("src/applogo.png");
	
	public test30() {
		
		Title.setForeground(new Color(255,255,255));
		Title.setFont(new Font("Helvetica Rounded",Font.BOLD,37));
		Title.setBounds(100, 20, 200, 110 );
		Title.setBorder((new LineBorder(new Color(223,195,64),8)));
		
		a.setBounds(100,140,200,100);
		a.setOpaque(false);
		a.setContentAreaFilled(false);;
		a.setBorder(null);
		
		
		JButton b = new JButton(new ImageIcon("src/02.png"));
			
			b.setBounds(50,200,300,200);
			b.setOpaque(false);
			b.setContentAreaFilled(false);;
			b.setBorder(null);
			
		
			JButton c = new JButton(new ImageIcon("src/03.png"));
				
			    c.setBounds(50,320,300,200);
				c.setOpaque(false);
				c.setContentAreaFilled(false);;
				c.setBorder(null);
				
				JButton d = new JButton(new ImageIcon("src/04.png"));
					
					d.setBounds(50,450,300,200);
					d.setOpaque(false);
					d.setContentAreaFilled(false);;
					d.setBorder(null);
					
		Panel.add(Title);
		Panel.add(a);
		Panel.add(b);
		Panel.add(c);
		Panel.add(d);
		Panel.setLayout (null);
		Panel.setBackground(new Color(29,27,30));
		
		frame.add (Panel);
		frame.setTitle("Language Option");
		frame.setSize(400, 800);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setIconImage (logo.getImage());
		
		a.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new Home();
				frame.dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new test30();
	}

}
