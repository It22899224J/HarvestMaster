package com.Backend.HarvestMaster.LogisticHandler.Repository;

import com.Backend.HarvestMaster.LogisticHandler.Model.LogisticHandler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogisticHandlerRepository extends JpaRepository<LogisticHandler,Integer> {
    Optional<LogisticHandler> findByUserEmail(String email);
}
