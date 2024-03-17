package com.Backend.HarvestMaster.PaddyHealth.Service;
import com.Backend.HarvestMaster.PaddyHealth.Model.Solution;
import java.util.List;

public interface SolutionService {
    // Save a new solution
    void saveSolution(Solution solution);

    // Retrieve all solutions
    List<Solution> getAllSolutions();

    // Retrieve a solution by its ID
    Solution getSolutionById(int id);

    // Delete a solution by its ID
    void deleteSolution(int id);

    // Update an existing solution
    Solution updateSolution(Solution solution, int id);
}


