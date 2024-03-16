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

    // Save a new solution
    @Override
    public void saveSolution(Solution solution) {
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
    public void deleteSolution(int id) {
        if (!solutionRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Solution with ID " + id + " not found");
        }
        solutionRepository.deleteById(id);
    }

    // Update an existing solution
    @Override
    public Solution updateSolution(Solution solution, int id) {
        Optional<Solution> existingSolutionOptional = solutionRepository.findById(id);
        if (existingSolutionOptional.isPresent()) {
            Solution existingSolution = existingSolutionOptional.get();
            existingSolution.setSolution(solution.getSolution());
            existingSolution.setDocumentUrl(solution.getDocumentUrl());
            return solutionRepository.save(existingSolution);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Solution with ID " + id + " not found");
        }
    }
}
