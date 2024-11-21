package model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Rooms room;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @Column(name = "check_in_date")
    private Date checkInDate;

    @Column(name = "check_out_date")
    private Date checkOutDate;
    
    public Reservation() {}

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setCheckInDate(Date checkin_date) {
        this.checkInDate = checkin_date;
    }

    public void setCheckOutDate(Date date) {
        this.checkOutDate = date;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rooms getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }
}