package com.api.teste.services.impl;

import com.api.teste.entity.Document;
import com.api.teste.repository.DocRepository;
import com.api.teste.services.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocServiceImpl implements DocService {

    @Autowired
    DocRepository docRepository;

    @Override
    public Document save(Document document) {
        return docRepository.save(document);
    }

    @Override
    public List<Document> findAll() {
        return docRepository.findAll();
    }

    @Override
    public Document findById(Long id) {
        return docRepository.findById(id).get();

    }

    @Override
    public Document edit(Document alterations) {
        if(alterations.getId() != null) {
            return docRepository.save(alterations);
        }
        else {
            throw new IllegalArgumentException("the document id can't be null");
        }
    }

    @Override
    public Document delete(Document document) {
        Document doc = this.docRepository.findByName(document.getName()).get();
        docRepository.delete(doc);
        return doc;
    }
}
