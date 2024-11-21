package com.hotel.hotelmngsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardAdmin extends JFrame implements ActionListener {
	
	JButton add_Employee, add_Room, add_Drivers, logout, exit,Dashback, update_Employee, delete_Employee, update_Room, delete_Room, update_Drivers, delete_Drivers;
	JPanel cpanel;
    public DashboardAdmin(){
    	super("King Hotel System - Admin Access");
    	
    	cpanel = new JPanel();
        cpanel.setLayout(null);
        cpanel.setBounds(250,100,1000,550);
        cpanel.setBackground(Color.decode("#EFDFBB"));
        add(cpanel);
        
    	
    	int left=220;
    	int top=90;
    	int gap=160;

        add_Employee = new JButton( "ADD EMPLOYEE");
        add_Employee.setBounds(left,top-50,200,30);
        add_Employee.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_Employee.addActionListener(this);
        cpanel.add(add_Employee);
        
        update_Employee = new JButton( "UPDATE EMPLOYEE");
        update_Employee.setBounds(left,top,200,30);
        update_Employee.setFont(new Font("Tahoma", Font.BOLD, 15));
        update_Employee.addActionListener(this);
//        cpanel.add(update_Employee);
        
        delete_Employee = new JButton( "DELETE EMPLOYEE");
        delete_Employee.setBounds(left,top+50,200,30);
        delete_Employee.setFont(new Font("Tahoma", Font.BOLD, 15));
        delete_Employee.addActionListener(this);
//        cpanel.add(delete_Employee);
        

        add_Room = new JButton( "ADD ROOM");
        add_Room.setBounds(left,top+gap-50,200,30);
        add_Room.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_Room.addActionListener(this);
        cpanel.add(add_Room);
        
        update_Room = new JButton( "UPDATE ROOM");
        update_Room.setBounds(left,top+gap,200,30);
        update_Room.setFont(new Font("Tahoma", Font.BOLD, 15));
        update_Room.addActionListener(this);
//        cpanel.add(update_Room);
        
        delete_Room = new JButton( "DELETE ROOM");
        delete_Room.setBounds(left,top+50+gap,200,30);
        delete_Room.setFont(new Font("Tahoma", Font.BOLD, 15));
        delete_Room.addActionListener(this);
//        cpanel.add(delete_Room);

        add_Drivers = new JButton( "ADD DRIVERS");
        add_Drivers.setBounds(left,top-50+gap*2,200,30);
        add_Drivers.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_Drivers.addActionListener(this);
        cpanel.add(add_Drivers);
        
        update_Drivers = new JButton( "UPDATE DRIVER");
        update_Drivers.setBounds(left,top+gap*2,200,30);
        update_Drivers.setFont(new Font("Tahoma", Font.BOLD, 15));
        update_Drivers.addActionListener(this);
//        cpanel.add(update_Drivers);
        
        delete_Drivers = new JButton( "DELETE DRIVER");
        delete_Drivers.setBounds(left,top+50+gap*2,200,30);
        delete_Drivers.setFont(new Font("Tahoma", Font.BOLD, 15));
        delete_Drivers.addActionListener(this);
//        cpanel.add(delete_Drivers);
        
        Dashback = new JButton( "Dashboard");
        Dashback.setBounds(1020,720,150,30);
        Dashback.setBackground(Color.BLACK);
        Dashback.setForeground(Color.WHITE);
        Dashback.setFont(new Font("Tahoma", Font.BOLD, 15));
        Dashback.addActionListener(this);
        add(Dashback);

        logout = new JButton( "Logout");
        logout.setBounds(1200,720,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma", Font.BOLD, 15));
        logout.addActionListener(this);
        add(logout);

        exit = new JButton( "Exit");
        exit.setBounds(1300,720,95,30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Tahoma", Font.BOLD, 15));
        exit.addActionListener(this);
        add(exit);


        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icons/employees.png"));
        Image l11 = l1.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(l11);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(50,50,120,120);
        cpanel.add(label);
//
        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/room2.jpg"));
        Image image = imageIcon1.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(50,210,120,120);
        cpanel.add(label1);
        
        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icons/driver.png"));
        Image image1 = imageIcon2.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon12 = new ImageIcon(image1);
        JLabel label2 = new JLabel(imageIcon12);
        label2.setBounds(50,370,120,120);
        cpanel.add(label2);
        
        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icons/hoto_logo2.png"));
        Image image2 = imageIcon3.getImage().getScaledInstance(400,400, Image.SCALE_DEFAULT);
        ImageIcon imageIcon13 = new ImageIcon(image2);
        JLabel label3 = new JLabel(imageIcon13);
        label3.setBounds(500,50,400,400);
        cpanel.add(label3);
        
        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel.jpg"));
        Image image3 = imageIcon4.getImage().getScaledInstance(1450,800, Image.SCALE_DEFAULT);
        ImageIcon imageIcon14 = new ImageIcon(image3);
        JLabel label4 = new JLabel(imageIcon14);
        label4.setBounds(0,0,1450,800);
        add(label4);


        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        setSize(1450,800); //1950
        setLocationRelativeTo(null);
        setVisible(true);
    }
	
	public static void main(String args[]) {
		new DashboardAdmin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add_Employee) {
            new AddEmployee();
        } else if (e.getSource() == add_Room) {
            new AddRoom();
        } else if (e.getSource() ==  add_Drivers) {
            new addDriver();
        } else if (e.getSource() == logout){
        	new Login();
            setVisible(false);dispose();
        } else if (e.getSource() == exit) {
        	System.exit(102);
        }else if(e.getSource() == Dashback) {
        	setVisible(false);dispose();
        	new Dashboard();
        }
		
	}

}
