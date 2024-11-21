package model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int emp_id;	
	@Column(name="name",nullable=false)
	String name;	
	@Column(name="age")
	String age;
	@Column(name="salary")
	String salary;
	@Column(name="phone")
	String phone;
	@Column(name="email")
	String email;
	@Column(name="aadhar")
	String aadhar;
	@Column(name="job")
	String job;
	@Column(name="gender")
	String gender;

	
	public Employee() {
		
	}
	
	public Employee(String name, String age, String salary, String phone, String email, String aadhar,String job, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.phone = phone;
		this.email = email;
		this.aadhar = aadhar;
		this.job = job;
		this.gender = gender;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", phone="
				+ phone + ", email=" + email + ", aadhar=" + aadhar + ", job=" + job + ", gender=" + gender + "]";
	}
	
}
