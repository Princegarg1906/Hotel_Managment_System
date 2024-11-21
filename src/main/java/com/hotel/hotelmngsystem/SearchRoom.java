package com.hotel.hotelmngsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Services.roomService;
import model.Rooms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchRoom extends JFrame implements ActionListener {
    JCheckBox checkBox;
    Choice choice;
    JTable table;
    JButton search, back, check;
    roomService rs =  new roomService();
    DefaultTableModel model;
    
    SearchRoom(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        add(panel);

        JLabel searchForRoom = new JLabel("Search For Room");
        searchForRoom.setBounds(250,11,186,31);
        searchForRoom.setForeground(Color.WHITE);
        searchForRoom.setFont(new Font("Tahoma", Font.BOLD,20));
        panel.add(searchForRoom);

        JLabel rbt = new JLabel("Room Bed Type:");
        rbt.setBounds(50,73,120,20);
        rbt.setForeground(Color.WHITE);
        rbt.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(rbt);

        JLabel rn = new JLabel("Room Number");
        rn.setBounds(23,162,150,20);
        rn.setForeground(Color.WHITE);
        rn.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(rn);

        JLabel available = new JLabel("Availability");
        available.setBounds(175,162,150,20);
        available.setForeground(Color.WHITE);
        available.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(available);

        JLabel price = new JLabel("Price");
        price.setBounds(458,162,150,20);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(price);

        JLabel BT = new JLabel("Bed Type");
        BT.setBounds(580,162,150,20);
        BT.setForeground(Color.WHITE);
        BT.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(BT);

        JLabel status = new JLabel("Status");
        status.setBounds(306,162,150,20);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(status);



        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(400,69,205,23);
        checkBox.setForeground(Color.WHITE);
        checkBox.setBackground(Color.DARK_GRAY);
        panel.add(checkBox);

        choice = new Choice();
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.setBounds(170,70,120,20);
        panel.add(choice);

        model  = new DefaultTableModel(new String[]{"Room Number","Availabilty","Price","Status","Bed Type"},0);
        table = new JTable();
        table.setBounds(0,187,700,150);
        table.setBackground(Color.DARK_GRAY);
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            List<Rooms> resultSet = rs.getAllRooms();
            for(Rooms r:resultSet) {
            model.addRow(new Object[]{r.getRoom_number(),r.getAvalibilty(),r.getPrice(),r.getStatus(),r.getType()});
            }
            table.setModel(model);
        }catch (Exception e ){
            e.printStackTrace();
        }


        search = new JButton("Search");
        search.setBounds(200,400,120,30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        panel.add(search);
        
        back = new JButton("Back");
        back.setBounds(360,400,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);


        setUndecorated(true);
        setLayout(null);
        setLocation(500,200);
        setSize(700,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==search){
        	List<Rooms> list = rs.getAllRooms();
            String Q1 = "select * from Room where availability = 'Available'  And bed_type = '"+choice.getSelectedItem()+"'";
            try{
            	model.setRowCount(0);
                List<Rooms> resultSet = rs.getAllRooms();
                for(Rooms r:resultSet) {
                	String check = choice.getSelectedItem();
                	if(check.equalsIgnoreCase(r.getType())) {
                		model.addRow(new Object[]{r.getRoom_number(),r.getAvalibilty(),r.getPrice(),r.getStatus(),r.getType()});
                	}
                }
                	if (checkBox.isSelected()) {
                		model.setRowCount(0);
                		for(Rooms r:resultSet) {
                        	String check = choice.getSelectedItem();
                        	if(check.equalsIgnoreCase(r.getType()) && "Available".equalsIgnoreCase(r.getAvalibilty())) {
                        		model.addRow(new Object[]{r.getRoom_number(),r.getAvalibilty(),r.getPrice(),r.getStatus(),r.getType()});
                        	}
                	}
                }
                table.setModel(model);
            }catch (Exception ex ){
                ex.printStackTrace();
            }
        }else {
            setVisible(false);dispose();
        }

    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}