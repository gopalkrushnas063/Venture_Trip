package com.venture.venturetrip.repository;

import com.venture.venturetrip.model.admin.CurrentAdminSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AdminSessionDAO extends JpaRepository<CurrentAdminSession,Integer> {
    public Optional<CurrentAdminSession> findByAdminId(Integer adminId);
    public Optional<CurrentAdminSession> findByUuid(String uuid);
}
