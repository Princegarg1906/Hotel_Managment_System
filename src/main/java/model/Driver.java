package model;

import jakarta.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;	
	@Column(name="name",nullable=false)
	String name;	
	@Column(name="age")
	String age;
	@Column(name="phone")
	String phone;
	@Column(name="gender")
	String gender;
	@Column(name="car_comapny")
	String carcompany;
	@Column(name="location")
	String location;
	
	
	public Driver() {}
	public Driver(String name, String age, String phone, String gender, String carcompany, String location) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.gender = gender;
		this.carcompany = carcompany;
		this.location = location;
	}
	public int getDriver_id() {
		return id;
	}
	public void setDriver_id(int driver_id) {
		this.id = driver_id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCarcompany() {
		return carcompany;
	}
	public void setCarcompany(String carcompany) {
		this.carcompany = carcompany;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Driver [driver_id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + ", gender="
				+ gender + ", carcompany=" + carcompany + ", location=" + location + "]";
	}
	


}
