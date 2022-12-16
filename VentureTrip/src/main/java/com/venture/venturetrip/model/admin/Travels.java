package com.venture.venturetrip.model.admin;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Travels {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer travelsID;
    private String travelsName;
    private String agentName;
    private String address;
    private String contact;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Route> routes = new ArrayList<>();
    
   

}
