package com.hotel.hotelmngsystem;
import javax.swing.*;

import Services.employeeService;
import model.Employee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class AddEmployee extends JFrame implements ActionListener {
	JTextField nameText, ageText, salaryText, phoneText, aadharText, emailText;
    JRadioButton radioButtonM, radioButtonF;
    JComboBox comboBox;
    JButton add,back;
    
    AddEmployee(){
    	super("King Hotel System");
    	
        JPanel panel = new JPanel();
        panel.setBounds(6,6,872,500);
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        add(panel);

        JLabel name = new JLabel("NAME");
        name.setBounds(60,30,150,27);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));;
        name.setForeground(Color.WHITE);
        panel.add(name);
        nameText = new JTextField();
        nameText.setBounds(200,30,150,27);
        nameText.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(nameText);

        JLabel Age = new JLabel("AGE");
        Age.setBounds(60,80,150,27);
        Age.setFont(new Font("Tahoma", Font.BOLD, 14));;
        Age.setForeground(Color.WHITE);
        panel.add(Age);
        ageText = new JTextField();
        ageText.setBounds(200,80,150,27);
        ageText.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(ageText);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60,120,150,27);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));;
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        radioButtonM = new JRadioButton("MALE");
        radioButtonM.setBounds(200,120,70,27);
        radioButtonM.setFont(new Font("Tahoma", Font.BOLD,14));
        radioButtonM.setBackground(Color.DARK_GRAY);
        radioButtonM.setForeground(Color.white);
        panel.add(radioButtonM);

        radioButtonF = new JRadioButton("FEMALE");
        radioButtonF.setBounds(280,120,100,27);
        radioButtonF.setFont(new Font("Tahoma", Font.BOLD,14));
        radioButtonF.setBackground(Color.DARK_GRAY);
        radioButtonF.setForeground(Color.white);
        panel.add(radioButtonF);

        JLabel job = new JLabel("JOB");
        job.setBounds(60,170,150,27);
        job.setFont(new Font("serif", Font.BOLD,17));
        job.setForeground(Color.WHITE);
        panel.add(job);

        comboBox = new JComboBox(new String[]{"Front Desk", "Housekeeping", "Kitchen Staff","Room Service", "Manager", "Accountant","Chef"});
        comboBox.setBounds(200,170,150,30);
        comboBox.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(comboBox);

        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60,220,150,27);
        salary.setFont(new Font("Tahoma", Font.BOLD, 14));;
        salary.setForeground(Color.WHITE);
        panel.add(salary);
        salaryText = new JTextField();
        salaryText.setBounds(200,220,150,27);
        salaryText.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(salaryText);

        JLabel phone = new JLabel("PHONE");
        phone.setBounds(60,270,150,27);
        phone.setFont(new Font("Tahoma", Font.BOLD, 14));;
        phone.setForeground(Color.WHITE);
        panel.add(phone);
        phoneText = new JTextField();
        phoneText.setBounds(200,270,150,27);
        phoneText.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(phoneText);

        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setBounds(60,320,150,27);
        aadhar.setFont(new Font("Tahoma", Font.BOLD, 14));;
        aadhar.setForeground(Color.WHITE);
        panel.add(aadhar);
        aadharText = new JTextField();
        aadharText.setBounds(200,320,150,27);
        aadharText.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(aadharText);

        JLabel email = new JLabel("EMAIL");
        email.setBounds(60,370,150,27);
        email.setFont(new Font("Tahoma", Font.BOLD, 14));;
        email.setForeground(Color.WHITE);
        panel.add(email);
        emailText = new JTextField();
        emailText.setBounds(200,370,150,27);
        emailText.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(emailText);

        JLabel AED = new JLabel("ADD EMPLOYEE DETAILS");
        AED.setBounds(450,24,445,35);
        AED.setFont(new Font("Tahoma", Font.BOLD, 31));
        AED.setForeground(Color.WHITE);
        panel.add(AED);

        add = new JButton("ADD");
        add.setBounds(80,420,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(200,420,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/addemp.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,100,300,300);
        panel.add(label);


//        setUndecorated(true);
        setLocation(320,160);
//        setLocationRelativeTo(null);
        setLayout(null);
        setSize(900,550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            String name = nameText.getText();
            String age = ageText.getText();
            String salary = salaryText.getText();
            String phone = phoneText.getText();
            String email = emailText.getText();
            String aadhar = aadharText.getText();
            String job = (String) comboBox.getSelectedItem();
            String gender = null;
            if (radioButtonM.isSelected()){
                gender = "Male";
            } else if (radioButtonF.isSelected()) {
                gender = " Female";
            }
            try {
	            employeeService empservice = new employeeService();
	            Employee emp = new Employee(name,age,salary,phone,email,aadhar,job,gender);
	            empservice.addEmployee(emp);
	            JOptionPane.showMessageDialog(null,"Employee Added");
	            setVisible(false);dispose();
            }catch(Exception ex) {
            	JOptionPane.showMessageDialog(null,"Employee Add Failed");
            }

        }else{
           setVisible(false);dispose();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
