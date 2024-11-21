package com.hotel.hotelmngsystem;


import javax.swing.*;

import Services.guestService;
import Services.pickupService;
import Services.reservationService;
import Services.roomService;
import model.Guest;
import model.PickUp;
import model.Reservation;
import model.Rooms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.List;


public class checkOut extends JFrame implements ActionListener{
	JButton back,checkOut;
	guestService gs = new guestService();
	JComboBox Customer;
	JLabel labelRoomnumber,labelname,labelcheckintime;
	Date date;
	
	checkOut(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,490);
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100,20,200,30);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel guestId = new JLabel("Guest Id : ");
        guestId.setBounds(30,80,150,30);
        guestId.setFont(new Font("Tahoma",Font.BOLD,14));
        guestId.setForeground(Color.WHITE);
        panel.add(guestId);
        
        List<Guest> list = gs.getAllGuests();
    	String[] s=new String[list.size()];
        try{
        	
        	int i=0;
            for(Guest guest:list) {
            	String id = String.valueOf(guest.getId());
            	s[i]=id;
            	i++;
            }  
        }catch (Exception E){
            E.printStackTrace();
        }
        
        Customer = new JComboBox(s);
        Customer.setBounds(200,80,150,25);
        panel.add(Customer);
        
        
        
        Customer.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent ie) {
        		int id = Integer.parseInt((String) Customer.getSelectedItem());
    			Guest guest = gs.getGuestById(id);
    			labelname.setText(guest.getName());
    			labelRoomnumber.setText(guest.getRoom());
    			labelcheckintime.setText(guest.getDate());
        	}
        });

        
        
        JLabel name = new JLabel("Guest Name : ");
        name.setBounds(30,130,150,30);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setForeground(Color.WHITE);
        panel.add(name);

        labelname = new JLabel();
        labelname.setBounds(200,130,150,30);
        labelname.setFont(new Font("Tahoma",Font.BOLD,14));
        labelname.setForeground(Color.WHITE);
        panel.add(labelname);

        JLabel roomNum = new JLabel("Room Number : ");
        roomNum.setBounds(30,180,150,30);
        roomNum.setFont(new Font("Tahoma",Font.BOLD,14));
        roomNum.setForeground(Color.WHITE);
        panel.add(roomNum);

        labelRoomnumber = new JLabel();
        labelRoomnumber.setBounds(200,180,150,30);
        labelRoomnumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoomnumber.setForeground(Color.WHITE);
        panel.add(labelRoomnumber);

        JLabel checkintime = new JLabel("Check-In Time : ");
        checkintime.setBounds(30,230,150,30);
        checkintime.setFont(new Font("Tahoma",Font.BOLD,14));
        checkintime.setForeground(Color.WHITE);
        panel.add(checkintime);

        labelcheckintime  = new JLabel();
        labelcheckintime.setBounds(200,230,200,30);
        labelcheckintime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelcheckintime.setForeground(Color.WHITE);
        panel.add(labelcheckintime);

        JLabel checkouttime = new JLabel("Check-Out Time : ");
        checkouttime.setBounds(30,280,150,30);
        checkouttime.setFont(new Font("Tahoma",Font.BOLD,14));
        checkouttime.setForeground(Color.WHITE);
        panel.add(checkouttime);

        date = new Date();

        JLabel labelcheckouttime = new JLabel(""+date);
        labelcheckouttime.setBounds(200,280,200,30);
        labelcheckouttime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelcheckouttime.setForeground(Color.WHITE);
        panel.add(labelcheckouttime);
        
        try{
			int id = Integer.parseInt((String) Customer.getSelectedItem());
			Guest guest = gs.getGuestById(id);
			labelname.setText(guest.getName());
			labelcheckintime.setText(guest.getDate());
			labelRoomnumber.setText(guest.getRoom());
        }catch (Exception E){
            E.printStackTrace();
        }
 

        checkOut = new JButton(" Check-Out");
        checkOut.setBounds(30,370,120,30);
        checkOut.setForeground(Color.WHITE);
        checkOut.setBackground(Color.BLACK);
        checkOut.addActionListener(this);
        panel.add(checkOut);



        back = new JButton("Back");
        back.setBounds(170,370,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);
        
        
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/checkout.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imglabel = new JLabel(imageIcon1);
        imglabel.setBounds(450,100,300,200);
        panel.add(imglabel);

        
       
        setUndecorated(true);
        setLayout(null);
        setSize(800,500);
        setLocation(500,210);
        setVisible(true);
        
        
      
    }
    public static void main(String[] args) {
        new checkOut();
    }
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(false);dispose();
		}
		if(ae.getSource() == checkOut) {
			try {
            	int id = Integer.parseInt((String)Customer.getSelectedItem());
            	String roomnum = gs.getGuestById(id).getRoom();
            	reservationService reservationservice = new reservationService();
            	List<Reservation> list = reservationservice.getAllReservations();
            	for(Reservation res:list) {
            		String rnum = res.getRoom().getRoom_number();
            		if(roomnum.equals(rnum)){
//            			String date_check = String.valueOf(res.getCheckInDate());
	            			reservationservice.deleteReservation(res.getId());;
	            			gs.deleteGuest(id);
//	            			System.out.println(res);
	            		}
            		}
            	
            	pickupService ps = new pickupService();
            	List<PickUp> plist = ps.getAllPickUps();
            	for(PickUp pickup:plist) {
            		if(id == pickup.getGuest().getId()){
	            			ps.deletePickUp(pickup.getId());
	            			gs.deleteGuest(id);
	            		}
            		}
            	
            	roomService rs =new roomService();
            	Rooms room = rs.getRoomsByNumber(labelRoomnumber.getText());
            	room.setAvalibilty("Available");
            	rs.updateRooms(room);
            	
                JOptionPane.showMessageDialog(null, "Checkout Done");
                setVisible(false);dispose();
            }catch (Exception E ){
                E.printStackTrace();
            }
		}
		
	}

}
