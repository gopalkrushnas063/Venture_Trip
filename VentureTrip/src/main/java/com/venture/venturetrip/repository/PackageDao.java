package com.venture.venturetrip.repository;

import com.venture.venturetrip.model.admin.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageDao extends JpaRepository<Package,Integer> {
}
