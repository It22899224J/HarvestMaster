package com.Backend.HarvestMaster.SupportRequest.Repository;

import com.Backend.HarvestMaster.SupportRequest.Model.SupportRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportRepository extends JpaRepository<SupportRequest,Integer> {
}
