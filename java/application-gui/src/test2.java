/* The tickets screen of the application where users can purchase tickets
 * The price of the tickets vary based on the destination as well as boarding station
 * A financial details screen is provided to make possible transactions
 * Things involved in independent learning includes:
 * 	1. Timer
 * 		Timer timer = new Timer(10, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                long duration = System.currentTimeMillis() - startTime;    
                double progress = (double)duration / (double)runTime;     

                if (progress > 1f) {
                    progress = 1f;
                    ((Timer)e.getSource()).stop(); 
                }
 * 		- to animate
 *  2. Custom JComboBox
 *  	- to allow JComboBox to fit in with the background
 *  3. JScrollPane
 *  	JScrollPane ticket = new JScrollPane(mainInScroll);
 *  	- to allow scrolling
 *  4. int diff = Math.abs(fromI - toI); 
 *  	- to convert negative number to positive
 *  5. HashMap
 *  	Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
 *  	- to store values
 *  Coded by Xiwei
 */
import java.util.Map;
import java.util.HashMap;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class test2 extends JFrame{
	
	ImageIcon logo = new ImageIcon("src/applogo.png");
	
	JButton back = new JButton(new ImageIcon("src/backButton.png"));
	JButton info = new JButton(new ImageIcon("src/info.png"));
	
	JFrame fare = new JFrame();
	JFrame pay = new JFrame();
    
	String b,b2,b3;
	String LRTroute[]={"  Please Select", "  Ampang Line", "  Sri Petaling Line", "  Kelana Jaya Line"};        
    
	JComboBox routeCB=new JComboBox(LRTroute); 
	JComboBox toCB =new JComboBox();
    JComboBox fromCB =new JComboBox();
    
    JTextField error = new JTextField("*Invalid Promo Code");
    
    int e = 0 , f = 0;
	int fromI,toI;
    double oriPrice, price12, price50;

    
	public test2() {

		
		JButton swap = new JButton(new ImageIcon("src/swap.png"));
		JButton reset = new JButton(new ImageIcon("src/reset.png"));
		JButton addB = new JButton(new ImageIcon("src/addButton.png"));
		JLabel heading = new JLabel("<html>WHERE DO <br> YOU WANT <br> TO GO ? </html>"), body = new JLabel("ROUTE"), body2 = new JLabel("FROM"), 
				body3 = new JLabel("TO"), cart = new JLabel("ADD TO CART");
		JLabel cbBox = new JLabel((new ImageIcon("src/cb.png"))), cbBox2 = new JLabel((new ImageIcon("src/cb.png"))), cbBox3 = new JLabel((new ImageIcon("src/cb.png"))),
				ad = new JLabel((new ImageIcon("src/ad1.png")));
		        
        //label
        heading.setForeground(new Color(255,255,255)); 
        heading.setFont(new Font("Helvetica Rounded",Font.BOLD,32));     
        heading.setBounds(60, 37, 300, 250 );
      
        body.setForeground(new Color(255,255,255)); 
        body.setFont(new Font("Glacial Indifference",Font.BOLD,13));      
        body.setBounds(60, 225, 100, 50 );
     
        body2.setForeground(new Color(255,255,255)); 
        body2.setFont(new Font("Glacial Indifference",Font.BOLD,13));     
        body2.setBounds(60, 317, 100, 50); 
        
        body3.setForeground(new Color(255,255,255)); 
        body3.setFont(new Font("Glacial Indifference",Font.BOLD,13));             
        body3.setBounds(60, 387, 100, 50);
       
        cart.setForeground(new Color(0,0,0)); 
        cart.setFont(new Font("Alata",Font.PLAIN,15));             
        cart.setBounds(171, 486, 210, 35);
        
        cbBox.setBounds(56, 260, 220, 50);
        cbBox2.setBounds(56, 352, 220, 50);
        cbBox3.setBounds(56, 421, 220, 50);
        ad.setBounds(60, 548, 280, 197);     
      
        
        //combo box
        fromCB.addItem("  Station");
        fromCB.setBounds(66, 360, 200, 40);
        fromCB.setOpaque(false);
        fromCB.setBorder(null);
        fromCB.setUI(new CbUI());
        fromCB.setRenderer(new test4());
        fromCB.setEditable(true);
        fromCB.getEditor().getEditorComponent().setFont(new Font("Calibri",Font.PLAIN,17));
        fromCB.getEditor().getEditorComponent().setForeground(new Color(223,195,64));
        fromCB.getEditor().getEditorComponent().setBackground(null);
        ((JTextField) fromCB.getEditor().getEditorComponent()).setBorder(null);
        ((JTextField) fromCB.getEditor().getEditorComponent()).setOpaque(false);
        fromCB.getEditor().getEditorComponent().setFocusable(false);
        
        
        toCB.addItem("  Station");
        toCB.setBounds(66, 429, 200, 40);
        toCB.setOpaque(false);
        toCB.setBorder(null);
        toCB.setUI(new CbUI());
        toCB.setRenderer(new test4());
        toCB.setEditable(true);
        toCB.getEditor().getEditorComponent().setFont(new Font("Calibri",Font.PLAIN,17));
        toCB.getEditor().getEditorComponent().setForeground(new Color(223,195,64));
        toCB.getEditor().getEditorComponent().setBackground(null);
        ((JTextField) toCB.getEditor().getEditorComponent()).setBorder(null);
        ((JTextField) toCB.getEditor().getEditorComponent()).setOpaque(false);
        toCB.getEditor().getEditorComponent().setFocusable(false);
        

    	
        
        
        routeCB.setBounds(66, 268, 200, 40);
        routeCB.setOpaque(false);
        routeCB.setBorder(null);
        routeCB.setUI(new CbUI());
        routeCB.setRenderer(new test4()); //important for to implement the custom jcombobox
        routeCB.setEditable(true);
        routeCB.getEditor().getEditorComponent().setFont(new Font("Calibri",Font.PLAIN,17));
        routeCB.getEditor().getEditorComponent().setForeground(new Color(223,195,64));
        routeCB.getEditor().getEditorComponent().setBackground(null);
        ((JTextField) routeCB.getEditor().getEditorComponent()).setBorder(null);
        ((JTextField) routeCB.getEditor().getEditorComponent()).setOpaque(false);
        routeCB.getEditor().getEditorComponent().setFocusable(false);
        routeCB.addActionListener( new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {
                                 
            
                String s = (String) routeCB.getSelectedItem();//get the selected item

                switch (s) {//check for a match
                    case "  Kelana Jaya Line":
                    	String From1[] = {"  Station", "  Putra Heigths", "  Subang Alam", "  Alam Megah", "  USJ 21", "  Wawasan", "  Taipan", "  USJ 7",
                		        "  SS18", "  SS15", "  Subang Jaya", "  Glenmarie", "  Ara Damansara", "  Lembah Subang", "  Kelana Jaya", "  Taman Bahagia",
                		        "  Taman Paramount", "  Asia Jaya", "  Taman Jaya", "  Universiti", "  Kerinchi", "  Abdullah Hukum", "  Bangsar", "  KL Sentral", 
                		        "  Pasar Seni", "  Masjid Jamek", "  Dang Wangi", "  Kampung Baru", "  KLCC", "  Ampang Park", "  Damai", "  Dato' Keramat", "  Jelatek" , 
                		        "  Setiawangsa", "  Sri Rampai", "  Wangsa Melayu", "  Taman Melati", "  Gombak" };
                    	
                    	String To1[] = {"  Station", "  Putra Heigths", "  Subang Alam", "  Alam Megah", "  USJ 21", "  Wawasan", "  Taipan", "  USJ 7",
                		        "  SS18", "  SS15", "  Subang Jaya", "  Glenmarie", "  Ara Damansara", "  Lembah Subang", "  Kelana Jaya", "  Taman Bahagia",
                		        "  Taman Paramount", "  Asia Jaya", "  Taman Jaya", "  Universiti", "  Kerinchi", "  Abdullah Hukum", "  Bangsar", "  KL Sentral", 
                		        "  Pasar Seni", "  Masjid Jamek", "  Dang Wangi", "  Kampung Baru", "  KLCC", "  Ampang Park", "  Damai", "  Dato' Keramat", "  Jelatek" , 
                		        "  Setiawangsa", "  Sri Rampai", "  Wangsa Melayu", "  Taman Melati", "  Gombak" };
                    	
                    	fromCB.setModel(new DefaultComboBoxModel(From1));  
                    	toCB.setModel(new DefaultComboBoxModel(To1));
                     
                        break;
                    case "  Sri Petaling Line":
                    	String From2[] = {"  Station", "  Putra Heigths", "  Puchong Prima", "  Puchong Perdana", "  Bandar Puteri", "  Taman Perindustrian Puchong", 
                    			"  Pusat Bandar Puchong", "  IOI Puchong Jaya", "  Kinrara", "  Alam Sutera", "  Muhibbah", "  Awan Besar", "  Sri Petaling", 
                    			"  Bukit Jalil", "  Sungai Besi", "  Bandar Tasik Selatan", "  Bandar Tun Razak", "  Salak Selatan", "  Cheras", "  Chan Sow Lin", 
                    			"  Pudu", "  Hang Tuah", "  Plaza Rakyat", "  Masjid Jamek", "  Bandaraya", "  Sultan Ismail", "  PWTC", "  Titiwangsa", "  Sentul", 
                    			"  Sentul Timur" };
                    	
                    	
                    	String To2[] = {"  Station", "  Putra Heigths", "  Puchong Prima", "  Puchong Perdana", "  Bandar Puteri", "  Taman Perindustrian Puchong", 
                    			"  Pusat Bandar Puchong", "  IOI Puchong Jaya", "  Kinrara", "  Alam Sutera", "  Muhibbah", "  Awan Besar", "  Sri Petaling", 
                    			"  Bukit Jalil", "  Sungai Besi", "  Bandar Tasik Selatan", "  Bandar Tun Razak", "  Salak Selatan", "  Cheras", "  Chan Sow Lin", 
                    			"  Pudu", "  Hang Tuah", "  Plaza Rakyat", "  Masjid Jamek", "  Bandaraya", "  Sultan Ismail", "  PWTC", "  Titiwangsa", "  Sentul", 
                    			"  Sentul Timur" };
                    	
                    	fromCB.setModel(new DefaultComboBoxModel(From2));  
                    	toCB.setModel(new DefaultComboBoxModel(To2));
                    	
                        break;
                    case "  Ampang Line":
                    	String From3[] = {"  Station", "  Ampang", "  Cahaya", "  Cempaka", "  Pandan Indah", "  Pandan Jaya", "  Maluri", "  Miharja", 
                    			"  Chan Sow Lin", "  Pudu", "  Hang Tuah", "  Plaza Rakyat", "  Masjid Jamek", "  Bandaraya", "  Sultan Ismail", "  PWTC", 
                    			"  Titiwangsa", "  Sentul", "  Sentul Timur" };
                    	
                    	
                    	String To3[] = {"  Station", "  Ampang", "  Cahaya", "  Cempaka", "  Pandan Indah", "  Pandan Jaya", "  Maluri", "  Miharja", 
                    			"  Chan Sow Lin", "  Pudu", "  Hang Tuah", "  Plaza Rakyat", "  Masjid Jamek", "  Bandaraya", "  Sultan Ismail", "  PWTC", 
                    			"  Titiwangsa", "  Sentul", "  Sentul Timur" };
                    	
                    	fromCB.setModel(new DefaultComboBoxModel(From3));  
                    	toCB.setModel(new DefaultComboBoxModel(To3));
                    	
                       
                        break;
                        
                    default :
                    	fromCB.removeAllItems();
                    	toCB.removeAllItems();
                    	fromCB.addItem("  Station");
                    	toCB.addItem("  Station");
                     
                    	break;
                   
                }
            }
        });
        
       
        	//button
      		  back.setBounds(40, 43, 45, 45 );
      		  back.setOpaque(false); 
              back.setContentAreaFilled(false); //no fill
              back.setBorder(null); //no border
              
              info.setBounds(300, 43, 45, 45 );
      		  info.setOpaque(false); 
              info.setContentAreaFilled(false); //no fill
              info.setBorder(null); //no border
              
              swap.setBounds(295, 390, 45, 45 );
      		  swap.setOpaque(false); 
              swap.setContentAreaFilled(false); //no fill
              swap.setBorder(null); //no border
              swap.addActionListener(new ActionListener() {

                  public void actionPerformed(ActionEvent e) {
                  	  Object i = fromCB.getSelectedItem();
                      Object i2 = toCB.getSelectedItem();
                      
                      fromCB.setSelectedItem(i2);
                      toCB.setSelectedItem(i);
                  }
                  
              });
              
              reset.setBounds(75, 485, 35, 35 );
              reset.setOpaque(false); 
              reset.setContentAreaFilled(false); //no fill
              reset.setBorder(null); //no border
              reset.addActionListener(new ActionListener() {

                  public void actionPerformed(ActionEvent e) {
                      
                      routeCB.setSelectedIndex(0);
                      fromCB.removeAllItems();
                  	  toCB.removeAllItems();
                  	  fromCB.addItem("  Station");
                  	  toCB.addItem("  Station");
                  }
                  
              });
              
              addB.setBounds(127, 485, 210, 35 );
              addB.setOpaque(false); 
              addB.setContentAreaFilled(false); //no fill
              addB.setBorder(null); //no border
              addB.addActionListener(new ActionListener() {

                  public void actionPerformed(ActionEvent e) {
                  
                	  Object i = fromCB.getSelectedItem();
                      Object i2 = toCB.getSelectedItem();
                      Object i3 = routeCB.getSelectedItem();	
              		  
                      UIManager.put("OptionPane.background",new ColorUIResource(29,27,30));
                	  UIManager.put("Panel.background",new ColorUIResource(29,27,30));
                	  
                	  JLabel label = new JLabel();
                	  label.setFont(new Font("Arial", Font.BOLD, 13));
                	  label.setForeground(new Color(225,225,225)); 
                	  
                	  JButton button = new JButton("OK");
                	  button.setBackground(Color.WHITE);
                	  button.setForeground(Color.BLACK);
                	  button.setFocusable(false);
                	  button.addActionListener(new ActionListener() {
      
                	     public void actionPerformed(ActionEvent actionEvent) {
                	         JOptionPane.getRootFrame().dispose();
                	     }
                	  });
                	  
                	  JButton[] buttons = { button };
                	  
                	 if (i == "  Station" | i2 == "  Station")
                      {
                    	  label.setText("Error: Please select station");
                    	  JOptionPane.showOptionDialog(null, label, "Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, buttons, buttons[0]);
                      }
                     
                      else 
                      {	
                  	  	dispose();
                  	  	FareCart();
                	  	
                      }
                  } 
                  
             });
              
              back.addActionListener (new ActionListener() {
        			public void actionPerformed (ActionEvent press) {
        				new Home();
        				dispose();
        			}
        		});
             
              
        add(ad);
        add(back);
        add(routeCB);
        add(fromCB);
        add(toCB);
        add(cart);
        add(body);
        add(body2);
        add(body3);
        add(cbBox);
        add(cbBox2);
        add(cbBox3);
        add(info);
        add(heading);
        add(swap);
        add(reset);
        add(addB);
        
        setLayout(null);	
        setTitle("LRT Booking");
		setSize(400, 810);
		setResizable(false);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(29,27,30));
		setVisible(true);
		setIconImage(logo.getImage());
	}
	
	
	public void FareCart() {
		
		
		back.addActionListener( new ActionListener() {
	         
            public void actionPerformed(ActionEvent e) {
            	fare.dispose();
            	add(back);
            	add(info);
            	setVisible(true);
            	
            }
        });

		JLabel title = new JLabel("FARE CART");
		title.setForeground(new Color(255,255,255)); 
		title.setFont(new Font("Glacial Indifference",Font.PLAIN,23));    
		title.setBounds(128, 43, 200, 45);
		
		JLabel miniTitle = new JLabel("FARE CALCULATOR");
		miniTitle.setForeground(new Color(255,255,255)); 
		miniTitle.setFont(new Font("Glacial Indifference",Font.PLAIN,16));    
		miniTitle.setBounds(50, 393, 200, 45);

	    JLabel total = new JLabel("TOTAL 1 TICKET");
	    total.setForeground(new Color(223,195,64)); 
	    total.setFont(new Font("Glacial Indifference",Font.PLAIN,13));     
	    total.setBounds(48, 96, 100, 40 );
		
		//ticket part
		JPanel mainInScroll = new JPanel();
		mainInScroll.setBounds(0, 0, 300, 800);
		mainInScroll.setVisible(true);
		mainInScroll.setLayout(new FlowLayout());
		mainInScroll.setOpaque(false);
		mainInScroll.setPreferredSize(new Dimension(300, 800));
		
		JLayeredPane t2 = new JLayeredPane();
		t2.setPreferredSize(new Dimension(286, 70));
	    t2.setVisible(true);
	    t2.setLayout(null);
	    t2.setOpaque(false);
  
		JScrollPane ticket = new JScrollPane(mainInScroll);
		ticket.setBounds(45, 152, 315, 178);
		ticket.setOpaque(false);
		ticket.getViewport().setOpaque(true);
		ticket.setBorder(null);
		ticket.setViewportBorder(null);
		ticket.setVisible(true);
		ticket.getVerticalScrollBar().setPreferredSize(new Dimension(10, 197));
		ticket.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		ticket.getVerticalScrollBar().setUI(new ScrollUI());
		ticket.getViewport().setBackground(new Color(29,27,30));
		
		final JRadioButton a1 = new JRadioButton();
	    a1.setBounds(8,23,28,25);
	    a1.setBackground(new Color(29,27,30));
	    a1.setIcon(new ImageIcon("src/rb1.png"));
	    a1.setSelectedIcon(new ImageIcon("src/rb2.png"));
	        
		final JRadioButton all = new JRadioButton();
		all.setBounds(53,125,28,25);
		all.setBackground(new Color(29,27,30));
		all.setIcon(new ImageIcon("src/rb1.png"));
		all.setSelectedIcon(new ImageIcon("src/rb2.png"));
		all.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(all.isSelected())
					a1.setSelected(true);
				else
					a1.setSelected(false);
			}
		});
		
        
        JButton dustbin = new JButton(new ImageIcon("src/bin.png"));
        dustbin.setBounds(305,108,35,35);
        dustbin.setOpaque(false); 
        dustbin.setContentAreaFilled(false); //no fill
        dustbin.setBorder(null); //no border
        
        JButton tadd = new JButton(new ImageIcon("src/addTButton.png"));
        tadd.setBounds(50, 337, 300, 45 );
        tadd.setOpaque(false); 
        tadd.setContentAreaFilled(false); //no fill
        tadd.setBorder(null); //no border
        tadd.addActionListener( new ActionListener() {
	         
            public void actionPerformed(ActionEvent e) {
            	fare.dispose();
            	back.removeActionListener(this);
            	add(back);
            	add(info);
            	setVisible(true);
            
            }
        });
      
        JLabel bg = new JLabel(new ImageIcon("src/ticket.png"));
        bg.setBounds(50,0,250,70);
        
        JLabel jrAll = new JLabel("All");
        jrAll.setForeground(new Color(255,255,255)); 
        jrAll.setFont(new Font("Glacial Indifference",Font.BOLD,15));     
        jrAll.setBounds(85, 117, 100, 40 );

        //take the first time select only
        if (e == f) {
        b = (String) routeCB.getItemAt(routeCB.getSelectedIndex()); 
        b2 = (String) fromCB.getItemAt(fromCB.getSelectedIndex()); 
        b3 = (String) toCB.getItemAt(toCB.getSelectedIndex()); 
        
        fromI = fromCB.getSelectedIndex();
        toI = toCB.getSelectedIndex();
        
        e++;
        }  
  	  	routeCB.setSelectedIndex(0);
  	  	
        JLabel head = new JLabel(b);
        head.setFont(new Font("Agrandir Medium",Font.BOLD,15)); 
        head.setVisible(true);
        head.setForeground(new Color(0,0,0));    		
        head.setBounds(92,5,200,27);           
         
        JLabel sub = new JLabel("<html>" + b2 + "  -" + b3 + "</html>");
        sub.setFont(new Font("Roboto",Font.BOLD,13)); 
        sub.setForeground(new Color(223,195,64));    		
        sub.setBounds(100,25,190,40);
        
        JLabel mode = new JLabel("<html>L R T</html>");
        mode.setFont(new Font("Calibri",Font.BOLD,20)); 
        mode.setForeground(new Color(255,255,255));   
        mode.setBounds(61,0,18,65);    
        
        
        t2.add(head,Integer.valueOf(2));
        t2.add(mode,Integer.valueOf(2));
        t2.add(sub,Integer.valueOf(2));
        t2.add(a1,Integer.valueOf(2));
        t2.add(bg,Integer.valueOf(0));
        
        mainInScroll.add(t2);
        //ticket part end
        
        //determine price
    	double minPrice = 0.8;
    	
    	int diff = Math.abs(fromI - toI); //convert negative num to positive
    	      	
        	if(diff == 0) {
        		oriPrice = minPrice;
        		price12 = minPrice ;
        		price50 = minPrice;
        	}
        	
        	else {
        		oriPrice = minPrice + 0.4*(diff);
        		price12 = oriPrice - 0.20 ;
        		price50 = oriPrice * 50/100;
        	}
        //determine price end
        
        	
        //calculator part
        JPanel fareCal = new JPanel();
		fareCal.setBounds(50, 435, 45, 128);
		fareCal.setVisible(true);
		fareCal.setLayout(new GridLayout(3,1,0,5));
		fareCal.setOpaque(false);
		
		JLabel funds = new JLabel(new ImageIcon("src/money.png"));
		JLabel card = new JLabel(new ImageIcon("src/card.png"));
		JLabel concesCard = new JLabel(new ImageIcon("src/conCard.png"));
		
		fareCal.add(funds);
		fareCal.add(card);
		fareCal.add(concesCard);
		
		JLabel payType = new JLabel("Fund Transfer");
		payType.setFont(new Font("Agrandir Medium",Font.PLAIN,15)); 
		payType.setForeground(new Color(255,255,255));    		
		payType.setBounds(110,422,150,50);           
        
		JLabel etc = new JLabel("Bank,Credit,eWallet,etc.");
		etc.setFont(new Font("Agrandir Narrow",Font.PLAIN,10)); 
		etc.setForeground(new Color(223,195,64));    		
		etc.setBounds(110,437,150,50); 
		
		JLabel payType2 = new JLabel("Touch 'n Go");
		payType2.setFont(new Font("Agrandir Medium",Font.PLAIN,15)); 
		payType2.setForeground(new Color(255,255,255));    		
		payType2.setBounds(110,466,150,50);           
        
		JLabel etc2 = new JLabel("Smart Card");
		etc2.setFont(new Font("Agrandir Narrow",Font.PLAIN,10)); 
		etc2.setForeground(new Color(223,195,64));    		
		etc2.setBounds(110,481,140,50); 
		
		JLabel payType3 = new JLabel("Concession Card");
		payType3.setFont(new Font("Agrandir Medium",Font.PLAIN,15)); 
		payType3.setForeground(new Color(255,255,255));    		
		payType3.setBounds(110,510,140,50);           
        
		JLabel etc3 = new JLabel("Smart Card");
		etc3.setFont(new Font("Agrandir Narrow",Font.PLAIN,10)); 
		etc3.setForeground(new Color(223,195,64));    		
		etc3.setBounds(110,525,140,50); 
		
		JLabel bodyText = new JLabel("<html>PRICE DISPLAYED INCLUDED AVAILABLE DISCOUNT</html>");
		bodyText.setFont(new Font("Helvetica Regular",Font.BOLD,13)); 
		bodyText.setForeground(new Color(255,255,255));    		
		bodyText.setBounds(50,625,300,50); 
		
		JLabel bodyText2 = new JLabel("<html>Up to 17% discount for Touch 'n Go users<br>50% discount for concession card users</html>");
		bodyText2.setFont(new Font("Glacial Indifference",Font.BOLD,12)); 
		bodyText2.setForeground(new Color(255,255,255));    		
		bodyText2.setBounds(50,659,300,50); 
		
		JLabel bodyText3 = new JLabel("<html>Register to enjoy an additional 3% discount!<br>Become a premium user to enjoy an additional  8% discount!</html>");
		bodyText3.setFont(new Font("Agrandir Narrow",Font.PLAIN,10)); 
		bodyText3.setForeground(new Color(255,255,255));    		
		bodyText3.setBounds(50,693,300,50); 
		
		JLabel dottedLine = new JLabel(new ImageIcon("src/line.png"));
		dottedLine.setBounds(275,462,75,10);
		
		JLabel dottedLine2 = new JLabel(new ImageIcon("src/line.png"));
		dottedLine2.setBounds(275,508,75,10);
		
		JLabel dottedLine3 = new JLabel(new ImageIcon("src/line.png"));
		dottedLine3.setBounds(275,554,75,10);
		
		//mapping between a key and a value
		Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>(); 
		fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		JButton details = new JButton("Fare Details...");
		details.setBounds(246,405,130,25);
		details.setOpaque(false); 
		details.setContentAreaFilled(false); //no fill
		details.setBorder(null); //no border
		details.setFocusable(false);
		details.setForeground(new Color(223,195,64));
		details.setFont(new Font("Agrandir Narrow",Font.PLAIN,10).deriveFont(fontAttributes)); 
		
		JButton register = new JButton("Register Now");
		register.setBounds(243,697,100,25);
		register.setOpaque(false); 
		register.setContentAreaFilled(false); //no fill
		register.setBorder(null); //no border
		register.setFocusable(false);
		register.setForeground(new Color(223,195,64));
		register.setFont(new Font("Agrandir Narrow",Font.PLAIN,11).deriveFont(fontAttributes)); 
		
		JButton subscribe = new JButton("Subscribe Now");
		subscribe.setBounds(50,726,70,25);
		subscribe.setOpaque(false); 
		subscribe.setContentAreaFilled(false); //no fill
		subscribe.setBorder(null); //no border
		subscribe.setFocusable(false);
		subscribe.setForeground(new Color(223,195,64));
		subscribe.setFont(new Font("Agrandir Narrow",Font.PLAIN,10).deriveFont(fontAttributes)); 
		
		JButton buy = new JButton(new ImageIcon("src/buy.png"));
        buy.setBounds(220,580,135,35);
        buy.setOpaque(false); 
        buy.setContentAreaFilled(false); //no fill
        buy.setBorder(null); //no border
        buy.setFocusable(false);
        buy.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      fare.dispose();
			      Payment();
			}
		});
        

		final JTextField promo = new JTextField();
		promo.setBounds(50, 584, 100, 26);
		promo.setBackground(new Color(29,27,30));
		promo.setBorder(new LineBorder(new Color(223,195,64)));
		promo.setText("Promo Code...");
		promo.setFont(new Font("Calibri",Font.PLAIN,12)); 
		promo.setForeground(new Color(223,195,64));   
		promo.setCaretColor(new Color(223,195,64));			
		promo.addMouseListener(new MouseAdapter(){
    	
        public void mouseClicked(MouseEvent e){      
        	promo.setText("");
        	promo.getCaret().setVisible(true); 
        	promo.setEditable(true);  
        	}
		});
		
		
		JButton next = new JButton(new ImageIcon("src/nxt2.png"));
		next.setBounds(157,584,25,25);
		next.setOpaque(false); 
		next.setContentAreaFilled(false); //no fill
		next.setBorder(null); //no border
        next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				error.setFont(new Font("Agrandir Narrow",Font.PLAIN,10)); 
                error.setForeground(new Color(255,106,106));    		
                error.setBounds(50, 612, 100, 20); 
                error.getCaret().setVisible(false); 
                error.setEditable(false); 
        		error.setBorder(null);
        		error.setBackground(new Color(29,27,30));
        		
				if(promo.getText().equals("")| promo.getText().equals(" ") | promo.getText().equals("Promo Code...")){
                   
	    		       error.setText("");
                   
				}
				else
	                   error.setText("*Invalid Promo Code");

			}
        });
        
		NumberFormat nf = new DecimalFormat("#0.00"); // setting 2 decimal

		JTextField price1 = new JTextField("RM   " + nf.format(oriPrice));
		price1.setBounds(276,438,100, 30);
		price1.setBackground(new Color(29,27,30));
		price1.setBorder(null);
		price1.setFont(new Font("Agrandir Medium",Font.BOLD,15)); 
		price1.setForeground(new Color(255,255,255));   		
		price1.getCaret().setVisible(false); 
		price1.setEditable(false);  
	
		JTextField price2 = new JTextField("RM   " + nf.format(price12));
		price2.setBounds(276,484,100, 30);
		price2.setBackground(new Color(29,27,30));
		price2.setBorder(null);
		price2.setFont(new Font("Agrandir Medium",Font.BOLD,15)); 
		price2.setForeground(new Color(255,255,255));   		
		price2.getCaret().setVisible(false); 
		price2.setEditable(false);  
			
		JTextField price3 = new JTextField("RM   " + nf.format(price50));
		price3.setBounds(276,530,100, 30);
		price3.setBackground(new Color(29,27,30));
		price3.setBorder(null);
		price3.setFont(new Font("Agrandir Medium",Font.BOLD,15)); 
		price3.setForeground(new Color(255,255,255));   		
		price3.getCaret().setVisible(false); 
		price3.setEditable(false);  
		//calculator part end

		
		//frame add & settings
		fare.setLayout(null);	
		fare.setTitle("Fare Cart");
		fare.setSize(400, 810);
		fare.setResizable(false);
		fare.setLocationRelativeTo(null); 
		fare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fare.getContentPane().setBackground(new Color(29,27,30));
		fare.setVisible(true);
		fare.setIconImage(logo.getImage());
		fare.addMouseListener(new MouseAdapter(){
        	
            public void mouseClicked(MouseEvent e){      
            		promo.getCaret().setVisible(false);  
            		promo.setEditable(false);  
            		
            		if (promo.getText().equals("")| promo.getText().equals(" "))
            			promo.setText("Promo Code...");
            		
            }
        });
		
		fare.add(details);
		fare.add(register);
		fare.add(subscribe);
		fare.add(bodyText);
		fare.add(bodyText2);
		fare.add(bodyText3);
		fare.add(dottedLine);
		fare.add(dottedLine2);
		fare.add(dottedLine3);
		fare.add(price1);
		fare.add(price2);
		fare.add(price3);
        fare.add(buy);
        fare.add(next);
        fare.add(miniTitle);
		fare.add(dustbin);
        fare.add(jrAll);
        fare.add(all);
        fare.add(tadd);
        fare.add(total);
		fare.add(info);
		fare.add(back);
		fare.add(ticket);
		fare.add(title);
		fare.add(fareCal);
		fare.add(promo);
		fare.add(payType);
		fare.add(etc);
		fare.add(payType2);
		fare.add(etc2);
		fare.add(payType3);
		fare.add(etc3);
		fare.add(error);
	}
	

	public void Payment() {
		
		pay.setLayout(null);	
		pay.setTitle("Payment");
		pay.setSize(400, 810);
		pay.setResizable(false);
		pay.setLocationRelativeTo(null); 
		pay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pay.getContentPane().setBackground(new Color(29,27,30));
		pay.setVisible(true);
		pay.setIconImage(logo.getImage());

		JButton back2 = new JButton(new ImageIcon("src/backButton.png"));
		back2.setBounds(40, 43, 45, 45 );
		back2.setOpaque(false); 
		back2.setContentAreaFilled(false); //no fill
		back2.setBorder(null); //no border
		back2.setFocusable(false);
		back2.addActionListener( new ActionListener() {
	         
            public void actionPerformed(ActionEvent e) {
            	pay.dispose();	
            	FareCart();     	
            
            }
        });
		
		//attempt animation start
		JPanel credit = new JPanel();
		credit.setBackground(null);
		credit.setOpaque(false);
		credit.setVisible(true);
		credit.setLayout(null);
		credit.setBounds(50,810,398,300);
		
		JLabel bg2 = new JLabel(new ImageIcon("src/bg2.png"));
		bg2.setBounds(0,0,398,266);
		
		JLabel text = new JLabel("PAY");
		text.setFont(new Font("Agrandir Medium",Font.BOLD,15)); 
		text.setForeground(new Color(0,0,0));    		
		text.setBounds(280, 200, 50, 30 ); 
		
		JButton payy = new JButton();
		payy.setBounds(246, 200, 100, 30 );
		payy.setOpaque(false); 
		payy.setContentAreaFilled(false); //no fill
		payy.setVisible(true);
		payy.setBorder(new LineBorder(new Color(223,195,64), 30, true));
		
		final JTextField cardNum = new JTextField(" Card Number");
		final JTextField fName = new JTextField(" First Name");
		final JTextField lName = new JTextField(" Last Name");
		final JTextField expDate = new JTextField(" MM/YY");
		final JTextField cvv = new JTextField(" CVV");
		
		cardNum.setBounds(53, 64, 290, 32);
		cardNum.setBackground(new Color(255,255,255));
		cardNum.setBorder(new LineBorder(new Color(46,46,46), 3));
		cardNum.setFont(new Font("Calibri",Font.PLAIN,15)); 
		cardNum.setForeground(new Color(46,46,46));   
		cardNum.setCaretColor(new Color(46,46,46));
		cardNum.addMouseListener(new MouseAdapter(){
    	
        public void mouseClicked(MouseEvent e){      
        	cardNum.setText(" ");
        	cardNum.getCaret().setVisible(true); 
        	cardNum.setEditable(true);  
        	
        	if (fName.getText().equals("") | fName.getText().equals(" ") | cvv.getText().equals("")|cvv.getText().equals("")|
            	lName.getText().equals("")|lName.getText().equals("")| expDate.getText().equals("")|expDate.getText().equals("")) {
        				fName.setText(" First Name");
            			cvv.setText(" CVV");
            			lName.setText(" Last Name");
            			expDate.setText(" MM/YY");
            		}
        	}
		});
		

		fName.setBounds(53, 107, 135, 32);
		fName.setBackground(new Color(255,255,255));
		fName.setBorder(new LineBorder(new Color(46,46,46), 3));
		fName.setFont(new Font("Calibri",Font.PLAIN,15)); 
		fName.setForeground(new Color(46,46,46));   
		fName.setCaretColor(new Color(46,46,46));
		fName.addMouseListener(new MouseAdapter(){
    	
        public void mouseClicked(MouseEvent e){      
        	fName.setText(" ");
        	fName.getCaret().setVisible(true); 
        	fName.setEditable(true);  
        	
        	if (cardNum.getText().equals("") | cardNum.getText().equals(" ") | cvv.getText().equals("")|cvv.getText().equals("")|
        		lName.getText().equals("")|lName.getText().equals("")| expDate.getText().equals("")|expDate.getText().equals("")) {
        			cardNum.setText(" Card Number");
        			cvv.setText(" CVV");
        			lName.setText(" Last Name");
        			expDate.setText(" MM/YY");
        		}
        	}	
        	
		});
		

		lName.setBounds(208, 107, 135, 32);
		lName.setBackground(new Color(255,255,255));
		lName.setBorder(new LineBorder(new Color(46,46,46), 3));
		lName.setFont(new Font("Calibri",Font.PLAIN,15)); 
		lName.setForeground(new Color(46,46,46));   
		lName.setCaretColor(new Color(46,46,46));
		lName.addMouseListener(new MouseAdapter(){
    	
        public void mouseClicked(MouseEvent e){      
        	lName.setText(" ");
        	lName.getCaret().setVisible(true); 
        	lName.setEditable(true);  
        	
        	if (cardNum.getText().equals("") | cardNum.getText().equals(" ") | fName.getText().equals("")|fName.getText().equals(" ")|
                cvv.getText().equals("")|cvv.getText().equals(" ")| expDate.getText().equals("")|expDate.getText().equals(" ")) {
            		
                			cardNum.setText(" Card Number");
                			fName.setText(" First Name");
                			cvv.setText(" CVV");
                			expDate.setText(" MM/YY");
                   }
        	}
		});
		

		expDate.setBounds(53, 149, 135, 32);
		expDate.setBackground(new Color(255,255,255));
		expDate.setBorder(new LineBorder(new Color(46,46,46), 3));
		expDate.setFont(new Font("Calibri",Font.PLAIN,15)); 
		expDate.setForeground(new Color(46,46,46));   
		expDate.setCaretColor(new Color(46,46,46));
		expDate.addMouseListener(new MouseAdapter(){
    	
        public void mouseClicked(MouseEvent e){      
        	expDate.setText(" ");
        	expDate.getCaret().setVisible(true); 
        	expDate.setEditable(true); 
        	
        	if (cardNum.getText().equals("") | cardNum.getText().equals(" ") | fName.getText().equals("")|fName.getText().equals(" ")|
                cvv.getText().equals("")|cvv.getText().equals(" ")| lName.getText().equals("")|lName.getText().equals(" ")) {
                		
                    			cardNum.setText(" Card Number");
                    			fName.setText(" First Name");
                    			lName.setText(" Last Name");
                    			cvv.setText(" CVV");
               }
        	}
		});
		

		cvv.setBounds(208, 149, 135, 32);
		cvv.setBackground(new Color(255,255,255));
		cvv.setBorder(new LineBorder(new Color(46,46,46), 3));
		cvv.setFont(new Font("Calibri",Font.PLAIN,15)); 
		cvv.setForeground(new Color(46,46,46));   
		cvv.setCaretColor(new Color(46,46,46));
		cvv.addMouseListener(new MouseAdapter(){
    	
        public void mouseClicked(MouseEvent e){      
        	cvv.setText(" ");
        	cvv.getCaret().setVisible(true); 
        	cvv.setEditable(true);  
        	
        	if (cardNum.getText().equals("") | cardNum.getText().equals(" ") | fName.getText().equals("")|fName.getText().equals(" ")|
            	lName.getText().equals("")|lName.getText().equals(" ")| expDate.getText().equals("")|expDate.getText().equals(" ")) {
        		
            			cardNum.setText(" Card Number");
            			fName.setText(" First Name");
            			lName.setText(" Last Name");
            			expDate.setText(" MM/YY");
               }
            	
        	}
		});
		
		
		Dimension size = new Dimension(398,300);
        Rectangle from = new Rectangle(0, 810, size.width, size.height);
        Rectangle to = new Rectangle(1, 510, size.width, size.height);

        final AnimateUp animateUp = new AnimateUp(credit, from, to);
		
        JButton close = new JButton(new ImageIcon("src/cross.png"));
		close.setBounds(323, 25, 25, 25 );
		close.setOpaque(false); 
		close.setContentAreaFilled(false); //no fill
		close.setVisible(true);
		close.setBorder(null);
		close.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 animateUp.exit();
        	}
        });
		
		credit.add(close);
		credit.add(text);
		credit.add(payy);
		credit.add(fName);
		credit.add(lName);
		credit.add(cvv);
		credit.add(expDate);
		credit.add(cardNum);
		credit.add(bg2);		
        //attempt animation end
		
		JLabel heading = new JLabel("<html>FINANCIAL<br>DETAILS </html>");
    	heading.setForeground(new Color(255,255,255)); 
    	heading.setFont(new Font("Helvetica Rounded",Font.BOLD,37));     
    	heading.setBounds(60, 49, 200, 200 );
    	
    	JLabel body = new JLabel("PAYMENT METHOD");
    	body.setForeground(new Color(255,255,255)); 
        body.setFont(new Font("Glacial Indifference",Font.BOLD,13));      
        body.setBounds(60, 195, 200, 50 );
        
        JButton type1 = new JButton(new ImageIcon("src/p1.png"));  
        type1.setOpaque(false); 
        type1.setContentAreaFilled(false); //no fill
        type1.setBorder(null); //no border
        
        JButton type2 = new JButton(new ImageIcon("src/p2.png"));       
        type2.setOpaque(false); 
        type2.setContentAreaFilled(false); //no fill
        type2.setBorder(null); //no border
        JButton type3 = new JButton(new ImageIcon("src/p3.png"));   
        type3.setOpaque(false); 
        type3.setContentAreaFilled(false); //no fill
        type3.setBorder(null); //no border
        
        JButton type4 = new JButton(new ImageIcon("src/p4.png"));  
        type4.setOpaque(false); 
        type4.setContentAreaFilled(false); //no fill
        type4.setBorder(null); //no border
        type4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 animateUp.start();
        	}
        });
        
        JButton type5 = new JButton(new ImageIcon("src/p5.png"));  
        type5.setOpaque(false); 
        type5.setContentAreaFilled(false); //no fill
        type5.setBorder(null); //no border
        type5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 animateUp.start();
        	}
        });
        
        JButton type6 = new JButton(new ImageIcon("src/p6.png"));  
        type6.setOpaque(false); 
        type6.setContentAreaFilled(false); //no fill
        type6.setBorder(null); //no border
        
        JPanel type = new JPanel();
        type.setLayout(new GridLayout(2,3,5,0));
        type.setVisible(true);
        type.setBounds(56, 236, 280, 160);
        type.setBackground(null);
        type.add(type1);
        type.add(type2);
        type.add(type3);
        type.add(type4);
        type.add(type5);
        type.add(type6);
        
        JLabel ad = new JLabel(new ImageIcon("src/ad1.png"));
        JLabel ad2 = new JLabel(new ImageIcon("src/ad2.png"));
        
        JPanel advert = new JPanel();
        advert.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        advert.setVisible(true);
        advert.setBounds(60, 405, 280, 290);
        advert.setBackground(null);
        advert.add(ad);
        advert.add(ad2);
        
        JButton next = new JButton(new ImageIcon("src/nxt.png"));  
        next.setOpaque(false); 
        next.setContentAreaFilled(false); //no fill
        next.setBorder(null); //no border
        next.setBounds(280, 690, 70, 72);
        

        pay.add(credit);
        pay.add(advert);
        pay.add(type);        
    	pay.add(heading);
    	pay.add(body);
    	pay.add(next);
		pay.add(info);
		pay.add(back2);
	}



	public static void main(String[] args) {
		
		new test2();
		 
		}
	}		




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
         final JButton button = new JButton(new ImageIcon("src/down.png"));
         button.setName("ComboBox.arrowButton"); //Mandatory
         button.setOpaque(false); 
         button.setContentAreaFilled(false); //no fill
         button.setBorder(null); //no border
         button.setFocusable(false);
         button.setFocusPainted(false);
       
         return button;
         }
     }
     
