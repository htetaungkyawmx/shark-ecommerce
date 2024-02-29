package org.ecommerce.sharkecommerce.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDTO {
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
}
