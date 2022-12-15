package com.venture.venturetrip.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class FeedBack {
    @Id
    private String feedbackID;
    private String feedback;
    private Integer rating;
    private LocalDate submitDate;
}
