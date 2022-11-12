package org.fam.spring.demo.by.type.web;

import org.fam.spring.demo.by.type.domain.Document;
import org.fam.spring.demo.by.type.dto.DocumentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocumentMapper {
    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    DocumentDto toDto(Document document);
}
