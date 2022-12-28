package com.mjc.school.mapper;

import com.mjc.school.dto.NewsDTO;
import com.mjc.school.entity.Author;
import com.mjc.school.entity.News;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-28T15:41:50+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDTO newsToNewsDTO(News news, Author author) {
        if ( news == null && author == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String content = null;
        LocalDateTime createDate = null;
        LocalDateTime lastUpdateDate = null;
        if ( news != null ) {
            id = news.getId();
            title = news.getTitle();
            content = news.getContent();
            createDate = news.getCreateDate();
            lastUpdateDate = news.getLastUpdateDate();
        }
        String authorName = null;
        if ( author != null ) {
            authorName = author.getName();
        }

        NewsDTO newsDTO = new NewsDTO( id, title, content, createDate, lastUpdateDate, authorName );

        return newsDTO;
    }
}
