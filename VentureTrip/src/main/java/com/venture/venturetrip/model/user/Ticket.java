package com.venture.venturetrip.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket {
    @Id
    private Integer ticketID;
    private String status;
    private Integer bookingID;
	public Ticket() {
		super();
	}
	public Ticket(Integer ticketID, String status, Integer bookingID) {
		super();
		this.ticketID = ticketID;
		this.status = status;
		this.bookingID = bookingID;
	}
	public Integer getTicketID() {
		return ticketID;
	}
	public void setTicketID(Integer ticketID) {
		this.ticketID = ticketID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getBookingID() {
		return bookingID;
	}
	public void setBookingID(Integer bookingID) {
		this.bookingID = bookingID;
	}
	@Override
	public String toString() {
		return "Ticket [ticketID=" + ticketID + ", status=" + status + ", bookingID=" + bookingID + "]";
	}
    
    
    

}
