package bms;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class withdraw extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw, back;
    String pinNo;
    public withdraw(String pinNo){
        this.pinNo = pinNo;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,670, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,670);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(210,230,700,35);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(230, 280, 180, 40);
        amount.setFont(new Font("Arial",Font.BOLD,16));
        image.add(amount);
        
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(215, 340, 100, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(330, 340, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        setSize(900, 670);
        setVisible(true);
        setLocation(200, 0);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String number = amount.getText();
            int balance = 0;
            
            try{
                
                
                conn c4 = new conn();
              
                String query1 = "select * from transaction where pin_number = '"+pinNo+"'";
                ResultSet rs = c4.s.executeQuery(query1);
                
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource()==withdraw && balance < Integer.parseInt(number)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                
                String query = "insert into transaction value('"+pinNo+"','"+number+"','Withdraw')";
                c4.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+ number+" withdrawed successfully ");
                int newBalance = balance - Integer.parseInt(number);
                JOptionPane.showMessageDialog(null,"Current Balance "+ newBalance);
                setVisible(false);
                Transaction t3 = new Transaction(pinNo);
                t3.setVisible(true);
                
                
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource() == back){
            setVisible(false);
            Transaction t4 = new Transaction(pinNo);
            t4.setVisible(true);
        } 
    }
   
    public static void main(String args[]) {
       new withdraw("");
        
    }
}
