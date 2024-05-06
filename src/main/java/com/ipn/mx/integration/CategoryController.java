package com.ipn.mx.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ipn.mx.model.entity.Category;
import com.ipn.mx.service.CategoryService;

@RestController
@RequestMapping("/api/categories") // Más RESTful: nombre en plural y sin camelCase
public class CategoryController {

    @Autowired
    private CategoryService service;

    // Obtener todas las categorías
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getAllCategories() {
        return service.findAll();
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = service.findById(id);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    // Crear una nueva categoría
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@RequestBody Category category) {
        return service.save(category);
    }

    // Eliminar una categoría
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        Category category = service.findById(id);
        if (category != null) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable Long id) {
        Category existingCategory = service.findById(id);
        if (existingCategory != null) {
            existingCategory.setNameCategory(category.getNameCategory());
            existingCategory.setDescriptionCategory(category.getDescriptionCategory());
            return ResponseEntity.ok(service.save(existingCategory));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
