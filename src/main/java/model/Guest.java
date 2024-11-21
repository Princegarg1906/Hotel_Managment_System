package model;

import jakarta.persistence.*;

@Entity
@Table(name="guest")
public class Guest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="id_type")
	String id_type;
	@Column(name="id_number")
	String id_number;
	@Column(name="name")
	String name;
	@Column(name="gender")
	String Gender;
	@Column(name="country")
	String country;
	@Column(name="room")
	String room;
	@Column(name="date")
	String date;
	@Column(name="phone")
	String phone;
	
	
	public Guest() {}
	public Guest(String id_type, String id_number, String name, String gender, String country, String room, String date,
			String phone) {
		super();
		this.id_type = id_type;
		this.id_number = id_number;
		this.name = name;
		Gender = gender;
		this.country = country;
		this.room = room;
		this.date = date;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getId_type() {
		return id_type;
	}
	public void setId_type(String id_type) {
		this.id_type = id_type;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Guest [id=" + id + ", id_type=" + id_type + ", id_number=" + id_number + ", name=" + name + ", Gender="
				+ Gender + ", country=" + country + ", room=" + room + ", date=" + date + ", phone=" + phone + "]";
	}
	
	
}
