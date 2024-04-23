package com.Backend.HarvestMaster.PaymentHandle.Repositiory;

import com.Backend.HarvestMaster.PaymentHandle.Model.PaymentLogActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentLogActivityRepository extends JpaRepository<PaymentLogActivity, Long> {
}