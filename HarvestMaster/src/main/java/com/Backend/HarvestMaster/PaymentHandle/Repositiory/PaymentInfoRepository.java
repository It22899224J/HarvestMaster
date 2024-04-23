package com.Backend.HarvestMaster.PaymentHandle.Repositiory;

import com.Backend.HarvestMaster.PaymentHandle.Model.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {
    List<PaymentInfo> findByPaymentStatus(String paymentStatus);
}