class ScrollUI extends BasicScrollBarUI {
	
	//custom scroll bar
	public ScrollUI() {
	
		UIManager.put("ScrollBar.trackHighlightForeground", (new Color(57,57,57))); 
	    UIManager.put("ScrollBar.thumb", new ColorUIResource(new Color(223,195,64)));      
	    UIManager.put("ScrollBar.thumbDarkShadow", new ColorUIResource(new Color(223,195,64)));
	    UIManager.put("ScrollBar.thumbShadow", new ColorUIResource(new Color(223,195,64)));
	    UIManager.put("ScrollBar.thumbHighlight", new ColorUIResource(new Color(223,195,64)));
	    UIManager.put("ScrollBar.trackForeground", new ColorUIResource(new Color(57,57,57)));
	    UIManager.put("ScrollBar.trackHighlight", new ColorUIResource(new Color(57,57,57)));
	    UIManager.put("ScrollBar.track", new ColorUIResource(new Color(57,57,57)));
	    UIManager.put("ScrollBar.shadow", new ColorUIResource(new Color(57,57,57)));
	    UIManager.put("ScrollBar.highlight", new ColorUIResource(new Color(57,57,57)));
	}
	    protected JButton createDecreaseButton(int orientation) {
	        JButton button = super.createDecreaseButton(orientation);
	        button.setBorder(new LineBorder(new Color(57,57,57)));
	        button.setBackground(new Color(57,57,57));
	        return button;
	    }
	    
