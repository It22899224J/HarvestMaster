package com.Backend.HarvestMaster.FAQ.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FAQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int faq_id;


    private String topic;

    private String description;

    private String solution;
}
