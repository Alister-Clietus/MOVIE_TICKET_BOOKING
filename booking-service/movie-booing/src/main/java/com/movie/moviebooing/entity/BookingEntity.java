package com.movie.moviebooing.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Ticket_Booking_Details")
public class BookingEntity 
{
	@EmbeddedId
    private BookingID id;
    
    @Column(name = "movie_id")
    private int movieId;
    
    @Column(name = "showtime_id")
    private int showtimeId;
    
    @Column(name = "number_of_tickets")
    private int numberOfTickets;
    
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "payment_method")
    private String paymentMethod;
    
    @Column(name = "total_amount")
    private double totalAmount;
    
    @Column(name = "booking_date")
    private String bookingDate;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "created_by")
    private Date createdby;
    
    @Column(name = "modified_by")
    private Date modifiedby;
    

	public BookingID getId() {
		return id;
	}

	public void setId(BookingID id) {
		this.id = id;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Date createdby) {
		this.createdby = createdby;
	}

	public Date getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Date modifiedby) {
		this.modifiedby = modifiedby;
	}
    
    
}
