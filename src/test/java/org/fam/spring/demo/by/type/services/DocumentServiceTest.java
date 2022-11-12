package org.fam.spring.demo.by.type.services;

import org.fam.spring.demo.by.type.domain.Author;
import org.fam.spring.demo.by.type.domain.Document;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DocumentServiceTest {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private AuthorManagementService authorManagementService;
    private Author author;

    @BeforeEach
    public void setUp() {
        author = authorManagementService.create("test author");
    }

    @Test
    public void shouldSetAuthorToNewDocument() {
        final Document document = new Document();

        final Document created = documentService.createNewDocument(document, author);

        assertEquals(author.getId(), created.getAuthorId());
    }

    @Test
    public void shouldCreationTimeToNewDocument() {
        final Document document = new Document();

        final Document created = documentService.createNewDocument(document, author);

        assertNotNull(created.getCreatedAt());
    }

    @Test
    public void shouldAssignIdToNewDocument() {
        final Document document = new Document();

        final Document created = documentService.createNewDocument(document, author);

        assertNotNull(created.getId());
    }

    /**
     * Messy test, ONLY for demo
     */
    @Test
    public void shouldStoreNewDocument() {
        Assumptions.assumeTrue(documentService.allDocuments().isEmpty()); // Assumptions

        final Document document = new Document();
        final String documentText = "some document text";
        document.setText(documentText);
        final Document created = documentService.createNewDocument(document, author);

        final List<Document> allDocuments = documentService.allDocuments();

        assertEquals(1, allDocuments.size());
        final Document stored = allDocuments.get(0);

        assertEquals(created.getAuthorId(), stored.getAuthorId());
        assertEquals(created.getCreatedAt(), stored.getCreatedAt());
        assertEquals(documentText, stored.getText());
        assertEquals(created.getId(), stored.getId());
    }

    @Test
    public void shouldStoreDocumentByAuthor() {
        final Document document = new Document();
        final String documentText = "some document text";
        document.setText(documentText);
        final Document created = documentService.createNewDocument(document, author);

        final List<Document> allDocuments = documentService.authoredBy(author.getId());

        assertEquals(1, allDocuments.size());
        final Document stored = allDocuments.get(0);

        assertEquals(created.getAuthorId(), stored.getAuthorId());
        assertEquals(documentText, stored.getText());
        assertEquals(created.getId(), stored.getId());
    }
}