package com.venture.venturetrip.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.venture.venturetrip.model.admin.Route;

@Repository
public interface RouteDao extends JpaRepository<Route,Integer> {
	
	@Query("select r from Route r where r.routeFrom = ?1")
	List<Route> getRouteFrom(String from);

	@Query("select r from Route r where r.doj = ?1")
	List<Route> getByDate(LocalDateTime doj);
	
	
}
