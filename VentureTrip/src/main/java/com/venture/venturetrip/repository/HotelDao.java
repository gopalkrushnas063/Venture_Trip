package com.venture.venturetrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venture.venturetrip.model.admin.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer> {

}
