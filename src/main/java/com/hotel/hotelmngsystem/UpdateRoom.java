package com.hotel.hotelmngsystem;

import javax.swing.*;

import Services.roomService;
import model.Rooms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.List;

public class UpdateRoom extends JFrame implements ActionListener{
	
	roomService rs = new roomService();
	JButton update,back,check;
	JTextField statusText,roomnumberText,typeText,avalibilityText;
	JLabel PreviusRoomnumberlabel,Previusavaliablitylabel,Previus_typelabel,Previustype;
	JLabel Previus_statuslabel ;
	Choice c,typeChoice;

	
	UpdateRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,440);
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);
        add(panel);

        JLabel label1  = new JLabel("Update Room Status");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel Roomnumber  = new JLabel("Room Number :");
        Roomnumber.setBounds(25,88,120,20);
        Roomnumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Roomnumber.setForeground(Color.WHITE);
        panel.add(Roomnumber);

        c = new Choice();
        c.setBounds(248,85,140,20);
        panel.add(c);

        try {
        	List<Rooms> list = rs.getAllRooms();
            for(Rooms room:list){
                c.add(room.getRoom_number());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
        
        JLabel Previusdata = new JLabel("Previous Data");
        Previusdata.setBounds(580,60,250,50);
        Previusdata.setFont(new Font("Tahoma", Font.BOLD, 20));
        Previusdata.setForeground(Color.WHITE);
        panel.add(Previusdata);

        JLabel newRoomnumberlabel  = new JLabel("New Room Number :");
        newRoomnumberlabel.setBounds(25,129,150,14);
        newRoomnumberlabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        newRoomnumberlabel.setForeground(Color.WHITE);
        panel.add(newRoomnumberlabel);
        
        roomnumberText = new JTextField();
        roomnumberText.setBounds(248,129,140,20);
        panel.add(roomnumberText);
        
        JLabel PreviusRoomnumber = new JLabel("Room Number : ");
        PreviusRoomnumber.setBounds(550,129,170,14);
        PreviusRoomnumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        PreviusRoomnumber.setForeground(Color.WHITE);
        panel.add(PreviusRoomnumber);
        
        PreviusRoomnumberlabel = new JLabel();
        PreviusRoomnumberlabel.setBounds(750,129,107,14);
        PreviusRoomnumberlabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        PreviusRoomnumberlabel.setForeground(Color.WHITE);
        panel.add(PreviusRoomnumberlabel);


        JLabel avaliablitylabel  = new JLabel("Availability :");
        avaliablitylabel.setBounds(25,174,97,14);
        avaliablitylabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        avaliablitylabel.setForeground(Color.WHITE);
        panel.add(avaliablitylabel);
        
        avalibilityText = new JTextField();
        avalibilityText.setBounds(248,174,140,20);
        panel.add(avalibilityText);
        
        JLabel Previusavaliablity = new JLabel("Availability :");
        Previusavaliablity.setBounds(550,174,170,14);
        Previusavaliablity.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Previusavaliablity.setForeground(Color.WHITE);
        panel.add(Previusavaliablity);
        
        Previusavaliablitylabel  = new JLabel();
        Previusavaliablitylabel.setBounds(720,174,110,14);
        Previusavaliablitylabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Previusavaliablitylabel.setForeground(Color.WHITE);
        panel.add(Previusavaliablitylabel);


        JLabel statuslabel  = new JLabel("Status :");
        statuslabel.setBounds(25,216,97,14);
        statuslabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        statuslabel.setForeground(Color.WHITE);
        panel.add(statuslabel);
        
        JLabel Previusstatus  = new JLabel("Status :");
        Previusstatus.setBounds(550,216,97,14);
        Previusstatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Previusstatus.setForeground(Color.WHITE);
        panel.add(Previusstatus);
        
        Previus_statuslabel = new JLabel();
        Previus_statuslabel.setBounds(720,216,97,20);
        Previus_statuslabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Previus_statuslabel.setForeground(Color.WHITE);
        panel.add(Previus_statuslabel);

        statusText = new JTextField();
        statusText.setBounds(248,216,140,20);
        panel.add(statusText);
        
        JLabel typelabel  = new JLabel("Room Type :");
        typelabel.setBounds(25,258,97,20);
        typelabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        typelabel.setForeground(Color.WHITE);
        panel.add(typelabel);
        
        JLabel Previustype  = new JLabel("Room Type :");
        Previustype.setBounds(550,258,97,20);
        Previustype.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Previustype.setForeground(Color.WHITE);
        panel.add(Previustype);
        
        Previus_typelabel = new JLabel();
        Previus_typelabel.setBounds(720,258,97,20);
        Previus_typelabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Previus_typelabel.setForeground(Color.WHITE);
        panel.add(Previus_typelabel);

        typeChoice = new Choice();
        typeChoice.setBounds(248,258,140,20);
        panel.add(typeChoice);
        typeChoice.add("Single Bed");
        typeChoice.add("Double Bed");
        

        update = new JButton("Update");
        update.setBounds(120,315,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        panel.add(update);


        back = new JButton("Back");
        back.setBounds(180,355,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        check = new JButton("Check");
        check.setBounds(60,355,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        panel.add(check);

        setUndecorated(true);
        setLayout(null);
        setSize(950,450);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new UpdateRoom();
    }
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == update) {
			 try {
             	String status = statusText.getText();
             	String number = roomnumberText.getText();
             	String ava = avalibilityText.getText();
             	String type = typeChoice.getSelectedItem();
             	Rooms room = rs.getRoomsByNumber(c.getSelectedItem());
             	if(!status.isEmpty()) { room.setStatus(status);}
             	if(!number.isEmpty()) { room.setRoom_number(number); }
             	if(!ava.isEmpty()) { room.setAvalibilty(ava); }
             	if(!type.isEmpty()) { room.setType(type);}
             	rs.updateRooms(room);
                JOptionPane.showMessageDialog(null, "Updated Successfully");
                setVisible(false);dispose();

             }catch (Exception E){
                 E.printStackTrace();
             }
		}
		else if(ae.getSource() == back) {
			setVisible(false);dispose();
		}
		else if(ae.getSource() == check) {
			try { 
            	Rooms room = rs.getRoomsByNumber(c.getSelectedItem());
            	Previusavaliablitylabel.setText(room.getAvalibilty());
            	Previus_statuslabel.setText(room.getStatus());
            	PreviusRoomnumberlabel.setText(room.getRoom_number());
            	Previus_typelabel.setText(room.getType());
            } catch(Exception e) {}
		}
		else {
			dispose();
			System.exit(100);
		}
		
	}

}
