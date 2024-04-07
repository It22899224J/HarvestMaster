package com.Backend.HarvestMaster.PaddyHealth.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;



@Table(name = "solution")
@Entity
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToOne
    @JoinColumn(name = "issue_id")
    private Issue issue;

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public Issue getIssue() {
        return issue;
    }

    private String solution;
    private String document_url;

    private String date;

    private String instructor;




    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getDocument_url() {
        return document_url;
    }

    public void setDocument_url(String documentUrl) {
        this.document_url = documentUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}