	    protected JButton createIncreaseButton(int orientation) {
	        JButton button = super.createIncreaseButton(orientation);
	        button.setBorder(new LineBorder(new Color(57,57,57)));
	        button.setBackground(new Color(57,57,57));
	        return button;
	    }
	
	
}

class AnimateUp {

    static final int runTime = 400;

    JPanel panel;
    Rectangle from;
    Rectangle to;

    long startTime;

    public AnimateUp(JPanel paymentType, Rectangle from, Rectangle to) {
        this.panel = paymentType;
        this.from = from;
        this.to = to;
    }

    public void start() {
    	
    	panel.setVisible(true);
    	//timer for the animation (delay time in milliseconds, listener)
        Timer timer = new Timer(10, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                long duration = System.currentTimeMillis() - startTime;    //duration = animation happened time point - start time
                double progress = (double)duration / (double)runTime;      //to keep track of the animation ran time

                if (progress > 1f) {
                    progress = 1f;
                    ((Timer)e.getSource()).stop(); //stop animation
                }
                
                Rectangle target = calculateProgress(from, to, progress);  //setting position each milliseconds
                
                panel.setBounds(target);
            }
        });
        timer.setRepeats(true);
        //timer.setCoalesce(true);
        timer.setInitialDelay(0);
        startTime = System.currentTimeMillis();
        timer.start();
    }

    public void remove() {
  
                
                panel.setVisible(false);

    }
    
    public void exit() {
    	
    	panel.setVisible(true);

        Timer timer = new Timer(10, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                long duration = System.currentTimeMillis() - startTime;   
                double progress = (double)duration / (double)runTime;     

                if (progress > 1f) {
                    progress = 1f;
                    ((Timer)e.getSource()).stop(); 
                }
                
                Rectangle target = calculateProgress(to, from, progress);  
                
                panel.setBounds(target);
            }
        });
        timer.setRepeats(true);
        timer.setInitialDelay(0);
        startTime = System.currentTimeMillis();
        timer.start();
    }
    										 //from, to, progress  refer up 
    public static Rectangle calculateProgress(Rectangle start, Rectangle end, double progress) {

    	Rectangle bounds = new Rectangle();

    	if (start != null && end != null) {

    		bounds.setLocation(calculateProgress(start.getLocation(), end.getLocation(), progress));
    		bounds.setSize(calculateProgress(start.getSize(), end.getSize(), progress));

    	}

    	return bounds; //exit method with the value

    }
    
    //location
    public static Point calculateProgress(Point startPoint, Point targetPoint, double progress) {

    	Point point = new Point();

    	if (startPoint != null && targetPoint != null) {

    		point.x = calculateProgress(startPoint.x, targetPoint.x, progress);
    		point.y = calculateProgress(startPoint.y, targetPoint.y, progress);

    	}

    	return point;

    }

    //distance move each time interval 
    public static int calculateProgress(int startValue, int endValue, double fraction) {

    	int value = 0;
    	int distance = endValue - startValue;
    	value = (int)Math.round((double)distance * fraction);
    	value += startValue;

    return value;

    }

    public static Dimension calculateProgress(Dimension startSize, Dimension targetSize, double progress) {

    	Dimension size = new Dimension();

    	if (startSize != null && targetSize != null) {

    		size.width = calculateProgress(startSize.width, targetSize.width, progress);
    		size.height = calculateProgress(startSize.height, targetSize.height, progress);

    	}

    	return size;
    
}}
 

 
