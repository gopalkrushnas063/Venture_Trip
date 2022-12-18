package com.venture.venturetrip.model.admin;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminDTO {
    @Pattern(regexp="(^$|[0-9]{10})",message = "Phone number should be 10 digits")
    private String mobile;

    @Size(min = 4, max = 12,message = "Password should has minimum 4 to 12 characters")   
    private String password;
    
    

    
    
}
