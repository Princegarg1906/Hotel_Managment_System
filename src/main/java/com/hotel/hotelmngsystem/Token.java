package com.hotel.hotelmngsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Services.LoginRegisterService;

public class Token extends JFrame implements ActionListener {

	JTextField tokentft;
	JButton registerbtn,cancelbtn;
	int chance=3;
	private String email,username,password,role;
	Token(String email,String username,String password,String role){
		super("King Hotel System");
		
		this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
		
		int top_margin = 20;    	
    	int top = top_margin+20;
    	int left_label = 40;
    	int left_field = 170;
    	int gap = 50;
		
		JLabel token_label = new JLabel("Enter the OTP : ");
        token_label.setBounds(left_label,top-3,150,30);
        token_label.setFont(new Font("Tahoma",Font.BOLD,14));
        token_label.setForeground(Color.WHITE);
        add(token_label);
        
        tokentft = new JTextField();
        tokentft.setBounds(left_field,top,100,25);
        tokentft.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(tokentft);
        
        registerbtn = new JButton("Register");
        registerbtn.setBounds(40,top+gap,120,30);
        registerbtn.setFont(new Font("serif", Font.BOLD, 15));
        registerbtn.setBackground(Color.BLACK);
        registerbtn.setForeground(Color.WHITE);
        registerbtn.addActionListener(this);
        add(registerbtn);
        
        cancelbtn = new JButton("Cancel");
        cancelbtn.setBounds(180,top+gap,120,30);
        cancelbtn.setFont(new Font("serif", Font.BOLD, 15));
        cancelbtn.setBackground(Color.BLACK);
        cancelbtn.setForeground(Color.WHITE);
        cancelbtn.addActionListener(this);
        add(cancelbtn);
		
		getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(null);
        setLocation(550,280);
        setSize(370,170);
        setVisible(true);
	}


	public static void main(String[] args) {
		new Token("japiyan950@cpaurl.com","kajal","1234","Staff");
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == cancelbtn) {
	    	dispose();
	    	new Register();
	    }else if (ae.getSource() == registerbtn){
            boolean useradd = false;
            String tokenText = tokentft.getText();
            System.out.println(tokenText);
            useradd = LoginRegisterService.newregister(this.email, this.username, this.password, this.role,tokenText);
            if(useradd) {
            	setVisible(false);dispose();
            	JOptionPane.showMessageDialog(null,"User Added Succesfully");
            	new Login();
            }else {
            	if(chance<=1) {
                	JOptionPane.showMessageDialog(null,"Trial Limit Exeed");
                	System.exit(ABORT);
                }else {
                	--chance;
                	JOptionPane.showMessageDialog(null,"INVALID OTP"+
                										"Trial Left:"+chance);
                }
            	}
            
	    }
		
	}
}
