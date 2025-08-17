
package bms;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener{

    int random;
    JTextField nameTF, fNameTF,emailAdd,add,cityTF, stateTF,pincodeTF;
    JButton next;
    JRadioButton male,female,others, married, unmarried;
    JDateChooser dateChooser;
    
   SignUpOne(){
       
       Random rand = new Random();
       random = rand.nextInt(9000) + 1000; //(9000) takes value till 8999 its range 0 to val - 1
       setLayout(null);
       
       JLabel formNo = new JLabel("APPLICATION FORM NO. " + random);
       formNo.setBounds(180, 20, 600, 40);
       formNo.setFont(new Font("Arial",Font.BOLD, 22));
       add(formNo);
       
       
       JLabel personalDetail = new JLabel("PERSONAL DETAILS");
       personalDetail.setBounds(240, 80 , 400 , 40);
       personalDetail.setFont(new Font("Arial",Font.BOLD, 18));
       add(personalDetail);
       
       //candidate name
       JLabel name = new JLabel("Name : ");
       name.setBounds(50, 150 , 100 , 30);
       name.setFont(new Font("Arial",Font.BOLD, 16));
       add(name);
       //adding the text field
       nameTF = new JTextField();
       nameTF.setBounds(190,150, 380, 30);
       nameTF.setFont(new Font("Arial", Font.BOLD,12));
       add(nameTF);
       
       //candidates father name
       JLabel fName = new JLabel("Father's Name : ");
       fName.setBounds(50, 210 , 130 , 40);
       fName.setFont(new Font("Arial",Font.BOLD, 16));
       add(fName);
       //adding the text field
       fNameTF = new JTextField();
       fNameTF.setBounds(190,210, 380, 30);
       fNameTF.setFont(new Font("Arial", Font.BOLD,12));
       add(fNameTF);
       
       //adding the date of birth 
       JLabel Dob = new JLabel("Date Of Birth : ");
       Dob.setBounds(50, 260 , 130 , 40);
       Dob.setFont(new Font("Arial",Font.BOLD, 16));
       add(Dob);
       //adding calendar
       dateChooser = new JDateChooser();
       dateChooser.setBounds(190, 260,380, 40);
       dateChooser.setForeground(Color.BLACK);
       add(dateChooser);
       
       
       JLabel gender = new JLabel("Gender : ");
       gender.setBounds(50, 310 , 130 , 40);
       gender.setFont(new Font("Arial",Font.BOLD, 16));
       add(gender);
       //adding radio buttons
       //male
       male = new JRadioButton("Male");
       male.setBounds(190, 310, 80, 30);
       male.setBackground(Color.WHITE);
       add(male);
       //female
       female = new JRadioButton("Female");
       female.setBounds(290, 310, 80, 30);
       female.setBackground(Color.WHITE);
       add(female);
       //others
       others = new JRadioButton("Others");
       others.setBounds(390, 310, 80, 30);
       others.setBackground(Color.WHITE);
       add(others);
       
       
       ButtonGroup gendergroup = new ButtonGroup();
       gendergroup.add(male);
       gendergroup.add(female);
       gendergroup.add(others);
       
       
       
       
       //adding emailaddress
       JLabel emailAddress = new JLabel("Email Address : ");
       emailAddress.setBounds(50, 360 , 130 , 40);
       emailAddress.setFont(new Font("Arial",Font.BOLD, 16));
       add(emailAddress);
       //adding text field
       emailAdd = new JTextField();
       emailAdd.setBounds(190,360, 380, 30);
       emailAdd.setFont(new Font("Arial", Font.BOLD,12));
       add(emailAdd);
       
       //marital status
       JLabel marital = new JLabel("Marital Status : ");
       marital.setBounds(50, 410 , 130 , 40);
       marital.setFont(new Font("Arial",Font.BOLD, 16));
       add(marital);
       //adding radio buttons
       //married
       married = new JRadioButton("Married");
       married.setBounds(190, 410, 80, 30);
       married.setBackground(Color.WHITE);
       add(married);
       //unmarried
       unmarried = new JRadioButton("Unmarried");
       unmarried.setBounds(290, 410, 100, 30);
       unmarried.setBackground(Color.WHITE);
       add(unmarried);
       
       ButtonGroup msGroup = new ButtonGroup();
       msGroup.add(married);
       msGroup.add(unmarried);
       
       //adding address
       JLabel address = new JLabel("Home Address : ");
       address.setBounds(50, 460 , 130 , 40);
       address.setFont(new Font("Arial",Font.BOLD, 16));
       add(address);
       //adding text field
       add = new JTextField();
       add.setBounds(190,460, 380, 30);
       add.setFont(new Font("Arial", Font.BOLD,12));
       add(add);
       
       //adding city
       JLabel city = new JLabel("City : ");
       city.setBounds(50, 500 , 130 , 40);
       city.setFont(new Font("Arial",Font.BOLD, 16));
       add(city);
       //adding text field
       cityTF = new JTextField();
       cityTF.setBounds(190,500, 380, 30);
       cityTF.setFont(new Font("Arial", Font.BOLD,12));
       add(cityTF);
       
       
     
       //adding state
       JLabel state = new JLabel("State : ");
       state.setBounds(50, 555 , 130 , 40);
       state.setFont(new Font("Arial",Font.BOLD, 16));
       add(state);
       //adding text field
       stateTF = new JTextField();
       stateTF.setBounds(190,555, 380, 30);
       stateTF.setFont(new Font("Arial", Font.BOLD,12));
       add(stateTF);
       
       //adding pincode
       JLabel pincode = new JLabel("Pincode : ");
       pincode.setBounds(50, 595 , 130 , 40);
       pincode.setFont(new Font("Arial",Font.BOLD, 16));
       add(pincode);
       //adding text field
       pincodeTF = new JTextField();
       pincodeTF.setBounds(190,595, 380, 30);
       pincodeTF.setFont(new Font("Arial", Font.BOLD,12));
       add(pincodeTF);
       
       
       next = new JButton("Next");
       next.setBackground(Color.BLACK);
       next.setForeground(Color.WHITE);
       next.setFont(new Font("Arial", Font.BOLD,14));
       next.setBounds(600,595,80,30);
       next.addActionListener(this);
       add(next);
       
       
       getContentPane().setBackground(Color.WHITE);
       setSize(710,670);
       setVisible(true);
       setLocation(250, 10);
   }
       
       public void actionPerformed(ActionEvent ae){
      
           String formNo = "" + random;
           String name = nameTF.getText();
           String fName = fNameTF.getText();
           String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
           String emailAddress = emailAdd.getText();
           String address = add.getText();
           String city = cityTF.getText();
           String state = stateTF.getText();
           String pincode = pincodeTF.getText();
           String gender = null;
           if(male.isSelected()){
           
               gender = "male";
           }else if(female.isSelected()){
              gender = "female";
           }else if(others.isSelected()){
               gender = "others";
           }
           
           String marital = null;
           
           if(unmarried.isSelected()){
               marital = "Unmarried";
           }else if(married.isSelected()){
                marital = "Married";
           }
           
           try{
           
               if(name.equals("")){
                   JOptionPane.showMessageDialog(null, "Name is Required");
               }else {
               
                   conn c = new conn();
                   String query = "insert into signup values('" +formNo+"','" +name+ "','" +fName+ "','" +dob+ "','" +gender+ "','" +emailAddress+ "','" +marital+ "','" +address+ "','" +city+ "','" +state+ "','" +pincode+ "')";
                   c.s.executeUpdate(query);
                   
                   setVisible(false);
                   signUpTwo s2 = new signUpTwo(formNo,name);
                   s2.setVisible(true);
                   
               }
               
           }catch(Exception e){
               System.out.println(e);
           }
       }
   
   
    
    public static void main(String args[]) {
       new SignUpOne();
    }
}
