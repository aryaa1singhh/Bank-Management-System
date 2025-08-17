package bms;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class signUpTwo extends JFrame implements ActionListener{
     
     JComboBox religion1, incomeTF, educationTF,occupationTF;
     JTextField panTF,aadharTF;
     JRadioButton yes, no, yes1,no1;
     JButton next;
     String formNo;
     String name;
     
     signUpTwo(String formNo,String name){
         this.formNo = formNo;
         this.name = name;
         setLayout(null);
         //title
         JLabel title = new JLabel("Page 2 : Additional Details");
         title.setBounds(210, 60, 300,30);
         title.setFont(new Font("Arial", Font.BOLD, 20));
         add(title);
         
        //religion
         JLabel religion = new JLabel("Religion : ");
         religion.setBounds(50,110,150 ,30);
         religion.setFont(new Font("Raleway", Font.BOLD, 16));
         add(religion);
         
         String valReligion[] = {"Hindu","Muslim", "Christian","Sikh","Prefer not to say"};
         religion1 = new JComboBox(valReligion);
         religion1.setBounds(200,110,250 ,30);
         religion1.setFont(new Font("Raleway", Font.BOLD, 16));
         religion1.setBackground(Color.WHITE);
         add(religion1);
         
         //income bracket
         JLabel income = new JLabel("Income : ");
         income.setBounds(50,160,150,30);
         income.setFont(new Font("Raleway", Font.BOLD, 16));
         add(income);
         
         String valInc[] = {"0-1,50,00","1,50,000 - 5,00,000","5,00,000 - 10,00,000","> 10,00,000"};
         incomeTF = new JComboBox(valInc);
         incomeTF.setBounds(200,160,250 ,30);
         incomeTF.setFont(new Font("Raleway", Font.BOLD, 16));
         add(incomeTF);
         
         //education level
         JLabel education = new JLabel("Education : ");
         education.setBounds(50,210,150,30);
         education.setFont(new Font("Raleway", Font.BOLD, 16));
         add(education);
         
         String eduVal[] = {"Non-graduate","Graduate","Post-graduate", "PHd","Others"};
         educationTF = new JComboBox(eduVal);
         educationTF.setBounds(200 ,210, 250,30);
         educationTF.setFont(new Font("Arial", Font.BOLD, 16));
         add(educationTF);
         
         //occupation
         JLabel occupation = new JLabel("Occupation : ");
         occupation.setBounds(50,260,150 ,30);
         occupation.setFont(new Font("Raleway", Font.BOLD, 16));
         add(occupation);
         
         String occVal[] = {"Salaried","Self-employeed","Bussiness","Student","Others"};
         occupationTF = new JComboBox(occVal);
         occupationTF.setBounds(200 ,260, 250,30);
         occupationTF.setFont(new Font("Arial", Font.BOLD, 16));
         add(occupationTF);
         
         //pan number
         JLabel pan = new JLabel("Pan Number : ");
         pan.setBounds(50,310,150 ,30);
         pan.setFont(new Font("Raleway", Font.BOLD, 16));
         add(pan);
         
         panTF = new JTextField();
         panTF.setBounds(200 ,310, 250,30);
         panTF.setFont(new Font("Arial", Font.BOLD, 16));
         add(panTF);
         
         //aadhar card
         JLabel aadhar = new JLabel("Aadhar Number : ");
         aadhar.setBounds(50,360,150 ,30);
         aadhar.setFont(new Font("Raleway", Font.BOLD, 16));
         add(aadhar);
         
         aadharTF = new JTextField();
         aadharTF.setBounds(200 ,360, 250,30);
         aadharTF.setFont(new Font("Arial", Font.BOLD, 16));
         add(aadharTF);
         
         //senior citizen
         JLabel senior = new JLabel("Senior Citizen : ");
         senior.setBounds(50,410,150 ,30);
         senior.setFont(new Font("Raleway", Font.BOLD, 16));
         add(senior);
         
         yes = new JRadioButton("Yes");
         yes.setBounds(200,410,50 ,30);
         add(yes);
         no = new JRadioButton("No");
         no.setBounds(280,410,50 ,30);
         add(no);
         
         ButtonGroup sgroup = new ButtonGroup();
         sgroup.add(yes);
         sgroup.add(no);
         
        
         
         //existing acc
         JLabel existing = new JLabel("Existing Account : ");
         existing.setBounds(50,460,150 ,30);
         existing.setFont(new Font("Raleway", Font.BOLD, 16));
         add(existing);
         
         yes1 = new JRadioButton("Yes");
         yes1.setBounds(200,460,50 ,30);
         add(yes1);
         no1 = new JRadioButton("No");
         no1.setBounds(280,460,50 ,30);
         add(no1);
         
         ButtonGroup egroup = new ButtonGroup();
         egroup.add(yes1);
         egroup.add(no1);
         
         //next button
         
         next = new JButton("Next");
         next.setBounds(500, 540, 80,30);
         next.setFont(new Font("Raleway", Font.BOLD, 16));
         next.setBackground(Color.BLACK);
         next.setForeground(Color.WHITE);
         next.addActionListener(this);
         add(next);
         
        
         //frame settings
        setSize(700, 650);
        setVisible(true);
        setLocation(200, 10);
    
    }
     
     public void actionPerformed(ActionEvent ae){
         String religion = (String)religion1.getSelectedItem();
         String income = (String)incomeTF.getSelectedItem();
         String education = (String)educationTF.getSelectedItem();
         String occupation = (String)occupationTF.getSelectedItem();
         
         String pan = panTF.getText();
         String aadhar = aadharTF.getText();
         
         String senior = null;
         if(yes.isSelected()){
             senior = "yes";
         }else if(no.isSelected()){
             senior = "no";
         }
         
         String existing = null;
         if(yes.isSelected()){
             existing = "yes";
         }else if(no.isSelected()){
             existing = "no";
         }
         
         
         try{
             conn c = new conn();
             String query = "insert into signuptwo values('"+formNo+"','"+name+"','"+religion+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+senior+"','"+existing+"')";
             c.s.executeUpdate(query);
             
             setVisible(false);
             new signUpThree(formNo,name).setVisible(true);
         
            
         }catch(Exception e){
             System.out.println(e);
         }
     }
    
     //JComboBox religion1, incomeTF, educationTF,occupationTF;
     //JTextField panTF,aadharTF;
     //JRadioButton yes, no, yes1,no1;
     //JButton next;
    public static void main(String args[]) {
       new signUpTwo("","");
    }
}
