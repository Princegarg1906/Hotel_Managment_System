package com.hotel.hotelmngsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;


import Services.guestService;
import Services.reservationService;
import Services.roomService;
import model.Guest;
import model.Reservation;
import model.Rooms;

import java.util.Date;
import java.util.List;

public class addGuest extends JFrame implements ActionListener{
	JComboBox comboBox;
    JTextField textFieldNumber ,TextName, TextCountry,TextPhone;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    Date date1;
    JButton add,back;
    addGuest(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,838,540);
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imglabel = new JLabel(imageIcon1);
        imglabel.setBounds(550,150,200,200);
        panel.add(imglabel);

        JLabel labelName = new JLabel("NEW GUEST FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma", Font.BOLD,20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35,76,200,14);
        labelID.setForeground(Color.WHITE);
        labelID.setBackground(Color.white);
        labelID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelID);

        comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving License"});
        comboBox.setBounds(271,73,150,20);
//        comboBox.setBackground(Color.GRAY);
//        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelNumber);
        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);

        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(35,151,200,14);
        labelname.setForeground(Color.WHITE);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelname);
        TextName = new JTextField();
        TextName.setBounds(271,151,150,20);
        panel.add(TextName);


        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35,191,200,14);
        labelGender.setForeground(Color.WHITE);
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(Color.GRAY);
        r1.setBounds(271,191,80,30);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(Color.GRAY);
        r2.setBounds(350,191,80,30);
        panel.add(r2);

        JLabel labelCountry = new JLabel("Country :");
        labelCountry.setBounds(35,231,200,14);
        labelCountry.setForeground(Color.WHITE);
        labelCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelCountry);
        TextCountry = new JTextField();
        TextCountry.setBounds(271,231,150,20);
        panel.add(TextCountry);


        JLabel labelRoom = new JLabel("Allocated Room Number :");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setForeground(Color.WHITE);
        labelRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelRoom);

        c1 = new Choice();
        try{
        	roomService roomservice = new roomService();
        	List<Rooms> list = roomservice.getAllRooms();
            for(Rooms l:list) {
            	if(l.getAvalibilty().equalsIgnoreCase("Available")) {
            		c1.add(l.getRoom_number()); }
//            	System.out.println(l.getAvalibilty());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        c1.setBounds(271,274,150,30);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
//        c1.setForeground(Color.WHITE);
//        c1.setBackground(Color.GRAY);
        panel.add(c1);

        JLabel labelCIS = new JLabel("Checked-In :");
        labelCIS.setBounds(35,316,200,14);
        labelCIS.setForeground(Color.WHITE);
        labelCIS.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelCIS);

        date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271,316,200,14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(date);


        JLabel labelPhone = new JLabel("Phone Number :");
        labelPhone.setBounds(35,359,200,14);
        labelPhone.setForeground(Color.WHITE);
        labelPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelPhone);
        TextPhone = new JTextField();
        TextPhone.setBounds(271,359,150,20);
        panel.add(TextPhone);

        add = new JButton("ADD");
        add.setBounds(100,430,120,30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(260,430,120,30);
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

    public static void main(String[] args) {
        new addGuest();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add){
            String radioBTn = null;
            if (r1.isSelected()){
                radioBTn = "Male";
            } else if (r2.isSelected()) {
                radioBTn = "Female";
            }

            String id_type = (String)comboBox.getSelectedItem();
            String id_number =  textFieldNumber.getText();
            String name =  TextName.getText();
            String gender =  radioBTn;
            String country =  TextCountry.getText();
            String room_num =  c1.getSelectedItem();
            String checkin_date =  date.getText();
            String phone = TextPhone.getText();

            try {
            	Guest guest = new Guest(id_type,id_number,name,gender,country,room_num,checkin_date,phone);
                guestService guestservice = new guestService();
                roomService rs = new roomService();
                
                //reservation
                reservationService reservationservice = new reservationService();
                Rooms room = rs.getRoomsByNumber(room_num);
                guestservice.addGuest(guest);
                if (room != null && guest != null) {
                    Reservation reservation = new Reservation();
                    reservation.setRoom(room);
                    reservation.setGuest(guest);
                    reservation.setCheckInDate(date1);
                    reservationservice.addReservation(reservation);
                }
                room = rs.getRoomsByNumber(room_num);
                room.setAvalibilty("Occupied");
                rs.updateRooms(room);
                JOptionPane.showMessageDialog(null, "added Successfully");
                setVisible(false);dispose();
            }catch (Exception E) {
                E.printStackTrace();
            }
        }else if(e.getSource() == back) {
            setVisible(false);dispose();
        }
		
	}
}
