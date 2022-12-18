package com.venture.venturetrip.repository;

import com.venture.venturetrip.model.admin.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageDao extends JpaRepository<Package,Integer> {
}
