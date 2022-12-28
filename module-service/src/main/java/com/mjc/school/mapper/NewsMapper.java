package com.mjc.school.mapper;

import com.mjc.school.dto.NewsDTO;
import com.mjc.school.entity.Author;
import com.mjc.school.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewsMapper {

    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    @Mapping(source = "news.id", target = "id")
    @Mapping(source = "author.name", target = "authorName")
    NewsDTO newsToNewsDTO(News news, Author author);
}
