package com.venture.venturetrip.repository;

import com.venture.venturetrip.model.user.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDao extends JpaRepository<Ticket,Integer> {
}
