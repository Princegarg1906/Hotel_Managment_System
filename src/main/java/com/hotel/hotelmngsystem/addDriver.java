package com.hotel.hotelmngsystem;

import javax.swing.*;

import Services.driverService;
import model.Driver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.beans.Expression;

public class addDriver extends JFrame implements ActionListener {
    JTextField nameText, ageText,carCText,phoneText,locationText;
    JComboBox gender;
    JButton add, back;
    addDriver(){
    	super("King Hotel System");
    	
    	int left_field = 210;
    	int left_label = 65;

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("ADD DRIVERS");
        label.setBounds(194,30,200,22);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 22));
        panel.add(label);

        JLabel name = new JLabel("NAME");
        name.setBounds(left_label,90,102,22);
        name.setFont(new Font("Tahoma", Font.BOLD,14));
        name.setForeground(Color.WHITE);
        panel.add(name);
        
        nameText = new JTextField();
        nameText.setBounds(left_field,90,156,20);
        nameText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(nameText);

        JLabel age = new JLabel("AGE");
        age.setBounds(left_label,130,102,22);
        age.setFont(new Font("Tahoma", Font.BOLD,14));
        age.setForeground(Color.WHITE);
        panel.add(age);
        
        ageText = new JTextField();
        ageText.setBounds(left_field,130,156,20);
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(ageText);

        JLabel gender_lbl = new JLabel("GENDER");
        gender_lbl.setBounds(left_label,170,102,22);
        gender_lbl.setFont(new Font("Tahoma", Font.BOLD,14));
        gender_lbl.setForeground(Color.WHITE);
        panel.add(gender_lbl);

        gender = new JComboBox(new String[]{"Male","Female"});
        gender.setBounds(left_field,170,154,20);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);
 

        JLabel carC = new JLabel("CAR COMPANY");
        carC.setBounds(left_label,210,110,22);
        carC.setFont(new Font("Tahoma", Font.BOLD,14));
        carC.setForeground(Color.WHITE);
        panel.add(carC);
        
        carCText = new JTextField();
        carCText.setBounds(left_field,210,156,20);
        carCText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carCText);

        JLabel phone_lbl = new JLabel("PHONE ");
        phone_lbl.setBounds(left_label,250,102,22);
        phone_lbl.setFont(new Font("Tahoma", Font.BOLD,14));
        phone_lbl.setForeground(Color.WHITE);
        panel.add(phone_lbl);
        
        phoneText = new JTextField();
        phoneText.setBounds(left_field,250,156,20);
        phoneText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(phoneText);

        JLabel location = new JLabel("LOCATION");
        location.setBounds(left_label,290,102,22);
        location.setFont(new Font("Tahoma", Font.BOLD,14));
        location.setForeground(Color.WHITE);
        panel.add(location);
        
        locationText = new JTextField();
        locationText.setBounds(left_field,290,156,20);
        locationText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(locationText);

        add = new JButton("ADD");
        add.setBounds(left_label,350,111,33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(198,350,111,33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("iconS/license.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(500,60,300,300);
        panel.add(label1);

//        setUndecorated(true);
//        setLocation(60,160);
        setLocation(320,160);
        setLayout(null);
        setSize(900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            String name = nameText.getText();
            String age = ageText.getText();
            String Gender = (String) gender.getSelectedItem();
            String phone = phoneText.getText();
            String carcompany = carCText.getText();
            String locationtext = locationText.getText();

            try {
                driverService Driverervice = new driverService();
                Driver driver = new Driver(name,age,phone,Gender,carcompany,locationtext);
                Driverervice.adddriver(driver);
                JOptionPane.showMessageDialog(null, "Driver Added");
                setVisible(false);dispose();
            }catch(Exception ex) {
            	JOptionPane.showMessageDialog(null,"Failed");
            }

        }else {
            setVisible(false);dispose();
        }
    }

    public static void main(String[] args) {
        new addDriver();
    }
}
