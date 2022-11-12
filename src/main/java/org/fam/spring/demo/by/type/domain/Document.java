package org.fam.spring.demo.by.type.domain;

import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.time.LocalDateTime;

public class Document {
    @Id
    private Long id;
    private String text;
    private LocalDateTime createdAt;
    private Long authorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
