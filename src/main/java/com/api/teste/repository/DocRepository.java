package com.api.teste.repository;

import com.api.teste.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocRepository extends JpaRepository<Document, Long> {

    public Optional<Document> findByName(String name);
}
