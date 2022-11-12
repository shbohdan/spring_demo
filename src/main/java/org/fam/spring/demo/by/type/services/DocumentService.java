package org.fam.spring.demo.by.type.services;

import org.fam.spring.demo.by.type.domain.Author;
import org.fam.spring.demo.by.type.domain.Document;
import org.fam.spring.demo.by.type.repository.AuthorRepository;
import org.fam.spring.demo.by.type.repository.DocumentRepository;
import org.fam.spring.demo.by.type.util.CollectionUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static org.fam.spring.demo.by.type.util.CollectionUtils.toList;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final AuthorRepository authorRepository;

    public DocumentService(DocumentRepository documentRepository, AuthorRepository authorRepository) {
        this.documentRepository = documentRepository;
        this.authorRepository = authorRepository;
    }

    public Document createNewDocument(Document document, Author author) {
        document.setAuthorId(author.getId());
        document.setCreatedAt(LocalDateTime.now());
        return documentRepository.save(document);
    }

    public List<Document> allDocuments() {
        final Iterable<Document> allFromDb = documentRepository.findAll();
        return toList(allFromDb);
    }

    public List<Document> authoredBy(Long authorId) {
        return documentRepository.findByAuthorId(authorId);
    }

}
