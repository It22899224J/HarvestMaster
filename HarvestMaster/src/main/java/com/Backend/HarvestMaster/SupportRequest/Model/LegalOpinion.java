package com.Backend.HarvestMaster.SupportRequest.Model;

import com.sun.jdi.PrimitiveValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LegalOpinion {
    @Id
    private int requestID;
    private String opinion;
    private int expertID;

    private String status;
}
