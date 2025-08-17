package bms;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdraw,exit; 
    String pinNo;
    public Transaction(String pinNo){
        this.pinNo = pinNo;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,670, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,670);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(235,230,700,35);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,310,130,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(370,310,130,20);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
               
        exit = new JButton("Exit");
        exit.setBounds(370,385,130,20);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setSize(900, 670);
        setVisible(true);
        setLocation(200, 0);
        
    }
    
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            deposit d1 = new deposit(pinNo);
            d1.setVisible(true);
        }else if(ae.getSource() == withdraw){
            setVisible(false);
            withdraw w1 = new withdraw(pinNo);
            w1.setVisible(true);
        }
    }
            
            
    public static void main(String args[]) {
        new Transaction("");
    }
}
