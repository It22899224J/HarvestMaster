package com.Backend.HarvestMaster.FAQ.Repository;

import com.Backend.HarvestMaster.FAQ.Model.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<FAQ,Integer> {
}
