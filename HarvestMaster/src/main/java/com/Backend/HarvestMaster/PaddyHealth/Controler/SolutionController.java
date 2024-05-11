package com.Backend.HarvestMaster.PaddyHealth.Controler;
import com.Backend.HarvestMaster.PaddyHealth.Model.Issue;
import com.Backend.HarvestMaster.PaddyHealth.Service.IssueService;
import org.springframework.http.HttpStatus;

import com.Backend.HarvestMaster.PaddyHealth.Model.Solution;
import com.Backend.HarvestMaster.PaddyHealth.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/solution")
public class SolutionController {

    @Autowired
    private SolutionService solutionService; // Injecting SolutionService object

    @Autowired
    private IssueService issueService; // Assuming you have an IssueService


    // Endpoint to add a new solution
    @PostMapping("/add/{id}")
    public ResponseEntity<String> add(@PathVariable int id, @RequestBody Solution solution) {
        // Attempt to save the new solution
        solutionService.saveSolution(id, solution);

        // Assuming solutionService.saveSolution(id, solution) doesn't throw an exception on failure
        return ResponseEntity.status(HttpStatus.CREATED).body("New Solution is Added");
    }

    // Endpoint to get all solutions
    @GetMapping("/getAll")
    public List<Solution> getAllSolutions() {
        return solutionService.getAllSolutions();
    }

    // Endpoint to get a solution by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Solution> getSolutionById(@PathVariable int id) {
        Solution solution = solutionService.getSolutionById(id);
        if (solution != null) {
            return ResponseEntity.ok(solution);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete a solution by its id
    @DeleteMapping("/solution/{id}")
    public ResponseEntity<String> deleteSolution(@PathVariable int id) {
        // Attempt to delete the solution
        if (solutionService.delete(id)) {
            // If deletion is successful, return a success response
            return ResponseEntity.ok("Solution deleted successfully");
        } else {
            // If the relevant ID is not found, return a not found response
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Solution with ID " + id + " not found");
        }
    }

    // Endpoint to update a solution by its id
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSolution(@PathVariable int id, @RequestBody Solution solution) {
        try {
            // Attempt to update the solution
            solutionService.updateSolution(id, solution);
            return ResponseEntity.ok("Solution updated successfully");
        } catch (NoSuchElementException e) {
            // If the relevant ID is not found, return a bad request response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Solution with ID " + id + " not found");
        }
    }

    // Endpoint to get solutions for a specific issue
    @GetMapping("/solutions/{issue_id}")
    public ResponseEntity<?> getSolutionsForIssue(@PathVariable int issue_id) {
        // Check if the issue with the given ID exists
        Issue issue = issueService.getIssueById(issue_id);
        if (issue == null) {
            // If the issue does not exist, return a 404 Not Found response with an error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Issue with ID " + issue_id + " not found.");
        }

        // Proceed with fetching solutions for the specified issue
         Solution solutions = solutionService.getSolutionsForIssue(issue_id);

        if (solutions == null) {
            // If no solutions are found, return a 404 Not Found response with an error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No solutions found for issue with ID " + issue_id);
        }

        // Return the list of solutions
        return ResponseEntity.ok(solutions);
    }
}