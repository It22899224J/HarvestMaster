package com.Backend.HarvestMaster.PaddyHealth.Controler;
import com.Backend.HarvestMaster.PaddyHealth.Model.Solution;
import com.Backend.HarvestMaster.PaddyHealth.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/solution")
public class SolutionController {

    @Autowired
    private SolutionService solutionService; // Making SolutionService object

    // Endpoint to add a new solution
    @PostMapping("/add")
    public String add(@RequestBody Solution solution) {
        solutionService.saveSolution(solution); // Saving the new solution
        return "New Solution is Added";
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

    // Endpoint to update an existing solution
    @PutMapping("/{id}")
    public ResponseEntity<String> updateSolution(@PathVariable int id, @RequestBody Solution updatedSolution) {
        Solution existingSolution = solutionService.getSolutionById(id);
        if (existingSolution != null) {
            // Update the existing solution with the provided data
            updatedSolution.setId(existingSolution.getId());
            solutionService.saveSolution(updatedSolution);
            return ResponseEntity.ok("Solution updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Solution with ID " + id + " not found");
        }
    }


    // Endpoint to delete a solution by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSolution(@PathVariable int id) {
        Solution existingSolution = solutionService.getSolutionById(id);
        if (existingSolution != null) {
            solutionService.deleteSolution(id);
            return ResponseEntity.ok("Solution deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

