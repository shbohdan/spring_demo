package org.fam.spring.demo.by.type.web;

import org.fam.spring.demo.by.type.domain.Author;
import org.fam.spring.demo.by.type.dto.AuthorDto;
import org.fam.spring.demo.by.type.services.AuthorManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorManagementService authorManagementService;

    @RequestMapping(value = "/api/authors", method = RequestMethod.POST)
    @ResponseBody
    public AuthorDto createAuthor(@RequestBody AuthorDto dto) {
        return toDto(authorManagementService.create(dto.getName()));
    }

    @RequestMapping(value = "/api/authors", method = RequestMethod.GET)
    @ResponseBody
    public List<AuthorDto> all() {
        return authorManagementService.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @RequestMapping(value = "/api/authors/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AuthorDto byId(@PathVariable Long id) {
        return toDto(authorManagementService.getAuthorById(id));
    }

    private AuthorDto toDto(Author author) {
        final AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        return dto;
    }
}
