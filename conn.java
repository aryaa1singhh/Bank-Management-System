package bms;
import java.sql.*;
public class conn {
    
    Connection c;
    Statement s;
    public conn(){
    
        
        try{
          //creating connection
          c = DriverManager.getConnection("jdbc:mysql:///bms", "root","arya");
          s = c.createStatement();
        } catch (Exception e){
            System.out.println(e);
        
        }
    }
    
}
