package com.venture.model.admin;


import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminDTO {
    @NotNull(message = "Mobile is mandatory")
    private String mobile;
    @NotNull(message = "Password is mandatory")
    private String password;
}
