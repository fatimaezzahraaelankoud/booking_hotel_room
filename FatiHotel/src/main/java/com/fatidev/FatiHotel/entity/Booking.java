package com.fatidev.FatiHotel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotNull(message = "check in date is required")
    private LocalDate checkInDate ;

    @Future(message="check out date must be in future")
    private LocalDate getCheckOutDate ;

    @Min(value=1 ,message="number of adult must be more than 1")
    private int numOfAdults;
    @Min(value=0 ,message="number of children  must  not be less than 0")
    private int numOfChildren ;

    private int numTotalOfGuest;

    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_id")
    private Room room ;

    public void calculateTotaleOfGuest(){
        this.numTotalOfGuest = this.numOfChildren+this.numOfAdults ;

    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotaleOfGuest() ;
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotaleOfGuest();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", checkInDate=" + checkInDate +
                ", getCheckOutDate=" + getCheckOutDate +
                ", numOfAdults=" + numOfAdults +
                ", numOfChildren=" + numOfChildren +
                ", numTotalOfGuest=" + numTotalOfGuest +
                ", bookingConfirmationCode='" + bookingConfirmationCode + '\'' +
                ", user=" + user +
                ", room=" + room +
                '}';
    }
}
