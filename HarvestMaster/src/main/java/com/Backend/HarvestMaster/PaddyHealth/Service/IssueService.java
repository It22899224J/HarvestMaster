package com.Backend.HarvestMaster.PaddyHealth.Service;
import com.Backend.HarvestMaster.PaddyHealth.Model.Issue;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
public interface IssueService {

    // Method to save a new issue along with its image data
    void saveIssue(Issue newIssue, MultipartFile file);

    // Method to retrieve all issues
    List<Issue> getAllIssues();

    // Method to retrieve an issue by its ID
    Issue getIssueById(int id);

    // Method to delete an issue by its ID
    void deleteIssueById(int id);

    // Method to update an existing issue
    Issue updateIssue(Issue issue, int id);


}
