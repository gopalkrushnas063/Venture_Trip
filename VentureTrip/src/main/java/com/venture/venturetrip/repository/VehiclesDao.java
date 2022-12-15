package com.venture.venturetrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venture.venturetrip.model.admin.Vehicles;

@Repository
public interface VehiclesDao extends JpaRepository<Vehicles, Integer> {

}
