package com.Backend.HarvestMaster.Cart.Repository;

import com.Backend.HarvestMaster.Cart.Model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {
}
