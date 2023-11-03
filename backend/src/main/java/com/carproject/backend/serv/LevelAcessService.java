package com.carproject.backend.serv;

import com.carproject.backend.model.Category;
import com.carproject.backend.model.LevelAccess;
import com.carproject.backend.repo.CategoryRepository;
import com.carproject.backend.repo.LevelAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@Service
public class LevelAcessService {

    @Autowired
    LevelAccessRepository levelAccessRepository;

    public List<LevelAccess> getAll(){
        List<LevelAccess> levelAccesses =  levelAccessRepository.findAll();
        return levelAccesses;
    }

    public ResponseEntity getById(Long id){
        Assert.notNull(id, "Não foi encontrar pois está sem o ID");
        Optional<LevelAccess> levelAccess = levelAccessRepository.findById(id);

        if(levelAccess.isPresent()){
            return ResponseEntity.ok(levelAccess);
        }
        return ResponseEntity.notFound().build();

    }
}
