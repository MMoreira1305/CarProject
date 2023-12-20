package com.carproject.service;

import com.carproject.model.Document;
import com.carproject.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public List<Document> getAll(){
        return documentRepository.findAll();
    }

    public Document getById(Long id){
        Optional<Document> document = documentRepository.findById(id);

        if(document.isPresent()){
            return document.get();
        }

        throw new RuntimeException("Não foi possível achar o documento, por favor verifique o ID");
    }

    public Document post(Document document){
        try{
            documentRepository.save(document);
            return document;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    public void delete(Long id){
        try{
            documentRepository.deleteById(id);
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }

    }
}
