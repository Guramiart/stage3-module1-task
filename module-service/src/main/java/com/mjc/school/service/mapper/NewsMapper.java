package com.mjc.school.service.mapper;

import com.mjc.school.service.dto.NewsDTO;
import com.mjc.school.repository.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewsMapper {

    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    NewsDTO newsToNewsDTO(News news);

    News newsDTOtoNews(NewsDTO newsDTO);
}
