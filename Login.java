
package bms;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{

    JButton login, signUp, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        setTitle ("AUTOMATED TELLER MACHINE");
        setLayout(null);
        
        // atm image on the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,20,100,100);
        add(label);
        
        //addind text to the frame 
        JLabel text1 = new JLabel("Welcome To ATM");
        text1.setFont(new Font("Osward", Font.BOLD,38));
        text1.setBounds(200,40,400,80);
        add(text1);
        
        //card number text
        JLabel cardNO = new JLabel("Card Number :");
        cardNO.setFont(new Font("Raleway", Font.BOLD,20));
        cardNO.setBounds(70,150,150,30);
        add(cardNO);
        cardTextField = new JTextField();
        cardTextField.setBounds(250,150,200,30);
        add(cardTextField);
        
        //pint text 
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD,20));
        pin.setBounds(70,220,150, 30);
        add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(250,220,200,30);
        add(pinTextField);
       
     
        login = new JButton("SIGN IN");
        login.setBounds(220,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        clear = new JButton("CLEAR");
        clear.setBounds(370,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        
        signUp = new JButton("SIGN UP");
        signUp.setBounds(295,350,100,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(250,150);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardTextField.setText(""); 
            pinTextField.setText(""); 
            
        }else if(ae.getSource()== signUp){
            
          setVisible(false);
          SignUpOne form = new SignUpOne();
          form.setVisible(true);

        
        } else if(ae.getSource() == login){
            conn c3 = new conn();
            String cardNo = cardTextField.getText();
            String pinNo = pinTextField.getText();
            String query = "select * from login  where card_number  = '"+cardNo+"' and pin_number = '"+pinNo+"'";
            try{
               ResultSet rs = c3.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    Transaction t1 = new Transaction(pinNo);
                    t1.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        
        }
    }
    
    public static void main(String args[]) {
      new Login();
    }
}
