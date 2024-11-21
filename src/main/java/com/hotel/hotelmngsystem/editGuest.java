package com.hotel.hotelmngsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.*;
import Services.guestService;
import Services.roomService;
import model.Guest;
import model.Rooms;

public class editGuest extends JFrame implements ActionListener {
	
	JComboBox comboBox,c1,idchoice;
    JTextField textFieldNumber, TextCountry,TextPhone;
    JLabel date,Gender,name,Room;
    guestService guestservice = new guestService();

    JButton update,back,check;
    editGuest(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,837,540);
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imglabel = new JLabel(imageIcon1);
        imglabel.setBounds(550,150,200,200);
        panel.add(imglabel);
        

        JLabel labelName = new JLabel("EDIT GUEST FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma", Font.BOLD,20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);
        
        JLabel id = new JLabel("GUEST ID : ");
        id.setBounds(35,76,200,14);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(id);
        
        List<Guest> list = guestservice.getAllGuests();
    	String[] s=new String[list.size()];
    	int i=0;
        
        try{
        	List<Guest> resultSet = guestservice.getAllGuests();
            for(Guest guest:resultSet){
            	s[i]=String.valueOf(guest.getId());
            	i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        idchoice = new JComboBox(s);
        idchoice.setBounds(271,73,150,20);
        panel.add(idchoice);

        
        idchoice.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent ie) {
        		try {
            		int id = Integer.parseInt((String)idchoice.getSelectedItem());
    	        	Guest guest = guestservice.getGuestById(id);
    	        	textFieldNumber.setText(guest.getRoom());
    	        	TextCountry.setText(guest.getCountry());
    	        	TextPhone.setText(guest.getPhone());
    	        	Gender.setText(guest.getGender());
    	        	name.setText(guest.getName());
    	        	Room.setText(guest.getRoom());
            	}catch(Exception ex) {
            		ex.printStackTrace();
            	}
        	}
        });

        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35,111,200,14);
        labelID.setForeground(Color.WHITE);
        labelID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelID);

        comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving License"});
        comboBox.setBounds(271,111,150,20);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("ID_Number :");
        labelNumber.setBounds(35,316,200,14);
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelNumber);
        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,316,150,20);
        panel.add(textFieldNumber);

        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(35,191,200,14);
        labelname.setForeground(Color.WHITE);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelname);
        
        name = new JLabel();
        name.setBounds(271,191,200,14);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(name);


        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35,231,200,14);
        labelGender.setForeground(Color.WHITE);
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelGender);
        
        Gender = new JLabel();
        Gender.setBounds(271,231,200,14);
        Gender.setForeground(Color.WHITE);
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(Gender);

        

        JLabel labelCountry = new JLabel("Country :");
        labelCountry.setBounds(35,274,200,14);
        labelCountry.setForeground(Color.WHITE);
        labelCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelCountry);
        TextCountry = new JTextField();
        TextCountry.setBounds(271,274,150,20);
        panel.add(TextCountry);


        JLabel labelRoom = new JLabel("Allocated Room Number :");
        labelRoom.setBounds(35,151,200,14);
        labelRoom.setForeground(Color.WHITE);
        labelRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelRoom);
        
        Room = new JLabel();
        Room.setBounds(271,151,150,20);
        
        Room.setForeground(Color.WHITE);
        Room.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(Room);



        JLabel labelPhone = new JLabel("Phone Number :");
        labelPhone.setBounds(35,359,200,14);
        labelPhone.setForeground(Color.WHITE);
        labelPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelPhone);
        TextPhone = new JTextField();
        TextPhone.setBounds(271,359,150,20);
        panel.add(TextPhone);

        update = new JButton("UPDATE");
        update.setBounds(100,430,120,30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.addActionListener(this);
        panel.add(update);
        
//        check = new JButton("CHECK");
//        check.setBounds(260,430,120,30);
//        check.setForeground(Color.WHITE);
//        check.setBackground(Color.BLACK);
//        check.addActionListener(this);
//        panel.add(check);
        
        

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
        new editGuest();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == update){
			int id = Integer.parseInt((String) idchoice.getSelectedItem());
            String id_type = (String)comboBox.getSelectedItem();
            String id_number =  textFieldNumber.getText();
            String country =  TextCountry.getText();
//            String room_num =  c1.getSelectedItem();
//            String checkin_date =  date.getText();
            String phone = TextPhone.getText();

            try {
                Guest guest = guestservice.getGuestById(id);
//            	roomService rs = new roomService();
//                Rooms preroom = rs.getRoomsByNumber(guest.getRoom());
//                preroom.setAvalibilty("Available");
//                rs.updateRooms(preroom);
                guest.setCountry(country);
//                guest.setDate(checkin_date);
                guest.setId_number(id_number);
                guest.setId_type(id_type);
                guest.setPhone(phone);
//                guest.setRoom(room_num);
                guestservice.updateGuest(guest);
//                Rooms room = rs.getRoomsByNumber(room_num);
//                room.setAvalibilty("Occupied");
//                rs.updateRooms(room);
                JOptionPane.showMessageDialog(null, "Updated Successfully");
                setVisible(false);dispose();
            }catch (Exception E) {
                E.printStackTrace();
            }
        }
		else {
            setVisible(false);dispose();
        }
		
	}

}
