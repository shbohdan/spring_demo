package org.fam.spring.demo.by.type.services;

import org.fam.spring.demo.by.type.domain.Author;
import org.fam.spring.demo.by.type.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorManagementService {
    private final AuthorRepository authorRepository;

    public AuthorManagementService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author create(String name) {
        final Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(); // Bad design: exception type is not defined explicitly,
                                // but it is better than orElse(null)
    }
}
