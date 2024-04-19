package com.Backend.HarvestMaster.PaymentHandle.Repositiory;


import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPaymentRepository extends JpaRepository<TransactionPayment, Long> {
}