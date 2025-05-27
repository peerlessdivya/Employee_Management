
/**
 For connecting the jdbc u have 5 steps
 * 1) register the driver class
 * 2)Creating the connection String
 * 3) Creating Statement
 * 4) Executing mysql queries
 * 5) Closing the connections
 */
package employee.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Conn {
    
    Connection c;
    //creating connection String where connection is an interface
    Statement st;
    public Conn(){
        try{          //JDBC driver loading can fail (e.g., if the driver isn't in the classpath),
                    //so we catch the exception to avoid a crash
            Class.forName("com.mysql.cj.jdbc.Driver"); // This loads the MySQL JDBC driver so that your Java app can talk to the MySQL database.
            c = DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/employeemanagementsystem", 
             "root", 
             "Divya"
               );
            
           


            st=c.createStatement();
        
        
        }catch(Exception e){
            e.printStackTrace(); //Prints details about any exception for debugging.
        }
    }
    
}
