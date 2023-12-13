/* Lost & Found Section where users can try their luck in searching for their lost belongings in public transport
 * Users can claim the displayed objects once their ownership is proven
 * Things involved in independent learning includes:
 * 	1. JScrollPane
 * 		- to allow scrolling
 * 	2. JLayeredPane
 * 		JLayeredPane pane = new JLayeredPane();
 * 	3. html tag
 * 	heading.setText("<html>LOST & <br> FOUND <br> SECTION </html>");
 * 		- for text wrapping and formatting
 * Coded by Xiwei
 */
import javax.swing.JFrame; 
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class A2_LFS implements ItemListener {
	
	JButton back = new JButton(new ImageIcon("src/backButton.png")), info = new JButton(new ImageIcon("src/info.png")),
			sIcon = new JButton(new ImageIcon("src/sIcon.png")), scan = new JButton(new ImageIcon("src/scan.png")),
			next = new JButton(new ImageIcon("src/next.png")), claim = new JButton(new ImageIcon("src/cbutton.png")), claim2 = new JButton(new ImageIcon("src/cbutton.png")),
			claim3 = new JButton(new ImageIcon("src/cbutton.png"));
	JLabel heading = new JLabel(), subhead = new JLabel(), minihead2 = new JLabel(), minihead = new JLabel(), minihead3 = new JLabel(),
			mini = new JLabel(), mini2 = new JLabel(), mini3 = new JLabel(), claimT = new JLabel("CLAIM"), claimT2 = new JLabel("CLAIM"), claimT3 = new JLabel("CLAIM"); 
	JLabel search = new JLabel(new ImageIcon("src/search.png")), search2 = new JLabel(new ImageIcon("src/search2.png")),
		   box = new JLabel(new ImageIcon("src/box.png")), box2 = new JLabel(new ImageIcon("src/box.png")), box3 = new JLabel(new ImageIcon("src/box.png")),
		   bag = new JLabel(new ImageIcon("src/bag.png")), wallet = new JLabel(new ImageIcon("src/wallet.png")), glasses = new JLabel(new ImageIcon("src/glasses.png")), 
		   locate = new JLabel(new ImageIcon("src/locate.png")),locate2 = new JLabel(new ImageIcon("src/locate.png")),locate3 = new JLabel(new ImageIcon("src/locate.png"));
	
	static ImageIcon logo = new ImageIcon("src/applogo.png");
	
	static JTextField searchbar = new JTextField("Search...");
	JToggleButton menu1 = new JToggleButton("All",true), menu2 = new JToggleButton("Mobile",false), 
				  menu3 = new JToggleButton("Purse",false), menu4 = new JToggleButton("Bag",false);
	JLayeredPane pane = new JLayeredPane();
	JScrollPane scroll = new JScrollPane(pane);
	
	public A2_LFS() {
		
		
			//jtextfield
			searchbar.setBounds(86, 316, 150, 20);
			searchbar.setBackground(new Color(29,27,30));
			searchbar.setBorder(null);
			searchbar.setFont(new Font("Calibri",Font.PLAIN,16)); 
			searchbar.setForeground(new Color(223,195,64));   
			searchbar.setCaretColor(new Color(223,195,64));			
			searchbar.addMouseListener(new MouseAdapter(){
        	
            public void mouseClicked(MouseEvent e){      
            		searchbar.setText("");
            		searchbar.getCaret().setVisible(true); 
            		searchbar.setEditable(true);  
            	}
			});
        
			//jbutton
			back.setBounds(40, 43, 45, 45 );
			back.setOpaque(false); 
			back.setContentAreaFilled(false); //no fill
			back.setBorder(null); //no border
			back.setVisible(true);
			
			info.setBounds(300, 43, 45, 45 );
			info.setOpaque(false); 
			info.setContentAreaFilled(false); //no fill
        	info.setBorder(null); //no border
        
        	sIcon.setBounds(244,308,28,28);
        	sIcon.setOpaque(false); 
        	sIcon.setContentAreaFilled(false); //no fill
        	sIcon.setBorder(null); //no border
        
        	scan.setBounds(288,299,45,45);
        	scan.setOpaque(false); 
        	scan.setContentAreaFilled(false); //no fill
        	scan.setBorder(null); //no border
        
        	next.setBounds(316,360,30,39);
        	next.setOpaque(false); 
        	next.setContentAreaFilled(false); //no fill
        	next.setBorder(null); //no border
        
       
        	   		
        	//jlabel
        	heading.setText("<html>LOST & <br> FOUND <br> SECTION </html>"); 
        	heading.setForeground(new Color(255,255,255)); 
        	heading.setFont(new Font("Helvetica Rounded",Font.BOLD,37));     
        	heading.setBounds(60, 50, 200, 250 );
        
        	subhead.setText("<html>NOTHING IS REALLLY LOST,<br>UNTIL YOUR MUM CAN'T FIND IT =)</html>"); 
        	subhead.setForeground(new Color(255,255,255)); 
        	subhead.setFont(new Font("Glacial Indifference",Font.PLAIN,13));     
        	subhead.setBounds(60, 140, 230, 250 );
        
        
        	search.setBounds(70, 300, 235, 46);
        	search2.setBounds(45,354,272,48);  
       
       
      
        	//jtogglebutton
        	ButtonGroup bg = new ButtonGroup();     
        	menu1.setBounds(54,370,50,20);
        	menu1.setOpaque(false); 
        	menu1.setContentAreaFilled(false); //no fill
        	menu1.setBorder(null); //no border
        	menu1.setFocusPainted(false); //no border when selected
        	menu1.setForeground(new Color(223,195,64));
        	menu1.setFont(new Font("Gill Sans MT",Font.BOLD,22)); 
        	menu1.addItemListener(this);
        
        	menu2.setBounds(106,364,78,30);
        	menu2.setOpaque(false); 
        	menu2.setContentAreaFilled(false); //no fill
        	menu2.setBorder(null); //no border
        	menu2.setFocusPainted(false); //no border when selected
        	menu2.setForeground(new Color(255,255,255));
        	menu2.setFont(new Font("Gill Sans MT",Font.PLAIN,22)); 
        	menu2.addItemListener(this);    
        
        	menu3.setBounds(192,364,65,30);
        	menu3.setOpaque(false); 
        	menu3.setContentAreaFilled(false); //no fill
        	menu3.setBorder(null); //no border
        	menu3.setFocusPainted(false); //no border when selected
        	menu3.setForeground(new Color(255,255,255));
        	menu3.setFont(new Font("Gill Sans MT",Font.PLAIN,22)); 
        	menu3.addItemListener(this);
        
        	menu4.setBounds(262,364,50,30);
        	menu4.setOpaque(false); 
        	menu4.setContentAreaFilled(false); //no fill
        	menu4.setBorder(null); //no border
        	menu4.setFocusPainted(false); //no border when selected
        	menu4.setForeground(new Color(255,255,255));
        	menu4.setFont(new Font("Gill Sans MT",Font.PLAIN,22)); 
        	menu4.addItemListener(this);
        
        	bg.add(menu1);
        	bg.add(menu2);
        	bg.add(menu3);
        	bg.add(menu4);
        
        	final JFrame frame = new JFrame();
    		frame.setIconImage(logo.getImage());
    		frame.setLayout(null);
    		frame.setTitle("Lost & Found");
    		frame.setSize(400, 810);
    		frame.setResizable(false);
    		frame.setLocationRelativeTo(null); 
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.getContentPane().setBackground(new Color(29,27,30));
    		frame.setVisible(true);	
    		frame.addMouseListener(new MouseAdapter(){
            	
                public void mouseClicked(MouseEvent e){      
                		searchbar.setText("Search...");
                		searchbar.getCaret().setVisible(false);  
                		searchbar.setEditable(false);  
                }
            });
    		
        	//add main frame
        	frame.add(back);
        	frame.add(info);
        	frame.add(heading);
        	frame.add(subhead);
        	frame.add(search);
        	frame.add(searchbar);
        	frame.add(sIcon);
        	frame.add(scan);
        	frame.add(menu1);
        	frame.add(menu2);
        	frame.add(menu3);
        	frame.add(menu4);
        	frame.add(next);
        	frame.add(search2);
		
        	back.addActionListener (new ActionListener() {
    			public void actionPerformed (ActionEvent press) {
    				new Settings();
    				frame.dispose();
    			}
    		});
        	
        	//scrollpane contents
        	box.setBounds(6,5,300,170);
        	bag.setBounds(0,0,170,170);
        	locate.setBounds(171, 68, 28, 30 );
	     
        	box2.setBounds(6,175,300,170);
        	wallet.setBounds(0,170,170,170);
        	locate2.setBounds(171, 238, 28, 30 );
	     
        	box3.setBounds(6,345,300,170);
        	glasses.setBounds(0,340,170,170);
        	locate3.setBounds(171, 408, 28, 30 );
	    
	     
        	minihead.setText("SLING  BAG"); 
        	minihead.setForeground(new Color(255,255,255)); 
        	minihead.setFont(new Font("Aleo",Font.BOLD,17));     
        	minihead.setBounds(163, 36, 130, 20 );
	     
        	minihead2.setText("WALLET"); 
        	minihead2.setForeground(new Color(255,255,255)); 
        	minihead2.setFont(new Font("Aleo",Font.BOLD,17));     
        	minihead2.setBounds(163, 206, 130, 20 );
	     
        	minihead3.setText("SUNGLASSES"); 
        	minihead3.setForeground(new Color(255,255,255)); 
        	minihead3.setFont(new Font("Aleo",Font.BOLD,17));     
        	minihead3.setBounds(163, 376, 130, 20 );
	     
        	mini.setText("<html>USJ 7 LRT<br>Station</html>"); 
        	mini.setForeground(new Color(255,255,255)); 
        	mini.setFont(new Font("Montserrat",Font.PLAIN,12));     
        	mini.setBounds(201, 64, 60, 40 );
	     
        	mini2.setText("<html>Outside USJ<br>21 LRT Station</html>"); 
        	mini2.setForeground(new Color(255,255,255)); 
        	mini2.setFont(new Font("Montserrat",Font.PLAIN,12));     
        	mini2.setBounds(201, 234, 100, 40 );
	     
        	mini3.setText("<html>Sunway <br> Lagoon <br> BRT Station</html>"); 
        	mini3.setForeground(new Color(255,255,255)); 
        	mini3.setFont(new Font("Montserrat",Font.PLAIN,12));     
        	mini3.setBounds(201, 405, 100, 50 );
        	
        	
        	//claim message frame
        	JLabel popup = new JLabel(new ImageIcon("src/popup.png"));
        	final JFrame mesg = new JFrame();
			mesg.setUndecorated(true);	 // remove the frame's title bar	
			mesg.setShape(new RoundRectangle2D.Double(0, 0, 380, 300, 50, 50)); //( x , y , width , height, arcWidth, arcHeight)
	        mesg.setTitle("Claim Confirmation");
	        mesg.setLayout(null);
	        mesg.setSize(380, 300);
			mesg.setResizable(false);
			mesg.setLocationRelativeTo(null); 
			mesg.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			mesg.getContentPane().setBackground(new Color(29,27,30));
			mesg.setVisible(false);		
			
			
			JLabel info = new JLabel("You are about to be");
			JLabel info2 = new JLabel("redirected to a Live Agent.....");
			info.setBounds(113,162,300,30);
			info.setForeground(new Color(223,195,64)); 
		    info.setFont(new Font("Arial",Font.BOLD,15));  
			info2.setForeground(new Color(223,195,64)); 
		    info2.setFont(new Font("Arial",Font.BOLD,15));  
		    info2.setBounds(84,184,300,30);
		    
		    JLabel mascot = new JLabel(new ImageIcon("src/mascot.png"));
		    mascot.setBounds(114,22,150,147);
		    
		    JLabel text1 = new JLabel("Proceed");
		    text1.setBounds(93,223,90,30);
		    text1.setForeground(new Color(0,0,0)); 
		    text1.setFont(new Font("Glacial Indifference",Font.BOLD,13));   
		    
		    JLabel text2 = new JLabel("Cancel");
		    text2.setBounds(239,223,90,30);
		    text2.setForeground(new Color(0,0,0)); 
		    text2.setFont(new Font("Glacial Indifference",Font.BOLD,13));   
		    
		    JButton exit = new JButton(new ImageIcon("src/exit.png"));
		    exit.setBounds(23, 21, 45, 45);
		    exit.setFocusPainted(false);
		    exit.setOpaque(false); 
		    exit.setContentAreaFilled(false); //no fill
		    exit.setBorder(null); //no border
		    exit.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	mesg.dispose();
			    }
			});
		    
			JButton cancel = new JButton(new ImageIcon("src/button.png"));
			cancel.setBounds(215, 223, 90, 30);
			cancel.setFocusPainted(false);
			cancel.setOpaque(false); 
			cancel.setContentAreaFilled(false); //no fill
        	cancel.setBorder(null); //no border
			cancel.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	mesg.dispose();
			    }
			});
			JButton proceed = new JButton(new ImageIcon("src/button.png"));
			proceed.setBounds(75, 223, 90, 30);
			proceed.setFocusPainted(false);
			proceed.setOpaque(false); 
			proceed.setContentAreaFilled(false); //no fill
			proceed.setBorder(null); //no border
			
			popup.setBounds(0,0,380,300);
			
			mesg.add(exit);
			mesg.add(text1);
			mesg.add(text2);
			mesg.add(info);
			mesg.add(info2);
			mesg.add(cancel);
			mesg.add(proceed);
			mesg.add(mascot);
			mesg.add(popup);
			//claim message frame end
	    
			
        	claim.setBounds(225,120,55,30);
        	claim.setOpaque(false); 
        	claim.setContentAreaFilled(false); //no fill
        	claim.setBorder(null); //no border
        	claim.addActionListener(new ActionListener() { 
        		public void actionPerformed(ActionEvent e) {
	    				mesg.setVisible(true);		
        			}
	    	});
	    			   
	    	        
        	claim2.setBounds(225,290,55,30);
        	claim2.setOpaque(false); 
        	claim2.setContentAreaFilled(false); //no fill
        	claim2.setBorder(null); //no border
        	claim2.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	    		  		mesg.setVisible(true);		
	    	  		}
	    
        	});
	   
        	claim3.setBounds(225,460,55,30);
        	claim3.setOpaque(false); 
        	claim3.setContentAreaFilled(false); //no fill
        	claim3.setBorder(null); //no border
        	claim3.addActionListener(new ActionListener() { 
        		public void actionPerformed(ActionEvent e) { 
    		  			mesg.setVisible(true);		
    	  			}
    
        	});
	     
        	claimT.setForeground(new Color(255,255,255)); 
        	claimT.setFont(new Font("Dubai",Font.BOLD,12));     
        	claimT.setBounds(235,119,55,30 );
	     
        	claimT2.setForeground(new Color(255,255,255)); 
        	claimT2.setFont(new Font("Dubai",Font.BOLD,12));     
        	claimT2.setBounds(235,289,55,30 );
	     
        	claimT3.setForeground(new Color(255,255,255)); 
        	claimT3.setFont(new Font("Dubai",Font.BOLD,12));     
        	claimT3.setBounds(235,459,55,30 );
	     
		
        	//add layered pane
        	pane.add(box, Integer.valueOf(1));
        	pane.add(bag, Integer.valueOf(2));
        	pane.add(minihead, Integer.valueOf(2));
        	pane.add(locate, Integer.valueOf(2));
			pane.add(mini, Integer.valueOf(2));
			pane.add(claim, Integer.valueOf(2));
			pane.add(claimT, Integer.valueOf(3));
		
			pane.add(box2, Integer.valueOf(1));
			pane.add(wallet, Integer.valueOf(2));
			pane.add(locate2, Integer.valueOf(2));
			pane.add(minihead2, Integer.valueOf(2));
			pane.add(mini2, Integer.valueOf(2));
			pane.add(claim2, Integer.valueOf(2));
			pane.add(claimT2, Integer.valueOf(3));
		
			pane.add(box3, Integer.valueOf(1));
			pane.add(glasses, Integer.valueOf(2));
			pane.add(locate3, Integer.valueOf(2)); 
			pane.add(minihead3, Integer.valueOf(2));    
			pane.add(mini3, Integer.valueOf(3));
			pane.add(claim3, Integer.valueOf(2));
			pane.add(claimT3, Integer.valueOf(3));
		
			pane.setPreferredSize(new Dimension(300, 800));
			scroll.setBounds(40, 430, 700, 400);
			scroll.setOpaque(false);
			scroll.getViewport().setOpaque(false);
			scroll.setBorder(null);
			scroll.setViewportBorder(null);
        	scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        	scroll.addMouseListener(new MouseAdapter(){
            	
                public void mouseClicked(MouseEvent e){      
                		searchbar.setText("Search...");
                		searchbar.getCaret().setVisible(false);       	
                		searchbar.setEditable(false);  
                }
            });
        
        	frame.add(scroll);
		}
	

	public void itemStateChanged(ItemEvent e) {
		searchbar.setText("Search...");
    	searchbar.getCaret().setVisible(false); //mouse text pointer
	
		Object source = e.getSource();
		int state = e.getStateChange();
		if(source == menu1) 
	        
			if(state == ItemEvent.SELECTED)
			{
				menu1.setForeground(new Color(223,195,64));
				menu1.setFont(new Font("Gill Sans MT",Font.BOLD,22));
				scroll.setBounds(40, 430, 700, 400);
				pane.setVisible(true);
				pane.add(box, Integer.valueOf(1));
				pane.add(bag, Integer.valueOf(2));
				pane.add(minihead, Integer.valueOf(2));
				pane.add(locate, Integer.valueOf(2));
				pane.add(mini, Integer.valueOf(2));
				pane.add(claim, Integer.valueOf(2));
				pane.add(claimT, Integer.valueOf(3));
				
				pane.add(box2, Integer.valueOf(1));
				pane.add(wallet, Integer.valueOf(2));
				pane.add(locate2, Integer.valueOf(2));
				pane.add(minihead2, Integer.valueOf(2));
				pane.add(mini2, Integer.valueOf(2));
				pane.add(claim2, Integer.valueOf(2));
				pane.add(claimT2, Integer.valueOf(3));
				
				pane.add(box3, Integer.valueOf(1));
				pane.add(glasses, Integer.valueOf(2));
				pane.add(locate3, Integer.valueOf(2)); 
				pane.add(minihead3, Integer.valueOf(2));    
				pane.add(mini3, Integer.valueOf(3));
				pane.add(claim3, Integer.valueOf(2));
				pane.add(claimT3, Integer.valueOf(3));
			
			}
			else
			{
				menu1.setForeground(new Color(255,255,255));
				menu1.setFont(new Font("Gill Sans MT",Font.PLAIN,22));
				pane.setPreferredSize(new Dimension(300, 800));
				pane.removeAll();
				pane.setVisible(false);
			
				
			}
		
		else if(source == menu2)
		{
			if(state == ItemEvent.SELECTED)
			{
				menu2.setForeground(new Color(223,195,64));
				menu2.setFont(new Font("Gill Sans MT",Font.BOLD,22));
				pane.setPreferredSize(new Dimension(300, 400));
				pane.removeAll();
				pane.setVisible(false);
			}
			else 
			{
				menu2.setForeground(new Color(255,255,255));
				menu2.setFont(new Font("Gill Sans MT",Font.PLAIN,22)); 
				pane.setPreferredSize(new Dimension(300, 800));
				pane.removeAll();
				pane.setVisible(false);
			}
		}
		
		else if(source == menu3)
			if(state == ItemEvent.SELECTED) 
			{
				menu3.setForeground(new Color(223,195,64));
				menu3.setFont(new Font("Gill Sans MT",Font.BOLD,22));
				pane.setPreferredSize(new Dimension(300, 400));
				pane.removeAll();
				pane.setVisible(false);
			}
			else
			{
				menu3.setForeground(new Color(255,255,255));
				menu3.setFont(new Font("Gill Sans MT",Font.PLAIN,22)); 
				pane.setPreferredSize(new Dimension(300, 800));
				pane.removeAll();
				pane.setVisible(false);
			}
		else
			
			if(state == ItemEvent.SELECTED) 
			{
				menu4.setForeground(new Color(223,195,64));
				menu4.setFont(new Font("Gill Sans MT",Font.BOLD,22));
				pane.setVisible(true);
				pane.setPreferredSize(new Dimension(300, 400));
				pane.add(box, Integer.valueOf(1));
				pane.add(bag, Integer.valueOf(2));
				pane.add(minihead, Integer.valueOf(2));
				pane.add(locate, Integer.valueOf(2));
				pane.add(mini, Integer.valueOf(2));
				pane.add(claim, Integer.valueOf(2));
				pane.add(claimT, Integer.valueOf(3));
		      
			
			}
			else
			{
				menu4.setForeground(new Color(255,255,255));
				menu4.setFont(new Font("Gill Sans MT",Font.PLAIN,22));
				pane.setPreferredSize(new Dimension(300, 800));
				pane.removeAll();
				pane.setVisible(false);
			
		}
	}



	public static void main(String[] args) {
		new A2_LFS();
		
	}
}

