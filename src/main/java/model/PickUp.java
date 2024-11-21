package model;

import jakarta.persistence.*;

@Entity
@Table(name="pickup")
public class PickUp {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @OneToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @Column(name = "guest_location")
    private String glocation;

    @Column(name = "driver_location")
    private String dlocation;
    
    public PickUp() {}

	public PickUp(Driver driver, Guest guest, String glocation, String dlocation) {
		super();
		this.driver = driver;
		this.guest = guest;
		this.glocation = glocation;
		this.dlocation = dlocation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public String getGlocation() {
		return glocation;
	}

	public void setGlocation(String glocation) {
		this.glocation = glocation;
	}

	public String getDlocation() {
		return dlocation;
	}

	public void setDlocation(String dlocation) {
		this.dlocation = dlocation;
	}

	@Override
	public String toString() {
		return "PickUp [id=" + id + ", driver=" + driver + ", guest=" + guest + ", glocation=" + glocation
				+ ", dlocation=" + dlocation + "]";
	}
    
    

}
