/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author NEHI
 */
public class Login extends JFrame implements ActionListener {//j means swing class hain
    JButton submit,reset,close;
    JTextField tfusername;
    JPasswordField tfpassword;
    
    
public Login(){
    getContentPane().setBackground(Color.WHITE);//color class ke error kr liye use package awt
    setLayout(null);
    
    JLabel lblusername = new JLabel("UserName");
    lblusername.setBounds(20,20,100,20);//left,top,length of label,height of label
    add(lblusername);
    
    tfusername = new JTextField();
    tfusername.setBounds(130,20,200,20);
    add(tfusername);
    
    
     JLabel lblpassword = new JLabel("Password");
    lblpassword.setBounds(20,60,100,20);//left,top,length of label,height of label
    add(lblpassword);
    
    tfpassword = new JPasswordField();
    tfpassword.setBounds(130,60,200,20);
    add(tfpassword);
    
    reset=new JButton("Reset");
    reset.setBounds(40,120,120,20);
    reset.addActionListener(this);
    add(reset);
   
    submit=new JButton("Submit");
    submit.setBounds(190,120,120,20);
    submit.addActionListener(this);
    add(submit);
   
    close=new JButton("Close");
    close.setBounds(120,160,120,20);
    close.addActionListener(this);
    add(close);
   
    setSize(400, 250);//length,height
    setLocation(600,250);//left,top
setVisible(true);//visible ho jayega frame
}
    
public void actionperformed(ActionEvent ae){
    if(ae.getSource()== submit){
        String username = tfusername.getText();//gettext means value lene ke liye or settext means value set krne ke liye
        String password =tfpassword.getText();
        
        try{
            Conn c =new Conn();
            
            String query= "select * from login where username = '"+username+"' and password = '"+password+"'";
            
           ResultSet rs= c.s.executeQuery(query);
           
           if (rs.next()){
               new Home();
               setVisible(false);
           } else{
                       JOptionPane.showMessageDialog(null,"invalid username or password");
                       setVisible(false);
                       }
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }else if(ae.getSource()== close){
        setVisible(false);
    }else if(ae.getSource()== reset){
        tfusername.setText("");
        tfpassword.setText("");
    }

}
    
   public static void main(String[] args){
       new Login();
}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
