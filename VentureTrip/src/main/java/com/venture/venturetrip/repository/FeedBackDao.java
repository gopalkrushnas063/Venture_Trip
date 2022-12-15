package com.venture.venturetrip.repository;

import com.venture.venturetrip.model.user.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackDao extends JpaRepository<FeedBack,Integer> {
}
