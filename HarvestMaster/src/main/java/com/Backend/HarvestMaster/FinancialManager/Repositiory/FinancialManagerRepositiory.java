package com.Backend.HarvestMaster.FinancialManager.Repositiory;

import com.Backend.HarvestMaster.FinancialManager.Model.FinancialManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FinancialManagerRepositiory  extends JpaRepository<FinancialManager,Integer> {

    Optional<FinancialManager> findByUserEmail(String email);
}
