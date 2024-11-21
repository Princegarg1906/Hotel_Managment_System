package model;

import jakarta.persistence.*;

@Entity
@Table(name="room")
public class Rooms {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	
	@Column(name="roomnumber")
	String room_number;
	@Column(name="avalibity")
	String avalibilty;
	@Column(name="status")
	String status;
	@Column(name="price")
	String price;
	@Column(name="type")
	String type;
	
	public Rooms() {
		
	}
	public Rooms(String room_number, String avalibilty, String status, String price, String type) {
		super();
		this.room_number = room_number;
		this.avalibilty = avalibilty;
		this.status = status;
		this.price = price;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRoom_number() {
		return room_number;
	}
	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}
	public String getAvalibilty() {
		return avalibilty;
	}
	public void setAvalibilty(String avalibilty) {
		this.avalibilty = avalibilty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Rooms [room_number=" + room_number + ", avalibilty=" + avalibilty + ", status="
				+ status + ", price=" + price + ", type=" + type + "]";
	}
	

}
