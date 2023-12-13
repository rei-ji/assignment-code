/* For Ruban:
 * Things involved in independent learning:
 * 	1. JPasswordField
 * 		password_text = new JPasswordField();
 * 		- to enter password and ensure the password is not visible
 *  2. setOpaque
 * 		a.setOpaque(false);
 * 		- to toggle object transparency
 * 	3. html tag
 * 		JLabel Title = new JLabel ("<html>Mode of<br> Transport</html>");
 * 		- for text wrapping and formatting
 * 
 * For Kimberly:
 * Things involved in independent:
 *  1. Calling another class
 *  	settingsButton.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent press) {
				new Settings();
				homeFrame.dispose();
			}
		});
		- to connect one screen to another
 * 	2. MatteBorder
 * 		final Border FAQQuestionBottom = BorderFactory.createMatteBorder (0,0,1,0, gold); 
 *  	- to set bottom border
 *	3. posted.setVisible (true);
		- toggle item visibility to simulate item functionality
	4. html tag
		JLabel FAQQuestion = new JLabel ("<html>CAN'T FIND AN ANSWER? <br>"
				+ "POST YOUR OWN QUESTIONS NOW AND AWAIT AN ANSWER FROM OUR CUSTOMER SERVICE PROMPTLY.</html>");
		- for text wrapping and formatting 	
 * 
 * For Michelle:
 * Things involved in independent learning:
 * 	1. html tag
 * 		Message1.setText( "<html>The time of arrival for the train you have chosen "
				+ "has been delayed from 14:15 to 15:00.<br />"
				+ "This is due to the heavy rain causing water to flood the track.</html>");
		- text wrapping and formatting
 * 	2. Formatted JTextField
 * 		JFormattedTextField noPassenger = new JFormattedTextField();
 * 		- allow only numbers to be typed
 *  3. MaskFormatter
 *  	MaskFormatter mf = new MaskFormatter("##:##");
 *  	- set placeholder text in text field
 *  4. Custom JComboBox
 *  	- allow JComboBox to fit in with the background
 *  5. setOpaque
 *  	LocationComboBox.setOpaque(false);
 *  	- toggle object transparency
 *  	- for designing purposes and to customize JComboBox
 * 
 * For Xiwei:
 * Things involved in independent learning:
 * 	1. JScrollPane
 * 		- to allow scrolling
 * 	2. JLayeredPane
 * 		JLayeredPane pane = new JLayeredPane();
 * 	3. html tag
 * 	heading.setText("<html>LOST & <br> FOUND <br> SECTION </html>");
 * 		- for text wrapping and formatting
 * 	4. Timer
 * 		Timer timer = new Timer(10, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                long duration = System.currentTimeMillis() - startTime;    
                double progress = (double)duration / (double)runTime;     

                if (progress > 1f) {
                    progress = 1f;
                    ((Timer)e.getSource()).stop(); 
                }
 * 		- to animate
 *  5. Custom JComboBox
 *  	- to allow JComboBox to fit in with the background
 *  6. int diff = Math.abs(fromI - toI); 
 *  	- to convert negative number to positive
 *  7. HashMap
 *  	Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
 *  	- to store values
 * 
 */

public class IndependentLearning {

}
