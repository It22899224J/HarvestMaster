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
import java.util.List;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    private IssueService issueService; // Making IssueService object

    // Endpoint to add a new issue
    @PostMapping("/add")
    public ResponseEntity<String> addIssue(
            @RequestParam("date") String date,
            @RequestParam("farmer_name") String farmerName,
            @RequestParam("field_location") String fieldLocation,
            @RequestParam("image_data") MultipartFile file,
            @RequestParam("observed_issues") String observedIssues,
            @RequestParam( "paddy_name") String paddyName){
        System.out.println("Received date: " + date);

        // Creating a new Issue object
        Issue newIssue = new Issue();
        newIssue.setDate(date);
        newIssue.setFarmerName(farmerName);
        newIssue.setFieldLocation(fieldLocation);
        newIssue.setObservedIssues(observedIssues);
        newIssue.setPaddyName(paddyName);


        try {
            // Setting image data to the Issue object
            newIssue.setImageData(file.getBytes());

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

    // Endpoint to delete an issue by its ID
    @DeleteMapping("/issues/{id}")
    public ResponseEntity<String> deleteIssueById(@PathVariable("id") int id) {
        issueService.deleteIssueById(id);
        return ResponseEntity.ok("Issue deleted successfully");
    }

    // Endpoint to update an existing issue
    @PutMapping("/{id}")
    public ResponseEntity<String> updateIssue(@PathVariable int id, @RequestBody Issue updatedIssue) {
        Issue existingIssue = issueService.getIssueById(id);
        if (existingIssue != null) {

            // Update the existing issue with the provided data
            updatedIssue.setId(existingIssue.getId());
            issueService.updateIssue(updatedIssue, id);
            return ResponseEntity.ok("Issue updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Issue with ID " + id + " not found");
        }
    }

}
