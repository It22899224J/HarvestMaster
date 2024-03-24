package com.Backend.HarvestMaster.PaddyHealth.Controler;
import com.Backend.HarvestMaster.PaddyHealth.Model.Issue;
import com.Backend.HarvestMaster.PaddyHealth.Service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    private IssueService issueService; // Injecting IssueService object

    // Endpoint to add a new issue
    @PostMapping("/add")
    public ResponseEntity<String> addIssue(
            @RequestParam("date") String date,
            @RequestParam("farmer_name") String farmerName,
            @RequestParam("field_location") String fieldLocation,
            @RequestParam("image_data") MultipartFile file,
            @RequestParam("observed_issues") String observedIssues){

        System.out.println("Received date: " + date);

        // Creating a new Issue object
        Issue newIssue = new Issue();
        newIssue.setDate(date);
        newIssue.setFarmerName(farmerName);
        newIssue.setFieldLocation(fieldLocation);
        newIssue.setObservedIssues(observedIssues);
        newIssue.setStatus("pending"); // Set status as "pending"

        try {
            // Encoding image data to Base64 string
            String base64ImageData = Base64.getEncoder().encodeToString(file.getBytes());

            // Setting Base64 encoded image data to the Issue object
            newIssue.setImageData(base64ImageData.getBytes());

            // Saving the new issue
            issueService.saveIssue(newIssue,file);
            return ResponseEntity.ok("Form submitted successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to submit form");
        }
    }

    // Endpoint to get all issues
    @GetMapping("/getAll")
    public List<Issue> getAllIssues() {
        return issueService.getAllIssues();
    }

    // Endpoint to get an issue by its ID
    @GetMapping("/issue/{id}")
    public ResponseEntity<Issue> getIssue(@PathVariable int id) {
        Issue issue = issueService.getIssueById(id);
        if (issue != null) {
            return ResponseEntity.ok(issue);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete an issue by its id
    @DeleteMapping("/issue/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {

        if (issueService.delete(id)) {
            return ResponseEntity.ok("Issue deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Issue could not be deleted");
        }
    }


    //Endpoint to update an issue by its id
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateIssue(@PathVariable int id, @RequestBody Issue issue) {
        try {
            issueService.updateIssue(id, issue);
            return ResponseEntity.ok("Issue updated successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Endpoint to mark an issue as accepted
    @PutMapping("/accept/{id}")
    public ResponseEntity<String> acceptIssue(@PathVariable int id) {
        try {
            Issue issue = issueService.getIssueById(id);
            if (issue != null) {
                issue.setStatus("accepted");
                issueService.updateIssue(id, issue);
                return ResponseEntity.ok("Issue accepted successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error accepting issue: " + e.getMessage());
        }
    }
    // Endpoint to get all pending issues
    @GetMapping("/pending")
    public ResponseEntity<List<Issue>> getPendingIssues() {
        List<Issue> pendingIssues = issueService.getIssuesByStatus("pending");
        return ResponseEntity.ok(pendingIssues);
    }

    // Endpoint to get all accepted issues
    @GetMapping("/accepted")
    public ResponseEntity<List<Issue>> getAcceptedIssues() {
        List<Issue> acceptedIssues = issueService.getIssuesByStatus("accepted");
        return ResponseEntity.ok(acceptedIssues);
    }



}