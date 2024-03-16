package com.Backend.HarvestMaster.PaddyHealth.Repository;
import com.Backend.HarvestMaster.PaddyHealth.Model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SolutionRepository extends JpaRepository<Solution, Integer> {
}
