
package employee.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils; //You use it to convert a ResultSet (from a database query) into a TableModel that can be set to a JTable.

public class ViewEmployee extends JFrame implements ActionListener{
    JTable table;
    Choice employeeId;
    JButton search,print,update,back;
    ViewEmployee(){
    
        
    getContentPane().setBackground(Color.white);
    setLayout(null);
    
    
    JLabel searchlbl=new JLabel("Search by Employee id");
    searchlbl.setBounds(20,20,150,20);
    add(searchlbl);
    
    employeeId= new Choice();
    employeeId.setBounds(180,20,150,20);
    add(employeeId);
    
     try{
        
        Conn c = new Conn(); //Connecting with conn file
        ResultSet rs = c.st.executeQuery("Select * from employee");
        while(rs.next()){
            
            employeeId.add(rs.getString("empId"));
            
        }
    }catch(Exception e){
        e.printStackTrace();
        
        
    }
    
    
    table = new JTable();
    
    try{
        
        Conn c = new Conn(); //Connecting with conn file
        ResultSet rs = c.st.executeQuery("Select * from employee");
        table.setModel(DbUtils.resultSetToTableModel(rs));  // all result will be shown in the table using the library dbutils
        
        //in java scrollbar cant be direct so u have to write a class
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
    }catch(Exception e){
        e.printStackTrace();
        
        
    }
    
    search = new JButton("Search");
    search.setBounds(20,70,80,20);
    search.addActionListener(this);
    add(search);
    
    
    
    print = new JButton("Print");
    print.setBounds(120,70,80,20);
    print.addActionListener(this);
    add(print);
    
    
    
    update = new JButton("update");
    update.setBounds(220,70,80,20);
    update.addActionListener(this);
    add(update);
    
    
    
    back = new JButton("back");
    back.setBounds(320,70,80,20);
    back.addActionListener(this);
    add(back);
    
    setSize(900,700);
    setLocation(300,100);
    setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query = "select * from employee where empId='"+employeeId.getSelectedItem()+"'";
            
            //remeber whenever u try to hit ur sql command make a try and catch block for handling the exception 
            try{
                Conn c = new Conn();
                ResultSet rs = c.st.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
              e.printStackTrace();
            }
            
            
        }else if(ae.getSource()==print){
            
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==update){
            
            setVisible(false);
            new UpdateEmployee(employeeId.getSelectedItem());
            
        }else{
            setVisible(false);
            new Home();
        }
        
    }
    
    public static void main(String [] args){
        new ViewEmployee();
    }
}
