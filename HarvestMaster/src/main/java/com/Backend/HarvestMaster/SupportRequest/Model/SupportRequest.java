package com.Backend.HarvestMaster.SupportRequest.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
@Getter
@Setter

@Entity
public class SupportRequest {


    public SupportRequest() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int r_Id;

    private String topic;
    private String issue;
    private String status;

    private String user_id;

    private String solution;

    @CreationTimestamp
    private LocalDate localDate;


}
