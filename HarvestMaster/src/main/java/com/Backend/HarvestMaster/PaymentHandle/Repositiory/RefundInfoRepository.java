package com.Backend.HarvestMaster.PaymentHandle.Repositiory;

import com.Backend.HarvestMaster.PaymentHandle.Model.RefundInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefundInfoRepository extends JpaRepository<RefundInfo, Long> {
    List<RefundInfo> findByStatus(String status);
}
