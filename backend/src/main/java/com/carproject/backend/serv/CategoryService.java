package com.carproject.backend.serv;

import com.carproject.backend.model.Category;
import com.carproject.backend.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll(){
        List<Category> categories =  categoryRepository.findAll();
        return categories;
    }

    public Category post(Category category){
        categoryRepository.save(category);
        return category;
    }

    public ResponseEntity getById(Long id){
        Assert.notNull(id, "Não foi encontrar pois está sem o ID");
        Optional<Category> category = categoryRepository.findById(id);

        if(category.isPresent()){
            return ResponseEntity.ok(category);
        }
        return ResponseEntity.notFound().build();

    }

    public Category updateCategory(Long id, Category category){
        Assert.notNull(id, "Não foi possível atualizar o registro");

        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isPresent()){
            category.setId(categoryOptional.get().getId());
            post(category);

            return category;
        }
        throw new RuntimeException("Não foi possível localizar o Brand no DBA");
    }

    public ResponseEntity delete(Long id){
        Assert.notNull(id, "Não foi encontrar pois está sem o ID");
        Optional<Category> category = categoryRepository.findById(id);

        if(category.isPresent()){
            categoryRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
