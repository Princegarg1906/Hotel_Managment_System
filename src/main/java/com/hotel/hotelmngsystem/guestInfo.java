package com.hotel.hotelmngsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Services.guestService;
import model.Guest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.List;

public class guestInfo extends JFrame implements ActionListener {
	JTable table;
    JButton back,print;

    guestInfo(){
    	JPanel panel = new JPanel();
        panel.setBounds(5,5,888,590);
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);
        add(panel);

        DefaultTableModel model  = new DefaultTableModel(new String[]{"ID","Number","Name","Gender","Country","Room","Time","Phone"},0);
        JTable table = new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(Color.DARK_GRAY);
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            guestService gs =  new guestService();
            List<Guest> result = gs.getAllGuests();
            for(Guest guest:result) {
            	model.addRow(new Object[]{guest.getId_type(),guest.getId_number(),guest.getName(),guest.getGender(),guest.getCountry(),guest.getRoom(),guest.getDate(),guest.getPhone()});
            }
            table.setModel(model);
        }catch (Exception e ){
            e.printStackTrace();
        }

        JLabel id = new JLabel("ID");
        id.setBounds(25,11,100,14);
        id.setForeground(Color.WHITE);
        id.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(id);

        JLabel number = new JLabel("Number");
        number.setBounds(125,11,100,14);
        number.setForeground(Color.WHITE);
        number.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(number);

        JLabel name = new JLabel("Name");
        name.setBounds(240,11,100,14);
        name.setForeground(Color.WHITE);
        name.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(name);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(350,11,100,14);
        gender.setForeground(Color.WHITE);
        gender.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(gender);

        JLabel country = new JLabel("Country");
        country.setBounds(460,11,100,25);
        country.setForeground(Color.WHITE);
        country.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(country);

        JLabel room = new JLabel("Room");
        room.setBounds(575,11,100,14);
        room.setForeground(Color.WHITE);
        room.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(room);

        JLabel Time = new JLabel("CI Time");
        Time.setBounds(690,11,100,14);
        Time.setForeground(Color.WHITE);
        Time.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(Time);

        JLabel Phone = new JLabel("Phone");
        Phone.setBounds(800,11,100,25);
        Phone.setForeground(Color.WHITE);
        Phone.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(Phone);

        back = new JButton("Back");
        back.setBounds(450,510,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);
        
        print = new JButton("Print");
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
    public static void main(String[] args) {
        new guestInfo();
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
