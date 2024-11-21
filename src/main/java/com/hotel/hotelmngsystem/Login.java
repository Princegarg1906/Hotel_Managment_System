package com.hotel.hotelmngsystem;

import javax.swing.*;

import Services.LoginRegisterService;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JTextField usernametft;
    JPasswordField passwordtft;
    JButton loginbtn,cancelbtn,registerbtn;
    JComboBox<String> role;

    Login(){
    	super("Login IN");
    	
    	int top_margin = 20;    	
    	int top = top_margin+20;
    	int left_label = 40;
    	int left_field = 150;
    	int gap = 50;
    	
        JLabel username_label = new JLabel("Username");
        username_label.setBounds(left_label,top,100,30);
        username_label.setFont(new Font("Tahoma",Font.BOLD,16));
        username_label.setForeground(Color.WHITE);
        add(username_label);

        JLabel password_label = new JLabel("Password");
        password_label.setBounds(left_label,top+gap,100,30);
        password_label.setFont(new Font("Tahoma",Font.BOLD,16));
        password_label.setForeground(Color.WHITE);
        add(password_label);

        usernametft = new JTextField();
        usernametft.setBounds(left_field,top,150,30);
        usernametft.setFont(new Font("Tahoma", Font.PLAIN,15));
        add(usernametft);

        passwordtft = new JPasswordField();
        passwordtft.setBounds(left_field,top+gap,150,30);
        add(passwordtft);
        
        
        JLabel role_label = new JLabel("Role");
        role_label.setBounds(left_label,top+gap*2,100,30);
        role_label.setFont(new Font("Tahoma",Font.BOLD,16));
        role_label.setForeground(Color.WHITE);
        add(role_label);
        
        String[] Roles = {"Admin","Staff","Other"};
        role = new JComboBox<String>(Roles);
        role.setBounds(left_field, top+gap*2, 120, 30);
        add(role);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(150,150,Image.SCALE_AREA_AVERAGING);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(378,20,150,150);
        add(label);

        loginbtn = new JButton("Login");
        loginbtn.setBounds(40,top+gap*3,120,30);
        loginbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        loginbtn.setBackground(Color.BLACK);
        loginbtn.setForeground(Color.WHITE);
        loginbtn.addActionListener(this);
        add(loginbtn);

        cancelbtn = new JButton("Cancel");
        cancelbtn.setBounds(180,top+gap*3,120,30);
        cancelbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancelbtn.setBackground(Color.BLACK);
        cancelbtn.setForeground(Color.WHITE);
        cancelbtn.addActionListener(this);
        add(cancelbtn);
        
        registerbtn = new JButton("Register");
        registerbtn.setBounds(180+140,top+gap*3,120,30);
        registerbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        registerbtn.setBackground(Color.BLACK);
        registerbtn.setForeground(Color.WHITE);
        registerbtn.addActionListener(this);
        add(registerbtn);


        getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(null);
        setLocation(400,270);
        setSize(600,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginbtn){
        	String username = usernametft.getText();
            String password = passwordtft.getText();
            String Role = (String) role.getSelectedItem();
            String checkLogin = LoginRegisterService.login(username,password,Role);

            if(checkLogin == null) {
                JOptionPane.showMessageDialog(null,"Invalid Username and Password");
    			new Login();
                setVisible(false);dispose();
            }else if(checkLogin.equalsIgnoreCase("norole")) {
            	JOptionPane.showMessageDialog(null,"Not Registered for this role");
            	new Login();
                setVisible(false);dispose();
            }
            else if (checkLogin.equalsIgnoreCase("Admin")) {
            	new DashboardAdmin();
            	setVisible(false);dispose();
				JOptionPane.showMessageDialog(null,"Admin Login Success");
            }else {
            	new Dashboard();
				setVisible(false);dispose();
				JOptionPane.showMessageDialog(null,"Login Success");
            }

        }else if(ae.getSource() == cancelbtn) {
        	setVisible(false);dispose();
        	System.exit(100);
        }
        else if(ae.getSource() == registerbtn){
        	setVisible(false);dispose();
        	new Register();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

