package com.Backend.HarvestMaster.PaddyHealth.Controler;
import com.Backend.HarvestMaster.PaddyHealth.Model.Solution;
import com.Backend.HarvestMaster.PaddyHealth.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/solution")
public class SolutionController {

    @Autowired
    private SolutionService solutionService; // Injecting SolutionService object

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

    // Endpoint to delete an issue by its ID
    @DeleteMapping("/solution/{id}")
    public ResponseEntity<Solution> delete(@PathVariable int id) {
        try {


            if (solutionService.delete(id)){
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Endpoint to update an issue by its id
    @PutMapping("/update/{id}")
    public ResponseEntity<Solution> updateSolution(@PathVariable int id, @RequestBody Solution solution) {
        try {
            solutionService.updateSolution(id, solution);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}