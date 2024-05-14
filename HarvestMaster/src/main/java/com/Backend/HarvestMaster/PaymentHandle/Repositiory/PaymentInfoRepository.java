package com.Backend.HarvestMaster.PaymentHandle.Repositiory;

import com.Backend.HarvestMaster.PaymentHandle.Model.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {
    List<PaymentInfo> findByPaymentStatus(String paymentStatus);

    @Query("SELECT SUM(p.amount) FROM PaymentInfo p WHERE p.paymentStatus = :status")
    double getTotalAmountByPaymentStatus(@Param("status") String paymentStatus);
}
