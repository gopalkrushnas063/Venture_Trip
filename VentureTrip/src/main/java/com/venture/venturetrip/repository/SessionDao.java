package com.venture.venturetrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venture.venturetrip.model.user.CurrentUserSession;

public interface SessionDao extends JpaRepository<CurrentUserSession, Integer> {

	
	public  CurrentUserSession  findByUuid(String uuid);
}
