
package bms;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class signUpThree extends JFrame implements ActionListener{
    
    JRadioButton saving,fixedDep,current,recurring;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton submit, clear;
    long random;
    String formNo;
    String name;
     signUpThree(String formNo, String name) {
         this.formNo=formNo;
         this.name = name;
         setLayout(null);
         
          //title
         JLabel title = new JLabel("Page 2 : Account Details");
         title.setBounds(210, 60, 300,30);
         title.setFont(new Font("Arial", Font.BOLD, 22));
         add(title);
         
         //account type
         JLabel type = new JLabel("Account Type  ");
         type.setBounds(50,110,150 ,30);
         type.setFont(new Font("Raleway", Font.BOLD, 18));
         add(type);
         
         saving = new JRadioButton("Saving Account");
         saving.setBounds(50,150,180,30);
         saving.setFont(new Font("Raleway", Font.BOLD, 14));
         add(saving);
         
         fixedDep = new JRadioButton("Fixed Deposit Account");
         fixedDep.setBounds(260,150,200,30);
         fixedDep.setFont(new Font("Raleway", Font.BOLD, 14));
         add(fixedDep);
         
         current = new JRadioButton("Current Account");
         current.setBounds(50,200,200,30);
         current.setFont(new Font("Raleway", Font.BOLD, 14));
         add(current);
         
         recurring = new JRadioButton("Recurring Account");
         recurring.setBounds(260,200,200,30);
         recurring.setFont(new Font("Raleway", Font.BOLD, 14));
         add(recurring);
         
         ButtonGroup tGroup = new ButtonGroup();
         tGroup.add(saving);
         tGroup.add(fixedDep);
         tGroup.add(current);
         tGroup.add(recurring);
         
         //card number 
         JLabel card = new JLabel("Card Number ");
         card.setBounds(50,240,200 ,50);
         card.setFont(new Font("Raleway", Font.BOLD, 18));
         add(card);
         //message and dummy card number 
         JLabel m1 = new JLabel("Your 16 digit card number");
         m1.setBounds(50,260,200 ,50);
         m1.setFont(new Font("Raleway", Font.BOLD, 10));
         add(m1);
         JLabel Cdigit = new JLabel("XXXX-XXXX-XXXX-XXXX");
         Cdigit.setBounds(240,240,200 ,50);
         Cdigit.setFont(new Font("Raleway", Font.BOLD, 16));
         add(Cdigit);
                 
         //pin
         JLabel pin = new JLabel("Pin");
         pin.setBounds(50,300,200 ,50);
         pin.setFont(new Font("Raleway", Font.BOLD, 18));
         add(pin);
         //message and dummy pin
         JLabel m2 = new JLabel("Your 4 digit pin code");
         m2.setBounds(50,320,200 ,50);
         m2.setFont(new Font("Raleway", Font.BOLD, 10));
         add(m2);
         JLabel Pdigit = new JLabel("XXXX");
         Pdigit.setBounds(240,300,200 ,50);
         Pdigit.setFont(new Font("Raleway", Font.BOLD, 16));
         add(Pdigit);
         
         JLabel services = new JLabel("Services Required");
         services.setBounds(50,370,200 ,50);
         services.setFont(new Font("Raleway", Font.BOLD, 18));
         add(services);
         
         c1 = new JCheckBox("ATM Card");
         c1.setBounds(60, 420, 150, 50);
         c1.setFont(new Font("Raleway", Font.BOLD, 14));
         add(c1);
         
         c2 = new JCheckBox("Mobile Banking");
         c2.setBounds(60, 470, 150, 50);
         c2.setFont(new Font("Raleway", Font.BOLD, 14));
         add(c2);
         
         c3 = new JCheckBox("Cheque Book");
         c3.setBounds(60, 520, 150, 50);
         c3.setFont(new Font("Raleway", Font.BOLD, 14));
         add(c3);
         
         c4 = new JCheckBox("Internet Banking");
         c4.setBounds(260, 420, 150, 50);
         c4.setFont(new Font("Raleway", Font.BOLD, 14));
         add(c4);
         
         c5 = new JCheckBox("EMAIL & SMS Alerts");
         c5.setBounds(260, 470, 250, 50);
         c5.setFont(new Font("Raleway", Font.BOLD, 14));
         add(c5);
         
         c6 = new JCheckBox("E-Statement");
         c6.setBounds(260, 520, 150, 50);
         c6.setFont(new Font("Raleway", Font.BOLD, 14));
         add(c6);
         
         submit = new JButton("Submit");
         submit.setBounds(150, 580, 80, 30);
         submit.setBackground(Color.BLACK);
         submit.setForeground(Color.WHITE);
         submit.setFont(new Font("Arial", Font.BOLD, 12));
         submit.addActionListener(this);
         add(submit);
         
         clear = new JButton("Clear");
         clear.setBounds(300, 580, 80, 30);
         clear.setBackground(Color.BLACK);
         clear.setForeground(Color.WHITE);
         clear.setFont(new Font("Arial", Font.BOLD, 12));
         clear.addActionListener(this);
         add(clear);
         
         
         
         //frame settings
        setSize(700, 650);
        setVisible(true);
        setLocation(200, 10);
     }
     
     public void actionPerformed(ActionEvent ae){
        String type;
        String services;
         if(ae.getSource()==submit){
         type = null;
         if(saving.isSelected()){
             type = "Savings Account";
         }else if (fixedDep.isSelected()){
             type = "Fixed Deposit Account";
         }else if (current.isSelected()){
             type = "Fixed Deposit Account";
         }else if (recurring.isSelected()){
             type = "Recurring Account";
         }
         Random random = new Random();
         String cardNo =  "" + Math.abs((random.nextLong() % 90000000L)+5040936000000000L);
         
         String pinNo = "" + Math.abs(random.nextInt(9000) + 1000);
         
         services = "";
         if(c1.isSelected()){
             services += "ATM Card";
         } if(c2.isSelected()){
             services += "Mobile Banking";
         }if(c3.isSelected()){
             services += "Cheque Book";
         }if(c4.isSelected()){
             services += "Internet Banking";
         }if(c5.isSelected()){
             services += "Email & SMS Services";
         }if(c6.isSelected()){
             services += "E-Statement";
         }
         
         try{
             
             conn c = new conn();
             String query = "insert into signupthree values('"+formNo+"','"+name+"','"+type+"','"+services+"','"+cardNo+"','"+pinNo+"')";
             String query1 = "insert into login values('"+formNo+"','"+name+"','"+cardNo+"','"+pinNo+"')";
             c.s.executeUpdate(query);
             c.s.executeUpdate(query1);
         
             JOptionPane.showMessageDialog(null,"Card Number" + cardNo+ "\n Pin Code"+ pinNo);
         }catch(Exception e){
             System.out.println(e);
         }
         
         }else if (ae.getSource() == clear){
             setVisible(false);
             new signUpThree(formNo,name).setVisible(true);
             
         
         }
         
        
      // JRadioButton saving,fixedDep,current,recurring;
     //JCheckBox c1,c2,c3,c4,c5,c6;
    //JButton submit, clear;     
         
         
     
         
      
     }

    public static void main(String args[]) {
      new signUpThree("","");
    }
}
