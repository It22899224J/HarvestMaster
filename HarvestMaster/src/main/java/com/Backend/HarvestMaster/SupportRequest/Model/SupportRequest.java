package com.Backend.HarvestMaster.SupportRequest.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class SupportRequest {

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public SupportRequest() {
    }

    public int getR_Id() {
        return r_Id;
    }

    public void setR_Id(int r_Id) {
        this.r_Id = r_Id;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int r_Id;

    private String topic;
    private String issue;
    private String status;

    private String user_id;

private LocalDate localDate;

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getTopic() {
        return topic;
    }
}
