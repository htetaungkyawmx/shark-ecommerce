package org.ecommerce.sharkecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private LocalDateTime createAt;
    private LocalDateTime updateAt = LocalDateTime.now();
    private boolean isDeleted;

    private Boolean gender = null;
    private String address;
    private String phone;

}
