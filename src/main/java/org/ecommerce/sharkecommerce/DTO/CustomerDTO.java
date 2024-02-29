package org.ecommerce.sharkecommerce.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
}
