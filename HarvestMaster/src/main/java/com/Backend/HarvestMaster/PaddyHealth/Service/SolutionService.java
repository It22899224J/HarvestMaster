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

    // Method to delete a solution by its ID
    public boolean delete(int id);

    // Method to update an existing solution
    Solution updateSolution(int id, Solution solution);


}

