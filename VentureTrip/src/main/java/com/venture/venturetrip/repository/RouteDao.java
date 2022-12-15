package com.venture.venturetrip.repository;

import com.venture.venturetrip.model.admin.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteDao extends JpaRepository<Route,Integer> {
}
