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

    //@Value("${file.upload-dir}")
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
    public boolean delete(int id){
        issueRepository.deleteById(id);
        return true;
    }

    // Update an existing issue
    @Override
    public Issue updateIssue( int id,Issue issue) {
        Issue current=issueRepository.findById(id).get();
        issue.setId(current.getId());
        return issueRepository.save(issue) ;
    }
}
