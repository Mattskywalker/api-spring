package com.api.teste.data;

import com.api.teste.entity.Document;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentResources {

    private Document document;

    private List<Document> documentList;

    private String error;



    public DocumentResources(Document document) {
        this.document = document;
    }

    public DocumentResources(List<Document> documentList) {
        this.documentList = documentList;
    }

    public DocumentResources(String error) {
        this.error = error;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
