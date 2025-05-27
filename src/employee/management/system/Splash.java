
package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; // for importing jframes
 
public class Splash extends JFrame implements ActionListener {
//ActionListener is an interface in Java used to handle events like button clicks,
    Splash(){ // creating constructor because i want to use to see the frame just after calling the main method
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("Serif",Font.PLAIN,60));
        heading.setForeground(Color.red);
        add(heading);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2= i1.getImage().getScaledInstance(1100, 700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400,400,300,70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image.add(clickhere);
      
        setSize(1170,650);
        setLocation(200,50); //y default frame will open from top so we set the location 
        setVisible(true);
        
        
        while(true){                        //for making heading in dipper format
            heading.setVisible(false);
            try{
                Thread.sleep(500);          // timing set for heading
                }catch(Exception e){
                    
                }
            heading.setVisible(true);    //when you pause or delay execution using Thread.sleep(), it must be enclosed in a try-catch block
            try{                                // because it can throw an exception called InterruptedException.
                Thread.sleep(500);
                }catch(Exception e){
                    
                }
        }
        
    }
    //override the method action supplier because splash is not an absttract method
    public void actionPerformed(ActionEvent ae){
        
      setVisible(false);//telling button to cross this page using actionevent
      new Login();
    }
    public static void main(String args[]){
    new Splash(); // creating oject and this object will create default constructor by jvm 
                   // if u dont create the constructor
    }
    
    }

