package com.api.teste.rest;

import com.api.teste.data.DocumentResources;
import com.api.teste.entity.Document;
import com.api.teste.services.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.Date;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    DocService docService;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Hello");
        return "Hello World!";
    }

    @GetMapping("/doc/{id}")
    public ResponseEntity<DocumentResources> getById(@PathVariable Long id) {

        try {
            return new ResponseEntity<DocumentResources>(new DocumentResources(docService.findById(id)), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<DocumentResources>(new DocumentResources(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/doc/all")
    public ResponseEntity<DocumentResources> getAll() {

        try {
            List<Document> doc = this.docService.findAll();
            return new ResponseEntity<DocumentResources>(new DocumentResources(doc), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<DocumentResources>(new DocumentResources(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/doc")
    public ResponseEntity<DocumentResources> save(@RequestBody Document document) {

        try {
            Document doc = this.docService.save(document);
            return new ResponseEntity<DocumentResources>(new DocumentResources(doc), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<DocumentResources>(new DocumentResources(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/doc")
    public ResponseEntity<DocumentResources> update(@RequestBody Document document) {

        try {
            Document doc = this.docService.edit(document);
            return new ResponseEntity<DocumentResources>(new DocumentResources(doc), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e) {
            return new ResponseEntity<DocumentResources>(new DocumentResources(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/doc")
    public ResponseEntity<DocumentResources> delete(@RequestBody Document document) {

        try {
            Document doc = this.docService.delete(document);
            return new ResponseEntity<DocumentResources>(new DocumentResources(doc), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<DocumentResources>(new DocumentResources(e.getMessage()), HttpStatus.OK);
        }
    }

}
