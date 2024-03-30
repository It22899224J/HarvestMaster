package com.Backend.HarvestMaster.Admin.Repository;

import com.Backend.HarvestMaster.Admin.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Optional<Admin> findByUserEmail(String email);
}
