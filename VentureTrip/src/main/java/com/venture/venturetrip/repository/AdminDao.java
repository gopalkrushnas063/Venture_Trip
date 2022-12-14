package com.venture.venturetrip.repository;

import com.venture.venturetrip.model.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AdminDao extends JpaRepository<Admin,Integer> {
    public Optional<Admin> findByMobile(String mobile);
}
