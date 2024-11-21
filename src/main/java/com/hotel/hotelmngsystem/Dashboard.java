package com.hotel.hotelmngsystem;

import javax.swing.*;

import Services.guestService;
import Services.pickupService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.Guest;
import model.PickUp;
import model.Reservation;
import Services.reservationService;

public class Dashboard extends JFrame implements ActionListener{
	
	JButton btnNGF,btnRoom,btneditguest,btnAEI,btnGI,btnCO,btnURS,btnDD,btnSR,logoutbtn,backbtn,resbtn,btnAPU,btnPD;
	
	public Dashboard(){
		super("King Hotel System");
		
		JPanel rpanel = new JPanel();
        rpanel.setLayout(null);
        rpanel.setBounds(280,5,1149,753);
        rpanel.setBackground(null);
        add(rpanel);

        JPanel lpanel = new JPanel();
        lpanel.setLayout(null);
        lpanel.setBounds(5,5,270,753);
        lpanel.setBackground(Color.GRAY);
        add(lpanel);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(900,-5,230,230);
        panel.setOpaque(false);
        rpanel.add(panel);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i = image.getImage().getScaledInstance(1149,753, Image.SCALE_DEFAULT);
        ImageIcon imageicon = new ImageIcon(i);
        JLabel labelimg = new JLabel(imageicon);
        labelimg.setBounds(0,0,1149,753);
        rpanel.add(labelimg);
        
        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("icons/hoto_logo2.png"));
        Image i2 = image2.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon imageicon2 = new ImageIcon(i2);
        JLabel labelimg2 = new JLabel(imageicon2);
        labelimg2.setBounds(0,0,250,250);
        panel.add(labelimg2);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/hoto_logo2.png"));
        Image i1 = image1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon imageicon1 = new ImageIcon(i1);
        JLabel labelimg1 = new JLabel(imageicon1);
        labelimg1.setBounds(5,520,250,250);
        lpanel.add(labelimg1);
        
        
        btnNGF = new JButton("New Guest Form");
        btnNGF.setBounds(30,30,200,30);
        btnNGF.addActionListener(this);
        lpanel.add(btnNGF);

        btnRoom = new JButton("Room Details");
        btnRoom.setBounds(30,110,200,30);
        btnRoom.addActionListener(this);
        lpanel.add(btnRoom);


        btneditguest = new JButton("Edit Guest Details");
        btneditguest.setBounds(30,70,200,30);
        btneditguest.addActionListener(this);
        lpanel.add(btneditguest);
        
        resbtn = new JButton("Reservation Info");
        resbtn.setBounds(30,150,200,30);
        resbtn.addActionListener(this);
        lpanel.add(resbtn);


        btnAEI = new JButton("All Employee Info");
        btnAEI.setBounds(30,190,200,30);
        btnAEI.addActionListener(this);
        lpanel.add(btnAEI);


        btnGI = new JButton("Guests Info");
        btnGI.setBounds(30,230,200,30);
        btnGI.addActionListener(this);
        lpanel.add(btnGI);
        
        btnPD = new JButton("Car Service Info");
        btnPD.setBounds(30,270,200,30);
        btnPD.addActionListener(this);
        lpanel.add(btnPD);
        
        btnDD = new JButton("Driver Info");
        btnDD.setBounds(30,310,200,30);
        btnDD.addActionListener(this);
        lpanel.add(btnDD);


        btnCO = new JButton("Check Out");
        btnCO.setBounds(30,350,200,30);
        btnCO.addActionListener(this);
        lpanel.add(btnCO);



        btnURS = new JButton("Update Room Status");
        btnURS.setBounds(30,390,200,30);
        btnURS.addActionListener(this);
        lpanel.add(btnURS);

        btnSR = new JButton("Search Room");
        btnSR.setBounds(30,430,200,30);
        btnSR.addActionListener(this);
        lpanel.add(btnSR);
        
        
        btnAPU = new JButton("Add Car Request");
        btnAPU.setBounds(30,470,200,30);
        btnAPU.addActionListener(this);
        lpanel.add(btnAPU);


