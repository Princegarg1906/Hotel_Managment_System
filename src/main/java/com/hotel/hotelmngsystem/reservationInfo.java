package com.hotel.hotelmngsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Services.reservationService;
import model.Reservation;

public class reservationInfo extends JFrame implements ActionListener {
	
	JButton back,print;
	JTable table;
	
	reservationInfo(){
	
		JPanel panel = new JPanel();
	    panel.setBounds(5,5,888,590);
	    panel.setBackground(Color.DARK_GRAY);
	    panel.setLayout(null);
	    add(panel);
	
	    DefaultTableModel model  = new DefaultTableModel(new String[]{"guestid","GuestName","Roomnumber","checkindate","checkoutdate"},0);
	    table = new JTable();
	    table.setBounds(10,40,900,450);
	    table.setBackground(Color.DARK_GRAY);
	    table.setForeground(Color.WHITE);
	    panel.add(table);
	
	    try{
	        reservationService rs =  new reservationService();
	        List<Reservation> result = rs.getAllReservations();
	        for(Reservation res:result) {
	        	int guest_id = res.getGuest().getId();
	        	String guest_name = res.getGuest().getName();
	        	String roomnum = res.getRoom().getRoom_number();
	        	model.addRow(new Object[]{guest_id,guest_name,roomnum,res.getCheckInDate(),res.getCheckOutDate()});
	        }
	        table.setModel(model);
	    }catch (Exception e ){
	        e.printStackTrace();
	    }
	
	    JLabel gid = new JLabel("GUEST_ID");
	    gid.setBounds(25,11,100,14);
	    gid.setForeground(Color.WHITE);
	    gid.setFont( new Font("Tahoma", Font.BOLD,14));
	    panel.add(gid);
	
	    JLabel name = new JLabel("GUEST_NAME");
	    name.setBounds(200,11,150,14);
	    name.setForeground(Color.WHITE);
	    name.setFont( new Font("Tahoma", Font.BOLD,14));
	    panel.add(name);
	
	    JLabel number = new JLabel("ROOM NUMBER");
	    number.setBounds(380,11,150,14);
	    number.setForeground(Color.WHITE);
	    number.setFont( new Font("Tahoma", Font.BOLD,14));
	    panel.add(number);
	
	    JLabel checkindate = new JLabel("CHECK IN DATE");
	    checkindate.setBounds(570,11,150,14);
	    checkindate.setForeground(Color.WHITE);
	    checkindate.setFont( new Font("Tahoma", Font.BOLD,14));
	    panel.add(checkindate);
	
//	    JLabel checkoutdate = new JLabel("CHECK OUT DATE");
//	    checkoutdate.setBounds(730,11,150,25);
//	    checkoutdate.setForeground(Color.WHITE);
//	    checkoutdate.setFont( new Font("Tahoma", Font.BOLD,14));
//	    panel.add(checkoutdate);
	
	    back = new JButton("Back");
	    back.setBounds(450,510,120,30);
	    back.setBackground(Color.BLACK);
	    back.setForeground(Color.WHITE);
	    back.addActionListener(this);
	    panel.add(back);
	    
	    print = new JButton("PRINT");
        print.setBounds(300,510,120,30);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        panel.add(print);
	
	
	
	    setUndecorated(true);
	    setLayout(null);
	    setSize(900,600);
	    setLocation(500,100);
	    setVisible(true);
	}
    
    public static void main(String args[]) {
    	new reservationInfo();
    }
    
    @Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back){
			setVisible(false);dispose();
			dispose();
		}else if(ae.getSource() == print) {
			try {
				table.print();
			} catch (PrinterException e) {
				e.printStackTrace();
			}
		}
		else {
			dispose();
		}
	}

}
