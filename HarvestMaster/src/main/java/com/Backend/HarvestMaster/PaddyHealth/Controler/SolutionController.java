package com.Backend.HarvestMaster.PaddyHealth.Controler;
import com.Backend.HarvestMaster.PaddyHealth.Model.Solution;
import com.Backend.HarvestMaster.PaddyHealth.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // Endpoint to add a new solution
    @PostMapping("/add/{id}")
    public String add(@PathVariable int id, @RequestBody Solution solution) {
        solutionService.saveSolution(id, solution); // Saving the new solution
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

    // Endpoint to delete a solution by its id
    @DeleteMapping("/solution/{id}")
    public ResponseEntity<String> deleteSolution(@PathVariable int id) {

        if (solutionService.delete(id)) {
            return ResponseEntity.ok("Solution deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Solution could not be deleted");
        }

    }

    // Endpoint to update a solution by its id
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSolution(@PathVariable int id, @RequestBody Solution solution) {
        try {
            solutionService.updateSolution(id, solution);
            return ResponseEntity.ok("Solution updated successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}