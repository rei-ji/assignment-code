/* Login screen for the application
 * User can type in their username and password to log into the application
 * Access is given only when username and password is correct
 * Things involved in independent learning:
 * 	1. JPasswordField
 * 		password_text = new JPasswordField();
 * 		- to enter password and ensure the password is not visible
 * Coded by Ruban
 * Aided by Xiwei to fix issues regarding screen visibility
 * Aided by Kimberly to set background colors
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class aa extends JFrame implements ActionListener {
JPanel panel;
JLabel user_label, password_label, message;
JTextField userName_text;
JPasswordField password_text;
JButton submit, cancel;
ImageIcon logo = new ImageIcon("src/applogo.png");
aa() {
Color darkGray = new Color (29,27,30);
Color gold = new Color (225,195,64);
// Username
user_label = new JLabel();
user_label.setText("User Name :");
user_label.setForeground (Color.WHITE);
userName_text = new JTextField();
userName_text.setBackground(gold);
setBackground(Color.BLACK);
setForeground(Color.BLACK);
// Password
password_label = new JLabel();
password_label.setText("Password :");
password_label.setForeground (Color.WHITE);
password_text = new JPasswordField();
password_text.setBackground(gold);
// Submit
submit = new JButton("SUBMIT");
submit.setBackground(gold);
panel = new JPanel(new GridLayout(3, 1));
panel.add(user_label);
panel.setBackground (darkGray);
panel.add(userName_text);
panel.add(password_label);
panel.add(password_text);
message = new JLabel();
message.setForeground (Color.WHITE);
panel.add(message);
panel.add(submit);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setIconImage (logo.getImage());

submit.addActionListener(this);
add(panel, BorderLayout.CENTER);
setTitle("Login here if you already got an account !");
setSize(400,500);
setVisible(true);
setResizable (true);
setLocationRelativeTo (null);
}
public static void main(String[] args) {
new aa();

}
public void actionPerformed(ActionEvent ae) {
String userName = userName_text.getText();
@SuppressWarnings("deprecation")
String password = password_text.getText();
if (userName.trim().equals("John Doe") && password.trim().equals("1234")) {
message.setText(" Welcome " + userName + "");
new test30();
dispose();
} else {
message.setText(" Invalid username or password.. ");
}
}
}
