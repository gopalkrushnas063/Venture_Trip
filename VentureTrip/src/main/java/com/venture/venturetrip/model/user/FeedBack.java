package com.venture.venturetrip.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedBack {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer feedbackID;
    private String feedback;
    private Integer rating;
//    private LocalDate submitDate;
    
	
    
    
}
