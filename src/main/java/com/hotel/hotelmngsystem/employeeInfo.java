package com.hotel.hotelmngsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Services.employeeService;
import model.Employee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.List;

public class employeeInfo extends JFrame implements ActionListener {
	JButton back,print;
	JTable table;
	
	employeeInfo(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,587);
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);
        add(panel);

        DefaultTableModel model  = new DefaultTableModel(new String[]{"Name","Age","Gender","Job","Salary","Phone","Email","Aadhar"},0);
        table = new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(Color.DARK_GRAY);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.PLAIN,14));
        panel.add(table);
        try{
            employeeService es =  new employeeService();
            List<Employee> result = es.getAllEmployee();
            for(Employee emp:result) {
            	model.addRow(new Object[]{emp.getName(),emp.getAge(),emp.getGender(),emp.getJob(),emp.getSalary(),emp.getPhone(),emp.getEmail(),emp.getAadhar()});
//            	System.out.print(emp.getAge());
            }
            table.setModel(model);
        }catch (Exception e ){
            e.printStackTrace();
        }

        
        print = new JButton("PRINT");
        print.setBounds(200,500,120,30);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        panel.add(print);
        
        back = new JButton("BACK");
        back.setBounds(350,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);
 

        JLabel name = new JLabel("Name");
        name.setBounds(41,11,70,19);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(name);

        JLabel Age = new JLabel("Age");
        Age.setBounds(159,11,70,19);
        Age.setForeground(Color.WHITE);
        Age.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(Age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(273,11,70,19);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(gender);

        JLabel job = new JLabel("Job");
        job.setBounds(416,11,70,19);
        job.setForeground(Color.WHITE);
        job.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(job);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(536,11,70,19);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(salary);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(656,11,70,19);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(phone);

        JLabel email = new JLabel("Email");
        email.setBounds(786,11,70,19);
        email.setForeground(Color.WHITE);
        email.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(email);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(896,11,70,19);
        aadhar.setForeground(Color.WHITE);
        aadhar.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(aadhar);

        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(1000,600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new employeeInfo();
    }
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
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
