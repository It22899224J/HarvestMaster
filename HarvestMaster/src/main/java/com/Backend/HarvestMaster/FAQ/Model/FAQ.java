package com.Backend.HarvestMaster.FAQ.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FAQ {

    public FAQ() {
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int faq_id;


    private String topic;

    private String description;

    private String solution;
}
