package com.venture.venturetrip.repository;

import com.venture.venturetrip.model.user.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends JpaRepository<Booking,Integer> {
}
