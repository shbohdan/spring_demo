package org.fam.spring.demo.by.type.repository;

import org.fam.spring.demo.by.type.domain.Document;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocumentRepository extends CrudRepository<Document, Long> {
    List<Document> findByAuthorId(Long authorId);

}
