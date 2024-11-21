package com.hotel.hotelmngsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Services.driverService;
import Services.pickupService;
import model.Driver;
import model.Guest;
import model.PickUp;

public class pickUp extends JFrame implements ActionListener{
	
	driverService ds =  new driverService();
	pickupService ps = new pickupService();
	DefaultTableModel model;
    pickUp(){

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(5,5,788,588);
        panel.setLayout(null);
        add(panel);

        JLabel pud = new JLabel("CAR SERVICE DETAILS");
        pud.setBounds(300,10,400,50);
        pud.setForeground(Color.WHITE);
        pud.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(pud);
        
        model  = new DefaultTableModel(new String[]{"driver_id","Name","Phone","guest_id","guestname","Guest_Location","driver_location"},0);
        JTable table = new JTable();
        table.setBounds(5,110,800,250);
        table.setBackground(Color.DARK_GRAY);
        table.setForeground(Color.WHITE);
        panel.add(table);
        
        
        try{
	          List<PickUp> resultSet = ps.getAllPickUps();
	          for(PickUp p:resultSet) {
	        	  Driver d = p.getDriver();
	        	  Guest g = p.getGuest();
	        	  model.addRow(new Object[]{d.getDriver_id(),d.getName(),d.getPhone(),g.getId(),g.getName(),p.getGlocation(),p.getDlocation()});
          }
	          table.setModel(model);
	      }catch (Exception e ){
	          e.printStackTrace();
	      }

        
        JLabel d_id = new JLabel("DriverID");
        d_id.setBounds(24,80,70,14);
        d_id.setForeground(Color.WHITE);
        panel.add(d_id);
        
        
        JLabel name = new JLabel("Name");
        name.setBounds(130,80,46,14);
        name.setForeground(Color.WHITE);
        panel.add(name);


        JLabel company = new JLabel("Phone NO.");
        company.setBounds(250,80,100,14);
        company.setForeground(Color.WHITE);
        panel.add(company);

        JLabel guestname = new JLabel("Guest Name");
        guestname.setBounds(470,80,100,14);
        guestname.setForeground(Color.WHITE);
        panel.add(guestname);
        
        JLabel G_id = new JLabel("GUESTID");
        G_id.setBounds(350,80,100,14);
        G_id.setForeground(Color.WHITE);
        panel.add(G_id);
        
        JLabel gloacation = new JLabel("Guest Loacation");
        gloacation.setBounds(580,80,100,14);
        gloacation.setForeground(Color.WHITE);
        panel.add(gloacation);


        JLabel dloacation = new JLabel("Driver Loacation");
        dloacation.setBounds(700,80,100,14);
        dloacation.setForeground(Color.WHITE);
        panel.add(dloacation);
        


        JButton Back = new JButton("Back");
        Back.setBounds(420,500,120,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);dispose();
            }
        });
        
        

        setUndecorated(true);
        setLayout(null);
        setSize(800,600);
        setLocation(500,100);
        setVisible(true);

}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]) {
		new pickUp();
	}
}