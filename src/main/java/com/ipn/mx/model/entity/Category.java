package com.ipn.mx.model.entity;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Table(name = "Category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    @NotBlank(message = "Name required")
    @Size(min = 5, max = 50, message = "Length between 5 and 50")
    @Column(name = "nameCategory", nullable = false, length = 50)
    private String nameCategory;

    @NotBlank(message = "Description required")
    @Size(min = 5, max = 255, message = "Length between 5 and 255")
    @Column(name = "descriptionCategory", nullable = false, length = 255)
    private String descriptionCategory;

    // SETTERS
    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        this.descriptionCategory = descriptionCategory;
    }
}