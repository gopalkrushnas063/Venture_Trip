package com.venture.venturetrip.model.admin;


import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminDTO {
    @Pattern(regexp="(^$|[0-9]{10})",message = "Phone number should be 10 digits")
    private String mobile;

    @NotNull
    @Size(min = 2, max = 30,message = "Password should contains alphabet,numeric ,special characters ans it has also minimum 4 to 12 characters")
    private String password;
    
    

    
    
}
