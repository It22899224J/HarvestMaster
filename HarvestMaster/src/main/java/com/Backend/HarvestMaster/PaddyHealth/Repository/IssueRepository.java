package com.Backend.HarvestMaster.PaddyHealth.Repository;
import com.Backend.HarvestMaster.PaddyHealth.Model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {

}
