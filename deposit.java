
package bms;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit, back;
    String pinNo;
    public deposit(String pinNo){
       this.pinNo = pinNo;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,670, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,670);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(210,230,700,35);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(230, 280, 180, 40);
        amount.setFont(new Font("Arial",Font.BOLD,16));
        image.add(amount);
        
        
        deposit = new JButton("Deposit");
        deposit.setBounds(215, 340, 100, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(330, 340, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        setSize(900, 670);
        setVisible(true);
        setLocation(200, 0);
    }
    

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String number = amount.getText();
            
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Amount");
                
            }else{
              try {
                conn c4 = new conn();
                String query = "insert into transaction value('"+pinNo+"','"+number+"','Deposit')";
                c4.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+number+"deposited successfully ");
                setVisible(false);
                Transaction t3 = new Transaction(pinNo);
                t3.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(deposit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }else if(ae.getSource() == back){
           setVisible(false);
           Transaction t2 =  new Transaction(pinNo);
           t2.setVisible(true);
        }
    }
    
    public static void main(String args[]) {
      new deposit("");
    }
}
