package com.hotel.hotelmngsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.List;
import Services.roomService;
import model.Rooms;


public class roomInfo extends JFrame implements ActionListener{
	
	JTable table;
    JButton back,print;

    roomInfo(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,300,300);
        panel.add(label);
        
        DefaultTableModel model  = new DefaultTableModel(new String[]{"Room Number","Availabilty","Price","Status","Bed Type"},0);
        table = new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(Color.DARK_GRAY);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(table);
//        model.addRow(new String[]{"Room Number","Availabilty","Status","Price","Bed Type"});
        try{
            roomService rs =  new roomService();
            List<Rooms> resultSet = rs.getAllRooms();
            for(Rooms r:resultSet) {
            model.addRow(new Object[]{r.getRoom_number(),r.getAvalibilty(),r.getPrice(),r.getStatus(),r.getType()});
            }
            table.setModel(model);
        }catch (Exception e ){
            e.printStackTrace();
        }


        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,120,30);
        back.addActionListener(this);
        panel.add(back);
        
        print = new JButton("PRINT");
        print.setBounds(350,500,120,30);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        panel.add(print);
        

        JLabel room = new JLabel("Room No.");
        room.setBounds(10,15,80,19);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(room);


        JLabel availability = new JLabel("Availability");
        availability.setBounds(110,15,80,19);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(availability);

        JLabel Status = new JLabel("Status");
        Status.setBounds(315,15,80,19);
        Status.setForeground(Color.WHITE);
        Status.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Status);


        JLabel Price = new JLabel("Price");
        Price.setBounds(210,15,150,19);
        Price.setForeground(Color.WHITE);
        Price.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Price);

        JLabel Bed = new JLabel("Bed Type");
        Bed.setBounds(410,15,80,19);
        Bed.setForeground(Color.WHITE);
        Bed.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Bed);


        setUndecorated(true);
        setLayout(null);
        setLocation(500,100);
        setSize(900,600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new roomInfo();
    }
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(false);dispose();
		}else if(ae.getSource() == print) {
			try {
				table.print();
			} catch (PrinterException e) {
				e.printStackTrace();
			}
		}
		
	}

}
