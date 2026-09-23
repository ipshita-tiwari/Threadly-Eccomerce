package online.threadly.Product.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "products")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String slug;
    private String[] images;
    private String brand;
    private String description;
    private Integer stock;
    private Double price;
    private Double rating;
    private Integer ratingCount;
    private Boolean isFeatured;
    private LocalDateTime createdAt;

@PrePersist
    protected  void onCreate(){
    this.createdAt= LocalDateTime.now();
}

}
