package com.venture.venturetrip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.venture.venturetrip.model.admin.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer> {


    @Query("select h from Hotel h where h.hotelName = ?1")
	List<Hotel> getHotelByName(String name);

	@Query("select h from Hotel h where h.rent = ?1")
	List<Hotel> findByCost(String rent);
	
}
