package com.Backend.HarvestMaster.PaddyHealth.Service;
import com.Backend.HarvestMaster.PaddyHealth.Model.Solution;
import com.Backend.HarvestMaster.PaddyHealth.Repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:5173/")
@Service
public class SolutionServiceImpl implements SolutionService {

    @Autowired
    private SolutionRepository solutionRepository;
    @Autowired
    private IssueService issueService;

    // Save a new solution
    @Override
    public void saveSolution(int issue_id,Solution solution) {

        solution.setIssue(issueService.getIssueById(issue_id));

        solutionRepository.save(solution);
    }

    // Retrieve all solutions
    @Override
    public List<Solution> getAllSolutions() {
        return solutionRepository.findAll();
    }

    // Retrieve a solution by its ID
    @Override
    public Solution getSolutionById(int id) {
        Optional<Solution> solutionOptional = solutionRepository.findById(id);
        return solutionOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Solution with ID " + id + " not found"));
    }

    // Delete a solution by its ID
    @Override
    public boolean delete(int id){
        solutionRepository.deleteById(id);
        return true;
    }

    // Update an existing solution
    @Override
    public Solution updateSolution(int id, Solution solution) {
        Solution current=solutionRepository.findById(id).get();
        solution.setId(current.getId());
        return solutionRepository.save(solution) ;
    }

    //  get solutions for a specific issue
    @Override
    public List<Solution> getSolutionsForIssue(int issueId) {
        return solutionRepository.findByIssueId(issueId);
    }

}