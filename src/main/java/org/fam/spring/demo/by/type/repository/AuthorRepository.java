package org.fam.spring.demo.by.type.repository;

import org.fam.spring.demo.by.type.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
