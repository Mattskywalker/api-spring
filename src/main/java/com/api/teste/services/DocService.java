package com.api.teste.services;

import com.api.teste.entity.Document;

import java.util.List;

public interface DocService {

    public Document save(Document document);

    public Document findById(Long id);

    public List<Document> findAll();

    public Document edit(Document alterations);

    public Document delete(Document document);

}
