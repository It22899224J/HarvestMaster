package com.Backend.HarvestMaster.PaddyHealth.Repository;
import com.Backend.HarvestMaster.PaddyHealth.Model.Issue;
import com.Backend.HarvestMaster.PaddyHealth.Model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Integer> {

    List<Solution> findByIssueId(int issue_id);


    @Query(value = "SELECT * FROM solution  WHERE issue_id = ?1",nativeQuery = true)
    Solution findSolutionByIssueId(Integer issueId);

}
