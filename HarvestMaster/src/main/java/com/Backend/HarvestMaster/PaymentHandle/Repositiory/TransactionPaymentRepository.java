package com.Backend.HarvestMaster.PaymentHandle.Repositiory;


import com.Backend.HarvestMaster.Order.Model.Delivery;
import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionPaymentRepository extends JpaRepository<TransactionPayment, Long> {
    List<TransactionPayment> findByDelivery(Delivery delivery);

    @Query("SELECT SUM(tp.totalPrice) FROM TransactionPayment tp")
    double getTotalAmount();

}