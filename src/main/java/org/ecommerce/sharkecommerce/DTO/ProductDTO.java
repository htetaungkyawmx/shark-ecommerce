package org.ecommerce.sharkecommerce.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProductDTO {
    private String productName;
    private MultipartFile productImage;
    private String brand;
    private double price;
    private int quantity;
    private String description;


}
