package com.hotel.hotelmngsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Services.LoginRegisterService;


public class Register extends JFrame implements ActionListener {

	JTextField usernametft,emailtft,tokentft;
    JPasswordField passwordtft;
    JButton registerbtn,cancelbtn,backbtn;
    JComboBox<String> role;

    Register(){
    	super("SIGN UP");
    	
    	int top_margin = 20;    	
    	int top = top_margin+20;
    	int left_label = 40;
    	int left_field = 150;
    	int gap = 50;
    	
    	JLabel email_label = new JLabel("Email");
        email_label.setBounds(left_label,top,100,30);
        email_label.setFont(new Font("Tahoma",Font.BOLD,16));
        email_label.setForeground(Color.WHITE);
        add(email_label);
    	
        JLabel username_label = new JLabel("Username");
        username_label.setBounds(left_label,top+gap,100,30);
        username_label.setFont(new Font("Tahoma",Font.BOLD,16));
        username_label.setForeground(Color.WHITE);
        add(username_label);

        JLabel password_label = new JLabel("Password");
        password_label.setBounds(left_label,top+gap*2,100,30);
        password_label.setFont(new Font("Tahoma",Font.BOLD,16));
        password_label.setForeground(Color.WHITE);
        add(password_label);
       
        
        emailtft = new JTextField();
        emailtft.setBounds(left_field,top,150,30);
        add(emailtft);
        
        usernametft = new JTextField();
        usernametft.setBounds(left_field,top+gap,150,30);
        usernametft.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(usernametft);

        passwordtft = new JPasswordField();
        passwordtft.setBounds(left_field,top+gap*2,150,30);
        passwordtft.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(passwordtft);
        
        
        JLabel role_label = new JLabel("Role");
        role_label.setBounds(left_label,top+gap*3,100,30);
        role_label.setFont(new Font("Tahoma",Font.BOLD,16));
        role_label.setForeground(Color.WHITE);
        add(role_label);
        
        String[] Roles = {"Admin","Staff","Other"};
        role = new JComboBox<String>(Roles);
        role.setBounds(left_field, top+gap*3, 120, 30);
        add(role);
        

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/register.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(150,150,Image.SCALE_AREA_AVERAGING);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(378,40,150,150);
        add(label);


        registerbtn = new JButton("Register");
        registerbtn.setBounds(40,top+gap*4,120,30);
        registerbtn.setFont(new Font("serif", Font.BOLD, 15));
        registerbtn.setBackground(Color.BLACK);
        registerbtn.setForeground(Color.WHITE);
        registerbtn.addActionListener(this);
        add(registerbtn);
        
        backbtn = new JButton("Back");
        backbtn.setBounds(180,top+gap*4,120,30);
        backbtn.setFont(new Font("serif", Font.BOLD, 15));
        backbtn.setBackground(Color.BLACK);
        backbtn.setForeground(Color.WHITE);
        backbtn.addActionListener(this);
        add(backbtn);

        cancelbtn = new JButton("Cancel");
        cancelbtn.setBounds(180+140,top+gap*4,120,30);
        cancelbtn.setFont(new Font("serif", Font.BOLD, 15));
        cancelbtn.setBackground(Color.BLACK);
        cancelbtn.setForeground(Color.WHITE);
        cancelbtn.addActionListener(this);
        add(cancelbtn);
        


        getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(null);
        setLocation(400,270);
        setSize(600,350);
        setVisible(true);
}


	public static void main(String[] args) {
		new Register();

	}


	@Override
	public void actionPerformed(ActionEvent ae) {
	    if (ae.getSource() == registerbtn){
	    	try {
	            boolean useradd = false;
	            boolean userNotExist = false;
	            String email = emailtft.getText();
	            String username = usernametft.getText();
	            String password = passwordtft.getText();
	            String Role = (String) role.getSelectedItem();
	            userNotExist = LoginRegisterService.checkUser(email,username,password);            
	            if(userNotExist){
	            	LoginRegisterService.sendemail(email,username,Role);
	            	JOptionPane.showMessageDialog(null,"Verification Code Send to registered email.");
	            	new Token(email, username, password, Role);
	            	dispose();
	            	}
	            
		    } catch(Exception e) {
		    	e.printStackTrace();
		    }
	    }
	    if (ae.getSource() == backbtn) {
	    	setVisible(false);dispose();
	    	new Login();
	    }
	    if(ae.getSource() == cancelbtn) {
	    	dispose();
	    	System.exit(ABORT);
	    }
    }

}
