package com.hotel.hotelmngsystem;

import javax.swing.*;

import Services.roomService;
import model.Rooms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener {
    JTextField roomnum_tft,roomprice_tft;
    JComboBox roomava_tft,roomstatus_tft,roomtype_tft;
    JButton addroom,back;
    AddRoom(){
    	super("King Hotel System");

        JPanel panel = new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);
        add(panel);

        JLabel l1 = new JLabel("Add Rooms");
        l1.setBounds(194,30,160,22);
        l1.setFont(new Font("Tahoma", Font.BOLD,22));
        l1.setForeground(Color.WHITE);
        panel.add(l1);

        JLabel roomnum_lbl = new JLabel("ROOM NUMBER : ");
        roomnum_lbl.setBounds(64,90,152,22);
        roomnum_lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomnum_lbl.setForeground(Color.WHITE);
        panel.add(roomnum_lbl);
        roomnum_tft =new JTextField();
        roomnum_tft.setBounds(200,90,156,20);
        roomnum_tft.setFont(new Font("Tahoma", Font.PLAIN, 14));;
        panel.add(roomnum_tft);

        JLabel roomava_lbl = new JLabel("AVAILIBLITY : ");
        roomava_lbl.setBounds(64,130,152,22);
        roomava_lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomava_lbl.setForeground(Color.WHITE);
        panel.add(roomava_lbl);

        roomava_tft =new JComboBox(new String[] {"Available", "Occupied"});
        roomava_tft.setBounds(200,130,156,20);
        roomava_tft.setFont(new Font("Tahoma", Font.PLAIN, 14));

        panel.add(roomava_tft);

        JLabel roomprice_lbl = new JLabel("PRICE : ");
        roomprice_lbl.setBounds(64,170,152,22);
        roomprice_lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomprice_lbl.setForeground(Color.WHITE);
        panel.add(roomprice_lbl);

        roomprice_tft =new JTextField();
        roomprice_tft.setBounds(200,170,156,20);
        roomprice_tft.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(roomprice_tft);


        JLabel roomstatus_lbl = new JLabel("STATUS : ");
        roomstatus_lbl.setBounds(64,210,152,22);
        roomstatus_lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomstatus_lbl.setForeground(Color.WHITE);
        panel.add(roomstatus_lbl);

        roomstatus_tft =new JComboBox(new String[]{"Cleaned","Dirty"});
        roomstatus_tft.setBounds(200,210,156,20);
        roomstatus_tft.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(roomstatus_tft);

        JLabel roomtype_lbl = new JLabel("BED TYPE : ");
        roomtype_lbl.setBounds(64,250,152,50);
        roomtype_lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomtype_lbl.setForeground(Color.WHITE);
        panel.add(roomtype_lbl);

        roomtype_tft =new JComboBox(new String[]{"Single Bed","Double Bed"});
        roomtype_tft.setBounds(200,250,156,30);
        roomtype_tft.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        roomtype_tft.setForeground(Color.WHITE);
        panel.add(roomtype_tft);

        addroom = new JButton("Add");
        addroom.setBounds(64,361,111,33);
        addroom.setBackground(Color.BLACK);
        addroom.setForeground(Color.WHITE);
        addroom.addActionListener(this);
        panel.add(addroom);

        back = new JButton("Back");
        back.setBounds(198,361,111,33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/roomser.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);



//        setUndecorated(true);
//        setLocation(60,160);
        setLocation(320,160);
        setLayout(null);
        setSize(885,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addroom){
            try{
                String roomnum = roomnum_tft.getText();
                String ava = (String) roomava_tft.getSelectedItem();
                String status = (String)  roomstatus_tft.getSelectedItem();
                String price = roomprice_tft.getText();
                String type =  (String) roomtype_tft.getSelectedItem();

                try {
	                roomService roomservice = new roomService();
	                Rooms room = new Rooms(roomnum,ava,status,price,type);
	                roomservice.addRoom(room);
	                JOptionPane.showMessageDialog(null,"Room Added");
		            setVisible(false);dispose();
	            }catch(Exception ex) {
	            	JOptionPane.showMessageDialog(null,"Failed");
	            }

//                JOptionPane.showMessageDialog(null,"Room Successfully Added");
//                setVisible(false);dispose();

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);dispose();
        }

    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
