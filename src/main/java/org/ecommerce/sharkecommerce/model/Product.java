package org.ecommerce.sharkecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
//    private double serialNo;
    private String productName;
    private String productImage;
    private String brand;
    private double price;
    private int quantity;
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category productCategory;

}
