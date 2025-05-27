
package employee.management.system;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername,tfpassword;  //fields are declaring globally for using this field in another function also
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);
        tfusername= new JTextField();
        tfusername.setBounds(150,20,150,30); // for creating box 
        add(tfusername);
        
        
        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);
        tfpassword= new JTextField();
        tfpassword.setBounds(150,70,150,30); // for creating box 
        add(tfpassword);
        
        JButton login = new JButton("Login");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);      // after clicking button actionPerformed method will be called
        add(login);
      
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2= i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String username = tfusername.getText();
            String password = tfpassword.getText();
            Conn c = new Conn();
            String query = "select * from login where username ='"+username+"' and password='"+password+"'";
            //executing the query with execute query function
           ResultSet rs =  c.st. executeQuery(query); //using this function from create statement
            
           // Checking the value which stored under rs
           if(rs.next()) {
               setVisible(false);
               //Opening the next class after successfully enter in login page
               new Home();
           }
           else{
               JOptionPane.showMessageDialog(null, "Invalid username or password ");  //if value not find
               setVisible(false);
           }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String args[]){
        new Login();
    }
}
