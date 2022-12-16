package com.venture.venturetrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.venture.venturetrip.model.user.Ticket;

@Repository
public interface TicketDao extends JpaRepository<Ticket,Integer> {
	
	   @Query("select t from Ticket t where t.bookingID=?1")
	  public Ticket getTicketByBkingId(Integer  bookingID);
}
