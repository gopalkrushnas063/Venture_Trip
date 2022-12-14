package com.venture.adminModule.model;

import java.util.ArrayList;
import java.util.List;

public class Travels {
    private Integer travelsID;
    private String travelsName;
    private String agentName;
    private String address;
    private String contact;
    private List<Vehicles> vehicles = new ArrayList<>();
}
