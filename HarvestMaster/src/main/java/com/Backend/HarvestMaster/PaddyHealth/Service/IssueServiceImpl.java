package com.Backend.HarvestMaster.PaddyHealth.Service;

import com.Backend.HarvestMaster.PaddyHealth.Model.Issue;
import com.Backend.HarvestMaster.PaddyHealth.Repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:5173/")
@Service
public class IssueServiceImpl implements IssueService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private IssueRepository issueRepository;

    // Save a new issue along with its image data
    @Override
    public void saveIssue(Issue newIssue, MultipartFile file) {
        try {
            newIssue.setImageData(file.getBytes());
            issueRepository.save(newIssue);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle IOException
        }
    }

    // Retrieve all issues
    @Override
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    // Retrieve an issue by its ID
    @Override
    public Issue getIssueById(int id) {
        Optional<Issue> optionalIssue = issueRepository.findById(id);
        return optionalIssue.orElse(null);
    }

    // Delete an issue by its ID
    @Override
    public void deleteIssueById(int id) {
        issueRepository.deleteById(id);
    }

    // Update an existing issue
    @Override
    public Issue updateIssue(Issue issue, int id) {
        Optional<Issue> optionalIssue = issueRepository.findById(id);
        if (optionalIssue.isPresent()) {
            Issue existingIssue = optionalIssue.get();
            existingIssue.setDate(issue.getDate());
            existingIssue.setFarmerName(issue.getFarmerName());
            existingIssue.setFieldLocation(issue.getFieldLocation());
            existingIssue.setImageData(issue.getImageData());
            existingIssue.setObservedIssues(issue.getObservedIssues());
            existingIssue.setPaddyName(issue.getPaddyName());

            return issueRepository.save(existingIssue);
        } else {
            throw new RuntimeException("Issue with ID " + id + " not found"); // Solution with the provided ID not found
        }
    }
}
