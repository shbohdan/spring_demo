package org.fam.spring.demo.by.type.services;

import org.fam.spring.demo.by.type.domain.Author;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorManagementServiceTest {

    @Autowired
    private AuthorManagementService authorManagementService;

    @Test
    public void shouldAssignIdToNewAuthor() {
        final String newName = "some new name";
        final Author created = authorManagementService.create(newName);

        assertNotNull(created.getId());
    }

    @Test
    public void shouldSetNameToNewAuthor() {
        final String newName = "some new name";
        final Author created = authorManagementService.create(newName);

        assertEquals(newName, created.getName());
    }

    @Test
    public void shouldLeaveBlankEmailForNewAuthor() {
        final String newName = "some new name";
        final Author created = authorManagementService.create(newName);

        assertNull(created.getEmail());
    }


    @Test
    public void shouldStoreNewAuthor() {
        final String newName = "some new name";
        final Author created = authorManagementService.create(newName);

        final Author stored = authorManagementService.getAuthorById(created.getId());

        assertNotNull(stored);
        assertEquals(created.getId(), stored.getId());
        assertEquals(created.getEmail(), stored.getEmail());
        assertEquals(created.getName(), stored.getName());
    }
}