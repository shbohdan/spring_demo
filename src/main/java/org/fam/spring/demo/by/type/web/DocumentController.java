package org.fam.spring.demo.by.type.web;

import org.fam.spring.demo.by.type.domain.Author;
import org.fam.spring.demo.by.type.domain.Document;
import org.fam.spring.demo.by.type.dto.CreateDocumentDto;
import org.fam.spring.demo.by.type.dto.DocumentDto;
import org.fam.spring.demo.by.type.services.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public List<DocumentDto> all() {
        return documentService.allDocuments()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public DocumentDto byId(@PathVariable Long id) {
        return toDto(documentService.findById(id));
    }

    @PostMapping
    public DocumentDto create(@RequestBody CreateDocumentDto dto) {
        final Document document = new Document();
        document.setText(dto.getText());

        final Author author = new Author();
        author.setId(dto.getAuthorId());

        return toDto(documentService.createNewDocument(document, author));
    }

    private DocumentDto toDto(Document document) {
        return DocumentMapper.INSTANCE.toDto(document);
    }
}