        logoutbtn = new JButton("Logout");
        logoutbtn.setBounds(30,510,95,30);
        logoutbtn.addActionListener(this);
        lpanel.add(logoutbtn);


        backbtn = new JButton("Quit");
        backbtn.setBounds(140,510,95,30);
        backbtn.addActionListener(this);
        lpanel.add(backbtn);
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1950,1090);
        setSize(1450,800); //1950
        setLocationRelativeTo(null);
        setVisible(true);
        
//        while(true) {
//        	panel.setVisible(false);
//        	
//        	try {
//				Thread.sleep(500);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//        	panel.setVisible(true);
//        	try {
//				Thread.sleep(500);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//        }
        
	}
	
	public static void main(String args[]) {
		new Dashboard();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == backbtn) {
			try {
                setVisible(false);dispose();
                System.exit(100);
             }catch (Exception E){
                 E.printStackTrace();
             }
		}
		else if(ae.getSource() == logoutbtn) {
			try {
//                System.exit(500);
				setVisible(false);dispose();
                new Login();
              }catch (Exception E){
                  E.printStackTrace();
              }
		}
		else if(ae.getSource() == btnURS) {
			 try {
               new UpdateRoom();
           }catch (Exception E){
               E.printStackTrace();
           }
		}
		else if(ae.getSource() == btnSR) {
			 try {
               new SearchRoom();
           }catch (Exception E){
               E.printStackTrace();
           }
		}
		else if(ae.getSource() == btnCO) {
			try {
				List<Guest> list = new guestService().getAllGuests();
				if(list.size() == 0)
				{
					JOptionPane.showMessageDialog(null, "There is no Guest For Checkout");
				}else {
					new checkOut();
				}
          }catch (Exception E){
              E.printStackTrace();
          }
		}
		else if(ae.getSource() == btneditguest) {
			try {
				List<Guest> list = new guestService().getAllGuests();
				if(list.size() == 0)
				{
					JOptionPane.showMessageDialog(null, "There is no Guest at moment");
				}else {
					new editGuest();
				}
          }catch (Exception E){
              E.printStackTrace();
          }
		}
		else if(ae.getSource() == btnGI) {
			try {
				List<Guest> list = new guestService().getAllGuests();
				if(list.size() == 0)
				{
					JOptionPane.showMessageDialog(null, "There is no Guest at moment");
				}else {
					new guestInfo();
				}
          }catch (Exception E){
              E.printStackTrace();
          }
		}
		else if(ae.getSource()==btnAEI) {
			try {
              new employeeInfo();
          }catch (Exception E){
              E.printStackTrace();
          }
		}
		else if(ae.getSource() == btnRoom) {
			try {
              new roomInfo();
          }catch (Exception E){
              E.printStackTrace();
          }
		}
		else if(ae.getSource() == btnNGF) {
			try {
              new addGuest();
          }catch (Exception E){
              E.printStackTrace();
          }
		}
		else if(ae.getSource() == btnDD) {
			try {
                new driverInfo();
            }catch (Exception E){
                E.printStackTrace();
            }
		}else if(ae.getSource() == resbtn){
			try {
				List<Reservation> list = new reservationService().getAllReservations();
				if(list.size() == 0)
				{
					reservationInfo r = new reservationInfo();
					JOptionPane.showMessageDialog(null, "There is no Reservation at the moment");
					r.dispose();
				}else {
					new reservationInfo();
				}
			}catch (Exception E){
                E.printStackTrace();
            }
		}else if(ae.getSource() == btnAPU) {
			try {
				List<Guest> list = new guestService().getAllGuests();
				if(list.size() == 0)
				{
					JOptionPane.showMessageDialog(null, "There is no Guest at moment for Car Service");
				}else {
					new addPickUp();
				}
			}catch (Exception E){
                E.printStackTrace();
            }
		}else if(ae.getSource() == btnPD) {
			try {
				List<PickUp> list = new pickupService().getAllPickUps();
				if(list.size() == 0)
				{
					JOptionPane.showMessageDialog(null, "There is no Reservation at the moment");
				}else {
					new pickUp();
				}
			}catch (Exception E){
                E.printStackTrace();
            }
		}
		
	
	}
	

}
