package com.hotel.hotelmngsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;

import javax.swing.*;

import Services.driverService;
import Services.guestService;
import Services.pickupService;
import model.Driver;
import model.Guest;
import model.PickUp;

public class addPickUp extends JFrame implements ActionListener {
	
	JButton back,spbtn;
	JTextField textFieldlocation;
	Choice c ,g;
	driverService ds =  new driverService();
	guestService gs = new guestService();
	
	addPickUp(){
		
		JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(5,5,840,538);
        panel.setLayout(null);
        add(panel);
        
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/driver.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,150,300,300);
        panel.add(label);

        JLabel pus = new JLabel("Add Car Service");
        pus.setBounds(120,50,160,25);
        pus.setForeground(Color.WHITE);
        pus.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(pus);

        JLabel drivername = new JLabel("Driver Name : ");
        drivername.setBounds(32,97,150,14);
        drivername.setForeground(Color.WHITE);
        drivername.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(drivername);

        c= new Choice();
        c.setBounds(250,94,150,25);
        panel.add(c);

        try{
        	List<Driver> resultSet = ds.getAllDriver();
            for(Driver driver:resultSet){
            	c.add(driver.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel guestname = new JLabel("Guest Name : ");
        guestname.setBounds(32,150,150,14);
        guestname.setForeground(Color.WHITE);
        guestname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(guestname);

        g = new Choice();
        g.setBounds(250,150,150,25);
        panel.add(g);

        try{
        	
        	List<Guest> resultSet = gs.getAllGuests();
            for(Guest guest:resultSet){
            	g.add(String.valueOf(guest.getName()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel labelLocation = new JLabel("Guest Location :");
        labelLocation.setBounds(35,200,250,20);
        labelLocation.setForeground(Color.WHITE);
        labelLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelLocation);
        
        textFieldlocation = new JTextField();
        textFieldlocation.setBounds(250,200,150,20);
        panel.add(textFieldlocation);
        
        spbtn = new JButton("PickUP");
        spbtn.setBounds(80,300,120,30);
        spbtn.setForeground(Color.WHITE);
        spbtn.setBackground(Color.BLACK);
        spbtn.addActionListener(this);
        panel.add(spbtn);
        
        back = new JButton("BACK");
        back.setBounds(230,300,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);
        
        setUndecorated(true);
        setLayout(null);
        setLocation(500,150);
        setSize(850,550);
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == back) {
	            setVisible(false);dispose();
	        }else if(e.getSource() == spbtn) {
	        	String loc = textFieldlocation.getText();
	        	String drivername = c.getSelectedItem();
	        	int guest_id = gs.getGuestId(g.getSelectedItem());
	        	
	        	Driver driver = ds.getDriverByName(drivername);
	        	Guest guest = gs.getGuestById(guest_id);
	        	
	        	pickupService ps = new pickupService();
	        	PickUp pickup = new PickUp();
	        	pickup.setDriver(driver);
	        	pickup.setDlocation(driver.getLocation());
	        	pickup.setGlocation(loc);
	        	pickup.setGuest(guest);
	        	ps.addPickUp(pickup);
	        	
	        	
	        	JOptionPane.showMessageDialog(null,"Car Send to PickUP");
	        	dispose();
	        }
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void main(String args[]){
		new addPickUp();
	}

}
