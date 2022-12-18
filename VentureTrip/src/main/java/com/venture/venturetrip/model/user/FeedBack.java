package com.venture.venturetrip.model.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedBack {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer feedbackID;

    @NotNull
    private String feedback;

    @NotNull
    private Integer rating;

    private LocalDate submitDate;
}
