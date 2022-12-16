package com.venture.venturetrip.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venture.venturetrip.model.user.FeedBack;

@Repository
public interface FeedBackDao extends JpaRepository<FeedBack,Integer> {
	
	Optional<FeedBack> findById(Integer feedbackID);
	
}
